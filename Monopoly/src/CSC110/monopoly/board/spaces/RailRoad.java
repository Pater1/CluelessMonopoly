package CSC110.monopoly.board.spaces;

import java.io.IOException;

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
	
	public void PayDoubleRent(Player whoLanded){
		whoLanded.TakePlayerMoney(getRent()*2);
		whoOwns.GivePlayerMoney(getRent()*2);
	}
	
	public String[] Render(Player[] plas) {
		return RenderAssistant.SpliceTile(new String[]{
				name,
				"Rent: " + getRent(),
				(whoOwns == null) ? "Purchase: " + purchasePrice : "Mortgage: " + (purchasePrice),
				RenderAssistant.FitPlayerName(plas),
				"Owner: " + ((whoOwns == null)? "null" : whoOwns.getPlayerName())
		});
	}

	public String GetName() {
		return name;
	}
}
