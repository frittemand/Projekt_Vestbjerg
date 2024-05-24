package model;
import java.time.LocalDate;
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


public Product(int barcode, int stockCount, String locationNumber, double BasePrice, double CurrentPrice, double PurchasePrice, String description, String itemName,int maxStock, int minStock)
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
	
	
	Price pr1 = new Price(this.basePrice);
	basePriceLog.push(pr1);
	
	Price pr2 =  new Price(this.currentPrice);
	currentPriceLog.push(pr2);
	
	Price pr3 = new Price(this.purchasePrice);
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


public double getBasePrice(LocalDate date) {
	Stack<Price> tempStack = new Stack<>();
	Price pr = basePriceLog.pop();;
	Price lastPrice = null;
	while(!basePriceLog.isEmpty()) {
		if(pr.getDateFrom().compareTo(date) >= 0) {
			lastPrice = pr;
		}
		else {
		while(!tempStack.isEmpty()) {
			basePriceLog.push(tempStack.pop());
		}
		}
	}
	return lastPrice.getValue();
}

public double getCurrentPrice(LocalDate date) {
	Stack<Price> tempStack = new Stack<>();
	Price pr = currentPriceLog.pop();;
	Price lastPrice = null;
	while(!currentPriceLog.isEmpty()) {
		if(pr.getDateFrom().compareTo(date) >= 0) {
			lastPrice = pr;
		}
		else {
		while(!tempStack.isEmpty()) {
			currentPriceLog.push(tempStack.pop());
		}
		}
	}
	return lastPrice.getValue();
}

public double getPurchasePrice(LocalDate date) {
	Stack<Price> tempStack = new Stack<>();
	Price pr = purchasePriceLog.pop();;
	Price lastPrice = null;
	while(!purchasePriceLog.isEmpty()) {
		if(pr.getDateFrom().compareTo(date) >= 0) {
			lastPrice = pr;
		}
		else {
		while(!tempStack.isEmpty()) {
			purchasePriceLog.push(tempStack.pop());
		}
		}
	}
	return lastPrice.getValue();
}

public void setStockCount(int newStockCount) {
	stockCount = newStockCount;
}

}