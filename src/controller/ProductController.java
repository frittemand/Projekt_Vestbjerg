/**
 * 
 */
package controller;

import model.Product;
import model.ProductContainer;
import model.SaleContainer;

/**
 * 
 */
public class ProductController {

	
	public ProductController() {
	}

	public Product findProductByBarcode(int barcode) {
		ProductContainer pC = ProductContainer.getInstance();
		return pC.findProductByBarcode(barcode);
	}
	
	
	public void updateStockCount(int quantity, Product product) {
		ProductContainer pC = ProductContainer.getInstance();
		pC.updateStockCount(quantity, product);
}
}