package ui;

import java.util.ArrayList;
import java.util.Scanner;

import controller.LoanController;
import model.Customer;
import model.Orderline;
import model.Product;
import model.ToolCopy;
import model.ToolLoan;
import model.ToolOrderline;

public class LoanUI {
	private LoanController loanController;
	private ToolLoan loan;
	
public LoanUI(){
	loanController = new LoanController(); 
}
	
public void start() {
	loanMenu();
		}

public void loanMenu() {
	boolean running = true;
	while (running) {
		int choice = writeLoanMenu();
		switch (choice) {
		case 1:
			findCustomerByPhoneNumber();
			break;
		
		case 2:
			addCopyToLoan();
			break;
		
		case 3:
			
			break;
		
		case 0:
			endLoan();
			running = false;
			break;
		
		default:
			System.out.println("Not valid input.");
			break;
		}	
	}
}

private int writeLoanMenu() {
	Scanner keyboard = new Scanner(System.in);
	System.out.println("** Loan Menu **");
	System.out.println(" (1) Create Loan");
	System.out.println(" (2) Add Tools");
	System.out.println(" (3) End Loan");
	System.out.println(" (0) Finish");
	System.out.print("\n Choose: ");
	int choice = getIntegerFromUser(keyboard);
//	keyboard.close();
	return choice;

}	
	
	
	public void findCustomerByPhoneNumber() {
		System.out.println("Customer phonenumber plz");
		Scanner scanner = new Scanner(System.in);
		int phoneNumber = scanner.nextInt();
//		scanner.close();
		
		Customer customer = loanController.findCustomerByPhoneNumber(phoneNumber);
		if(customer ==null) {
			System.out.println("No customer found, try again");
			findCustomerByPhoneNumber();
		}
		else { 
			System.out.println("Customer name is:" + customer.getName());
			System.out.println("Confirm");
			System.out.println("1 for yes: 0 for no");
			
			Scanner scanner2 = new Scanner(System.in);
			int confirmChoice = scanner2.nextInt();
//			scanner2.close();
			
			if(confirmChoice == 1) {
				createLoan();
				
			}
			else {
				findCustomerByPhoneNumber();
			}
		}
	}
	
	public void createLoan() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many days do you want to loan the item?");
		int numberOfDays = scanner.nextInt();
		if(numberOfDays <= 0) {
			System.out.println("A loan can't be less than 0 days");
			createLoan();
		}
		else {
		loan = loanController.createLoan(numberOfDays);
//		scanner.close();
	}
	}
	public void addCopyToLoan() {
		boolean running = true;
		while(running = true) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert Tool Name");
		String toolName = scanner.nextLine();
		ToolCopy copy = loanController.addCopyToLoan(toolName);
		if (copy == null) {
			System.out.println("couldnt find any Tools ");
			System.out.println("Try again");
			addCopyToLoan();
		}
		System.out.println("tool: " + loan.getOrderlineToolName());
		System.out.println("DayRate: " + loan.getOrderlineDayRate());
		System.out.println("Price for period: " + loan.getOrderlineLinePrice());
		System.out.println("Add more tools?");
		System.out.println("1 for yes. 0 for no");
		
		int confirmChoice = getIntegerFromUser(scanner);
		if(confirmChoice == 1) {
			addCopyToLoan();
		}
		else {
			running = false;
			endLoan();
		}
		}
		}
		
	
	
	public void endLoan() {
		printReceipt();
		loanController.endLoan();
		
	}
	
	private int getIntegerFromUser(Scanner keyboard) {
	    while (!keyboard.hasNextInt()) {
	        System.out.println("Invalid input.");
	        keyboard.nextLine();
	    }
	    return keyboard.nextInt();
	}
	private void printReceipt() {
		System.out.println("The Loan is completed");
		System.out.println("Here is your receipt");
		ArrayList<ToolOrderline> printLines = loanController.getToolOrderLines();

		for (ToolOrderline orderline : printLines) {
			
			System.out.println("Tool: "+orderline.getToolName() + "Day rate: " + orderline.getToolDayRate() + " Price for period: "+ orderline.getLinePrice());
}
	}
}