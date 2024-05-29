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
	private ToolOrderline currentOrderline;
	
	public ToolLoan(int duration, Customer customer) {
		this.duration = duration;
		this.customer = customer;
		isReturned = false;
		loanDate = LocalDate.now();
		loanEndDate = loanDate.plusDays(duration);
		
	}
	
	public void addOrderlineToLoan(ToolOrderline toolOrderline) {
		if (toolOrderline != null) {
			toolOrderlines.add(toolOrderline);	
			currentOrderline = toolOrderline;
		}else {
			System.out.println("There are no ToolOrderline to be added");
		}
	}
	public int getDuration() {
		return duration;
	}
	public double getOrderlineLinePrice() {
		return currentOrderline.getLinePrice();
	}
	public String getOrderlineToolName() {
		return currentOrderline.getToolName();
	}
	
	public double getOrderlineDayRate() {
		return currentOrderline.getToolDayRate();
	}
	public void setTotalLoanPrice(double newTotalPrice) {
		totalLoanPrice = newTotalPrice;
	}
}