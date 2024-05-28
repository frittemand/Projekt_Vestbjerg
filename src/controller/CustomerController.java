package controller;

import model.Customer;
import model.CustomerContainer;

public class CustomerController {
	
	public CustomerController() {};
	
	public Customer findCustomerByPhoneNumber(int phoneNumber) {
		CustomerContainer cC = CustomerContainer.getInstance();
		return cC.findCustomerByPhoneNumber(phoneNumber);
	}
}
