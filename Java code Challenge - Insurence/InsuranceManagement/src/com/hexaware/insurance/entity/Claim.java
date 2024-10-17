package com.hexaware.insurance.entity;

public class Claim {

	private long claimId;
	private long claimNumber;
	private String dateField;
	private double claimAmount;
	private String status;
	private Policy policy;
	private Client client;
	
	
	
	public Claim() {
		super();
	}



	public Claim(long claimId, long claimNumber, String dateField, double claimAmount, String status, Policy policy,
			Client client) {
		super();
		this.claimId = claimId;
		this.claimNumber = claimNumber;
		this.dateField = dateField;
		this.claimAmount = claimAmount;
		this.status = status;
		this.policy = policy;
		this.client = client;
	}



	public long getClaimId() {
		return claimId;
	}



	public void setClaimId(long claimId) {
		this.claimId = claimId;
	}



	public long getClaimNumber() {
		return claimNumber;
	}



	public void setClaimNumber(long claimNumber) {
		this.claimNumber = claimNumber;
	}



	public String getDateField() {
		return dateField;
	}



	public void setDateField(String dateField) {
		this.dateField = dateField;
	}



	public double getClaimAmount() {
		return claimAmount;
	}



	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Policy getPolicy() {
		return policy;
	}



	public void setPolicy(Policy policy) {
		this.policy = policy;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", claimNumber=" + claimNumber + ", dateField=" + dateField
				+ ", claimAmount=" + claimAmount + ", status=" + status + ", policy=" + policy + ", client=" + client
				+ "]";
	}
	
	
	
	
}
