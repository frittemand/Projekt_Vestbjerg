package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductContainerTest {

	@Test
	Product findProductByBarcode(int i) {
		//Arrange
		Product product = new Product (12345,10,"Hylde 1, række 1",10,11,8,"Dette er en hammer","hammer",100,10 );
		
		//Act
		result = findProductByBarcode(barcode);
		
		//Assert
		assertEquals(product, result);
	}

}
