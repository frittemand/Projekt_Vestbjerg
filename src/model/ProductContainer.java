package model;

import java.util.ArrayList;

public class ProductContainer {
	private ArrayList<Product> products = new ArrayList<>();
	private static ProductContainer INSTANCE;
	
	private ProductContainer(){
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
}
