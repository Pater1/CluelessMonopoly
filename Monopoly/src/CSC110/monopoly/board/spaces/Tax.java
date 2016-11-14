package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.player.Player;

public class Tax implements BoardSpace {
	private String taxName;
	private int taxAmount;
	
	public static Tax _NewTax(String name, int amountToTax){
		Tax tx = new Tax();
		tx.taxName = name;
		tx.taxAmount = amountToTax;
		return tx;
	}

	public void LandOnSpace(Player whoLanded) {
		// TODO Take money from player at tax
	}

	public void PassSpace(Player whoPassed) {
		return;
	}

	@Override
	public String[] Render(Player[] plas) {
		// TODO Auto-generated method stub
		return null;
	}
}
