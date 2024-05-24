package model;

public class Product {

	
	

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

public Product(int barcode, int stockCount, String locationNumber, double basePrice,double currentPrice, double purchasePrice, String description, String itemName,int maxStock, int minStock)
{
	this.barcode = barcode;
	this.stockCount = stockCount;
	this.locationNumber = locationNumber;
	this.basePrice = basePrice;
	this.currentPrice = currentPrice;
	this.purchasePrice = purchasePrice;
	this.description = description;
	this.itemName = itemName;
	this.maxStock = maxStock;
	this.minStock = minStock;
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
