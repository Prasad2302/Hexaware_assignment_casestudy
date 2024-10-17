package com.hexaware.insurance.entity;

public class Policy {
	private long policyID;
	private String policyName;
	private String policyType;
	public Policy() {
		super();
	}
	public Policy(long policyID, String policyName, String policyType) {
		super();
		this.policyID = policyID;
		this.policyName = policyName;
		this.policyType = policyType;
	}
	public long getPolicyID() {
		return policyID;
	}
	public void setPolicyID(long policyID) {
		this.policyID = policyID;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	@Override
	public String toString() {
		return "Policy [policyID=" + policyID + ", policyName=" + policyName + ", policyType=" + policyType + "]";
	}
	
	
	
}
