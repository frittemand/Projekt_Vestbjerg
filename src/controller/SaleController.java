package controller;

import java.util.ArrayList;

import model.Orderline;
import model.Product;
import model.Sale;
import model.SaleContainer;

public class SaleController {
	/**
	 * 
	 */
	private Sale sale;
	/**
	 * 
	 */
	private Orderline orderline;

	
	/**constructor for SaleController
	 * 
	 */
	public SaleController() {
		createSale();
	}
	/**
	 * @returns a Sale
	 * creates a new Sale
	 */
	public Sale createSale() {
		if(sale == null) {
		this.sale = new Sale();
		}
		return sale;
	}

	/**
	 * @param amount is the amount of money a Customer has paid
	 * runs getInstance in SaleContainer
	 * runs setAmoundpaid in sale with amount as input
	 * checks if amount paid is bigger than total and calculates change
	 * runs setChangeAmount in sale with change as input
	 * runs setPaid in sale with true as input
	 * runs addSaleToSaleContainer in saleContainer with sale as input
	 */
	public void makePayment(double amount) {
		SaleContainer saleContainer = SaleContainer.getInstance();

		sale.setAmountPaid(amount);
		if (amount > sale.getTotalPrice()) {
			double change = amount - sale.getTotalPrice();

			sale.setChangeAmount(change);

			sale.setPaid(true);
			saleContainer.addSaleToSaleContainer(sale);
		}
	}

	/**
	 * @param quantity is the amount a Customer wishes to buy
	 * @param barcode is the barcode to a specific product
	 * makes a ProductController and runs findProductByBarcode in it with barcode as input
	 * creates a new orderline with quantity and product as inputs.
	 * adds orderline to sales ArrayList
	 * runs updateStockCount in productController with wuantity and product as input
	 * calculates total 
	 */
	public void addProduct(int quantity, int barcode) {
//	if(this.sale == null) {
//		createSale();
//	}
		ProductController productController = new ProductController();
		Product product = productController.findProductByBarcode(barcode);

		orderline = new Orderline(quantity, product);

		sale.addOrderline(orderline);

		productController.updateStockCount(quantity, product);

		double total = orderline.getLinePrice() + sale.getTotalPrice();
		sale.setTotalPrice(total);
	}

	/**
	 * @returns ArrayList
	 */
	public ArrayList<Orderline> getOrderlinesFromOrder() {
		ArrayList<Orderline> orderLinesOnSale = new ArrayList<>();
		orderLinesOnSale = sale.getOrderline();
		return orderLinesOnSale;

	}
public double getTotalPriceFromSale() {
	return sale.getTotalPrice();
}

}

