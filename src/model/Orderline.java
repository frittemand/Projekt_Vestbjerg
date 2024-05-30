package model;

import java.time.LocalDate;

public class Orderline {
	/**
	 * fields of Orderline
	 * 
	 */
	private int quantity;
	/**
	 * 
	 */
	private Product product;
	/**
	 * 
	 */
	private double linePrice;

	/**
	 * constructor for Orderline
	 * @param quantity is the amount of a product a Customer wishes to buy
	 * @param product is the exact product a Costumer wishes to buy
	 * linePrice calculates how much all of a product will cost
	 */
	public Orderline(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
		this.linePrice = product.getCurrentPrice(LocalDate.now()) * quantity;
	}

	/**
	 * @returns a quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @returns a linePrice
	 */
	public double getLinePrice() {
		return linePrice;
	}

	/**
	 * @returns a product
	 */
	public Product getProduct() {
		return product;
	}

}
