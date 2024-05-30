package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ToolLoan {
	/**
	 * fields of ToolLoan
	 */
	private ArrayList<ToolOrderline> toolOrderlines = new ArrayList<>();
	private int duration; 
	private LocalDate loanDate;
	private boolean isReturned;
	private boolean loanIsPaid;
	private double totalLoanPrice;
	private Customer customer;
	private LocalDate loanEndDate;
	private ToolOrderline currentOrderline;
	
	/**
	 * constructor for ToolLoan
	 * @param duration is the amount of days loan is active
	 * @param customer is a Customer instance 
	 * isReturned keeps track of tools home status
	 * loanEndDate calcutes what date the loan is supposed to be returned 
	 */
	public ToolLoan(int duration, Customer customer) {
		this.duration = duration;
		this.customer = customer;
		isReturned = false;
		loanDate = LocalDate.now();
		loanEndDate = loanDate.plusDays(duration);
		
	}
	
	/**
	 * @param toolOrderline is an orderline
	 * adds the Orderline input
	 */
	public void addOrderlineToLoan(ToolOrderline toolOrderline) {
			toolOrderlines.add(toolOrderline);	
			currentOrderline = toolOrderline;
		}
	/**
	 * @returns the duration of the loan
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @returns the lineprice of the current orderline 
	 */
	public double getOrderlineLinePrice() {
		return currentOrderline.getLinePrice();
	}
	/**
	 * @returns the toolName of the current orderline
	 */
	public String getOrderlineToolName() {
		return currentOrderline.getToolName();
	}
	
	/**
	 * @returns the dayrate of the current orderline
	 */
	public double getOrderlineDayRate() {
		return currentOrderline.getToolDayRate();
	}
	/**
	 * @param newTotalPrice is a new total price
	 * sets the field totalLoanPrice to a new one.
	 */
	public void setTotalLoanPrice(double newTotalPrice) {
		totalLoanPrice = newTotalPrice;
	}
	/**
	 * @returns a copy of toolOrderlines arraylist.
	 */
	public ArrayList<ToolOrderline> getToolOrderLines() {
		ArrayList<ToolOrderline>returnToolOrderLine = new ArrayList(); 
		returnToolOrderLine = toolOrderlines;
		return returnToolOrderLine ;
	}
}