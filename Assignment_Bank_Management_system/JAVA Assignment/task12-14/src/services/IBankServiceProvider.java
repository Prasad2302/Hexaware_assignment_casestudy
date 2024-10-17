package services;

import java.util.List;

import entity.Account;
import entity.Customer;
import exceptions.InvalidAccountException;

public interface IBankServiceProvider {

	public void  createAccount(Customer customer, long accNo, String accType, float balance) throws InvalidAccountException;
	
	List<Account>listAllAccounts();
	
	public void calculateInterest();
	
}
