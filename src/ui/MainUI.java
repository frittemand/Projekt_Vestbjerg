package ui;
import java.util.Scanner;
public class MainUI {
	private SaleUI newSaleUI;
	//Note: denne UI er ikke helt funktionel 
		    public MainUI() {
		    	 SaleUI newSaleUI = new SaleUI();
		        
		       
		    }
		    
		    public static void main(String []args) {
		    	MainUI mainUI = new MainUI(); 
		    	mainUI.writeMainMenu();
		    	
		    }
		    private void mainMenu() {
		        boolean running = true;
		        while (running) {
		            int choice = writeMainMenu();
		            switch (choice) {
		                case 1:
		                	newSaleUI.start();
		                	running = false; 
		                  break;
		                case 2:
		                  System.out.println("Denne er ikke implementeret endnu");
		                  break;
		                case 3:
		                System.out.println("Denne er ikke implementeret endnu");
		                  break;
		                case 9:
		                  System.out.println("Denne er ikke implementeret endnu");
		                  //createTestData();
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
		    }}

	}

	public static void main(String []args) {
	}
	private void mainMenu() {
		boolean running = true;
		while (running) {
			int choice = writeMainMenu();
			switch (choice) {
			case 1:
				System.out.println("Denne er ikke implementeret endnu");
				//saleUI.start();
				break;
			case 2:
				System.out.println("Denne er ikke implementeret endnu");
				break;
			case 3:
				System.out.println("Denne er ikke implementeret endnu");
				break;
			case 9:
				System.out.println("Denne er ikke implementeret endnu");
				//createTestData();
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
	System.out.println(" (0) C");
	System.out.print("\n Chose:");

	while (!keyboard.hasNextInt()) {
		System.out.println("Plz insert a number");
		keyboard.nextLine();
	}
	int choice = keyboard.nextInt();
	return choice;
}

private void createTestData(){
	TryMe tm = new TryMe();

}
}

