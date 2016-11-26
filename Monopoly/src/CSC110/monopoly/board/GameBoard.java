package CSC110.monopoly.board;

import java.util.ArrayList;

import CSC110.monopoly.board.spaces.CardDraw;
import CSC110.monopoly.board.spaces.FreeSpace;
import CSC110.monopoly.board.spaces.Go;
import CSC110.monopoly.board.spaces.Jail;
import CSC110.monopoly.board.spaces.Property;
import CSC110.monopoly.board.spaces.RailRoad;
import CSC110.monopoly.board.spaces.Tax;
import CSC110.monopoly.board.spaces.Utility;
import CSC110.monopoly.board.spaces.Property.PropertyGroup;
import CSC110.monopoly.board.spaces.modifiers.Construction;
import CSC110.monopoly.board.spaces.modifiers.Hotel;
import CSC110.monopoly.board.spaces.modifiers.House;
import CSC110.monopoly.cards.Deck;
import CSC110.monopoly.player.Player;

public class GameBoard {
	public BoardSpace[] board = _NewBoard(this);

	public ArrayList<PurchasableSpace> ProertiesOwnedBy(Player player) {
		ArrayList<PurchasableSpace> aps = new ArrayList<PurchasableSpace>();
		for(int i = 0; i < board.length; i++){
			if(board[i] instanceof PurchasableSpace){
				PurchasableSpace other = (PurchasableSpace)board[i];
				if(other.DoesOwn(player)) aps.add(other);
			}
		}
		return aps;
	}
	public boolean IsOtherUtilOwned(Utility utility) {
		for(int i = 0; i < board.length; i++){
			if(board[i] instanceof Utility && !board[i].GetName().equals(utility.GetName())){
				Utility other = (Utility)board[i];
				if(utility.whoOwns == other.whoOwns) return true;
			}
		}
		return false;
	}
	public int OwnedRailsCount(RailRoad railRoad) {
		int count = 0;
		for(int i = 0; i < board.length; i++){
			if(board[i] instanceof RailRoad){
				RailRoad other = (RailRoad)board[i];
				if(railRoad.whoOwns == other.whoOwns) count ++;
			}
		}
		return count;
	}
	
	public int FindSpaceIndexByName(String space){
		for(int i = 0; i < board.length; i++){
			if(board[i].GetName().equals(space)) return i;
		}
		
		return -1;
	}
	public BoardSpace FindSpaceByName(String space){
		for(int i = 0; i < board.length; i++){
			if(board[i].GetName().equals(space)) return board[i];
		}
		
		return null;
	}
	
	public String RenderToConsole(Player[] plas, int boardWidth){
		//Get Renders
		ArrayList<String[]> brd = new ArrayList<String[]>();
		for(int i = 0; i < board.length; i++){
			String[] spc = board[i].Render(plas);
			if(spc != null && spc.length > 0){
				brd.add(spc);
			}
		}
		
		//Sort for render
		ArrayList<String[]> srt = new ArrayList<String[]>();
		for(int i = 0; i < boardWidth; i++){
			srt.add(i, brd.get(i));
			
			srt.add(brd.get(brd.size()/2+boardWidth-i-1));
		}
		int col1 = boardWidth;
		for(int i = boardWidth; i < brd.size()/2; i++){
			srt.add(col1, brd.get(brd.size()-1-i+boardWidth));
			col1++;

			for(int j = 0; j < boardWidth-2; j++){
				srt.add(col1, RenderAssistant.EmptyTile());
				col1++;
			}
			
			srt.add(col1, brd.get(i));
			col1++;
		}
		
		//Render to rows
		ArrayList<String> mezinine = new ArrayList<String>();
		int dropDepth = -1;
		for(int i = 0; i < srt.size(); i++){
			if(i%boardWidth == 0) dropDepth ++;
			for(int j = 0; j < srt.get(i).length; j++){
				int y = ((srt.get(i).length) * dropDepth) + j;
				if(mezinine.size() <= y){
					mezinine.add(srt.get(i)[j]);
				}else{
					mezinine.set(y, mezinine.get(y) + srt.get(i)[j]);
				}
			}
		}
		
		//render to String
		String ret = "";
		for(int i = 0; i < mezinine.size(); i++){
			ret += mezinine.get(i) + "\n";
		}
		return ret;
	}
	
	public static GameBoard _NewGameBoard(){
		GameBoard gmbrd = new GameBoard();
		gmbrd.board = _NewBoard(gmbrd);
		return gmbrd;
	}
			
