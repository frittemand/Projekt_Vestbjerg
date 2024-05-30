package model;

import java.util.ArrayList;

public class LoanContainer {
/**
 * fields for loanContainer
 * 
 */
private ArrayList<ToolLoan> loans;
/**
 * 
 */
private static LoanContainer INSTANCE;
    
/**
 * constructor for loanContainer
 * loans creates an ArrayList
 */
private LoanContainer(){
	loans=new ArrayList<>();
}
    
/**
 * @returns a instance
 * checks is a instance already exist and either creates a new instance return a existing instance
 * (part of singleton)
 */
public static LoanContainer getInstance(){
	if(INSTANCE == null){
		INSTANCE = new LoanContainer();
	}
    return INSTANCE;
}

/**
 * @param loan is a specific loan
 * adds loan to loans ArrayList
 */
public void addToolLoanToLoanContainer(ToolLoan loan) {
	loans.add(loan);
}
    
    
}