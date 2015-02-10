//@file GameController.java
//@author Bradley Carrion
//@date 2/5/2015

import java.util.Random;
public class GameController {
	
	private GameBoard gameBoard;	// Creates an instance of GameBoard
	private char whoseTurn;			// Char value to keep track of whose turn it is
	
	/**
	 *  @description Constructor for the GameController Class
	 *  @param Takes a char parameter to set the char whoseTurn value
	 */
	public GameController(char humanValue) {
		gameBoard = new GameBoard();
		whoseTurn = humanValue;
	}
	
	/**
	 *  @description This method will make a String of all the cell values
	 *	@returns A String representation of the gameBoard
	 *	@usage The method is called after every move so the user knows the
	 *		   most current status of the board.
	 */
	public String toString() {
		String boardString = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				boardString += " ";
				boardString += gameBoard.getCellAtPosition(i, j).getValue();
				boardString += " ";
				if (j == 2) {
					boardString += "\n";
					break;
				}
				boardString += "|";
			}
			if (i == 2)
				break;
			boardString += "-----------\n";
		}
		return boardString;
	}
	
	/**
	 *  @description Checks if the gameBoard is full
	 *	@returns True if the gameBoard is full and false otherwise
	 *	@usage The method is called after any player makes a move
	 *		   to see if it's a tie.
	 */
	public boolean isFull() {
		return gameBoard.isFull();
	}
	
	/**
	 *  @description This method changes the char value of 'whoseTurn'
	 *	@usage The method is called after the computer moves and again
	 *		   after the human moves
	 */
	private void changeTurn() {
		if (whoseTurn == 'O')
			whoseTurn = 'X';
		else
			whoseTurn = 'O';
	}

	/**
	 *  @description This method will return winner's char value.
	 *	@returns The char value of the player that wins.
	 *	@usage The method is called when someone wins the game.
	 */
	public char getWinner() {
		if (whoseTurn == 'X')
			return 'O';
		return 'X';
	}
	
	/**
	 *  @description This method checks ever possible combination of ways to win
	 *	@param char 'value' is the value that is being checked in each Cell object
	 *	@return True is returned if there are 3 'X's or 3 'Y's in a row, column or diagonal
	 *	@usage The method is called after each player's turn to check if they made
	 *		   a winning move.
	 */
	public boolean hasWinner(char value) {
		Cell[][] gameBoard = this.gameBoard.getCellArray();
			
			// Checks all the columns
		if (gameBoard[0][0].getValue() == value && gameBoard[0][1].getValue() == value && gameBoard[0][2].getValue() == value)
			return true;
		else if (gameBoard[1][0].getValue() == value && gameBoard[1][1].getValue() == value && gameBoard[1][2].getValue() == value)
			return true;
		else if (gameBoard[2][0].getValue() == value && gameBoard[2][1].getValue() == value && gameBoard[2][2].getValue() == value)
			return true;
		else if (gameBoard[0][0].getValue() == value && gameBoard[1][0].getValue() == value && gameBoard[2][0].getValue() == value)
			return true;
		else if (gameBoard[0][1].getValue() == value && gameBoard[1][1].getValue() == value && gameBoard[2][1].getValue() == value)
			return true;
		else if (gameBoard[0][2].getValue() == value && gameBoard[1][2].getValue() == value && gameBoard[2][2].getValue() == value)
			return true;
		else if (gameBoard[0][0].getValue() == value && gameBoard[1][1].getValue() == value && gameBoard[2][2].getValue() == value)
			return true;
		else if (gameBoard[0][2].getValue() == value && gameBoard[1][1].getValue() == value && gameBoard[2][0].getValue() == value)
			return true;
		else
			return false;
					
	}
	
	/**
	 *  @description This method will call the anyPlayerMove method
	 * 				 passing in random x and y values and 'X' as the
	 * 				 Cell value if the user's letter is 'O' or 'O' if
	 * 				 the user's letter is 'X'
	 *	@post The gameBoard will now contain one more element
	 *	@usage The method is called when it is the computer's turn
	 */	
	public void computerMove() {
		Random randomXYPosition = new Random();
		int x = randomXYPosition.nextInt(3);
		int y = randomXYPosition.nextInt(3);
		while (!gameBoard.anyPlayerMove(x, y, whoseTurn)) {
			y = randomXYPosition.nextInt(3);
			x = randomXYPosition.nextInt(3);
		}
		changeTurn();
		System.out.println("The computer moved to position: " + x + " " + y);
	}
	
	/**
	 *  @description This method will call the anyPlayerMove method
	 * 				 passing in the user input of x and y values and
	 * 				 whatever the user's letter is
	 *	@pre x and y are between or equal to 0 and 2
	 *	@param x is the x coordinate on the board
	 *		   y is the y coordinate on the board
	 *	@post The gameBoard will now contain one more element
	 *	@return True is returned if the x and y values are valid and false otherwise
	 *	@usage The method is called when it is the human's turn
	 */
	public boolean humanMove(int x, int y) {
		if (x > 2 || x < 0 || y < 0 || y > 2)
			return false;
		if (gameBoard.anyPlayerMove(x, y, whoseTurn)) {
			changeTurn();
			return true;
		}
		changeTurn();
		return false;
	}
	
}
