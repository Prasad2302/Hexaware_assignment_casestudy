package task9;

public class CurrentAccount extends BankAccount {

	private static final double OVERDRAFT_LIMIT = 500.0;
	
	 public CurrentAccount(int accountNumber, String customerName, double balance) {
	        super(accountNumber, customerName, balance);
	    }
	
	@Override
	public void deposit(float amount) {
		setBalance(getBalance()+amount);
		System.out.println("Deposited amount :"+ amount);
		System.out.println("Total Balance :"+getBalance());
		
	}

	@Override
	public void withdraw(float amount) {
		if(amount>getBalance()+OVERDRAFT_LIMIT) {
			setBalance(getBalance()-amount);
			System.out.println("Updated Balance :"+getBalance());
		}
		else {
			System.out.println("Insufficient Funds ");
		}
		
		
	}

	@Override
	public void calculateInterest() {
		
		System.out.println("No Interest for current account");
		
		
	}

}
