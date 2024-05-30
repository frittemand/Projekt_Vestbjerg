package model;

import java.util.ArrayList;
import java.util.Iterator;


public class CustomerContainer {

	/**
	 * fields for CustomerContainer
	 * 
	 */
	private ArrayList<Customer> customers = new ArrayList<>();
	/**
	 * 
	 */
	private static CustomerContainer INSTANCE;
	
	
	/**
	 * constructor for CustomerContainer
	 */
	public CustomerContainer() {
		
	}
	/**
	 * @returns a instance
	 * checks is a instance already exist and either creates a new instance return a existing instance
     * (part of singleton)
	 */
	public static CustomerContainer getInstance() {
		if (INSTANCE == null){
			INSTANCE = new CustomerContainer();
		}
		return INSTANCE;
	}
	
	/**
	 * @param phoneNumber is a phoneNumber of a customer
	 * @returns a Customer
	 * searches for a Customer with a matching phoneNumber
	 */
	public Customer findCustomerByPhoneNumber(int phoneNumber){
		Customer foundNumber = null;
		boolean searching = true;
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext() && searching) {
			Customer c1 = it.next();
			if(c1.getPhoneNumber() == phoneNumber){
				foundNumber = c1; 
				searching = false;
				
			}
			
		}
		return foundNumber;
		
	}
	/**
	 * @param customer is a specific Customer
	 * checks if Customer input is valid
	 * adds customer to customers ArrayList
	 */
	public void addCustomerToContainer (Customer customer) {
		if (customer != null) {
		customers.add(customer);
		}
	
}
}
