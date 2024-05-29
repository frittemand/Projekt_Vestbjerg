package controller;
import model.*;

public class LoanController {

private ToolLoan l;
private ToolOrderline to;
private ToolCopy copy;
private	Customer c;
private double dr;



public Customer findCustomerByPhoneNumber(int phoneNumber) {
	CustomerController cc = new CustomerController();
	c = cc.findCustomerByPhoneNumber(phoneNumber);
	if(c != null) {
		return c;
	}
	else {
		throw new IllegalArgumentException("Phone number doesn't exist in the system");
	}
}

public void createLoan(int duration) {
	if(c != null) {
		l = new ToolLoan(duration, c);
	}
	else {
		throw new IllegalArgumentException("duration invalid or customer not present");
	}
}

public void addCopyToLoan(String toolName)	{
	ToolController tc = new ToolController();
	
	copy = tc.findToolByToolName(toolName);
	if(copy != null) {
		
	}
	else {
		throw new IllegalArgumentException("Tool unavailable");
	}
	
	dr = tc.findDayRate(toolName);
	if(dr != 0.0) {
	}
	else {
		throw new IllegalArgumentException("Tool doesnt exist");
	}
	
	if(copy != null && dr != 0.0) {
		to = new ToolOrderline(copy, dr);
	}
	else {
		throw new IllegalArgumentException("error occured");
	}
	
	if(to != null) {
		l.addToolOrderlineToToolOrderline(to);
		tc.updateIsHome(copy);
	}
	else {
		throw new IllegalArgumentException("error occured");
	}
}

public void finishLoan() {
	LoanContainer lc = LoanContainer.getInstance();
	lc.addToolLoanToLoanContainer(l);
}



}