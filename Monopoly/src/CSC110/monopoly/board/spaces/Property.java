package CSC110.monopoly.board.spaces;

import java.util.ArrayList;

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
	}
	private PropertyGroup group;
	private int rentCost;
 	private Construction[] developments;
 	
 	public PropertyGroup thisGroup(){
 		return group;
 	}
 	
 	protected int getRent(){
 		int ret = rentCost;
 		for(int i = developments.length-1; i >= 0; i--){
 			if(developments[i].IsPurchased()){
 				ret = developments[i].GetRent();
 				break;
 			}
 		}
 		return ret;
 	}
 	
 	public int DevelopmentsWorth(){
 		int net = 0;
 		for(int i = 0; i < developments.length; i++){
 			if(developments[i].IsPurchased()) net += developments[i].SellPrice();
 		}
 		return net;
 	}
 	
 	public Construction GetDevelopment(boolean upgrade){
 		if(upgrade){
 			if(!HasHotel()){
 				for(int i = 0; i < developments.length; i++){
 					if(!developments[i].IsPurchased()){
 						return developments[i];
 					}
 				}
 			}
 		}else{
 			for(int i = developments.length-1; i >= 0; i--){
 				if(developments[i].IsPurchased()){
 					return developments[i];
 				}
 			}
 		}
 		return null;
 	}
 	
 	public int HousesCount(){
 		int ret = 0;
 		for(int i = 0; i < developments.length-1; i++){
 			if(developments[i].IsPurchased()){
 				ret++;
 			}else{
 				break;
 			}
 		}
 		return ret;
 	}
 	
 	public boolean HasHotel(){
 		return developments[developments.length-1].IsPurchased();
 	}

	public void Upgrade(Player whoPurchase) {
		Construction curCon = GetDevelopment(true);
		
		boolean bought = false;
		if(curCon == null){
			System.out.println("Looks like you have no more developments on this property to make...");
		}else{
			bought = curCon.Purchase(whoPurchase);
		}
		
		if(bought && curCon.GetName().equals("Hotel")){
			for(int i = 0; i >= developments.length; i++){
				if(developments[i].GetName().equals("House")) developments[i].Demolish();
			}
		}
	}
	public void DownGrade(Player whoPurchase) {
		Construction curCon = GetDevelopment(false);
		
		if(curCon == null){
			System.out.println("Looks like you have no more developments on this property to sell...");
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
				"Owner: " + ((whoOwns == null)? "null" : whoOwns.getPlayerName())
		});
	}

	public int RentWithout(Construction con) {
		Construction uct = null;
		for(int i = 0; i < developments.length; i++){
			if(developments[i] == con){
				if(i <= 0) return rentCost;
				uct = developments[i-1];
			}
		}
		
		if(uct == null) return -1;
		return uct.GetRent();
	}

	public void ClearDevelopments() {
		for(int i = 0; i < developments.length; i++){
			developments[i].Demolish();
 		}
	}

	public boolean NoDevelopmentsOnGroup() {
		ArrayList<Property> inThisColorGroup = board.GetSpacesInColorGroup(group);
		for(int i = 0; i < inThisColorGroup.size(); i++){
			if(inThisColorGroup.get(i).DevelopmentsWorth() > 0) return false;
		}
		return true;
	}
}