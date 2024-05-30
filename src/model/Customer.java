package model;

public class Customer extends Person {

	/**
	 * 
	 */
	private static int customerGenerator = 0;
	/**
	 * 
	 */
	private int customerNumber;
	
	/**
	 * constructor for Customer
	 * @param name is the name of a Customer
	 * @param address is the address of a Customer
	 * @param email is the email of a Customer
	 * @param phoneNumber is the phoneNumber of a Customer
	 * customerNumber is generated
	 */
	public Customer(String name, String address, String email, int phoneNumber) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.customerNumber = ++customerGenerator;
	}
	
	/**
	 * @returns a phoneNumber
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @returns a name
	 */
	public String getName() {
		return name; 
	}
}
