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
//Checker den ordentligt for null? samme med ovenfor.
public void createLoan(int duration) {
	if(c != null) {
		l = new ToolLoan(duration, c);
	}
	else {
		throw new IllegalArgumentException("duration invalid or customer not present");
	}
}

public ToolCopy findToolByToolName(String toolName) {
	ToolController tc = new ToolController();
	copy = tc.findToolByToolName(toolName);
	if(copy != null) {
		return copy;
	}
	else {
		throw new IllegalArgumentException("Tool unavailable");
	}
}

public double findDayRate(String ToolName) {
	ToolController tc = new ToolController();
	dr = tc.findDayRate(ToolName);
	if(dr != 0.0) {
	return dr;
	}
	else {
		throw new IllegalArgumentException("Tool doesnt exist");
	}
}
	
public ToolOrderline createOrderline() {
	if(copy != null && dr != 0.0) {
		to = new ToolOrderline(copy, dr);
		return to;
	}
	else {
		throw new IllegalArgumentException("error occured");
	}
}

public void addOrderlineToLoan() {
	if(to != null) {
		l.addToolOrderlineToToolOrderline(to);
		updateIsHome();
	}
	else {
		throw new IllegalArgumentException("error occured");
	}
}
	public void updateIsHome() {
		ToolController tc = new ToolController();
		if(to.getCopy() != null) {
			tc.updateIsHome(copy);
		}
		else {
			throw new IllegalArgumentException("error occured");
		}
	}

public void addToolLoanToToolLoanContainer() {
	LoanContainer lc = LoanContainer.getInstance();
	
	lc.addToolLoanToToolContainer(l);
}


}