package ExtraMethods;


import java.util.ArrayList;

import controller.LoanController;
import model.Tool;
import model.ToolContainer;
import model.ToolCopy;
import model.ToolLoan;
import model.ToolOrderline;



public class extraMethods {
	private LoanController loanController;
	private ToolLoan loan;
	

	//This method prints out the receit of the orderline. 
	public void printReceit() {
		System.out.println("Vestbjerg Byggecenter");
		System.out.println("Receipt");
		System.out.println("xxxxxxxxxxxxxx");
		System.out.println("Name: ");
		System.out.println("Loan items: ");
		
		ArrayList<ToolOrderline> printLines = loanController.getToolOrderLines();
		
		for (ToolOrderline orderline : printLines) {
		System.out.println("Tool: "+orderline.getToolName());
		System.out.println(" Copy Number: "+ orderline.getCopy().getCopyNumber());
		System.out.println(" Day rate: " + orderline.getToolDayRate());
		System.out.println(" Price for period: "+ orderline.getLinePrice());
		System.out.println("___");
		
	}
		System.out.println("xxxxxxxxxxxxxx");

}
	
}