	private static final BoardSpace[] _NewBoard(GameBoard brd){
		Deck communityChest = Deck.CommunityChestDeck(), chance = Deck.ChanceDeck();
		return new BoardSpace[]{
				//Go --corner
				Go._NewGo(200, brd),
				//Mediteranian Avenue -Property-Brown
				Property._MakeNewProperty("Mediteranian Avenue", PropertyGroup.Brown, 60, 2, new Construction[]{
						House._NewHouse(50,10),
						House._NewHouse(50,30),
						House._NewHouse(50,90),
						House._NewHouse(50,160),
						Hotel._NewHotel(100,250)
				}, brd),
				//Community Chest
				CardDraw._NewCardDraw(communityChest, brd),
				//Baltic Avenue -Property-Brown
				Property._MakeNewProperty("Baltic Avenue", PropertyGroup.Brown, 60, 4, new Construction[]{
						House._NewHouse(50,20),
						House._NewHouse(50,60),
						House._NewHouse(50,180),
						House._NewHouse(50,320),
						Hotel._NewHotel(100,450)
				}, brd),
				//Income Tax
				Tax._NewTax("Income Tax", 200, brd),
				//Reading Railroad -RailRoad
				RailRoad._NewRail("Reading Railroad", 25, 200, brd),
				//Oriental Avenue -Property-LightBlue
				Property._MakeNewProperty("Oriental Avenue", PropertyGroup.LightBlue, 100, 6, new Construction[]{
						House._NewHouse(50,30),
						House._NewHouse(50,90),
						House._NewHouse(50,270),
						House._NewHouse(50,400),
						Hotel._NewHotel(100,550)
				}, brd),
				//Chance
				CardDraw._NewCardDraw(chance, brd),
				//Vermont Avenue -Property-LightBlue
				Property._MakeNewProperty("Vermont Avenue", PropertyGroup.LightBlue, 100, 6, new Construction[]{
						House._NewHouse(50,30),
						House._NewHouse(50,90),
						House._NewHouse(50,270),
						House._NewHouse(50,400),
						Hotel._NewHotel(100,550)
				}, brd),
				//Connecticut Avenue -Property-LightBlue
				Property._MakeNewProperty("Connecticut Avenue", PropertyGroup.LightBlue, 120, 8, new Construction[]{
						House._NewHouse(50,40),
						House._NewHouse(50,100),
						House._NewHouse(50,300),
						House._NewHouse(50,450),
						Hotel._NewHotel(100,600)
				}, brd),
				//Jail --corner
				Jail._NewJail(3, brd),
				//St. Charles Place -Property-Purple
				Property._MakeNewProperty("St. Charles Place", PropertyGroup.Purple, 140, 10, new Construction[]{
						House._NewHouse(100,50),
						House._NewHouse(100,150),
						House._NewHouse(100,450),
						House._NewHouse(100,625),
						Hotel._NewHotel(200,750)
				}, brd),
				//Electric Company -Utility
				Utility._NewUtility("Electric Company", 150, 4, 10),
				//States Avenue -Property-Purple
				Property._MakeNewProperty("States Avenue", PropertyGroup.Purple, 140, 10, new Construction[]{
						House._NewHouse(100,50),
						House._NewHouse(100,150),
						House._NewHouse(100,450),
						House._NewHouse(100,625),
						Hotel._NewHotel(200,750)
				}, brd),
				//Virginia Avenue -Property-Purple
				Property._MakeNewProperty("Virginia Avenue", PropertyGroup.Purple, 160, 12, new Construction[]{
						House._NewHouse(100,60),
						House._NewHouse(100,180),
						House._NewHouse(100,500),
						House._NewHouse(100,700),
						Hotel._NewHotel(200,900)
				}, brd),
				//Pennsylvania Railroad -RailRoad
				RailRoad._NewRail("Pennsylvania Railroad", 25, 200, brd),
				//St. James Place -Property-Orange
				Property._MakeNewProperty("St. James Place", PropertyGroup.Orange, 180, 14, new Construction[]{
						House._NewHouse(100,70),
						House._NewHouse(100,200),
						House._NewHouse(100,550),
						House._NewHouse(100,750),
						Hotel._NewHotel(200,950)
				}, brd),
				//Community Chest
				CardDraw._NewCardDraw(communityChest, brd),
				//Tennessee Avenue -Property-Orange
				Property._MakeNewProperty("Tennessee Avenue", PropertyGroup.Orange, 180, 14, new Construction[]{
						House._NewHouse(100,70),
						House._NewHouse(100,200),
						House._NewHouse(100,550),
						House._NewHouse(100,750),
						Hotel._NewHotel(200,950)
				}, brd),
				//New York Avenue -Property-Orange
				Property._MakeNewProperty("New York Avenue", PropertyGroup.Orange, 200, 16, new Construction[]{
						House._NewHouse(100,80),
						House._NewHouse(100,220),
						House._NewHouse(100,600),
						House._NewHouse(100,800),
						Hotel._NewHotel(200,1000)
				}, brd),
				//Free Parking --corner
				FreeSpace._NewFreeSpace("Free Parking"),
				//Kentucky Avenue -Property-Red
				Property._MakeNewProperty("Kentucky Avenue", PropertyGroup.Red, 220, 18, new Construction[]{
						House._NewHouse(150,90),
						House._NewHouse(150,250),
						House._NewHouse(150,700),
						House._NewHouse(150,875),
						Hotel._NewHotel(300,1050)
				}, brd),
				//Chance
				CardDraw._NewCardDraw(chance, brd),
				//Indiana Avenue -Property-Red
				Property._MakeNewProperty("Indiana Avenue", PropertyGroup.Red, 220, 18, new Construction[]{
						House._NewHouse(150,90),
						House._NewHouse(150,250),
						House._NewHouse(150,700),
						House._NewHouse(150,875),
						Hotel._NewHotel(300,1050)
				}, brd),
				//Illinois Avenue -Property-Red
				Property._MakeNewProperty("Illinois Avenue", PropertyGroup.Red, 240, 20, new Construction[]{
						House._NewHouse(150,100),
						House._NewHouse(150,300),
						House._NewHouse(150,750),
						House._NewHouse(150,925),
						Hotel._NewHotel(300,1100)
				}, brd),
				//B. & O. Railroad -Property-RailRoad
				RailRoad._NewRail("B. & O. Railroad", 25, 200, brd),
				//Atlantic Avenue -Property-Yellow
				Property._MakeNewProperty("Atlantic Avenue", PropertyGroup.Yellow, 260, 22, new Construction[]{
						House._NewHouse(150,110),
						House._NewHouse(150,330),
						House._NewHouse(150,800),
						House._NewHouse(150,975),
						Hotel._NewHotel(300,1150)
				}, brd),
				//Ventnor Avenue -Property-Yellow
				Property._MakeNewProperty("Ventnor Avenue", PropertyGroup.Yellow, 260, 22, new Construction[]{
						House._NewHouse(150,110),
						House._NewHouse(150,330),
						House._NewHouse(150,800),
						House._NewHouse(150,975),
						Hotel._NewHotel(300,1150)
				}, brd),
				//Water Works -Utility
				Utility._NewUtility("Water Works", 150, 4, 10),
				//Marvin Gardens -Property-Yellow
				Property._MakeNewProperty("Marvin Gardens", PropertyGroup.Yellow, 280, 24, new Construction[]{
						House._NewHouse(150,120),
						House._NewHouse(150,360),
						House._NewHouse(150,850),
						House._NewHouse(150,1025),
						Hotel._NewHotel(300,1200)
				}, brd),
				//Go To Jail --corner
				Jail._NewJail(brd),
				//Pacific Avenue -Property-Green
				Property._MakeNewProperty("Pacific Avenue", PropertyGroup.Green, 300, 26, new Construction[]{
						House._NewHouse(200,130),
						House._NewHouse(200,390),
						House._NewHouse(200,900),
						House._NewHouse(200,1100),
						Hotel._NewHotel(400,1275)
				}, brd),
				//North Carolina Avenue -Property-Green
				Property._MakeNewProperty("North Carolina Avenue", PropertyGroup.Green, 300, 26, new Construction[]{
						House._NewHouse(200,130),
						House._NewHouse(200,390),
						House._NewHouse(200,900),
						House._NewHouse(200,1100),
						Hotel._NewHotel(400,1275)
				}, brd),
				//Community ChestC
				CardDraw._NewCardDraw(communityChest, brd),
				//Pennsylvania Avenue -Property-Green
				Property._MakeNewProperty("Pennsylvania Avenue", PropertyGroup.Green, 320, 28, new Construction[]{
						House._NewHouse(200,150),
						House._NewHouse(200,450),
						House._NewHouse(200,1000),
						House._NewHouse(200,1200),
						Hotel._NewHotel(400,1400)
				}, brd),
				//Short Line -Property-RailRoad
				RailRoad._NewRail("Short Line", 25, 200, brd),
				//Chance
				CardDraw._NewCardDraw(chance, brd),
				//Park Place -Property-Blue
				Property._MakeNewProperty("Park Place", PropertyGroup.Blue, 350, 35, new Construction[]{
						House._NewHouse(200,175),
						House._NewHouse(200,500),
						House._NewHouse(200,1100),
						House._NewHouse(200,1300),
						Hotel._NewHotel(400,1500)
				}, brd),
				//Luxury Tax
				Tax._NewTax("Luxury Tax", 100, brd),
				//Boardwalk -Property-Blue
				Property._MakeNewProperty("Boardwalk", PropertyGroup.Blue, 400, 50, new Construction[]{
						House._NewHouse(200,200),
						House._NewHouse(200,600),
						House._NewHouse(200,1400),
						House._NewHouse(200,1700),
						Hotel._NewHotel(400,2000)
				}, brd),
		};
	}
}