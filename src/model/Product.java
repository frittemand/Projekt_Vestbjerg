package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Stack;

public class Product {

	/**
	 * fields of Product
	 * 
	 */
	private Stack<Price> basePriceLog;
	/**
	 * 
	 */
	private Stack<Price> currentPriceLog;
	/**
	 * 
	 */
	private Stack<Price> purchasePriceLog;
	/**
	 * 
	 */
	private int stockCount;
	/**
	 * 
	 */
	private String locationNumber;
	/**
	 * 
	 */
	private int barcode;
	/**
	 * 
	 */
	private double basePrice;
	/**
	 * 
	 */
	private double currentPrice;
	/**
	 * 
	 */
	private double purchasePrice;
	/**
	 * 
	 */
	private String itemName;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private int maxStock;
	/**
	 * 
	 */
	private int minStock;

	/**
	 * basePriceLog creates a new stack consisting of Price objects
	 * currentPriceLog creates a new stack consisting of Price objects
	 * pruchasePriceLog creates a new stack consisting of Price objects
	 * @param barcode is a products barcode
	 * @param stockCount is how many of a product is in inventory
	 * @param locationNumber is where the product is physically located
	 * @param basePrice is a products price when not on sale
	 * @param currentPrice is what a product is selling for at the moment
	 * @param purchasePrice is how much the store paid for a product
	 * @param description is a description of a product
	 * @param itemName is the name of a product
	 * @param maxStock is the maximum amount of a product that is allowed to be stored in the inventory
	 * @param minStock is the minimum amount of a product before a restock must happen
	 * 
	 * 
	 */
	
	/*
	 * constructor for Product
	 * pr1 stores new Price with purchasePrice as input
	 * pr2 stores new Price with purchasePrice as input
	 * pr3 stores new Price with purchasePrice as input
	 * 
	 * creates a new Product object aswell as 3 Price objects associated to the Product.
	 * 3 stacks basePriceLog, currentPriceLog and purchasePriceLog are initialized.
	 * the 3 prices are stored as local variables, and pushed to the top of a stack.
	 * theres 1 stack for each price. New Price with input basePrice, goes to the top of stack basePriceLog.
	 * Price with input currentPrice goes on top of stack currentPriceLog and so on.
	 *
	 */
	public Product(int barcode, int stockCount, String locationNumber, double basePrice, double currentPrice,
			double purchasePrice, String description, String itemName, int maxStock, int minStock) {
		basePriceLog = new Stack<>();
		currentPriceLog = new Stack<>();
		purchasePriceLog = new Stack<>();
		this.barcode = barcode;
		this.stockCount = stockCount;
		this.locationNumber = locationNumber;
		this.description = description;
		this.itemName = itemName;
		this.maxStock = maxStock;
		this.minStock = minStock;
		this.basePrice = basePrice;
		this.currentPrice = currentPrice;
		this.purchasePrice = purchasePrice;

		Price pr1 = new Price(basePrice);
		basePriceLog.push(pr1);

		Price pr2 = new Price(currentPrice);
		currentPriceLog.push(pr2);

		Price pr3 = new Price(purchasePrice);
		purchasePriceLog.push(pr3);

	}

	/**
	 * @returns a stockCount
	 */
	public int getStockCount() {
		return stockCount;
	}

	/**
	 * @returns a locationNumber
	 */
	public String getLocationNumber() {
		return locationNumber;
	}

	/**
	 * @returns a barcode
	 */
	public int getBarcode() {
		return barcode;
	}

	/**
	 * @returns a basePrice
	 */
	public double getBasePrice() {
		return basePriceLog.peek().getValue();

	}	

	/**
	 * @returns a currentPrice
	 */
	public double getCurrentPrice() {
		return currentPriceLog.peek().getValue();
	}

	/**
	 * @returna purchasePrise
	 */
	public double getPurchasePrice() {
		return purchasePriceLog.peek().getValue();
	}

	/**
	 * @returns itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @returns a description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @returns a maxStock
	 */
	public int getMaxStock() {
		return maxStock;
	}

	/**
	 * @returns a minStock
	 */
	public int getMinStock() {
		return minStock;
	}

	/**
	 * @param newStockCount is a updated product stockCount
	 * sets stockCount to newStockCount
	 */
	public void setStockCount(int newStockCount) {
		stockCount = newStockCount;
	}

	/**
	 * @param priceLogDate
	 * @return
	 */
	public double getBasePrice(LocalDate priceLogDate) {
		Stack<Price> tempStack = (Stack<Price>) basePriceLog.clone();
		boolean found = false;
		Price pr = null;
		while (!found && !tempStack.empty()) {
			if (tempStack.peek().getDateFrom().compareTo(priceLogDate) >= 0) {
				pr = tempStack.peek();
				found = true;
			} else {
				tempStack.pop();
			}
		}
		if (pr.getValue() == 0.0) {
			System.out.println("The product does't exist in the stack");
			return 0.0;
		} else {
			return pr.getValue();
		}
	}

	/**
	 * @param priceLogDate
	 * @return
	 */
	public double getCurrentPrice(LocalDate priceLogDate) {
		Stack<Price> tempStack = (Stack<Price>) currentPriceLog.clone();
		boolean found = false;
		Price pr = null;
		while (!found && !tempStack.empty()) {
			if (tempStack.peek().getDateFrom().compareTo(priceLogDate) >= 0) {
				pr = tempStack.peek();
				found = true;
			} else {
				tempStack.pop();
			}
		}
		if (pr.getValue() == 0.0) {
			System.out.println("The product does't exist in the stack");
			return 0.0;
		} else {
			return pr.getValue();
		}
	}

	/**
	 * @param priceLogDate
	 * @return
	 */
	public double getPurchasePrice(LocalDate priceLogDate) {
		Stack<Price> tempStack = (Stack<Price>) purchasePriceLog.clone();
		boolean found = false;
		Price pr = null;
		while (!found && !tempStack.empty()) {
			if (tempStack.peek().getDateFrom().compareTo(priceLogDate) >= 0) {
				pr = tempStack.peek();
				found = true;
			} else {
				tempStack.pop();
			}
		}
		if (pr.getValue() == 0.0) {
			System.out.println("The product does't exist in the stack");
			return 0.0;
		} else {
			return pr.getValue();
		}
	}
}