package model;

import java.util.ArrayList;
import model.Product;
import java.util.Iterator;

public class ProductContainer {
	private ArrayList<Product> products = new ArrayList<>();
	private static ProductContainer INSTANCE;

	public ProductContainer(){
	}

	public static ProductContainer getInstance() {
		if (INSTANCE == null){
			INSTANCE = new ProductContainer();
		}
		return INSTANCE;
	}

	public void addProduct(Product product) {
		if (product == null) {
			System.out.print("No product added. Please select a product");
		} else {
			products.add(product);
		}
	}

	public Product findProductByBarcode(int barcode) {
		Product foundProduct = null;
		boolean searching = true;
		Iterator<Product> it = products.iterator();
		while(it.hasNext() && searching) {
			Product product = it.next();
			if(product.getBarcode() ==barcode){
				foundProduct = product; 
				searching = false;
				
			}
			
		}
		return foundProduct;
	}
		
	public void updateStockCount(int quantity, Product product) {
		int newStockCount = product.getStockCount() - quantity; 
		product.setStockCount(newStockCount);
	}
}
