package dao;

import java.sql.Date;
import java.util.List;

import entity.Account;
import entity.Customer;
import entity.Transaction;


public interface IBankRepository {
	
	public void  createAccount(Customer customer, long accNo, String accType, float balance);
	
	List<Account>listAllAccounts();
	
	public void calculateInterest();
	
	public double getAccountBalance(long account_number);
	
	public double deposite(long account_number, float amount);
	
	public double withdraw(long account_number, float amount);
	
	public void transfer(long from_account_number, long to_account_number, float amount);
	
	
	
	
	Account getAccountDetails(long accountNumber);
	
	List<Transaction> getTransactions(long accountNumber, Date fromDate, Date toDate);
	
	
	
	
	
}
