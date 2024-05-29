package model;

public class ToolOrderline {
	private double linePrice; 
	private ToolCopy copy;
	private double toolDayRate;
	private String toolName;
	
	public ToolOrderline(ToolCopy copy, double dayRate, double linePrice, String toolName) {
		this.copy = copy;
		this.linePrice = linePrice;
		this.toolDayRate = dayRate; 
		this.toolName = toolName;
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
	public String getToolName() {
		return toolName;
	}

}
