package entity;

public class SavingsAccount extends Account{
	private int interestRate;
	
	private double minimumBalance = 1000; // Example minimum balance

    // Getters and setters

    public double getMinimumBalance() {
        return minimumBalance;
    }

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(int interestRate) {
		super();
		this.interestRate = interestRate;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + "]";
	}
	
	
}
