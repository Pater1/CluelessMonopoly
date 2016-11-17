package CSC110.monopoly.Driver;

import java.io.IOException;
import java.util.Random;


public class Game {
	
	public static void Start () {
		
	}
	public static boolean askToReplay () throws IOException {
		boolean userInput = AskForInput.boolInput("Would you like to play again?","Y","N");
		return userInput;
	}
	public static void replayOrNot () throws IOException {
		if (askToReplay() == true){
			System.out.println("A new game has been made!");
			Start();
		}else {
			System.out.println("Thanks for playing!");
			System.exit(0);
		}
	}
	public static int diceRoll () {
		Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(10);
		return randomInt;
		
	}
}
