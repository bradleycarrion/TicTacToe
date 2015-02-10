//@file Cell.java
//@author Bradley Carrion
//@date 2/5/2015

public class Cell {
	
	private char value;			// Private Char value to hold either 'X' or 'Y'
	private boolean isOccupied;	// Private Boolean whether the current cell has a value
	
	/**
	 *  @description Constructor for the Cell Class. Sets isOccupied to
	 *  			 false and an empty char value as default
	 */
	public Cell() {
		setOccupied(false);
		value = ' ';
	}

	/**
	 *  @description Getter for the value of the current Cell object
	 *  @returns The value of the current cell object of type char
	 */
	public char getValue() {
		return value;
	}
	
	/**
	 *  @description Sets the value of the current Cell object to the parameter
	 *  @param Takes in the char value to be set to this.value
	 */
	public void setValue(char value) {
		this.value = value;
	}

	/**
	 * @description Checks if the current Cell object is occupied or not
	 * @return A boolean whether the cell is occupied
	 */
	public boolean isOccupied() {
		return isOccupied;
	}

	/**
	 *  @description Sets the 'isOccupied' boolean value to the parameter
	 *  @param Takes in the boolean value to be set to this.isOccupied
	 */
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}	
}
