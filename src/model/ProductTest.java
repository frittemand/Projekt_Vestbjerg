package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void testGetPurchasePrice() {
		//Arrange
		Stack<Price> purchasePriceLog = new Stack<>();
		Product p1 = new Product (12345, 10, "Hylde 1, række 1", 10, 11, 8, 
				"Dette er en hammer", "hammer", 100, 10);
		Price pr1 = new Price(p1.getPurchasePrice());
		purchasePriceLog.push(pr1);
		
		Stack<Price> tempStack = (Stack<Price>)purchasePriceLog.clone();
		
		//Act
		LocalDate targetPriceLogDate = (pr1.getDateFrom()); 
		double result = p1.getPurchasePrice(targetPriceLogDate);
		
		//Assert
		assertEquals(8, result);
	}
	
}
