package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.PurchasableSpace;
import CSC110.monopoly.testing.Player;

public class RailRoad implements PurchasableSpace{
	private String railName;
	private int baseRent, purchasePrice, perOwnedMultiplyer;
 	private Player whoOwns;
	
	public void LandOnSpace(Player whoLanded) {
		if(whoOwns == null){
			//TODO: UI to buy property
		}else if(whoLanded != whoOwns){
			//TODO: take rent from whoLanded
			//rent = baseRent * (perOwnedMultiplyer * (number of owned railroads by this one's owner -1))
		}
	}

	public void PassSpace(Player whoPassed) {
		return;
	}

	public void Purchase(Player whoPurchase) {
		// TODO Auto-generated method stub
		
	}

	public void Sell(Player whoPurchase) {
		// TODO Auto-generated method stub
		
	}

	public void Mortgage(Player whoPurchase) {
		// TODO Auto-generated method stub
		
	}
	
	public static RailRoad _NewRail(String name, int rent, int purchase, int ownedMultiplyer){
		RailRoad rail = new RailRoad();
		rail.railName = name;
		rail.baseRent = rent;
		rail.purchasePrice = purchase;
		rail.perOwnedMultiplyer = ownedMultiplyer;
		rail.whoOwns = null;
		return rail;
	}

	@Override
	public String[] Render(Player[] plas) {
		// TODO Auto-generated method stub
		return null;
	}
}
