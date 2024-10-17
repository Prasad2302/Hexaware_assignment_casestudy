package entity;

public class Account {

	private long accountNumber;
	private String accountType;
	private double accountBalance;
	private Customer customer;
	private long lastAccountNumber;
	public Account() {
		super();
	}
	public Account(long accountNumber, String accountType, double accountBalance, Customer customer,
			long lastAccountNumber) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.customer = customer;
		this.lastAccountNumber = lastAccountNumber;
	}
	
	public Account(long accountNumber, String accountType, double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		
	}
	
	public Account(long accountNumber2, double accountBalance2) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public long getLastAccountNumber() {
		return lastAccountNumber;
	}
	public void setLastAccountNumber(long lastAccountNumber) {
		this.lastAccountNumber = lastAccountNumber;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", accountBalance="
				+ accountBalance + ", customer=" + customer + ", lastAccountNumber=" + lastAccountNumber + "]";
	}
	
	
}
