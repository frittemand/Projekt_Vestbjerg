package controller;

import java.util.ArrayList;

import model.Orderline;
import model.Product;
import model.Sale;
import model.SaleContainer;

public class SaleController {
private Sale s;
private Orderline o;


public void createSale() {
	this.s = new Sale ();
}

public void makePayment(double amount) {
	SaleContainer sC = SaleContainer.getInstance();
	
	s.setAmountPaid(amount);
	
	double change = amount - s.getTotalPrice(); 
	
	s.setChangeAmount(change);
	
	sC.addSaleToSaleContainer(s);
}

//
public void addProduct(int quantity, int barcode) {
	if(this.s == null) {
		createSale();
	}
	ProductController pC = new ProductController(); 	
	Product p = pC.findProductByBarcode(barcode);
	
	o = new Orderline(quantity, p);
	
	s.addOrderline(o);
	
	pC.updateStockCount(quantity, p);
	
	double total = o.getLinePrice() + s.getTotalPrice();
	s.setTotalPrice(total);
	
}
public ArrayList<Orderline> getOrderlinesFromOrder() {
	ArrayList<Orderline>orderLinesOnSale = new ArrayList<>();
	orderLinesOnSale = s.getOrderline();
	return orderLinesOnSale;
		
	}
	
	
}
















