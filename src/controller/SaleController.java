package controller;

import java.util.ArrayList;

import model.Orderline;
import model.Product;
import model.Sale;
import model.SaleContainer;

public class SaleController {
	private Sale sale;
	private Orderline orderline;

	public Sale createSale() {
		this.sale = new Sale();
		return sale;
	}

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

	public ArrayList<Orderline> getOrderlinesFromOrder() {
		ArrayList<Orderline> orderLinesOnSale = new ArrayList<>();
		orderLinesOnSale = sale.getOrderline();
		return orderLinesOnSale;

	}

}
