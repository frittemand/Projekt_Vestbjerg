


package controller;
import java.util.ArrayList;

import model.*;

public class LoanController {

private ToolLoan loan;
private	Customer customer;
private double dayRate;



public Customer findCustomerByPhoneNumber(int phoneNumber) {
	CustomerController customerController = new CustomerController();
	customer = customerController.findCustomerByPhoneNumber(phoneNumber);
	if(customer != null) {
		return customer;
	}
	else {
		throw new IllegalArgumentException("Phone number doesn't exist in the system");
	}
}

public ToolLoan createLoan(int duration) { 
	if(customer != null) {
		loan = new ToolLoan(duration, customer);
	}
	else {
		throw new IllegalArgumentException("duration invalid or customer not present");
	}
	return loan;
}

public ToolCopy addCopyToLoan(String toolName)	{
	ToolOrderline toolOrderline = null;
	ToolController toolController = new ToolController();
	ToolCopy copy = toolController.findToolByToolName(toolName);
	
	if(copy != null) {
		dayRate = toolController.findDayRate(toolName);
	}
	else {
		return copy;
		
	}

	if(dayRate != 0.0) {
		double linePrice = dayRate * loan.getDuration();
		toolOrderline = new ToolOrderline(copy, dayRate, linePrice, toolName);
		loan.addOrderlineToLoan(toolOrderline);
		toolController.updateIsHome(copy);
	}
	else {
		throw new IllegalArgumentException("error occured");
	}
	return copy;
}

public void endLoan() {
	LoanContainer loanContainer = LoanContainer.getInstance();
	loanContainer.addToolLoanToLoanContainer(loan);
}
public ArrayList<ToolOrderline> getToolOrderLines() {
	ArrayList<ToolOrderline> returnOrderlines = new ArrayList();
	returnOrderlines =loan.getToolOrderLines();
	return returnOrderlines;
}



}