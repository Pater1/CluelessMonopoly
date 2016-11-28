package CSC110.monopoly.player;

import java.io.IOException;

import CSC110.monopoly.cards.Card;

public interface Player {
	public void TakeTurn() throws IOException;
	
	public boolean IsBankrupt();
	
	public void GivePlayerMoney(int amountGiven);
	
	public void TakePlayerMoney(int amountTaken);
	
	public String getPlayerName();
	
	public int howMuchMoneyOwned();
	
	public int getCurrentPlayerLocation();
	
	public void setPlayerLocation(int location);
	
	public void storePlayerCard(Card card);	
}
