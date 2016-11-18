package CSC110.monopoly.board.spaces.modifiers;

import CSC110.monopoly.player.Player;

public class Hotel implements Construction{
	private boolean isPurchased = false;
	private int newRent, purchasePrice;
	
	public boolean Purchase(Player whoPurchase){
		if(true){ //check if player's $ is > purchasePrice
			whoPurchase.TakePlayerMoney(purchasePrice);
			isPurchased = true;
			return true;
		}/*else{
			return false;
		}*/
		return isPurchased;
	}
	public void Sell(Player whoPurchase){
		whoPurchase.GivePlayerMoney(purchasePrice/2);
		isPurchased = false;
	}
	public void Demolish() {
		isPurchased = false;
	}
	
	public boolean IsPurchased(){
		return isPurchased;
	}
	public int GetRent(){
		return newRent;
	}
	
	public static Hotel _NewHotel(int rent, int purchase){
		Hotel hot = new Hotel();
		hot.newRent = rent;
		hot.purchasePrice = purchase;
		hot.isPurchased = false;
		return hot;
	}
}
