package com.capgemini.bankapp.mapper;
import  com.capgemini.bankapp.model.*;

import org.springframework.jdbc.core.*;
import java.sql.ResultSet;
import java.sql.*;

public class BankAccountRowMapper implements RowMapper<BankAccount>
{
	public BankAccount account;
	public BankAccount mapRow(ResultSet rs,int rowNum) 
	{
		try{
			long accountId=rs.getLong(1);
	 		String accountHolderName=rs.getString(2);
	 		String accountType=rs.getString(3);
	 		double accountBalance=rs.getDouble(4);
			account=new BankAccount(accountId,accountHolderName,accountType, accountBalance);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return account;
	
	}
		

	
}

