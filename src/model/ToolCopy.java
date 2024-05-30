package model;

public class ToolCopy {
	/**
	 * fields of ToolCopy
	 */
	private static int copyGenerator = 0;
	private int copyNumber;
	private boolean isHome;

	/**
	 * constructor for ToolCopy
	 * generates s copyNumber
	 * sets isHome to true
	 */
	public ToolCopy() {
		this.copyNumber = ++copyGenerator;
		this.isHome = true;
	}

	/**
	 * @returns ishome status
	 */
	public boolean isHome() {
		return isHome;
	}

	/**
	 * @param isHome update home status
	 * sets is home to new status 
	 */
	public void setHome(boolean isHome) {
		this.isHome = isHome;
	}
/**
 * @returns a copyNumber
 */
public int getCopyNumber() {
	return copyNumber;
}
}
