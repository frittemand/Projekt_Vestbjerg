package model;
import java.time.LocalDate;
import java.time.LocalTime;
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


public Product(int barcode, int stockCount, String locationNumber, double basePrice, double currentPrice, double purchasePrice, String description, String itemName,int maxStock, int minStock)
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
	this.basePrice = basePrice;
	this.currentPrice = currentPrice;
	this.purchasePrice = purchasePrice;
	
	
	Price pr1 = new Price(basePrice);
	basePriceLog.push(pr1);
	
	Price pr2 =  new Price(currentPrice);
	currentPriceLog.push(pr2);
	
	Price pr3 = new Price(purchasePrice);
	purchasePriceLog.push(pr3);

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

public double getBasePrice(LocalDate priceLogDate) {
	Stack<Price> tempStack = (Stack<Price>)basePriceLog.clone();
	boolean found = false;
	Price pr = null;
	while(!found && !tempStack.empty()) {
		if(tempStack.peek().getDateFrom().compareTo(priceLogDate) >= 0) {
			pr = tempStack.peek();
			found = true;
		}
		else {
			tempStack.pop();
		}
		}
	return pr.getValue();
	}


public double getCurrentPrice(LocalDate priceLogDate) {
	Stack<Price> tempStack = (Stack<Price>)currentPriceLog.clone();
	boolean found = false;
	Price pr = null;
	while(!found && !tempStack.empty()) {
		if(tempStack.peek().getDateFrom().compareTo(priceLogDate) >= 0) {
			pr = tempStack.peek();
			found = true;
		}
		else {
			tempStack.pop();
		}
		}
	return pr.getValue();
	}


public double getPurchasePrice(LocalDate priceLogDate) {
	Stack<Price> tempStack = (Stack<Price>)purchasePriceLog.clone();
	boolean found = false;
	Price pr = null;
	while(!found && !tempStack.empty()) {
		if(tempStack.peek().getDateFrom().compareTo(priceLogDate) >= 0) {
			pr = tempStack.peek();
			found = true;
		}
		else {
			tempStack.pop();
		}
		}
	return pr.getValue();
	}
}