package model;

public class Customer extends Person {

	private static int customerGenerator = 0;
	private int customerNumber;
	
	public Customer(String name, String address, String email, int phoneNumber) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.customerNumber = ++customerGenerator;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
}
