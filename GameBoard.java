//@file GameBoard.java
//@author Bradley Carrion
//@date 2/5/2015

public class GameBoard {
	
	private Cell[][] gameBoard = new Cell[3][3];	// 2-dimensional Cell array to represent the board
	private int cellsInUse = 0;						// Integer to keep track of how many moves are made
	
	/**
	 *  @description Constructor for the GameBoard Class. Sets every
	 *  position in the 2-dimensional Cell array to a default Cell object
	 *  with isOccupied set to false.
	 */
	public GameBoard() {
		// default constructor
		// filling the Cell array with non-occupied cells
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Cell c1 = new Cell();
				gameBoard[i][j] = c1;
			}
		}
	}
	
	/**
	 *  @description Checks if the array is full of occupied Cell objects
	 *  @returns A boolean whether the cellsInUse variable is equal to 9 or not
	 */
	public boolean isFull() {
		if (cellsInUse == 9)
			return true;
		return false;
	}
	
	/**
	 *  @description This method will assign the char value to the Cell object's value
	 *  at position x, y.
	 *  @pre The x and y values are valid
	 *  @post The gameBoard array will now hold one more occupied object
	 *  @param xCoordinate is the x position in the array
	 *  	   yCoordinate is the y position in the array
	 *  	   value is the char value to be assigned to the Cell object's value
	 *  @return If the Cell object at x, y is occupied false will be returned
	 *  @usage This will be called whenever anyone wants to make a move.
	 */
	public boolean anyPlayerMove(int xCoordinate, int yCoordinate, char value) {
		if (!gameBoard[xCoordinate][yCoordinate].isOccupied()) {
			gameBoard[xCoordinate][yCoordinate].setValue(value);
			gameBoard[xCoordinate][yCoordinate].setOccupied(true);
			cellsInUse++;
			return true;
		} else {
			return false;
		}	
	}
	
	/**
	 *  @description Allows other classes to access the array of Cell objects
	 *  @returns A 2-dimensional Cell array that was created in this constructor
	 *  @usage This method is to be used to check for a winner in the GameController
	 */
	public Cell[][] getCellArray() {
		return gameBoard;
	}
	
	/**
	 *  @description This method allows other classes to access certain Cell objects
	 *  @param xCoordinate is the x position of the Cell object
	 *  	   yCoordinate is the y position of the Cell object
	 *  @return A Cell object at position x, y
	 *  @usage used in GameController
	 */
	public Cell getCellAtPosition(int xCoordinate, int yCoordinate) {
		return gameBoard[xCoordinate][yCoordinate];
	}
}
