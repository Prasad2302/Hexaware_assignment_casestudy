package services;

import java.util.List;

import dao.BankRepositoryImpl;
import dao.IBankRepository;
import entity.Account;
import entity.CurrentAccount;
import entity.Customer;
import entity.SavingsAccount;
import entity.ZeroBalanceAccount;

public class BankServiceProviderImpl implements IBankServiceProvider {

	private IBankRepository dao;
	
	public BankServiceProviderImpl() {
        this.dao = new BankRepositoryImpl(); // Initialize with the implementation class
    }

	
	@Override
	public void createAccount(Customer customer, long accNo, String accType, float balance) {
		// TODO Auto-generated method stub
		dao.createAccount(customer, accNo, accType, balance);

	}

	@Override
	public List<Account> listAllAccounts() {
		// TODO Auto-generated method stub
		return dao.listAllAccounts();
	}

	@Override
	public void calculateInterest() {
		List<Account> accounts = dao.listAllAccounts();  
	    
	    // Return the accounts to be handled in the presentation layer
	    for (Account account : accounts) {
	        double interest = 0.0;
	        
	        if (account instanceof SavingsAccount) {
	            SavingsAccount savingsAccount = (SavingsAccount) account;
	            double interestRate = savingsAccount.getInterestRate() / 100; // Convert percentage to decimal
	            interest = account.getAccountBalance() * interestRate; // Interest calculation
	            System.out.printf("Account Number: %d, Account Type: %s, Interest Earned: %.2f%n",
	                              account.getAccountNumber(), "SavingsAccount", interest);
	        } else if (account instanceof CurrentAccount) {
	            System.out.printf("Account Number: %d, Account Type: %s does not earn interest.%n",
	                              account.getAccountNumber(), "CurrentAccount");
	        } else if (account instanceof ZeroBalanceAccount) {
	            System.out.printf("Account Number: %d, Account Type: %s does not earn interest.%n",
	                              account.getAccountNumber(), "ZeroBalanceAccount");
	        } else {
	            System.out.printf("Account Number: %d, Account Type: %s is an unknown type.%n",
	                              account.getAccountNumber(), account.getAccountType());
	        }
	    }
	}

	
}
