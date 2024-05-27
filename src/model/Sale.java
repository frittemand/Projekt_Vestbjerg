package model;
import java.time.LocalDate;
import java.util.ArrayList; 
public class Sale {

	private LocalDate salesDate; 
	private static int salesID = 1; 
	private double totalPrice; 
	private ArrayList<Orderline> orderlines; 
	private double changeAmount; 
	private double amountPaid; 
	private boolean isPaid;

	public Sale(){
		this.salesDate = LocalDate.now();
		this.salesID = salesID++;
		this.changeAmount = 0; 
		this.amountPaid = 0; 
		orderlines = new ArrayList<>(); 
	}
	public void addOrderline(Orderline o) {
		if(o != null) {
			orderlines.add(o); 
		}
	}

	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getChangeAmount() {
		return changeAmount;
	}
	public void setChangeAmount(double changeAmount) {
		this.changeAmount = changeAmount;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
		
	}
	
	
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public ArrayList<Orderline> getOrderline(){
		ArrayList<Orderline> returnOrderlines = new ArrayList<>();
		returnOrderlines = orderlines;
		
		return returnOrderlines;
	}
}


