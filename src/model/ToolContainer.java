package model;

import java.util.ArrayList;
import java.util.Iterator;

public class ToolContainer {
	
		private static ToolContainer INSTANCE;  
		private ArrayList<Tool> tools;


		public ToolContainer() {
			tools = new ArrayList<>();
		}

		public static ToolContainer getInstance() {
			if (INSTANCE == null) {
				INSTANCE = new ToolContainer();
			}
			return INSTANCE;
		}

		public void addToolToToolContainer(Tool tool) {
			tools.add(tool);
		}

		public ToolCopy findToolByToolName(String toolName) {
				ToolCopy foundCopy = null;
				boolean searching = true;
				Iterator<Tool> it = tools.iterator();
				
				while(it.hasNext() && searching) {
					Tool tool = it.next();
					if(tool.getToolName().equalsIgnoreCase(toolName)){
						foundCopy =tool.findCopyByIsHome();
						searching = false;
						
					}
				}
				return foundCopy;
		}
		
		public void updateIsHome(ToolCopy copy) {
			if(copy != null) {
				copy.setHome(false);
			}
		}
		public double findDayRate(String toolName) {
			double foundDayRate = 0;
			boolean searching = true;
			
			Iterator<Tool> it = tools.iterator();
			
			while(it.hasNext() && searching) {
				Tool tool = it.next();
				if(tool.getToolName().equalsIgnoreCase(toolName)){
					foundDayRate = tool.getDayRate(); 
					searching = false;
					
				}
			}
			return foundDayRate;
		
		}
		}

