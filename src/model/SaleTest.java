package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SaleTest {

	@Test
	void testAddOrderline() {
		Product p1 = new Product (12345,10,"Hylde 1, række 1",10,11,8,
				  "Dette er en hammer","hammer",100,10);
		ArrayList<Orderline> orderlines = new ArrayList<>();
		Orderline orderline = new Orderline(1, p1);
		
		orderlines.add(orderline);
		
		assertTrue(orderline.equals(orderlines.get(0)));
		
	}

}
