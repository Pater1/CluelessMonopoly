package CSC110.monopoly.cards;

import java.io.IOException;

import CSC110.monopoly.player.Player;

public abstract class Card {
	protected String name = "";
	public abstract void playCard(Player owner) throws IOException; 
	public abstract String[] Render();
	public String GetName() {
		return name;
	}
	public void Sell(Player buyer, Player seller, int salePrice) {
		seller.GivePlayerMoney(salePrice);
		buyer.TakePlayerMoney(salePrice);
		seller.removePlayerCard(this);
		buyer.storePlayerCard(this);
	}
}