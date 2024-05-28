package model;

public class ToolOrderline {
	private double linePrice; 
	private ToolCopy copy;
	private double toolDayRate;
	
	public ToolOrderline(ToolCopy copy, double dayRate) {
		this.copy = copy;
		this.toolDayRate = dayRate; 
	}
	
	public double getLinePrice() {
		return linePrice;
	}

	public ToolCopy getCopy() {
		return copy;
	}

	public double getToolDayRate() {
		return toolDayRate;
	}

}
