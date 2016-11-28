package CSC110.monopoly.player;

import java.io.IOException;
import java.util.ArrayList;

import CSC110.monopoly.Input.AskForInput;
import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.board.PurchasableSpace;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.cards.Card;
import CSC110.monopoly.money.Money;

public class Piece implements Player{

	private GameBoard gmbrd;
	private Money moneyUse = new Money();
	private int locationalInt = 0;
	private PieceName piece;
	ArrayList<Card> playerCards = new ArrayList<Card>();
	
	public static Piece _PlayerInit(PieceName pieceInput, GameBoard board){
		Piece newPiece = new Piece();
		newPiece.piece = pieceInput;
		newPiece.moneyUse = Money._NewMoney();
		newPiece.locationalInt = 0;
		newPiece.playerCards = new ArrayList<Card>();
		newPiece.gmbrd = board;
		return newPiece;
	}
	
	public void TakeTurn() throws IOException{
		gmbrd.MovePlayer(this);
		int t = -1;
		do{
			switch(t = turnSelection()){
				case 0:
					break;
				case 1:
					System.out.println(moneyUse.displayMoney() + "Total: " + moneyUse.getCurrentMoney() + "\n");
					break;
				case 2:
					System.out.println(displayProperties());
					break;
				case 3:
					break;
				case 4:
					System.out.println(gmbrd.RenderToConsole());
					break;
				default:
			}
		}while(t != 0);
	}
	
	private int turnSelection() throws IOException{
		return AskForInput.Input(new String[]{
								"End Turn",
								"Display Current Money",
								"Display Owned Properties",
								"Display Owned Cards",
								"Display Game Board"});
	}
	
	private String displayCards(){
		if(playerCards.size() <= 0) return "You currently hold no cards...";
		
		String[][] tiles = new String[playerCards.size()][RenderAssistant.EmptyTile().length];
		for(int i = 0 ; i < tiles.length; i++){
			tiles[i] = playerCards.get(i).Render();
		}
		
		return RenderAssistant.RenderArray( RenderAssistant.ConcantinateTiles(tiles));
	}
	
	private String displayProperties(){
		ArrayList<PurchasableSpace> owned = gmbrd.ProertiesOwnedBy(this);
		
		if(owned.size() <= 0) return "You currently own no property...";
		
		String[][] tiles = new String[owned.size()][RenderAssistant.EmptyTile().length];
		for(int i = 0 ; i < tiles.length; i++){
			tiles[i] = owned.get(i).Render(new Player[0]);
		}
		
		return RenderAssistant.RenderArray( RenderAssistant.ConcantinateTiles(tiles));
	}
	
	public boolean IsBankrupt(){
		if(gmbrd.ProertiesOwnedBy(this).size() <= 0 && moneyUse.getCurrentMoney() <= 0){
			return true;
		}
		return false;
	}
	
	public void GivePlayerMoney(int amountGiven) {
		moneyUse.givePlayerMoney(amountGiven);
	}

	public void TakePlayerMoney(int amountTaken) {
		moneyUse.takePlayerMoney(amountTaken);	
	}	
	
	public String getPlayerName(){
		return piece.name();
	}
	
	public int howMuchMoneyOwned(){
		return moneyUse.getCurrentMoney();
	}
	
	public int getCurrentPlayerLocation(){		
		return locationalInt;
	}
	
	public void setPlayerLocation(int location){
		locationalInt = location;
	}
	
	public void storePlayerCard(Card card){
		playerCards.add(card);
	}
}
