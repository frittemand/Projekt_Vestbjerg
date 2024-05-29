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
	private Customer customer;
	private LocalDate loanEndDate;
	
	public ToolLoan(int duration, Customer customer) {
		this.duration = duration;
		this.customer = customer;
		isReturned = false;
		loanDate = LocalDate.now();
		loanEndDate = loanDate.plusDays(duration);
		
	}
	
	public void addOrderlineToLoan(ToolOrderline to) {
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