package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Stack;
import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void testGetPurchasePrice() {
		//Arrange
		//Stack<Price> tempStack = new Stack<>();
		Product p1 = new Product (12345, 10, "Hylde 1, række 1", 10, 11, 8, "Dette er en hammer", "hammer", 100, 10);
		//tempStack.push(p1.getPurchasePrice());
		Price priceP1 = new Price (22);
		priceP1.setValue(33);		
		
		//Act
		LocalDate priceRecord = priceP1.getDateFrom(); 
		double result = p1.getPurchasePrice(priceRecord);
		
		//Assert
		assertEquals(priceRecord, result);
	}
	
}
