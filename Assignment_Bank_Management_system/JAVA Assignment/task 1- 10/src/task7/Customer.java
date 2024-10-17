package task7;

public class Customer {
	private int customeId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private int mobileNumber;
	private String address;
	
	
	public Customer() {
		super();
	}
	
	
	
	public Customer(int customeId, String firstName, String lastName, String emailAddress, int mobileNumber,
			String address) {
		super();
		this.customeId = customeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}
	
	
	public int getCustomeId() {
		return customeId;
	}
	public void setCustomeId(int customeId) {
		this.customeId = customeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
