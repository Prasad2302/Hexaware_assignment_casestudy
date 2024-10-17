package task10;

public class Customer {

	private long customerID;
	private String firstName;
	private String lastName;
	private String email;
	private int phoneNumber;
	private String address;
	public Customer() {
		super();
	}
	public Customer(long customerID, String firstName, String lastName, String email, int phoneNumber, String address) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public long getCustomeID() {
		return customerID;
	}
	public void setCustomeID(long customeID) {
		this.customerID = customerID;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public void printCustomerInfo() {
		
		System.out.println("Customer Id :"+ customerID);
		System.out.println("First name :"+ firstName);
		System.out.println("Last name :"+lastName);
		System.out.println("email :"+email);
		System.out.println("address :"+address);
		
	}
	
	
}
