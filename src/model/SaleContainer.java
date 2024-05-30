package model;

import java.util.ArrayList;

public class SaleContainer {
/**
 * fields of SaleContainer
 */
private static SaleContainer INSTANCE;  
/**
 * 
 */
private ArrayList<Sale> sales;


/**
 * constructor of SaleContainer
 * sales creates a new Arraylist
 */
private SaleContainer() {
	sales = new ArrayList<>();
}

/**
 * @return a instance of SaleContainer
 * checks is a instance already exist and either creates a new instance return a existing instance
 * (part of singleton)
 */
public static SaleContainer getInstance() {
	if (INSTANCE == null) {
		INSTANCE = new SaleContainer();
	}
	return INSTANCE;
}

/**
 * @param sale is a Sale currently in the making
 * adds a current Sale to sales ArrayList 
 */
public void addSaleToSaleContainer(Sale sale) {
	sales.add(sale);
}


}