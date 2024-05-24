package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ProductContainerTest {
	private ProductContainer productContainer; 
	
	@Before
	public void setUp() {
		productContainer = new ProductContainer();
		Product product = new Product (12345,10,"Hylde 1, række 1",10,11,8,"Dette er en hammer","hammer",100,10 );
		productContainer.addProduct(product);
	}

	@Test
	void findProductByBarcode(int i) {
		//Arrange
		int barcode = 12345;
		Product expectedProduct = new Product (12345,10,"Hylde 1, række 1",10,11,8,"Dette er en hammer","hammer",100,10 );
		//Act
		Product result = productContainer.findProductByBarcode(12345);
		
		//Assert
		assertEquals(expectedProduct, result);
	}
}
