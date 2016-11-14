package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.PurchasableSpace;
import CSC110.monopoly.player.Player;

public class Utility implements PurchasableSpace{
	private String utilityName;
 	private int oneMult, twoMult;
 	private Player whoOwns;

	public void LandOnSpace(Player whoLanded) {
		if(whoOwns == null){
			//TODO: UI to buy property
		}else if(whoLanded != whoOwns){
			//TODO: take rent from whoLanded
			//rent = dieRoll * ((whoOwns owns only one utility) ? oneMult : twoMult)
		}
	}

	public void PassSpace(Player whoPassed) {
		return;
	}

	public void Purchase(Player whoPurchase) {
		// TODO Auto-generated method stub
		
	}

	public void Sell(Player whoPurchase) {
		// TODO Auto-generated method stub
		
	}

	public void Mortgage(Player whoPurchase) {
		// TODO Auto-generated method stub
		
	}

	public static Utility _NewUtility(String name, int purchase, int oneOwnedMultiplyer, int twoOwnedMultiplyer){
		Utility util = new Utility();
		util.utilityName = name;
		util.oneMult = oneOwnedMultiplyer;
		util.twoMult = twoOwnedMultiplyer;
		util.whoOwns = null;
		return util;
	}

	@Override
	public String[] Render(Player[] plas) {
		// TODO Auto-generated method stub
		return null;
	}
}
