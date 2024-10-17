package services;

import java.sql.Date;
import java.util.List;

import dao.BankRepositoryImpl;
import dao.IBankRepository;
import entity.Account;
import entity.CurrentAccount;
import entity.SavingsAccount;
import entity.Transaction;
import exceptions.InsufficientFundException;
import exceptions.InvalidAccountException;
import exceptions.OverDraftLimitExceededException;

public class CustomerServiceProviderImpl implements ICustomerServiceProvider {

	private IBankRepository dao;
	
	public CustomerServiceProviderImpl() {
        this.dao = new BankRepositoryImpl(); // Initialize with the implementation class
    }
	
	@Override
	public double getAccountBalance(long account_number) {
		// TODO Auto-generated method stub
		return dao.getAccountBalance(account_number);
	}

	@Override
	public double deposite(long account_number, float amount) {
		// TODO Auto-generated method stub
		return dao.deposite(account_number, amount);
	}

	@Override
	public double withdraw(long account_number, float amount)throws InsufficientFundException, OverDraftLimitExceededException,InvalidAccountException {
		// TODO Auto-generated method stub
		Account account = dao.getAccountDetails(account_number);
		if (account == null) {
            throw new InvalidAccountException("Invalid account number.");
        }
		
		
	    if (account instanceof SavingsAccount) {
	        // Check for minimum balance in Savings Account
	        double minimumBalance = 1000; // Example minimum balance
	        double currentBalance = account.getAccountBalance();

	        if (currentBalance - amount < minimumBalance) {
	            throw new InsufficientFundException("Withdrawal denied. Minimum balance of " + minimumBalance + " must be maintained.");
	        }
	    } else if (account instanceof CurrentAccount) {
	        CurrentAccount currentAccount = (CurrentAccount) account;
	        double overdraftLimit = currentAccount.getOverDraftLimit();
	        double currentBalance = account.getAccountBalance();

	        if (amount > currentBalance + overdraftLimit) {
	            throw new OverDraftLimitExceededException("Withdrawal denied. Amount exceeds overdraft limit of " + overdraftLimit);
	        }
	    }

	    // Proceed with withdrawal
	    double newBalance = dao.withdraw(account_number, amount);
	    System.out.println("Withdrawal successful. New balance: " + newBalance);
	    return newBalance;
	   
	}

	@Override
	public void transfer(long from_account_number, long to_account_number, float amount)throws InvalidAccountException, InsufficientFundException{
		// TODO Auto-generated method stub
//		dao.transfer(from_account_number, to_account_number, amount);
		
		// Step 1: Check if the source account (from_account) exists
	    Account fromAccount = dao.getAccountDetails(from_account_number);
	    if (fromAccount == null) {
	        throw new InvalidAccountException("Invalid source account number: " + from_account_number);
	    }

	    // Step 2: Check if the target account (to_account) exists
	    Account toAccount = dao.getAccountDetails(to_account_number);
	    if (toAccount == null) {
	        throw new InvalidAccountException("Invalid destination account number: " + to_account_number);
	    }

	    // Step 3: Check if the source account has sufficient balance
	    double fromBalance = fromAccount.getAccountBalance();
	    
	    if (fromAccount instanceof SavingsAccount) {
	        double minimumBalance = 1000;  // Example minimum balance for savings account
	        if (fromBalance - amount < minimumBalance) {
	            throw new InsufficientFundException("Transfer denied. Insufficient funds in source account (minimum balance must be maintained).");
	        }
	    } else if (fromAccount instanceof CurrentAccount) {
	        CurrentAccount currentAccount = (CurrentAccount) fromAccount;
	        double overdraftLimit = currentAccount.getOverDraftLimit();
	        
	        // Check if the withdrawal exceeds the available balance and overdraft limit for CurrentAccount
	        if (amount > fromBalance + overdraftLimit) {
	            throw new InsufficientFundException("Transfer denied. Amount exceeds available balance and overdraft limit.");
	        }
	    } else {
	        // Generic check for accounts that do not have special rules (if any)
	        if (fromBalance < amount) {
	            throw new InsufficientFundException("Transfer denied. Insufficient funds in source account.");
	        }
	    }

	    // Step 4: Perform the transfer (using the DAO method)
	    dao.transfer(from_account_number, to_account_number, amount);

	    System.out.println("Transfer successful from account " + from_account_number + " to account " + to_account_number);
	}

	@Override
	public Account getAccountDetails(long accountNumber) {
		// TODO Auto-generated method stub
		return dao.getAccountDetails(accountNumber);
	}

	@Override
	public List<Transaction> getTransactions(long accountNumber, Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return dao.getTransactions(accountNumber, fromDate, toDate);
	}

}
