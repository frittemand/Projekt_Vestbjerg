package model;

import java.util.ArrayList;

public class LoanContainer {
private ArrayList<ToolLoan> loans;
private static LoanContainer INSTANCE;
    
private LoanContainer(){
	loans=new ArrayList<>();
}
    
public static LoanContainer getInstance(){
	if(INSTANCE == null){
		INSTANCE = new LoanContainer();
	}
    return INSTANCE;
}

public void addToolLoanToLoanContainer(ToolLoan l) {
	loans.add(l);
}
    
    
}