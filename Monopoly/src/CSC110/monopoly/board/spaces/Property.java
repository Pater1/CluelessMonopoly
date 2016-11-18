package CSC110.monopoly.board.spaces;

import java.io.IOException;

import CSC110.monopoly.Driver.AskForInput;
import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.board.PurchasableSpace;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.board.spaces.modifiers.*;
import CSC110.monopoly.player.Player;

public class Property extends PurchasableSpace {
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
	private int rentCost;
 	private Construction[] developments;
 	
 	protected int getRent(){
 		int ret = rentCost;
 		for(int i = 0; i < developments.length; i++){
 			if(developments[i].IsPurchased()){
 				ret = developments[i].GetRent();
 			}else{
 				break;
 			}
 		}
 		return ret;
 	}

	public void Upgrade(Player whoPurchase) {
		Construction curCon = null;
		for(int i = 0; i < developments.length; i++){
			if(!developments[i].IsPurchased()) curCon = developments[i];
		}
		
		boolean bought = false;
		if(curCon == null){
			//no more developments to make
		}else{
			bought = curCon.Purchase(whoPurchase);
		}
		
		if(bought && curCon instanceof Hotel){
			for(int i = 0; i >= developments.length; i++){
				if(developments[i] instanceof House) developments[i].Demolish();
			}
		}
	}
	public void DownGrade(Player whoPurchase) {
		Construction curCon = null;
		for(int i = developments.length-1; i >= 0; i++){
			if(developments[i].IsPurchased()) curCon = developments[i];
		}
		
		if(curCon == null){
			//no more developments to sell
		}else{
			curCon.Sell(whoPurchase);
		}
	}

	public static Property _MakeNewProperty(String name, PropertyGroup propGroup, int price, int rent, Construction[] possibleDevelopments, GameBoard brd){
		Property prop = new Property();
		prop.name = name;
		prop.purchasePrice = price;
		prop.rentCost = rent;
		prop.developments = possibleDevelopments;
		prop.group = propGroup;
		prop.whoOwns = null;
		prop.board = brd;
		return prop;
	}

	public String[] Render(Player[] plas) {
		return RenderAssistant.SpliceTile(new String[]{
				name,
				group.name(),
				"Rent: " + rentCost,
				(whoOwns == null) ? "Purchase: " + purchasePrice : "Mortgage: " + (purchasePrice),
				RenderAssistant.FitPlayerName(plas),
				"Owner: " + whoOwns
		});
	}
}