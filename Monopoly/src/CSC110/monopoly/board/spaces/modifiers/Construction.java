package CSC110.monopoly.board.spaces.modifiers;

import CSC110.monopoly.player.Player;

public interface Construction {
	public boolean Purchase(Player whoPurchase);
	public void Sell(Player whoPurchase);
	public void Demolish();
	public boolean IsPurchased();
	public int GetRent();
}
