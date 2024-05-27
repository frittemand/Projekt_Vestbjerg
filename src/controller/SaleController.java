package controller;

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
	
	ProductController pC = new ProductController(); 	
	Product p = pC.findProductByBarcode(barcode);
	
	o = new Orderline(quantity, p);
	
	this.s.addOrderline(o);
	
	pC.updateStockCount(quantity, p);
	
	double total = o.getLinePrice() + s.getTotalPrice();
	s.setTotalPrice(total);
}















}

