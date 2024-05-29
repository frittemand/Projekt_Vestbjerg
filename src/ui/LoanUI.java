package ui;

import java.util.Scanner;

import controller.LoanController;

public class LoanUI {
	private LoanController loanController;
	
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
			createLoan();
			addCopyToLoan();
			break;
		
		case 2:
			System.out.println("not implemented");
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
	System.out.println("** Sale Menu **");
	System.out.println(" (1) Create Sale");
	System.out.println(" (2) Not implemented");
	System.out.println(" (3) Make Payment");
	System.out.println(" (0) Finish");
	System.out.print("\n Choose: ");
	int choice = getIntegerFromUser(keyboard);
	return choice;

}	
	
	
	public void findCustomerByPhoneNumber(int phoneNumber) {
		loanController.findCustomerByPhoneNumber(phoneNumber);
	}
	
	public void createLoan() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many days do you want to loan the item?");
		int numberOfDays = scanner.nextInt();
		loanController.createLoan(numberOfDays);
		scanner.close();
	}
	
	public void addCopyToLoan(String toolName) {
		//TODO implement method
		
	}
	
	public void endLoan() {
		loanController.endLoan();
	}
}
