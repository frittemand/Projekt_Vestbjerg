/**
 * 
 */
package controller;

import model.Product;
import model.ProductContainer;
import model.SaleContainer;

public class ProductController {

	
	/**
	 * constructor for ProductController
	 */
	public ProductController() {
	}

	/**
	 * @param barcode is a barcode of a specific Product
	 * @returns a Product
	 * runs getInstance in ProductContainer
	 * runs findProductByBarcode in productContainer with barcode as input
	 */
	public Product findProductByBarcode(int barcode) {
		ProductContainer productContainer = ProductContainer.getInstance();
		return productContainer.findProductByBarcode(barcode);
	}
	
	
	/**
	 * @param quantity is amount of a product that a Customer wishes to buy
	 * @param product is a specific product a Customer wishes to buy
	 * runs getInstance in ProductContainer
	 * runs updateStockCount in pC with quantity and product as inputs
	 */
	public void updateStockCount(int quantity, Product product) {
		ProductContainer pC = ProductContainer.getInstance();
		pC.updateStockCount(quantity, product);
}
}