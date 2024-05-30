package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Tool {

/**
 * fields of Tool
 */
private ArrayList<ToolCopy> copies; 
/**
 * 
 */
private double dayRate; 
/**
 * 
 */
private String description; 
/**
 * 
 */
private int toolBarcode; 
/**
 * 
 */
private String toolName; 

/**
 * constructor for Tool
 * @param dayRate is price to loan a Tool for a day
 * @param description is a description of a Tool
 * @param toolBarcode is a barcode connected to a Tool
 * @param toolName is a name of a Tool
 */
public Tool(double dayRate, String description, int toolBarcode, String toolName) {
	this.copies = new ArrayList<>();
	this.dayRate = dayRate;
	this.description = description;
	this.toolBarcode = toolBarcode;
	this.toolName = toolName;
}

/**
 * @returns a dayRate
 */
public double getDayRate() { 
	return dayRate;
}
/**
 * @return a toolName
 */
public String getToolName() {
	return toolName;
}
/**
 * @returns a ToolCopy
 * searches copies for a copy with isHome value set to true
 */
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
/**
 * @param copy is a specific ToolCopy
 * adds copy to copies ArrayList
 */
public void addCopyToTool(ToolCopy copy) {
	copies.add(copy);
}
}
