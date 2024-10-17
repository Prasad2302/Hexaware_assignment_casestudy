package task8;

public class Account {
	
	private int accountNumber;
	private String accountType;
	private double accountBalance;
	

	
	public Account() {
		super();
	}
	
	
	public Account(int accountNumber, String accountType, double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	
	
	
	
	
	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	
	public void accountInfo () {
		System.out.println("Account Creation....");
	}

	public void deposite(float amount) {
		
		
			if(amount>0) {
				accountBalance = accountBalance +amount;
				System.out.println("Amount of "+amount+" is deposited");
				System.out.println("Total Balance Update :"+accountBalance);
			
			}
		
		
	
		}
	
	public void withdraw(float amount) {
		if(amount>0) {
			if(accountBalance>= amount) {
				accountBalance = accountBalance - amount;
				System.out.println("Amount of :"+amount+" is Withdrawn ");
				System.out.println("Account Balance update :"+accountBalance);
			}
			else {
				System.out.println("Insufficient funds");
			}
		}
		else {
			System.out.println("Amount to be withdrawn must be greater then 0");
		}
	}
	
	
	public void deposite(double amount) {
		
		
		if(amount>0) {
			accountBalance = accountBalance +amount;
			System.out.println("Amount of "+amount+" is deposited");
			System.out.println("Total Balance Update :"+accountBalance);
		
		}
	
	

	}

public void withdraw(double amount) {
	if(amount>0) {
		if(accountBalance>= amount) {
			accountBalance = accountBalance - amount;
			System.out.println("Amount of :"+amount+" is Withdrawn ");
			System.out.println("Account Balance update :"+accountBalance);
		}
		else {
			System.out.println("Insufficient funds");
		}
	}
	else {
		System.out.println("Amount to be withdrawn must be greater then 0");
	}
}
	
	


public void deposite(int amount) {
	
	
	if(amount>0) {
		accountBalance = accountBalance +amount;
		System.out.println("Amount of "+amount+" is deposited");
		System.out.println("Total Balance Update :"+accountBalance);
	
	}



}

public void withdraw(int amount) {
if(amount>0) {
	if(accountBalance>= amount) {
		accountBalance = accountBalance - amount;
		System.out.println("Amount of :"+amount+" is Withdrawn ");
		System.out.println("Account Balance update :"+accountBalance);
	}
	else {
		System.out.println("Insufficient funds");
	}
}
else {
	System.out.println("Amount to be withdrawn must be greater then 0");
}
}


public void calculateInterest() {
	
}
	
	
}
