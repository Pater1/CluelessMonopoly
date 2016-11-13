package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.testing.Player;

public class Go implements BoardSpace {
	private int cashGo = 20;
	
	public static Go _NewGo(int passCash){
		Go g = new Go();
		g.cashGo = passCash;
		return g;
	}

	//landing on and passing Go do the same thing
	public void LandOnSpace(Player whoLanded) {
		// TODO Give player $
	}

	public void PassSpace(Player whoPassed) {
		// TODO Give player $
	}

}
