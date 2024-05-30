package model;

import java.util.ArrayList;
import model.Product;
import java.util.Iterator;

public class ProductContainer {
	/**
	 * fields for ProductContainer
	 * 
	 */
	private ArrayList<Product> products = new ArrayList<>();
	/**
	 * 
	 */
	private static ProductContainer INSTANCE;

	/**
	 * Constructor for ProductContainer
	 */
	public ProductContainer(){
	}

	/**
	 * @returns a instance
	 * checks is a instance already exist and either creates a new instance return a existing instance
     * (part of singleton)
	 */
	public static ProductContainer getInstance() {
		if (INSTANCE == null){
			INSTANCE = new ProductContainer();
		}
		return INSTANCE;
	}

	/**
	 * @param product is a specific product
	 * adds product to products ArrayList
	 */
	public void addProduct(Product product) {
		products.add(product);
	}

	/**
	 * @param barcode is the barcode of a product which is used to find products
	 * @returns a product
	 * searches products ArrayList for a matching barcode. 
	 */
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
		
	/**
	 * @param quantity is amount of a product bought
	 * @param product is the product of which the amount has been bought
	 * newStockCount calculates new stock count
	 * runs setStockCount in the product instance with new stockCount as parameter
	 */
	public void updateStockCount(int quantity, Product product) {
		int newStockCount = product.getStockCount() - quantity; 
		product.setStockCount(newStockCount);
	}
}
