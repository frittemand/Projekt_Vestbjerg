package model;

public class ToolCopy {
private static int copyNumber= 1;
private boolean isHome; 

public ToolCopy () {
	this.copyNumber = copyNumber++;
	this.isHome = true; 
}

public boolean isHome() {
	return isHome;
}

public void setHome(boolean isHome) {
	this.isHome = isHome;
}

}
