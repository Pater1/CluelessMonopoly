package CSC110.monopoly.board;

import java.io.IOException;
import CSC110.monopoly.Input.AskForInput;
import CSC110.monopoly.board.spaces.Property;
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
	public void Sell(Player whoPurchase, int forHowMuch) {
		whoOwns.GivePlayerMoney(forHowMuch);
		whoPurchase.TakePlayerMoney(forHowMuch);
		whoOwns = whoPurchase;
	}
	public void Mortgage(Player whoPurchase) {
		if(this instanceof Property){
			Property prop = (Property)this;
			if(!prop.NoDevelopmentsOnGroup()){
				System.out.println("You must first sell all developments on this property group!");
				return;
			}
		}
		
		if(whoPurchase.netWorth(purchasePrice) < 0){
			System.out.println("The bank denys your loan request (It'd make you go bankrupt)");
			return;
		}
		
		whoPurchase.GivePlayerMoney(purchasePrice);
		whoPurchase.GiveDebt(purchasePrice);
	}
	
	public int PurchasePrice(){
		return purchasePrice;
	}
	
	protected abstract int getRent();
	
	public void PassSpace(Player whoPassed) {
		return;
	}
	
	public boolean DoesOwn(Player thisPerson){
		return (thisPerson == whoOwns);
	}
}
