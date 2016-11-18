package CSC110.monopoly.board.spaces.modifiers;

import CSC110.monopoly.player.Player;

public class House implements Construction{
	private boolean isPurchased = false;
	private int newRent, purchasePrice;
	
	public boolean Purchase(Player whoPurchase){
		{ //check if player's $ is > purchasePrice
			whoPurchase.TakePlayerMoney(purchasePrice);
			isPurchased = true;
			return true;
		}/*else{
			return false;
		}*/
	}
	public void Sell(Player whoPurchase) {
		whoPurchase.GivePlayerMoney(purchasePrice/2);
		isPurchased = false;
	}
	public void Demolish() {
		isPurchased = false;
	}
	
	public static House _NewHouse(int purchase, int rent){
		House hot = new House();
		hot.newRent = rent;
		hot.purchasePrice = purchase;
		hot.isPurchased = false;
		return hot;
	}

	public boolean IsPurchased() {
		return isPurchased;
	}
	
	public int GetRent(){
		return newRent;
	}
}
