package ui;
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
