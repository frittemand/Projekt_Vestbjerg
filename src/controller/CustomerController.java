package controller;

import model.Customer;
import model.CustomerContainer;

public class CustomerController {
	
	/**
	 * constructor for CustomerController
	 */
	public CustomerController() {};
	
	/**
	 * @param phoneNumber is a phoneNumber of a Customer
	 * @returns a Customer
	 * runs getInstance in CustomerContainer
	 * runs findCustomerByPhoneNumber in cC with phoneNumber as input
	 */
	public Customer findCustomerByPhoneNumber(int phoneNumber) {
		CustomerContainer cC = CustomerContainer.getInstance();
		return cC.findCustomerByPhoneNumber(phoneNumber);
	}
}
