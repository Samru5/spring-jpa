package com.capgemini.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.bankapp.exception.BankAccountNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountService;

@Controller
@RequestMapping("/bankapp")
public class BankAppController {

	BankAccount account;

	@Autowired
	private BankAccountService service;

	
	 @RequestMapping("/") 
	 public String inputPage() 
	 { 
		return "BankHome"; }
	 
	
	@RequestMapping("/fornew")
	public String forNewAccount()
	{
		return "OpenNewAccount";
	}


	@RequestMapping("/new")
	public String addNewBankAccount(@RequestParam("customerName") String accountHolderName,
			@RequestParam("type") String accountType, @RequestParam("balance") double accountBalance) {
		account = new BankAccount(accountHolderName, accountType, accountBalance);
		service.addNewBankAccount(account);
		return "success";

	}
	
	@RequestMapping("/forcheck")
	public String forCheckBalance()
	{
		return "CheckBalance";
	}

	@RequestMapping("/check")
	public String checkBalance(@RequestParam("accountId") long accountId, Model model)
			 {
		try {
		double balance = service.checkBalance(accountId);
		model.addAttribute("accountId", "Balance is " + balance);
		return "balance";
		}
		catch(BankAccountNotFoundException e)
		{
			e.printStackTrace();
			model.addAttribute("message",e.getMessage());
		}
		return "Error";

	}


	@RequestMapping("/fordelete")
	public String forDelete()
	{
		return "DeleteAccount";
	}
	
	@RequestMapping("/delete")
	public String deleteBankAccount(@RequestParam("accountId") long accountId, Model model)
			throws BankAccountNotFoundException {
		service.deleteBankAccount(accountId);
		return "success";

	}
	
	@RequestMapping("/forsearch")
	public String forSearch()
	{
		return "SearchAccount";
	}

	@RequestMapping("/search")
	public String searchAccount(@RequestParam("accountId") long accountId, Model model)
		 {
		try {
			
		
		BankAccount account1 = service.searchAccount(accountId);
		model.addAttribute("accountId", account1);

		return "SearchResult";
		}
		catch(BankAccountNotFoundException e)
		{
			e.printStackTrace();
			model.addAttribute("message",e.getMessage());
		}
		return "Error";

	}

	@RequestMapping("/findall")
	public String findAllBankAccounts(Model model) {
		List<BankAccount> account2 = service.findAllBankAccounts();
		model.addAttribute("accountdetails", account2);

		return "ListAccounts";

	}

	@RequestMapping("/forupdate")
	public String getId() {
		return "UpdateDetails";

	}

	@RequestMapping("/update")
	public String performUpdate(@RequestParam("accountId") long accountId,Model model) {
		try {

		BankAccount account = service.searchAccount(accountId);
		model.addAttribute("accounts",account);

		return "update";
		}
		catch(BankAccountNotFoundException e)
		{
			e.printStackTrace();
			model.addAttribute("message",e.getMessage());
		}
		
		return "Error";

	}

	@RequestMapping("/updatedetails")

	public String updateDetails(@RequestParam("accountId") long accountId,
			@RequestParam("customerName") String accountHolderName, @RequestParam("type") String accountType,@RequestParam("balance") double accountBalance,Model model)
			throws BankAccountNotFoundException {
		try {

		service.updateBankAccountDetails(accountId, accountHolderName, accountType);
		return findAllBankAccounts(model);
		}
		catch(BankAccountNotFoundException e)
		{
			e.printStackTrace();
			model.addAttribute("message",e.getMessage());
		}
		return "Error";

	}

	@RequestMapping("/fordeposit")
	public String forDeposit() {
		return "Deposit";

	}
	@RequestMapping("/deposit")
	public String deposit(@RequestParam("accountId") long accountId, @RequestParam("amount") double amount, Model model)
		 {
		try {

		double balance = service.deposit(accountId, amount);
		model.addAttribute("deposit", "Balance after deposit is " + balance);

		return "DepositResult";
		}
		catch(BankAccountNotFoundException e)
		{
			e.printStackTrace();
			model.addAttribute("message",e.getMessage());
		}
		return "Error";


	}
	
	@RequestMapping("/forwithdraw")
	public String forWithdraw() {
		return "Withdraw";

	}
	@RequestMapping("/withdraw")
	public String withdraw(@RequestParam("accountId") long accountId, @RequestParam("amount") double amount,
			Model model)  {
		try
		{
		double balance = service.withdraw(accountId, amount);
		model.addAttribute("withdraw", "Balance after withdraw is " + balance);
		return "WithdrawResult";

		}
		catch( LowBalanceException |BankAccountNotFoundException e)
		{
			e.printStackTrace();
			model.addAttribute("message",e.getMessage());
		}

		return "Error";

	}
	
	@RequestMapping("/forfundtransfer")
	public String forFundTransfer() {
		return "FundTransfer";

	}
	@RequestMapping("/fund")
	public String fundTransfer(@RequestParam("fromaccount") long fromAccount, @RequestParam("toaccount") long toAccount,
			@RequestParam("amount") double amount, Model model)
	
	{
		try {
			
		
		double balance = service.fundTransfer(fromAccount, toAccount, amount);
		model.addAttribute("fundtransfer", "Balance after fund transfer is " + balance);

		return "FundTransferResult";
		}
		catch(LowBalanceException|BankAccountNotFoundException e)
		{
			e.printStackTrace();
			model.addAttribute("message",e.getMessage());
		}
		
		return "Error";

	}

}
