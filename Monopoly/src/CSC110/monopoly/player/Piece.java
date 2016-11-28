package CSC110.monopoly.player;

import java.io.IOException;
import java.util.ArrayList;
import CSC110.monopoly.Game.Game;
import CSC110.monopoly.Input.AskForInput;
import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.board.PurchasableSpace;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.board.spaces.Jail;
import CSC110.monopoly.board.spaces.Property;
import CSC110.monopoly.board.spaces.modifiers.Construction;
import CSC110.monopoly.cards.Card;
import CSC110.monopoly.cards.chance.GetOutOfJailFreeC;
import CSC110.monopoly.money.Money;
import CSC110.patpackages.imported.StandardUIInput;

public class Piece implements Player{

	private GameBoard gmbrd;
	private Money moneyUse = new Money();
	private int locationalInt = 0;
	private PieceName piece;
	public int debt = 0;
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
		PayDebt();
		if(IsJailed()){
			switch(jailTurn()){
				case 0:
					PostBail();
				case 1:
					JailBreak();
				case 2:
					break;
				default:
			}
		}
		if(!IsJailed()){
			locationalInt = gmbrd.MovePlayer(this);
		}
		int t = -1;
		do{
			Game._Stall();
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
					System.out.println(displayCards());
					break;
				case 4:
					System.out.println(gmbrd.RenderToConsole());
					break;
				case 5:
					PropertyXgrade(true);
					break;
				case 6:
					PropertyXgrade(false);
					break;
				case 7:
					SellProperty();
					break;
				case 8:
					SellCard();
					break;
				case 9:
					Mortgage();
					break;
				default:
			}
		}while(t != 0);
		
		if(IsBankrupt()){
			GoBankrupt();
		}
	}

	private void PayDebt() throws IOException {
		if(debt <= 0) return;
		
		int interest = (int) (debt * .1);
		int payment = StandardUIInput.promptForInt("How much would you like to pay down your debt? (minimum: $" +interest + ")",interest,moneyUse.getCurrentMoney());
		
		TakePlayerMoney(payment);
	}

	private void GoBankrupt() {
		System.out.println(getPlayerName() + " is now bankrupt.");
		
		ArrayList<PurchasableSpace> props = gmbrd.ProertiesOwnedBy(this);
		for(int i = 0; i < props.size(); i++){
			if(props.get(i) instanceof Property){
				((Property)props.get(i)).ClearDevelopments();
			}
			props.get(i).Sell(null,0);
		}
		
		gmbrd.game.RemovePlayer(this);
	}

	private void JailBreak() throws IOException {
		if(playerCards.size() <= 0){
			System.out.println("You have no cards to get out of jail.");
			return;
		}
		
		GetOutOfJailFreeC outOfJail = null;
		int breakCount = 0;
		for(int i = 0; i < playerCards.size(); i++){
			if(playerCards.get(i) instanceof GetOutOfJailFreeC){
				outOfJail = (GetOutOfJailFreeC)playerCards.get(i);
				breakCount ++;
			}
		}
		if(outOfJail == null){
			System.out.println("You have no cards to get out of jail.");
			return;
		}
		
		if(AskForInput.boolInput("Use " + ((breakCount == 0)? "your only" : "one of your " + breakCount) + " Get Out of Jail Free card" + ((breakCount == 0) ? "": "s") + "?", "y", "n")){
			Jail jail = (Jail)gmbrd.FindSpaceByName("Jail");
			jail.Release(this);
			removePlayerCard(outOfJail);
		}
	}

	private void PostBail() {
		Jail jail = (Jail)gmbrd.FindSpaceByName("Jail");
		jail.Release(this);
		TakePlayerMoney(50);
	}

	private int jailTurn() throws IOException {
		return AskForInput.Input(new String[]{
				"Pay Bail [$50]",
				"Play Card",
				"Wait"
		});
	}

	private boolean IsJailed() {
		Jail jail = (Jail)gmbrd.FindSpaceByName("Jail");
		return jail.IsJailing(this);
	}

	private void Mortgage() throws IOException {
		PurchasableSpace space = askForPurchasableSpaceSelection();
		space.Mortgage(this);
	}

	private int turnSelection() throws IOException{
		return AskForInput.Input(new String[]{
								"End Turn",
								"Display Current Money",
								"Display Owned Properties",
								"Display Owned Cards",
								"Display Game Board",
								"Upgrade a Property",
								"Downgrde a Property",
								"Auction a Property",
								"Auction a Card",
								"Mortgage a Property"});
	}
	
	private void SellCard() throws IOException {
		Player[] plas = gmbrd.game.GetPlayers();
		ArrayList<Player> players = new ArrayList<Player>();
		for(int i = 0; i < plas.length; i++){
			if(plas[i] != this) players.add(plas[i]);
		}
		
		Card sell = askForCardSelection();
		
		if(sell == null){
			System.out.println("You have no Properties to sell!");
			return;
		}
		
		int startPrice = AskForInput.AskInt("Where would you like to start the bidding?");
		int salePrice = 0;
		Player buyer = null;
		
		while(salePrice == 0 && startPrice > 0){
			for(int i = 0; i < players.size(); i++){
				if(AskForInput.boolInput(players.get(i).getPlayerName() + ", would you like to buy " + sell.GetName() + " for $" + startPrice, "y", "n")){
					buyer = players.get(i);
					salePrice = startPrice;
					startPrice += 10;
				}
			}
			startPrice /= 2;
		}
		
		if(buyer == null || salePrice == 0){
			System.out.println("Looks like no one wants to buy " + sell.GetName() + "...");
			return;
		}
		
		while(players.size() > 1){
			for(int i = 0; i < players.size(); i++){
				if(AskForInput.boolInput(players.get(i).getPlayerName() + ", would you like to buy " + sell.GetName() + " for $" + salePrice, "y", "n")){
					buyer = players.get(i);
					salePrice = startPrice;
					startPrice += 10;
				}else{
					players.remove(players.get(i));
				}
			}
		}
		System.out.println("SOLD! To " + buyer.getPlayerName() + " for $" + salePrice);
		sell.Sell(buyer, this, salePrice);
	}
	
	private void SellProperty() throws IOException{
		Player[] plas = gmbrd.game.GetPlayers();
		ArrayList<Player> players = new ArrayList<Player>();
		for(int i = 0; i < plas.length; i++){
			if(plas[i] != this) players.add(plas[i]);
		}
		
		PurchasableSpace space = askForPurchasableSpaceSelection();
		
		if(space == null){
			System.out.println("You have no Properties to sell!");
			return;
		}
		
		int startPrice = AskForInput.AskInt("Where would you like to start the bidding?");
		int salePrice = 0;
		Player buyer = null;
		
		while(salePrice == 0 && startPrice > 0){
			for(int i = 0; i < players.size(); i++){
				if(AskForInput.boolInput(players.get(i).getPlayerName() + ", would you like to buy " + space.GetName() + " for $" + startPrice, "y", "n")){
					buyer = players.get(i);
					salePrice = startPrice;
					startPrice += 10;
				}
			}
			startPrice /= 2;
		}
		
		if(buyer == null || salePrice == 0){
			System.out.println("Looks like no one wants to buy " + space.GetName() + "...");
			return;
		}
		
		while(players.size() > 1){
			for(int i = 0; i < players.size(); i++){
				if(AskForInput.boolInput(players.get(i).getPlayerName() + ", would you like to buy " + space.GetName() + " for $" + salePrice, "y", "n")){
					buyer = players.get(i);
					salePrice = startPrice;
					startPrice += 10;
				}else{
					players.remove(players.get(i));
				}
			}
		}
		System.out.println("SOLD! To " + buyer.getPlayerName() + " for $" + salePrice);
		space.Sell(buyer, salePrice);
	}
	
	private void PropertyXgrade(boolean upgrade) throws IOException{
		Property prop = askForPropertySelection();
		if(prop == null){
			System.out.println("You have no properties to upgrade!");
			return;
		}
		
		Construction con = prop.GetDevelopment(upgrade);
		if(con == null){
			System.out.println("You have no more developments to " + (upgrade? "make" : "sell") + " on this property!");
			return;
		}
		
		if(AskForInput.boolInput((upgrade? "Build" : "Demolish") +" a " + con.GetName() + " on this Property for $" + (upgrade? con.BuyPrice() : con.SellPrice()) + "?\nIt will " + (upgrade? "raise" : "reduce") + " this Property's rent to $" +  (upgrade? con.GetRent() : prop.RentWithout(con)) , "y", "n")){
			con.Purchase(this);
		}
	}
	
	private PurchasableSpace askForPurchasableSpaceSelection() throws IOException{
		ArrayList<PurchasableSpace> props = gmbrd.ProertiesOwnedBy(this);
		if(props.size() <= 0) return null;
		
		ArrayList<String> propNames = new ArrayList<String>();
		
		for(int i = 0; i < props.size(); i++){
			propNames.add(props.get(i).GetName());
		}
		
		String[] strs = new String[propNames.size()];
		for(int i = 0; i < strs.length; i++){
			strs[i] = propNames.get(i);
		}
		
		int sel = AskForInput.Input(strs);
		return (PurchasableSpace) gmbrd.FindSpaceByName(propNames.get(sel));
	}
	
	private Property askForPropertySelection() throws IOException{
		ArrayList<PurchasableSpace> props = gmbrd.ProertiesOwnedBy(this);
		if(props.size() <= 0) return null;
		
		ArrayList<String> propNames = new ArrayList<String>();
		
		for(int i = 0; i < props.size(); i++){
			if(props.get(i) instanceof Property){
				propNames.add(props.get(i).GetName());
			}
		}
		
		if(propNames.size() <= 0){
			return null;
		}
		
		String[] strs = new String[propNames.size()];
		for(int i = 0; i < strs.length; i++){
			strs[i] = propNames.get(i);
		}
		
		int sel = AskForInput.Input(strs);
		Property ret = (Property) gmbrd.FindSpaceByName(propNames.get(sel));
		return ret;
	}
	
	private Card askForCardSelection() throws IOException{
		if(playerCards.size() <= 0) return null;
		
		ArrayList<String> propNames = new ArrayList<String>();
		
		for(int i = 0; i < playerCards.size(); i++){
			propNames.add(playerCards.get(i).GetName());
		}
		
		String[] strs = new String[propNames.size()];
		for(int i = 0; i < strs.length; i++){
			strs[i] = propNames.get(i);
		}
		return playerCards.get(AskForInput.Input(strs));
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
		if(netWorth(0) <= 0){
			return true;
		}
		return false;
	}
	
	public int netWorth(int testDebt){
		int net = moneyUse.getCurrentMoney();
		
		ArrayList<PurchasableSpace> owned = gmbrd.ProertiesOwnedBy(this);
		if(owned.size() <= 0){
			for(int i = 0; i < owned.size(); i++){
				net += owned.get(i).PurchasePrice();
				if(owned.get(i) instanceof Property){
					net += ((Property)owned.get(i)).DevelopmentsWorth();
				}
			}
		}

		net -= debt;
		net -= testDebt;
		
		return net;
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
	public void removePlayerCard(Card card){
		playerCards.remove(card);
	}

	
	public void GiveDebt(int purchasePrice) {
		debt += purchasePrice;
	}
}
