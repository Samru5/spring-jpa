package com.capgemini.bankapp.dao.impl;

import java.sql.Connection;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.exception.BankAccountNotFoundException;
import com.capgemini.bankapp.mapper.BankAccountRowMapper;
import com.capgemini.bankapp.model.BankAccount;


@Repository
public class BankAccountDaoImpl implements BankAccountDao{

public DataSource dataSource;
public JdbcTemplate jdbcTemplateObject;
public Connection connection;

BankAccount account;
double balance;
private JdbcTemplate jdbcTemplate;
	
	 public BankAccountDaoImpl(JdbcTemplate jdbcTemplate) {
        	this.jdbcTemplate = jdbcTemplate;
    	}

	

	@Override
	public boolean addNewBankAccount(BankAccount account) {
		String query = "INSERT INTO bankaccounts (customer_name,account_type,account_balance) VALUES('"+account.getAccountHolderName()+"','"+account.getAccountType()+"','"+account.getAccountBalance()+"')";
		int result = jdbcTemplate.update(query);
		if(result==1)
			return true;
		else
			return false;	
	}

	@Override
	public boolean deleteBankAccount(long accountId) 
	{
		String query = "DELETE FROM bankaccounts WHERE account_Id="+accountId;
		int result = jdbcTemplate.update(query);
		try{
		if(result==1)
			return true;
		else
			return false;	
		}

		catch(Exception ex)
		{
			RuntimeException re=new RuntimeException();
			ex.initCause(re);
			re.printStackTrace();
			throw re;
		}
	}

	@Override
	public BankAccount searchAccount(long accountId) throws  BankAccountNotFoundException{
	try{
account=jdbcTemplate.queryForObject("SELECT * FROM bankaccounts WHERE account_id =?",new Object[] {accountId},new BankAccountRowMapper());
	}

	catch(Exception e)
	{
		throw new BankAccountNotFoundException("Bank account is not found!");
	}	
	return account;
		}


	@Override
	public List<BankAccount> findAllBankAccounts(){

	List<BankAccount> account=jdbcTemplate.query("SELECT * FROM bankaccounts",new BankAccountRowMapper());
	return account;
	}


	@Override
	public boolean updateBankAccountDetails(long accountId, String accountHolderName, String accountType) {

	String query = "UPDATE bankaccounts SET customer_name=?, account_type=? WHERE account_id=" + accountId;
	
		int result = jdbcTemplate.update(query,accountHolderName,accountType);
		if(result==1)
			return true;
		else
			return false;

	}

	@Override
	public double getBalance(long accountId) throws BankAccountNotFoundException
	{
	try
	{
	 balance=jdbcTemplate.queryForObject("SELECT account_balance FROM bankaccounts WHERE account_id =?",new Object[] {accountId},Double.class);
	}
	catch(Exception ex)
	{
		throw new BankAccountNotFoundException("Bank account is not found!");
	}	

	return balance;
	}

	@Override
	public void updateBalance(long accountId, double newBalance) throws BankAccountNotFoundException{
	String query = "UPDATE bankaccounts SET account_balance=? WHERE account_id=?";
	try{
		jdbcTemplate.update(query,newBalance,accountId);
	}
	catch(Exception e)
	{
		throw new BankAccountNotFoundException("Bank account is not found!");
	}
	

	}


	

	
}
