package services;

import java.sql.Date;
import java.util.List;

import entity.Account;
import entity.Transaction;
import exceptions.InsufficientFundException;
import exceptions.InvalidAccountException;
import exceptions.OverDraftLimitExceededException;

public interface ICustomerServiceProvider {
	
	
	public double getAccountBalance(long account_number);
	
	public double deposite(long account_number, float amount);
	
	public double withdraw(long account_number, float amount)throws InsufficientFundException, OverDraftLimitExceededException, InvalidAccountException;
	
	public void transfer(long from_account_number, long to_account_number, float amount) throws InsufficientFundException, InvalidAccountException;
	
	
	
	
	Account getAccountDetails(long accountNumber) throws InvalidAccountException;
	
	List<Transaction> getTransactions(long accountNumber, Date fromDate, Date toDate);
	
	
}
