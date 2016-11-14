package CSC110.monopoly.testing;

import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.player.Player;

public class BoardRenderTest {

	public static void main(String[] args) {
		GameBoard gmbrd = GameBoard._NewGameBoard();
		System.out.println(gmbrd.RenderToConsole(new Player[0], 10));
	}

}
