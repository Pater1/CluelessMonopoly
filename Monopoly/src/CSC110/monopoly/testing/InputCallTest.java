package CSC110.monopoly.testing;

import java.io.IOException;
import CSC110.monopoly.Driver.Driver;
import CSC110.monopoly.Driver.Game;
import CSC110.monopoly.Driver.PlayerTurn;
import CSC110.monopoly.Driver.AskForInput;
import CSC110.monopoly.Driver.CreatePlayers;
import CSC110.monopoly.Driver.DiceRoller;;

public class InputCallTest {
	public static void main(String[] args) throws IOException {
		// testInput();
		// testGameReplay();
		// testPlayerNum();
		//testDiceRoll();
		//AskForInput.enumInput();
		//System.out.println(CreatePlayers.createPlayers().get(2));
		//System.out.println(CreatePlayers.createPlayers().get(3));
		//PlayerTurn.playerLoop();
	}

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
			System.out.println(DiceRoller.diceRoll());
		}
	}
	public static void testPlayerPeice() throws IOException {
		AskForInput.enumInput();
	}
}
