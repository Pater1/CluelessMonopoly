package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.PurchasableSpace;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.board.spaces.modifiers.*;
import CSC110.monopoly.player.Player;

public class Property implements PurchasableSpace {
	public enum PropertyGroup{
		Brown,
		LightBlue,
		Purple,
		Orange,
		Red,
		Yellow,
		Green,
		Blue,
		Utility
	}
	private PropertyGroup group;
	private String propertyName;
	private int purchasePrice, rentCost;
 	private Construction[] developments;
 	private Player whoOwns;
 	
 	private int getRent(){
 		int ret = rentCost;
 		for(int i = 0; i < developments.length; i++){
 			if(developments[i].IsPurchased()) ret = developments[i].GetRent();
 		}
 		return ret;
 	}
	
	public void LandOnSpace(Player whoLanded){
		if(whoOwns == null){
			//TODO: UI to buy property
		}else if(whoLanded != whoOwns){
			whoLanded.TakePlayerMoney(getRent());
			whoOwns.GivePlayerMoney(getRent());
		}
	}
	public void PassSpace(Player whoPassed){
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

	public void Upgrade(Player whoPurchase) {
		// TODO Auto-generated method stub
	}

	public void DownGrade(Player whoPurchase) {
		// TODO Auto-generated method stub
	}

	public static Property _MakeNewProperty(String name, PropertyGroup propGroup, int price, int rent, Construction[] possibleDevelopments){
		Property prop = new Property();
		prop.propertyName = name;
		prop.purchasePrice = price;
		prop.rentCost = rent;
		prop.developments = possibleDevelopments;
		prop.group = propGroup;
		prop.whoOwns = null;
		return prop;
	}

	public String[] Render(Player[] plas) {
		return RenderAssistant.SpliceTile(new String[]{
				propertyName,
				group.name(),
				"Rent: " + rentCost,
				(whoOwns == null) ? "Purchase: " + purchasePrice : "Mortgage: " + (purchasePrice),
				RenderAssistant.FitPlayerName(plas),
				"Owner: " + whoOwns
		});
	}
}