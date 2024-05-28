package ui;

import controller.CustomerController;
import controller.LoanController;

public class LoanUI {
	private LoanController loanController;
	private CustomerController customerController; //TODO Add this attribute to the design class diagram
	
	public void findCustomerByPhoneNumber(int phoneNumber) {
		customerController.findCustomerByPhoneNumber(phoneNumber);
	}
	
	public void createLoan(int duration) {
		loanController.createLoan(duration);
	}
	
	public void addCopyToLoan(String toolName) {
		//TODO implement method
		
	}
	
	public void endLoan() {
		loanController.endLoan();
	}
}
