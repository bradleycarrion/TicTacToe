//@file Driver.java
//@author Bradley Carrion
//@date 2/5/2015

import java.util.Scanner;
public class Driver {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Would you like to be X's or O's: ");
		char userValue = keyboard.next().charAt(0);
		GameController game = new GameController(userValue);
		
		// This loop will run until the board is full
		while (!game.isFull()) {
				System.out.println("Please input valid numbers for x and y: ");
				while (!game.humanMove(keyboard.nextInt(), keyboard.nextInt())) {
					System.out.println("Please input valid numbers for x and y: ");
				}
				System.out.println(game.toString());
				if (game.hasWinner(game.getWinner()))	
					break;
				
				game.computerMove();
				System.out.println(game.toString());
				if (game.hasWinner(game.getWinner()))	
					break;

		}
	
		if (game.isFull()) {
			System.out.println("Nobody wins!");
		} else if (game.getWinner() == userValue) {
			System.out.println("You win!");
		} else {
			System.out.println("Computer wins!");
		}
		
		System.out.println("Bye!");
	}

}
