package model;
import java.time.LocalDate;
import java.util.ArrayList; 
public class Sale {
	/**
	 * fields for Sale
	 * 
	 */
	private LocalDate salesDate; 
	/**
	 * 
	 * 
	 */
	private static int salesID = 1; 
	/**
	 * 
	 */
	private double totalPrice; 
	/**
	 * 
	 */
	private ArrayList<Orderline> orderlines; 
	/**
	 * 
	 */
	private double changeAmount; 
	/**
	 * 
	 */
	private double amountPaid; 
	/**
	 * 
	 */
	private boolean isPaid;

	/**
	 * constructor for Sale
	 * salesDate is the date the sale is made
	 * changeAmount is how Customer gets back after paying
	 * amountPaid is how much the customer paid
	 */
	public Sale(){
		this.salesDate = LocalDate.now();
		this.salesID = salesID++;
		this.changeAmount = 0; 
		this.amountPaid = 0; 
		orderlines = new ArrayList<>(); 
	}
	/**
	 * @param o is an Orderline
	 * checks is Orderline input is valid 
	 * adds Orderline to orderlines ArrayList
	 */
	public void addOrderline(Orderline o) {
		if(o != null) {
			orderlines.add(o); 
		}
	}

	/**
	 * @returns a totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice is the total that needs to be paid
	 * sets totalPrice = totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * @returns a changeAmount
	 */
	public double getChangeAmount() {
		return changeAmount;
	}
	/**
	 * @param changeAmount is an amount an Customer needs returned
	 * sets changeAmount to new changeAmount
	 */
	public void setChangeAmount(double changeAmount) {
		this.changeAmount = changeAmount;
	}
	/**
	 * @returns an amountPaid
	 */
	public double getAmountPaid() {
		return amountPaid;
	}
	/**
	 * @param amountPaid is how much a Customer has paid
	 * sets amountPaid to new amountPaid
	 */
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
		
	}
	/**
	 * @returns a salesDate
	 */
	public LocalDate getSalesDate() {
		return salesDate;
	}	
	
	/**
	 * @returns a isPaid state
	 */
	public boolean isPaid() {
		return isPaid;
	}
	/**
	 * @param isPaid is a new state
	 * sets isPaid to the new state
	 */
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	/**
	 * @returns a copy of Orderline
	 * creates a copy ArrayList sets it to orderlines ArrayList
	 */
	public ArrayList<Orderline> getOrderline(){
		ArrayList<Orderline> returnOrderlines = new ArrayList<>();
		returnOrderlines = orderlines;
		
		return returnOrderlines;
	}
	
	public int getSalesID() {
		return salesID;
	}
}


