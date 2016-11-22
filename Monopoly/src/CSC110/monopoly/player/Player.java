package CSC110.monopoly.player;

import java.io.IOException;

import CSC110.monopoly.cards.Card;

public interface Player {
	
	public void GivePlayerMoney(int amountGiven);
	
	public void TakePlayerMoney(int amountTaken);
	
	public String getPlayerName() throws IOException;
	
	public int howMuchMoneyOwned();
	
	public int getCurrentPlayerLocation(int locationalInt);
	
	public int setPlayerLocation(int location);
	
	public void storePlayerCards(Card card);
	
}
