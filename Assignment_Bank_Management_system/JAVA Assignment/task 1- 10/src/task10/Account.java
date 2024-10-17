package task10;

public class Account {

	private long accountNumber;
	private String accountType;
	private long accountBalance;
	
	private Customer customer;

	public Account() {
		super();
	}

	public Account(long accountNumber, String accountType, long accountBalance, Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.customer = customer;
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

	public long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void printAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Balance: " + accountBalance);
        if (customer != null) {
            customer.printCustomerInfo();
        }
	
	}
}
