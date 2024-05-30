package model;

import java.util.ArrayList;
import java.util.Iterator;

public class ToolContainer {

	/**
	 * fields of ToolContainer
	 */
	private ArrayList<Tool> tools;
	private static ToolContainer INSTANCE;

	/**
	 * constructor for ToolContainer
	 * tools creates an new Arraylist
	 */
	public ToolContainer() {
		tools = new ArrayList<>();
	}

	/**
	 * @return instnce of ToolContainer
	 * checks is a instance already exist and either creates a new instance return a existing instance
	 * (part of singleton)
	 */
	public static ToolContainer getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ToolContainer();
		}
		return INSTANCE;
	}

	/**
	 * @param tool is a specific Tool
	 *  adds a Tool to Tools arraylist
	 */
	public void addToolToToolContainer(Tool tool) {
		tools.add(tool);
	}

	/**
	 * @param toolName is the name of a Tool
	 * @returns a ToolCopy
	 * search that finds Tool with matching name and runs findCopyByIsHome on that Tool 
	 */
	public ToolCopy findToolByToolName(String toolName) {
		ToolCopy foundCopy = null;
		boolean searching = true;
		Iterator<Tool> it = tools.iterator();

		while (it.hasNext() && searching) {
			Tool tool = it.next();
			if (tool.getToolName().equalsIgnoreCase(toolName)) {
				foundCopy = tool.findCopyByIsHome();
				searching = false;

			}
		}
		return foundCopy;
	}

	/**
	 * @param copy is a specific tool
	 * checks if a valid ToolCopy has been recieved
	 * sets isHome boolean to false
	 */
	public void updateIsHome(ToolCopy copy) {
		if (copy != null) {
			copy.setHome(false);
		}
	}

	/**
	 * @param toolName is the name of a tool
	 * @returns the dayRate of a relevant Tool
	 * searches arraylist of tools
	 */
	public double findDayRate(String toolName) {
		double foundDayRate = 0;
		boolean searching = true;

		Iterator<Tool> it = tools.iterator();

		while (it.hasNext() && searching) {
			Tool tool = it.next();
			if (tool.getToolName().equalsIgnoreCase(toolName)) {
				foundDayRate = tool.getDayRate();
				searching = false;

			}
		}
		return foundDayRate;

	}
}
