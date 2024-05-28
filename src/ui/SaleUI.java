package ui;
import java.util.ArrayList;
import java.util.Scanner;
import model.Orderline;
import model.Product;
import model.Sale;
import controller.SaleController; 

public class SaleUI {
	
	private SaleController sc;
	private Sale currentSale = null; 
	
	
	public SaleUI() {
		sc = new SaleController();
		
	}
	
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
				addProduct();
				break;
			
			case 2:
				System.out.println("not implemented");
				break;
			
			case 3:
				makePayment();
				break;
			
			case 0:
				finishSale();
				running = false;
				break;
			
			default:
				System.out.println("Not valid input.");
				break;
			}	
		}
	}

	private int writeSaleMenu() {
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

	public void createSale() {		
		if(currentSale == null) {
		currentSale = sc.createSale();}
		else {
			System.out.println("Sale already exist. Plz finish current sale");
			saleMenu();
		}
		
	}
	
	public void finishSale() {
		currentSale = null;
		printReceipt();
		//MainUI mainUI = new MainUI(); 
    	//mainUI.mainMenu();
	}
	
	public void addProduct() {
		boolean running = true;
		while(running) {
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Enter product barcode: ");
		int barcode = getIntegerFromUser(keyboard);
		System.out.println("Enter quantity: ");
		int quantity = getIntegerFromUser(keyboard);
		
		sc.addProduct(quantity, barcode);
		System.out.println("The total is "+currentSale.getTotalPrice());
		System.out.println("Add another product?(1 = yes 0 = no");
		if(getIntegerFromUser(keyboard)== 1) {
			addProduct();
		}
		else{
			running = false;
			saleMenu();
			
		}
		}
		
	}
	
	public void makePayment() {
	if(!currentSale.isPaid() && currentSale != null) {
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Enter payment amount: ");
		double amount = getDoubleFromUser(keyboard);
		sc.makePayment(amount);
		System.out.println("Total price of sale "+currentSale.getTotalPrice());
		System.out.println("Amount paid"+ currentSale.getAmountPaid());
		
		System.out.println("**** Change amount****");
		System.out.println(currentSale.getChangeAmount());	
		
		System.out.println("Salget er " +currentSale.isPaid());
			if(!currentSale.isPaid()) {
				makePayment();
			}
			else { 
				finishSale();
			}
	}
		else{
			System.out.println("Payment has already been made or sale has not been created");
			}
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
    private void printReceipt() {
    	System.out.println("The sale is completed");
    	System.out.println("Here is your receipt");
		ArrayList<Orderline> printLines = sc.getOrderlinesFromOrder();
		
		for(Orderline o : printLines) {
			Product p = o.getProduct();
			
			System.out.println(p.getItemName()+" "+ "quantity " + o.getQuantity());  
		}	
    }
}