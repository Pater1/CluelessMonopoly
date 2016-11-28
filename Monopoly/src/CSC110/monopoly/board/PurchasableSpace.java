package CSC110.monopoly.board;

import java.io.IOException;
import CSC110.monopoly.Input.AskForInput;
import CSC110.monopoly.player.Player;

public abstract class PurchasableSpace extends BoardSpace{
	protected int purchasePrice;
	protected Player whoOwns;
	
	public boolean isOwned(){
		if(whoOwns == null) return false;
		return true;
	}
	
	public void LandOnSpace(Player whoLanded) throws IOException {
		if(whoOwns == null){
			if(AskForInput.boolInput("Buy " + name + " for $" + purchasePrice + "?", "y", "n")){
				Purchase(whoLanded);
			}
		}else if(whoLanded != whoOwns){
			whoLanded.TakePlayerMoney(getRent());
			whoOwns.GivePlayerMoney(getRent());
		}
	}
	public void Purchase(Player whoPurchase){
		if(whoPurchase.howMuchMoneyOwned() > purchasePrice){ //check if player's $ is > purchasePrice
			whoPurchase.TakePlayerMoney(purchasePrice);
			whoOwns = whoPurchase;
		}else{
			System.out.println("Sorry, you don't have the money to purchase this property");
		}
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
