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
}
