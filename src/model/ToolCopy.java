package model;

public class ToolCopy {
private static int copyGenerator= 0;
private int copyNumber;
private boolean isHome; 

public ToolCopy () {
	this.copyNumber = ++copyGenerator;
	this.isHome = true; 
}

public boolean isHome() {
	return isHome;
}

public void setHome(boolean isHome) {
	this.isHome = isHome;
}

}
