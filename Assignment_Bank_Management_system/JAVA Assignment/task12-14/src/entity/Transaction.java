package entity;

import java.time.LocalDateTime;

public class Transaction {

	private Account account;
	private String description;
	private LocalDateTime dateTime;
	private String transactionType;
	private float amount;
	public Transaction() {
		super();
	}
	public Transaction(Account account, String description, LocalDateTime dateTime, String transactionType,
			float amount) {
		super();
		this.account = account;
		this.description = description;
		this.dateTime = dateTime;
		this.transactionType = transactionType;
		this.amount = amount;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transaction [account=" + account + ", description=" + description + ", dateTime=" + dateTime
				+ ", transactionType=" + transactionType + ", amount=" + amount + "]";
	}
	
	
}
