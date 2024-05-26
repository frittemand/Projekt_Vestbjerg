package model;

import java.time.LocalDate;

public class Price {
private double value;
private LocalDate dateFrom;
private String manualDateInputForTest;

public Price(double value) {
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


//For creating test
public void setDateFromManually(String manualInput) {
	this.setManualDateInputForTest(manualInput);	
}

public String getManualDateInputForTest() {
	return manualDateInputForTest;
}

public void setManualDateInputForTest(String manualDateInputForTest) {
	this.manualDateInputForTest = manualDateInputForTest;
}
}

