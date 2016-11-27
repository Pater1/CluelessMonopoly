package CSC110.monopoly.board;

import java.io.IOException;

import CSC110.monopoly.Driver.AskForInput;
import CSC110.monopoly.player.Player;

public abstract class PurchasableSpace extends BoardSpace{
	protected int purchasePrice;
	protected Player whoOwns;
	
	
	public void LandOnSpace(Player whoLanded) throws IOException {
		if(whoOwns == null){
			if(AskForInput.boolInput("Buy this property for $" + purchasePrice + "?", "y", "n")){
				Purchase(whoLanded);
			}
		}else if(whoLanded != whoOwns){
			whoLanded.TakePlayerMoney(getRent());
			whoOwns.GivePlayerMoney(getRent());
		}
	}
	public void Purchase(Player whoPurchase){
		if(true){ //check if player's $ is > purchasePrice
			whoPurchase.TakePlayerMoney(purchasePrice);
			whoOwns = whoPurchase;
		}/*else{
			
		}*/
	}
	public void Sell(Player whoPurchase) {
		whoPurchase.GivePlayerMoney(purchasePrice);
		whoOwns = null;
	}
	public void Mortgage(Player whoPurchase) {
		whoPurchase.GivePlayerMoney(purchasePrice/2);
		//give Player debt
	}
	
	protected abstract int getRent();
	
	public void PassSpace(Player whoPassed) {
		return;
	}
	
	public boolean DoesOwn(Player thisPerson){
		return (thisPerson == whoOwns);
	}
}
