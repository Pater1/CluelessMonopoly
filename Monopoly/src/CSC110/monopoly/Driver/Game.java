package CSC110.monopoly.Driver;

import java.io.IOException;


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
	//need to make a method to ask for how many players there are
}
