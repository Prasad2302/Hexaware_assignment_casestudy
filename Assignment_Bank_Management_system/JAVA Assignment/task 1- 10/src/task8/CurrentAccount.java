package task8;

public class CurrentAccount extends Account{

	
	public double overDraftLimit = 1000;

	public CurrentAccount(int accountNumber, double accountBalance) {
		super(accountNumber, "Current", accountBalance);
	}
	
	public CurrentAccount() {
		super();
	}

	public void withdraw(double amount) {
		if(amount>0) {
			if(getAccountBalance()>= amount) {
				setAccountBalance(getAccountBalance()- amount)  ;
				System.out.println("Amount of :"+amount+" is Withdrawn ");
				System.out.println("Account Balance update :"+getAccountBalance());
			}
			else {
				System.out.println("Insufficient funds");
			}
		}
		else {
			System.out.println("Amount to be withdrawn must be greater then 0");
		}
	}
		
	
	
	
	
	
}
