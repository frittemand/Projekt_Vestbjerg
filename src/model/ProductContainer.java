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
			Product a1 = it.next();
			if(a1.getBarcode() ==barcode){
				foundProduct = a1; 
				searching = false;
				
			}
			
		}
		return foundProduct;
	}
		
		
//		for (Product product : products) {
//			if (product.getBarcode() == barcode) {
//				foundProduct = product;
//							
//			}else {
//				System.out.println("The scanned product doesn't not exist");
//				foundProduct = null;
//			}
//		}
//		return foundProduct	;
//	}

	public void updateStockCount(int quantity, Product product) {
		int newStockCount = product.getStockCount() - quantity; 
		product.setStockCount(newStockCount);
	}
}
