package task7;

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

	public double getAccountBalancne() {
		return accountBalance;
	}

	public void setAccountBalancne(int accountBalancne) {
		this.accountBalance = accountBalance;
	}
	
	
	public void printAllValues() {
		System.out.println("Account Number :"+accountNumber);
		System.out.println("Account Type :"+accountType);
		System.out.println("Account Balance :"+accountBalance);
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
	
	
	public double calculateInterest(double accountBalance) {
		double interestRate = 4.5/100;
		double interest = interestRate * accountBalance;
		
		System.out.println("Interest amount is :"+ interest);
		return interest;
	}
	
	
	
	
	
	
	
}
