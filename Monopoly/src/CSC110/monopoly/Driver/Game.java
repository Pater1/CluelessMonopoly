package CSC110.monopoly.Driver;

import java.io.IOException;

import CSC110.monopoly.Driver.CreatePlayers;

public class Game {

	public static void Start() throws IOException {
		System.out.println("Welcome to Monopoly!");

		CreatePlayers.createPlayers();
		PlayerTurn.playerLoop();
	}
}
