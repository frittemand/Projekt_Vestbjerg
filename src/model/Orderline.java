package model;

import java.time.LocalDate;

public class Orderline {
	private int quantity;
	private Product product;
	private double linePrice;

	public Orderline(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
		this.linePrice = product.getCurrentPrice(LocalDate.now()) * quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getLinePrice() {
		return linePrice;
	}

	public Product getProduct() {
		return product;
	}

}
