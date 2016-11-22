package CSC110.monopoly.player;

import java.io.IOException;
import java.util.ArrayList;

import CSC110.monopoly.Driver.AskForInput;
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
		moneyUse.takePayerMoney(amountTaken);
		
	}
	
	public static Piece playerInit(PieceName pieceInput) throws IOException {
		Piece newPiece = new Piece();
		newPiece.piece = pieceInput;
		return newPiece;
	}
	
	//I am aware this isn't correct; I do however have the enum converted to a string.
	public String getPlayerName() throws IOException{
		PieceName.Thimble.name();
		PieceName.Wheelbarrow.name();
		PieceName.Shoe.name();
		PieceName.Canine.name();
		PieceName.Automobile.name();
		PieceName.Iron.name();
		PieceName.TopHat.name();
		PieceName.NavalShip.name();
		return playerName;
	}
	
	public int howMuchMoneyOwned(){
		return moneyUse.getCurrentMoney();
	}
	
	public int getCurrentPlayerLocation(int locationalInt){		
		return locationalInt;
	}
	
	public int setPlayerLocation(int location){
		location = locationalInt;
		return locationalInt;
	}
	
	public void storePlayerCards(Card card){
		playerCards.add(card);
	}
}
