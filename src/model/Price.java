package model;

import java.time.LocalDate;

public class Price {
	/**
	 * fields in Price
	 * 
	 */
	private double value;
	/**
	 * 
	 */
	private LocalDate dateFrom;

	/**
	 * constructor for Price
	 * @param value is the price value that is going to be logged
	 * dateFrom is the date the price is logged
	 */
	public Price(double value) {
		this.value = value;
		this.dateFrom = LocalDate.now();
	}

	/**
	 * @returns a value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value is a form of price
	 * sets value to value
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @returns a dateFrom
	 */
	public LocalDate getDateFrom() {
		return dateFrom;
	}

	/**
	 * @param dateFrom is a date from which a new price was added to a stack
	 * sets dateFrom to dateFrom
	 */
	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

}
