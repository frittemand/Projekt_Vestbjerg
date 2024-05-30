package model;

public class ToolOrderline {
	/**
	 * fields of ToolOrderline
	 */
	private double linePrice; 
	private ToolCopy copy;
	private double toolDayRate;
	private String toolName;
	
	/**
	 * constructor for ToolOrderline containing the parameters:
	 * @param copy is a specific instance of ToolCopy
	 * @param dayRate is the price to rent a tool for one day
	 * @param linePrice is the price for the full rent duration
	 * @param toolName is the came of a specific tool
	 * 
	 */
	public ToolOrderline(ToolCopy copy, double dayRate, double linePrice, String toolName) {
		this.copy = copy;
		this.linePrice = linePrice;
		this.toolDayRate = dayRate; 
		this.toolName = toolName;
	}
	
	/**
	 * @returns the linePrice
	 */
	public double getLinePrice() {
		return linePrice;
	}

	/**
	 * @returns a specific copy of a tool
	 */
	public ToolCopy getCopy() {
		return copy;
	}

	/**
	 * @returns the dayrate of a tool
	 */
	public double getToolDayRate() {
		return toolDayRate;
	}
	/**
	 * @returns a tools name
	 */
	public String getToolName() {
		return toolName;
	}

}
