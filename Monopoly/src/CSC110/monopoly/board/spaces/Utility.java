package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.PurchasableSpace;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.player.Player; //random comment here

public class Utility implements PurchasableSpace{
	private String utilityName;
 	private int oneMult, twoMult, purchase;
 	private Player whoOwns;

 	private int getRent(){
 		boolean ownsOtherUtil = false;
 		int dieRoll = 0; //replace with DieRoll method
 		return dieRoll * (ownsOtherUtil ? oneMult : twoMult);
 	}
 	
	public void LandOnSpace(Player whoLanded) {
		if(whoOwns == null){
			//TODO: UI to buy property
		}else if(whoLanded != whoOwns){
			whoLanded.TakePlayerMoney(getRent());
			whoOwns.GivePlayerMoney(getRent());
		}
	}

	public void PassSpace(Player whoPassed) {
		return;
	}

	public void Purchase(Player whoPurchase) {
		whoPurchase.TakePlayerMoney(purchase);
		whoOwns = whoPurchase;
	}

	public void Sell(Player whoPurchase) {
		whoPurchase.GivePlayerMoney(purchase/2);
		whoOwns = null;
	}

	public void Mortgage(Player whoPurchase) {
		// TODO Auto-generated method stub
		
	}

	public static Utility _NewUtility(String name, int purchasePrice, int oneOwnedMultiplyer, int twoOwnedMultiplyer){
		Utility util = new Utility();
		util.utilityName = name;
		util.purchase = purchasePrice;
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
				utilityName,
				"Rent: " + thisRent(),
				(whoOwns == null) ? "Purchase: " + purchase : "Mortgage: " + (purchase),
				RenderAssistant.FitPlayerName(plas),
				"Owner: " + whoOwns
		});
	}
}
