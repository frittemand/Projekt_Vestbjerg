package ui;
import java.util.Scanner;
public class MainUI {
	private SaleUI newSaleUI;
	private LoanUI newLoanUI;
		    public MainUI() {
		    	 
		        
		       
		    }
		    
		    public static void main(String []args) {
		    	MainUI mainUI = new MainUI(); 
		    	mainUI.mainMenu();
		    	
		    }
		    public void mainMenu() {
		        boolean running = true;
		        while (running) {
		            int choice = writeMainMenu();
		            switch (choice) {
		                case 1:
		                	SaleUI newSaleUI = new SaleUI();
		                	running = false;
		                	newSaleUI.start();
		                	 
		                  break;
		                case 2:
		                  LoanUI newLoanUI = new LoanUI();	
		                  running = false;
		                	newLoanUI.start();
		                  break;
		                case 3:
		                System.out.println("Denne er ikke implementeret endnu");
		                  break;
		                case 9:
		                  System.out.println("Test data gennemført.");
		                  generateData();
		                  break;
		                case 0:
		                  System.out.println("Tak for denne gang.");
		                  running = false;
		                  break;
		                default:
		                  System.out.println("Der er sket en uforklarlig fejl, choice = "+choice);
		                  break;
		            }
		        }
		    }

private int writeMainMenu() {
	Scanner keyboard = new Scanner(System.in);
	System.out.println("****** Main menu ******");
	System.out.println(" (1) Sale");
	System.out.println(" (2) Lend Tools");
	System.out.println(" (3) Products");
	System.out.println(" (9) Generate Test data");
	System.out.println(" (0) Close Program");
	System.out.print("\n Chose:");

	while (!keyboard.hasNextInt()) {
		System.out.println("Plz insert a number");
		keyboard.nextLine();
	}
	int choice = keyboard.nextInt();
	return choice;
}

public void generateData() {
	new TryMe();
}
}

