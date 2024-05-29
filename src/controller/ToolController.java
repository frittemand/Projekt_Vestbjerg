package controller;

import model.ToolContainer;
import model.ToolCopy;

public class ToolController {

public ToolController(){
	}

public ToolCopy findToolByToolName(String toolName) {
	ToolContainer toolContainer = ToolContainer.getInstance();
	return toolContainer.findToolByToolName(toolName);

}
public double findDayRate(String toolName) {
	ToolContainer toolContainer = ToolContainer.getInstance();
	return toolContainer.findDayRate(toolName);
}
public void updateIsHome(ToolCopy copy) {
	ToolContainer toolContainer = ToolContainer.getInstance();
	toolContainer.updateIsHome(copy);
}
}
