package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.board.PurchasableSpace;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.player.Player;

public class RailRoad extends PurchasableSpace{
	private int baseRent;
 	
 	protected int getRent(){
 		return baseRent * board.OwnedRailsCount(this);
 	}
	
	public static RailRoad _NewRail(String railName, int rent, int purchase, GameBoard brd){
		RailRoad rail = new RailRoad();
		rail.name = railName;
		rail.baseRent = rent;
		rail.purchasePrice = purchase;
		rail.whoOwns = null;
		rail.board = brd;
		return rail;
	}
	
	public String[] Render(Player[] plas) {
		return RenderAssistant.SpliceTile(new String[]{
				name,
				"Rent: " + getRent(),
				(whoOwns == null) ? "Purchase: " + purchasePrice : "Mortgage: " + (purchasePrice),
				RenderAssistant.FitPlayerName(plas),
				"Owner: " + whoOwns
		});
	}

	public String GetName() {
		return name;
	}
}
