package task9;

public class SavingsAccount extends BankAccount {

	public double interestRate;

	public SavingsAccount(int accountNumber, String customerName, double balance, double interestRate) {
		super(accountNumber,customerName, balance);
		this.interestRate = interestRate;
	}

	@Override
	public void deposit(float amount) {
		setBalance(getBalance()+amount);
		System.out.println("Deposited amount :"+ amount);
		System.out.println("Total Balance :"+getBalance());
		
	}

	@Override
	public void withdraw(float amount) {
		if(amount <= getBalance()) {
			setBalance(getBalance()-amount);
			System.out.println("Updated Balance :"+getBalance());
		}
		else {
			System.out.println("Insufficient Funds ");
		}
		
	}

	@Override
	public void calculateInterest() {
		double interest = getBalance() * interestRate/100;
		System.out.println("Interest is :"+interest);
		
		
	}
	
	
	
	
	
	
}
