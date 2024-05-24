package model;

public class Orderline {
private int quantity; 
private Product product; 
private double linePrice; 

public Orderline (int quantity, Product product) {
	this.quantity = quantity; 
	this.product = product;
	this.linePrice = product.getCurrentPrice()*quantity;
	//Er dette den bedste måde at sætte linePrice?? 
}

}
