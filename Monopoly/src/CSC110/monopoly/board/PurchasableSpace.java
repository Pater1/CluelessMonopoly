package CSC110.monopoly.board;

import CSC110.monopoly.testing.Player;

public interface PurchasableSpace extends BoardSpace{
	public void Purchase(Player whoPurchase);
	public void Sell(Player whoPurchase);
	public void Mortgage(Player whoPurchase);
}
