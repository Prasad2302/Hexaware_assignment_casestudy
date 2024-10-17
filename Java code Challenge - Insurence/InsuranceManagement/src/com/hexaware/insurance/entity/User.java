package com.hexaware.insurance.entity;

public class User {
	
	private long userID;
	private String userName;
	private String password;
	private String role;
	public User() {
		super();
	}
	public User(long userID, String userName, String password, String role) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	
	
}
