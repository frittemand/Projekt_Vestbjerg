package ui;
import java.util.Scanner;

import controller.SaleController; 

public class SaleUI {
	
	public void start() {
		saleMenu();
	}
	
	public void saleMenu() {
		boolean running = true;
		while (running) {
			int choice = writeSaleMenu();
			switch (choice) {
			case 1:
				createSale();
				break;
			
			case 2:
				addProduct(choice, choice);
				break;
			
			case 3:
				makePayment(choice);
				break;
			
			case 0:
				finishSale();
				running = false;
				break;
			
			default:
				System.out.println("Not valid input.");
		}
		
	}
	}

	private int writeSaleMenu() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("** Sale Menu **");
		System.out.println(" (1) Create Sale");
		System.out.println(" (2) Add Product");
		System.out.println(" (3) Make Payment");
		System.out.println(" (0) Finish");
		System.out.print("\n Choose");
		int choice = getIntegerFromUser(keyboard);
		return choice;

	}

	public void createSale() {
		SaleController sc = new SaleController();
		sc.createSale();
	}
	
	public void finishSale() {
		System.out.print("Null");
	}
	
	public void addProduct(int quantity, int barcode) {
		SaleController sc = new SaleController();
		sc.addProduct(barcode);
		
	}
	
	public void makePayment(double amount);
		SaleController sc = new SaleController();
		sc.makePayment(amount);
	}

	private int getIntegerFromUser(Scanner keyboard) {
    while (!keyboard.hasNextInt()) {
        System.out.println("Invalid input.");
        keyboard.nextLine();
    }
    return keyboard.nextInt();
}