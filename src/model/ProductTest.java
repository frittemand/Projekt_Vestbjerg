package model;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Stack;
import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void testGetPurchasePrice() {
		//Arrange
		Stack<Price> tempStack = new Stack<>();
		Price price1 = new Price(11.11);
		price1.setManualDateInputForTest("11-11-11");
		//TODO Implement price associated with product
		tempStack.push(price1);
		
		Price price2 = new Price(22.22);
		price2.setManualDateInputForTest("22-22-22");
		tempStack.push(price2);
		
		Price price3 = new Price(33.33);
		price3.setManualDateInputForTest("33-33-33");
		tempStack.push(price3);
		
		//Act
		String result = 
	}

}
