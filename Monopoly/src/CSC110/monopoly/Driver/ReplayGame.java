package CSC110.monopoly.Driver;

import java.io.IOException;

public class ReplayGame {
	public static boolean askToReplay () throws IOException {
		boolean userInput = AskForInput.boolInput("Would you like to play again?","Y","N");
		return userInput;
	}
	public static void replayOrNot () throws IOException {
		if (askToReplay() == true){
			System.out.println("A new game has been made!");
			Game.Start();
		}else {
			System.out.println("Thanks for playing!");
			System.exit(0);
		}
	}
}
