package com.hexaware.insurance.entity;

public class Client {

	private long clientId;
	private String clientName;
	private long contactInfo;
	private Policy policy;
	public Client() {
		super();
	}
	public Client(long clientId, String clientName, long contactInfo, Policy policy) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.contactInfo = contactInfo;
		this.policy = policy;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public long getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(long contactInfo) {
		this.contactInfo = contactInfo;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", contactInfo=" + contactInfo
				+ ", policy=" + policy + "]";
	}
	
	
	
	
}
