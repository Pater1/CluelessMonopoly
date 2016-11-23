package CSC110.monopoly.player;

import CSC110.monopoly.cards.Card;

public interface Player {
	
	public void GivePlayerMoney(int amountGiven);
	
	public void TakePlayerMoney(int amountTaken);
	
	public String getPlayerName(PieceName pieceInput);
	
	public int howMuchMoneyOwned();
	
	public int getCurrentPlayerLocation(int locationalInt);
	
	public int setPlayerLocation(int location);
	
	public void storePlayerCard(Card card);
	
}
