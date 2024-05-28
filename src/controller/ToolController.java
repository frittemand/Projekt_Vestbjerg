package controller;

import model.ToolContainer;
import model.ToolCopy;

public class ToolController {

public ToolController(){
	}

public ToolCopy findToolByToolName(String toolName) {
	ToolContainer tc = ToolContainer.getInstance();
	return tc.findToolByToolName(toolName);

}
public double findDayRate(String toolName) {
	ToolContainer tc = ToolContainer.getInstance();
	return tc.findDayRate(toolName);
}
public void updateIsHome(ToolCopy copy) {
	ToolContainer tc = ToolContainer.getInstance();
	tc.updateIsHome(copy);
}
}
