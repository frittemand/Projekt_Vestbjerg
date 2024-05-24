package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ProductContainerTest {
	private ProductContainer productContainer; 

	@Test
	void findProductByBarcode(int i) {
		//Arrange
		productContainer = new ProductContainer();
		Product product = new Product (12345,10,"Hylde 1, række 1",10,11,8,"Dette er en hammer","hammer",100,10);
		productContainer.addProduct(product);
		
		Product expectedProduct = new Product (12345,10,"Hylde 1, række 1",10,11,8,"Dette er en hammer","hammer",100,10);
		
		//Act
		int barcode = expectedProduct.getBarcode();
		Product result = productContainer.findProductByBarcode(barcode);
		
		//Assert
		assertEquals(expectedProduct, result);
	}
}
