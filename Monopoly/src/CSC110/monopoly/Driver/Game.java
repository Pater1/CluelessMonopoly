package CSC110.monopoly.Driver;

import java.io.IOException;

import CSC110.monopoly.AskForInput;

public class Game {
	
	public void Start () {
		
	}
	public boolean askToReplay () throws IOException {
		boolean userInput = AskForInput.boolInput("Would you like to play again?","Y","N");
		return userInput;
	}
	public void replayOrNot () throws IOException {
		if (askToReplay() == true){
			System.out.println("A new game has been made!");
			Start();
		}else {
			System.out.println("Thanks for playing!");
			System.exit(0);
		}
	}
}
