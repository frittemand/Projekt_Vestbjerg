package model;

public class Customer extends Person {

	private int customerNumber;
	
	
	public Customer(String name, String address, String email, int phoneNumber) {
		this.name = name;
		this.address = address;
		this.email = email;
		customerNumber = phoneNumber;
	}
	
	public int getPhoneNumber() {
		return customerNumber;
	}
}
