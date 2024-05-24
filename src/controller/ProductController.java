/**
 * 
 */
package controller;

import model.Product;
import model.ProductContainer;

/**
 * 
 */
public class ProductController {

	private ProductContainer productContainer;
	
	public ProductController() {
		productContainer = ProductContainer.getInstance();
	}

	public Product findProductByBarcode(int barcode) {
		return productContainer.findProductByBarcode(barcode);
	}
	
	/*
	 * public void updateStockCount(int o.quantity, o.product) {
	 * 
	 * }
	 */

}