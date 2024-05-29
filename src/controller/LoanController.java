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
	
	if(copy != null) {
		copy = tc.findToolByToolName(toolName);
	}
	else {
		throw new IllegalArgumentException("Tool unavailable");
	}

	if(dr != 0.0) {
		dr = tc.findDayRate(toolName);
	}
	else {
		throw new IllegalArgumentException("error occured");
	}
	
	to = new ToolOrderline(copy, dr);
	l.addOrderlineToLoan(to);
	tc.updateIsHome(copy);
}

public void finishLoan() {
	LoanContainer lc = LoanContainer.getInstance();
	lc.addToolLoanToLoanContainer(l);
}



}