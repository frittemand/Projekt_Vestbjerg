package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void testGetPurchasePrice() {
		//Arrange
		Product p1 = new Product (12345, 10, "Hylde 1, række 1", 10, 11, 8, "Dette er en hammer", "hammer", 100, 10);
		
		//Act
		LocalDate targetPriceLogDate = (LocalDate priceLogDate); 
		double result = p1.getPurchasePrice(targetPriceLogDate);
		
		//Assert
		assertEquals(8, result);
	}
	
}
