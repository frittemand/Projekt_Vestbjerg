


package controller;
import java.util.ArrayList;

import model.*;

public class LoanController {

/**
 * fields for LoanController
 */
private ToolLoan loan;
/**
 * 
 */
private	Customer customer;
/**
 * 
 */
private double dayRate;

/**
 * constructor for LoanController
 */
public LoanController () {
	
}

/**
 * @param phoneNumber is a phoneNumber of a Customer
 * @returns a Customer
 * creates a new CustomerController
 * runs findCustomerByPhoneNumber in customerController with phoneNumber as input
 * checks if customer is null
 */
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

/**
 * @param duration is the duration of a loan
 * @returns a ToolLoan
 * checks if Customer is null
 * creates a new loan with duration and customer as input
 */
public ToolLoan createLoan(int duration) { 
	if(customer != null) {
		loan = new ToolLoan(duration, customer);
	}
	else {
		throw new IllegalArgumentException("duration invalid or customer not present");
	}
	return loan;
}

/**
 * @param toolName is the name of a Tool
 * @returns a ToolCopy
 * creates new ToolController and runs findToolByToolName in it with toolName as input
 * checks if copy is null, returns copy if null. runs findDayRate in toolController if not null
 * calculates linePrice
 * runs addOrderlineToLoan with toolOrderline as input
 * runs updateIsHome in toolController
 */
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

/**
 * runs getInstance in LoanController
 * runs addToolLoanToLoanContainer in loanContainer with loan as input 
 */
public void endLoan() {
	LoanContainer loanContainer = LoanContainer.getInstance();
	loanContainer.addToolLoanToLoanContainer(loan);
}
/**
 * @return a ArrayList
 */
public ArrayList<ToolOrderline> getToolOrderLines() {
	ArrayList<ToolOrderline> returnOrderlines = new ArrayList();
	returnOrderlines =loan.getToolOrderLines();
	return returnOrderlines;
}



}