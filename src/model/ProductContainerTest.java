package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductContainerTest {
	private ProductContainer productContainer;

	@Test
	void testFindProductByBarcode() {
		//Arrange
		productContainer = new ProductContainer();
		Product expectedProduct = new Product (12345,10,"Hylde 1, række 1",10,11,8,
											   "Dette er en hammer","hammer",100,10);
		productContainer.addProduct(expectedProduct);
				
		//Act
		int barcode = 12345;
		Product result = productContainer.findProductByBarcode(barcode);
		
		//Assert
		assertEquals(expectedProduct, result);
	}
	
	@Test
	void testUpdateStockCount() {
		//Arrange
		Product hammer = new Product (12345,10,"Hylde 1, række 1",10,11,8,
				   "Dette er en hammer","hammer",100,10);
		hammer.setStockCount(100);
		productContainer = new ProductContainer();
		productContainer.addProduct(hammer);
		
		//Act
		productContainer.updateStockCount(20, hammer);
		int result = hammer.getStockCount();
		
		//Assert
		assertEquals(80, result);
	}
}