package model;

import java.util.ArrayList;

public class SaleContainer {
private static SaleContainer INSTANCE;  
private ArrayList<Sale> sales;


private SaleContainer() {
	sales = new ArrayList<>();
}

public static SaleContainer getInstance() {
	if (INSTANCE == null) {
		INSTANCE = new SaleContainer();
	}
	return INSTANCE;
}

public void addSaleToSaleContainer(Sale sale) {
	sales.add(sale);
}


}