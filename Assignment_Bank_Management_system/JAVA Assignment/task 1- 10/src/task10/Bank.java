package task10;

public class Bank {
	
	private Account[] accounts;  
	private int accountCount; 
	private static long nextAccountNumber = 1001; 
	
	public Bank(int maxAccounts) {
        accounts = new Account[maxAccounts];
        accountCount = 0;
    }
	
	public void create_account(Customer customer,  String accType, long balance){
		if (accountCount >= accounts.length) {
            System.out.println("Cannot create new account. Maximum account limit reached.");
            return;
        }
		long accNo = nextAccountNumber++; 
        Account account = new Account(accNo, accType, balance, customer);
        accounts[accountCount++] = account;  // Add the new account to the array
        System.out.println("Account created successfully: " + accNo);
		
		
	}
	
	
	public float get_account_balance(long account_number) {
		for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == account_number) {
                return accounts[i].getAccountBalance();
            }
        }
		System.out.println("Account Not found");
		return -1;
		
	}
	
	public float deposit(long account_number,  long amount) {
		for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == account_number) {
                accounts[i].setAccountBalance(accounts[i].getAccountBalance() + amount);
                return accounts[i].getAccountBalance();
            }
        }
        System.out.println("Account not found.");
        return -1; 
		
	}
	
	public float withdraw(long account_number, long amount) {
		for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == account_number) {
                long currentBalance = accounts[i].getAccountBalance();
                if (currentBalance >= amount) {
                    accounts[i].setAccountBalance(currentBalance - amount);
                    return accounts[i].getAccountBalance();
                } else {
                    System.out.println("Insufficient funds.");
                    return currentBalance; // Return current balance
                }
            }
        }
        System.out.println("Account not found.");
        return -1; 
		
	}
	
	public void transfer(long from_account_number, long to_account_number, long amount) {
		 Account fromAccount = null;
	        Account toAccount = null;

	        // Find both accounts
	        for (int i = 0; i < accountCount; i++) {
	            if (accounts[i] != null) {
	                if (accounts[i].getAccountNumber() == from_account_number) {
	                    fromAccount = accounts[i];
	                }
	                if (accounts[i].getAccountNumber() == to_account_number) {
	                    toAccount = accounts[i];
	                }
	            }
	        }
	        
	     // Check if both accounts were found
	        if (fromAccount == null) {
	            System.out.println("Source account not found.");
	            return;
	        }
	        
	        if (toAccount == null) {
	            System.out.println("Destination account not found.");
	            return;
	        }
	        
	        long currentBalance = fromAccount.getAccountBalance();
	        if (currentBalance >= amount) {
	            fromAccount.setAccountBalance(currentBalance - amount);
	            toAccount.setAccountBalance(toAccount.getAccountBalance() + amount);
	            System.out.println("Transferred " + amount + " from account " + from_account_number + " to account " + to_account_number);
	        } else {
	            System.out.println("Insufficient funds in source account.");
	        }
	}
	
	 public void getAccountDetails(long account_number) {
	        for (int i = 0; i < accountCount; i++) {
	            if (accounts[i] != null && accounts[i].getAccountNumber() == account_number) {
	                accounts[i].printAccountInfo();  // Print account info, which includes customer info
	                return;
	            }
	        }
	        System.out.println("Account not found.");
	    }
	
	
}
