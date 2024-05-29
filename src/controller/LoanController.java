


package controller;
import model.*;

public class LoanController {

private ToolLoan loan;
private	Customer customer;
private double dayRate;



public Customer findCustomerByPhoneNumber(int phoneNumber) {
	CustomerController cc = new CustomerController();
	customer = cc.findCustomerByPhoneNumber(phoneNumber);
	if(customer != null) {
		return customer;
	}
	else {
		throw new IllegalArgumentException("Phone number doesn't exist in the system");
	}
}

public void createLoan(int duration) { 
	if(customer != null) {
		loan = new ToolLoan(duration, customer);
	}
	else {
		throw new IllegalArgumentException("duration invalid or customer not present");
	}
}

public ToolCopy addCopyToLoan(String toolName)	{
	ToolOrderline to = null;
	ToolController tc = new ToolController();
	ToolCopy copy = tc.findToolByToolName(toolName);
	
	if(copy != null) {
		dayRate = tc.findDayRate(toolName);
	}
	else {
		return copy;
		
	}

	if(dayRate != 0.0) {
		to = new ToolOrderline(copy, dayRate);
		loan.addOrderlineToLoan(to);
		tc.updateIsHome(copy);
	}
	else {
		throw new IllegalArgumentException("error occured");
	}
	return copy;
}

public void finishLoan() {
	LoanContainer lc = LoanContainer.getInstance();
	lc.addToolLoanToLoanContainer(loan);
}



}