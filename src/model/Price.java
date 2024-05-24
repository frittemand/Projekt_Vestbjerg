package model;

import java.time.LocalDate;

public class Price {
private double value;
private LocalDate dateFrom;

private Price(double value) {
	this.value = value;
	this.dateFrom =LocalDate.now();
}

public double getValue() {
	return value;
}
public void setValue(double value) {
	this.value = value;
}
public LocalDate getDateFrom() {
	return dateFrom;
}
public void setDateFrom(LocalDate dateFrom) {
	this.dateFrom = dateFrom;
}
}

