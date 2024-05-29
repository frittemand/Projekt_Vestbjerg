package model;

public class Customer extends Person {

	private static int customerNumber = 0;
	
	
	public Customer(String name, String address, String email, int phoneNumber) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.customerNumber = customerNumber++;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
}
