package CSC110.monopoly.testing;

import java.io.IOException;

import CSC110.monopoly.AskForInput;
import CSC110.monopoly.Game;

public class InputCallTest {
	public static void  main(String [] args) throws IOException {
	testInput();
}
	public static void testInput() throws IOException {
		AskForInput.Input(new String[] {"h","hey", "hello","h","hey" });
	}
}
