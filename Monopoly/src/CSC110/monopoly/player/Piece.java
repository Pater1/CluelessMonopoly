package CSC110.monopoly.player;

import java.io.IOException;
import java.util.ArrayList;

import CSC110.monopoly.cards.Card;
import CSC110.monopoly.money.Money;

public class Piece implements Player{

	Money moneyUse = new Money();
	String rawInput;
	int locationalInt = 0;
	@SuppressWarnings("unused")
	private PieceName piece;
	private String playerName;
	ArrayList<Card> playerCards = new ArrayList<Card>();
	
	public void GivePlayerMoney(int amountGiven) {
		moneyUse.givePlayerMoney(amountGiven);
		
	}

	public void TakePlayerMoney(int amountTaken) {
		moneyUse.takePlayerMoney(amountTaken);
		
	}
	
	public static Piece playerInit(PieceName pieceInput) throws IOException {
		Piece newPiece = new Piece();
		newPiece.piece = pieceInput;
		return newPiece;
	}
	
	
	public String getPlayerName(PieceName pieceInput){
		playerName = pieceInput.name();		
		return playerName;
	}
	
	public int howMuchMoneyOwned(){
		return moneyUse.getCurrentMoney();
	}
	
	public int getCurrentPlayerLocation(){		
		return locationalInt;
	}
	
	public int setPlayerLocation(int location){
		location = locationalInt;
		return locationalInt;
	}
	
	public void storePlayerCard(Card card){
		playerCards.add(card);
	}
}
