package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ToolLoan {
	private ArrayList<ToolOrderline> toolOrderlines = new ArrayList<>();
	private int duration; 
	private LocalDate loanDate;
	private boolean isReturned;
	private boolean loanIsPaid;
	private double totalLoanPrice;
	
	public ToolLoan(int duration, Customer customer) {
		this.duration = duration;
		this.customer = customer; //TODO Resolve this issue
	}
	
	public void addToolOrderlineToToolOrderline(ToolOrderline to) {
		if (to != null) {
			toolOrderlines.add(to);			
		}else {
			System.out.println("There are no ToolOrderline to be added");
		}
	}
	
	public void setTotalLoanPrice(double newTotalPrice) {
		totalLoanPrice = newTotalPrice;
	}
}
