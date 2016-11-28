package CSC110.monopoly.testing;

import java.io.IOException;

import CSC110.monopoly.Game.Game;
import CSC110.monopoly.Input.AskForInput;

public class InputCallTest {

	/*
	 * public static void testInput() throws IOException { AskForInput.Input(new
	 * String[] {"h","hey", "hello","h","hey" }); }
	 */
	/*
	 * public static void testGameReplay () throws IOException {
	 * Game.replayOrNot(); }
	 */
	/*
	 * public static void testPlayerNum () throws IOException {
	 * System.out.println(AskForInput.numOfPlayers()); }
	 */
	public static void testDiceRoll() {
		for (int i = 0; i < 15; i++) {
			System.out.println(Game._DiceRoll());
		}
	}
	public static void testPlayerPeice() throws IOException {
		//AskForInput.enumInput();
	}
}
