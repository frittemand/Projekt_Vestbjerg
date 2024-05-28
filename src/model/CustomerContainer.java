package model;

import java.util.ArrayList;
import java.util.Iterator;


public class CustomerContainer {

	private ArrayList<Customer> customers = new ArrayList<>();
	private static CustomerContainer INSTANCE;
	
	public static CustomerContainer getInstance() {
		if (INSTANCE == null){
			INSTANCE = new CustomerContainer();
		}
		return INSTANCE;
	}
	
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

	
}
