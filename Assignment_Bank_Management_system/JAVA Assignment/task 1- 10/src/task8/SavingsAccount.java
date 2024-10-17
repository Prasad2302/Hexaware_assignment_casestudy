package task8;

public class SavingsAccount extends Account {
	
	public double interestRate;
	
	
	
	
	public SavingsAccount() {
		super();
	}


	
	public SavingsAccount(int accountNumber, double accountBalance) {
		super( accountNumber, "savings", accountBalance);
	
		
	}
	
	
	


	public void calculateInterest(double accountBalance) {
		
		double interest = getAccountBalance() * interestRate;
		setAccountBalance(getAccountBalance()+ interest);
		
		System.out.println("Interest amount is :"+ getAccountBalance());
	}
	
	
	
}
