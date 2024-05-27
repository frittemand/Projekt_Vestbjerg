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

}


