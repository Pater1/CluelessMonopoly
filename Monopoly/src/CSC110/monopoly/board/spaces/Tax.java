package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.player.Player;

public class Tax extends BoardSpace {
	private String taxName;
	private int taxAmount;
	
	public static Tax _NewTax(String name, int amountToTax, GameBoard brd){
		Tax tx = new Tax();
		tx.taxName = name;
		tx.taxAmount = amountToTax;
		tx.board = brd;
		return tx;
	}

	public void LandOnSpace(Player whoLanded) {
		whoLanded.TakePlayerMoney(taxAmount);
	}

	public void PassSpace(Player whoPassed) {
		return;
	}

	public String[] Render(Player[] plas) {
		return RenderAssistant.SpliceTile(new String[]{
				taxName,
				"Pay: " + taxAmount,
				"",
				RenderAssistant.FitPlayerName(plas)
		});
	}

	public String GetName() {
		return taxName;
	}
}
