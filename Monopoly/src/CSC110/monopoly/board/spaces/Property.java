package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.spaces.modifiers.*;
import CSC110.monopoly.testing.Player;

public class Property implements BoardSpace {
	public enum PropertyGroup{
		Brown,
		LightBlue,
		Purple,
		Orange,
		Red,
		Yellow,
		Green,
		Blue,
		RailRoad,
		Utility
	}
	private PropertyGroup group;
	private String propertyName;
	private int purchasePrice, rentCost;
 	private Construction[] developments = new Construction[5];

	public static Property _MakeNewProperty(String name, PropertyGroup propGroup, int price, int rent, Construction[] possibleDevelopments){
		Property prop = new Property();
		prop.propertyName = name;
		prop.purchasePrice = price;
		prop.rentCost = rent;
		prop.developments = possibleDevelopments;
		prop.group = propGroup;
		return prop;
	}
	
	public void LandOnSpace(Player whoLanded){
		//TODO: UI to buy property
	}
	public void PassSpace(Player whoPassed){
		return; //Properties don't do anything when passed
	}
}