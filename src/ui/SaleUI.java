package ui;
import java.util.Scanner;

import controller.SaleController; 

public class SaleUI {
	
	private SaleController sc;
	
	
	public SaleUI() {
		sc = new SaleController();
		
	}
	
	public void start() {
		saleMenu();
		writeSaleMenu();	}
	
	public void saleMenu() {
		boolean running = true;
		while (running) {
			int choice = writeSaleMenu();
			switch (choice) {
			case 1:
				createSale();
				break;
			
			case 2:
				addProduct();
				break;
			
			case 3:
				makePayment();
				break;
				
			case 4:
				generateData();
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
		System.out.println(" (4) Generate Data");
		System.out.println(" (0) Finish");
		System.out.print("\n Choose: ");
		int choice = getIntegerFromUser(keyboard);
		return choice;

	}

	public void createSale() {		
		sc.createSale();
	}
	
	public void finishSale() {
		System.out.print("Null");
	}
	
	public void addProduct() {
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Enter product barcode: ");
		int barcode = getIntegerFromUser(keyboard);
		System.out.println("Enter quantity: ");
		int quantity = getIntegerFromUser(keyboard);
		
		sc.addProduct(barcode, quantity);
		
	}
	
	public void makePayment() {
	
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Enter payment amount: ");
		double amount = getDoubleFromUser(keyboard);
		sc.makePayment(amount);
	}
	
	public void generateData() {
		new TryMe();
	}

	private int getIntegerFromUser(Scanner keyboard) {
    while (!keyboard.hasNextInt()) {
        System.out.println("Invalid input.");
        keyboard.nextLine();
    }
    return keyboard.nextInt();
	}
    private double getDoubleFromUser(Scanner keyboard) {
        while (!keyboard.hasNextDouble()) {
            System.out.println("Invalid input.");
            keyboard.nextLine();
        }
        return keyboard.nextDouble();
    }
}