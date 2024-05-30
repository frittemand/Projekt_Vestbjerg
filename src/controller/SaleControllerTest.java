package controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Orderline;
import model.Product;
import model.ProductContainer;
import model.Sale;
import model.SaleContainer;

class SaleControllerTest {

	@Test
	void testAddProductToContainer() {
		//Arrange
		ProductController productController = new ProductController();
		ProductContainer productContainer = new ProductContainer();
		Sale sale = new Sale();
		Product product = new Product (12345,10,"Hylde 1, række 1",10,11,8,
				  "Dette er en hammer","hammer",100,10);

		Orderline orderline = new Orderline(1, product);
		sale.addOrderline(orderline);
		productContainer.addProduct(product);
		
		//Act
		Product expectedProduct = product;
		Product result = productContainer.findProductByBarcode(12345);
		
		//Assert
		assertEquals(expectedProduct, result);
	}
//	@Test
//	void testAddSale() {
//		SaleContainer saleContainer = SaleContainer.getInstance();
//		Sale sale = new Sale();
//		Product product = new Product (12345,10,"Hylde 1, række 1",10,11,8,
//				  "Dette er en hammer","hammer",100,10);
//		Orderline orderline = new Orderline(1, product);
//		
//		sale.addOrderline(orderline);
//		saleContainer.addSaleToSaleContainer(sale);
//		
//		int expectedSale = 1;
//		Sale result = saleContainer.findSaleBySalesID();
//		
//		assertEquals(expectedSale, result);
//	}

}
