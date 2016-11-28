package CSC110.monopoly.board.spaces.modifiers;

import CSC110.monopoly.player.Player;

public class Construction {
	private boolean isPurchased = false;
	private int newRent, purchasePrice;
	private String name;
	
	public Construction(String type, int rent, int purchase){
		name = type;
		newRent = rent;
		purchasePrice = purchase;
		isPurchased = false;
	}
	
	public int BuyPrice(){
		return purchasePrice;
	}
	public int SellPrice(){
		return purchasePrice/2;
	}
	public String GetName(){
		return name;
	}
	
	public boolean Purchase(Player whoPurchase){
		if(whoPurchase.howMuchMoneyOwned() > BuyPrice()){
			whoPurchase.TakePlayerMoney(BuyPrice());
			isPurchased = true;
			return true;
		}else{
			return false;
		}
	}
	public void Sell(Player whoPurchase){
		whoPurchase.GivePlayerMoney(SellPrice());
		isPurchased = false;
	}
	public void Demolish(){
		isPurchased = false;
	}
	public boolean IsPurchased(){
		return isPurchased;
	}
	public int GetRent(){
		return newRent;
	}
}
