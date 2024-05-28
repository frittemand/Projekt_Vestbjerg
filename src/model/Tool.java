package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Tool {

private ArrayList<ToolCopy> copies; 
private double dayRate; 
private String description; 
private int toolBarcode; 
private String toolName; 

public Tool(double dayRate, String description, int toolBarcode, String toolName) {
	
	this.dayRate = dayRate;
	this.description = description;
	this.toolBarcode = toolBarcode;
	this.toolName = toolName;
}

public double getDayRate() { 
	return dayRate;
}
public String getToolName() {
	return toolName;
}
public ToolCopy findCopyByIsHome() {
	ToolCopy foundCopy = null;
	boolean searching = true;
	
	Iterator<ToolCopy> it = copies.iterator();
	while(it.hasNext() && searching) {
		ToolCopy copy = it.next();
		if(copy.isHome()){
			foundCopy = copy; 
			searching = false;
}

}
	return foundCopy;
	}
}
