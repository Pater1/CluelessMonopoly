package CSC110.monopoly.board.spaces;

import CSC110.monopoly.Driver.Game;
import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.PurchasableSpace;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.player.Player; //random comment here

public class Utility extends PurchasableSpace{
 	private int oneMult, twoMult;

 	protected int getRent(){
 		return Game.diceRoll() * (board.IsOtherUtilOwned(this) ? oneMult : twoMult);
 	}

	public static Utility _NewUtility(String name, int purchasePrice, int oneOwnedMultiplyer, int twoOwnedMultiplyer){
		Utility util = new Utility();
		util.name = name;
		util.purchasePrice = purchasePrice;
		util.oneMult = oneOwnedMultiplyer;
		util.twoMult = twoOwnedMultiplyer;
		util.whoOwns = null;
		return util;
	}
	
	private int thisRent(){
		return 5;
	}

	public String[] Render(Player[] plas) {
		return RenderAssistant.SpliceTile(new String[]{
				name,
				"Rent: " + thisRent(),
				(whoOwns == null) ? "Purchase: " + purchasePrice : "Mortgage: " + (purchasePrice),
				RenderAssistant.FitPlayerName(plas),
				"Owner: " + whoOwns
		});
	}

	public String GetName() {
		return name;
	}
}
