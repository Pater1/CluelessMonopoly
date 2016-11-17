package CSC110.monopoly.testing;

import java.io.IOException;
import CSC110.monopoly.Driver.Driver;
import CSC110.monopoly.Driver.Game;
import CSC110.monopoly.Driver.AskForInput;;

public class InputCallTest {
	public static void  main(String [] args) throws IOException {
	//testInput();
		//testGameReplay();
		testPlayerNum();
}
	/*public static void testInput() throws IOException {
		AskForInput.Input(new String[] {"h","hey", "hello","h","hey" });
	}*/
	/*public static void testGameReplay () throws IOException {
		Game.replayOrNot();
	}*/
	public static void testPlayerNum () throws IOException {
		System.out.println(AskForInput.numOfPlayers());
	}
}
