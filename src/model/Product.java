package model;
import java.util.Stack;

public class Product {

private Stack<Price> basePriceLog;
private Stack<Price> currentPriceLog;
private Stack<Price> purchasePriceLog;
private int stockCount;
private String locationNumber;
private int barcode;
private double basePrice;
private double currentPrice;
private double purchasePrice;
private String itemName;
private String description;
private int maxStock;
private int minStock;


public Product(int barcode, int stockCount, String locationNumber, double newBasePrice, double newCurrentPrice, double newPurchasePrice, String description, String itemName,int maxStock, int minStock)
{
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
	
	
	Price pr1 = new Price(newBasePrice);
	basePriceLog.push(pr1);
	
	Price pr2 =  new Price(newCurrentPrice);
	currentPriceLog.push(pr2);
	
	Price pr3 = new Price(newPurchasePrice);
	purchasePriceLog.push(pr3);
	
	basePrice = basePriceLog.peek().getValue();
	currentPrice = currentPriceLog.peek().getValue();
	purchasePrice = purchasePriceLog.peek().getValue();

}

public int getStockCount() {
	return stockCount;
}

public String getLocationNumber() {
	return locationNumber;
}

public int getBarcode() {
	return barcode;
}

public double getBasePrice() {
	return basePrice;
}

public double getCurrentPrice() {
	return currentPrice;
}

public double getPurchasePrice() {
	return purchasePrice;
}

public String getItemName() {
	return itemName;
}

public String getDescription() {
	return description;
}

public int getMaxStock() {
	return maxStock;
}

public int getMinStock() {
	return minStock;
}

public void setStockCount(int newStockCount) {
	stockCount = newStockCount;
}

}