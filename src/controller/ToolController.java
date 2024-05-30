package controller;

import model.ToolContainer;
import model.ToolCopy;

public class ToolController {

/**
 * constructor for ToolController
 */
public ToolController(){
	}

/**
 * @param toolName id the name of a Tool
 * @return a ToolCopy
 * runs getInstance in ToolContainer
 * runs findToolByToolName in toolConTainer with toolName as input
 */
public ToolCopy findToolByToolName(String toolName) {
	ToolContainer toolContainer = ToolContainer.getInstance();
	return toolContainer.findToolByToolName(toolName);

}
/**
 * @param toolName is the name of a Tool
 * @returns a dayRate
 * runs getInstance in ToolContainer
 * runs findDayRate in toolContainer with toolName as input
 */
public double findDayRate(String toolName) {
	ToolContainer toolContainer = ToolContainer.getInstance();
	return toolContainer.findDayRate(toolName);
}
/**
 * @param copy is a specific ToolCopy
 * runs getInstance in ToolContainer
 * runs updateIsHome in toolContainer with copy as input
 */
public void updateIsHome(ToolCopy copy) {
	ToolContainer toolContainer = ToolContainer.getInstance();
	toolContainer.updateIsHome(copy);
}
}
