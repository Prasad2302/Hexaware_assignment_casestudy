package task9;

public abstract class BankAccount {
	
	private int accountNumber;
	private String customerName;
	private double balance;
	public BankAccount() {
		super();
	}
	public BankAccount(int accountNumbebr, String customerName, double balance) {
		super();
		this.accountNumber = accountNumbebr;
		this.customerName = customerName;
		this.balance = balance;
	}
	public int getAccountNumbebr() {
		return accountNumber;
	}
	public void setAccountNumbebr(int accountNumbebr) {
		this.accountNumber = accountNumbebr;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public void printAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Balance: " + balance);
    }

   
    public abstract void deposit(float amount);

    public abstract void withdraw(float amount);

    public abstract void calculateInterest();
    
    
    
}
	
	
	
	


