package entity;

public class CurrentAccount extends Account {

	private int overDraftLimit;

	public CurrentAccount() {
		super();
	}

	public CurrentAccount(int overDraftLimit) {
		super();
		this.overDraftLimit = overDraftLimit;
	}

	public int getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(int overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}

	@Override
	public String toString() {
		return "CurrentAccount [overDraftLimit=" + overDraftLimit + "]";
	}
	
	
	
}
