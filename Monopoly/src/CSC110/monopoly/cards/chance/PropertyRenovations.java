package CSC110.monopoly.cards.chance;

import java.io.IOException;
import java.util.ArrayList;

import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.board.PurchasableSpace;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.board.spaces.Property;
import CSC110.monopoly.cards.Card;
import CSC110.monopoly.player.Player;

public class PropertyRenovations extends Card{
	int perHouse, perHotel;
	GameBoard board;
	
	public PropertyRenovations(String description, int houseCost, int hotelCost, GameBoard gameBoard){
		name = description;
		perHouse = houseCost;
		perHotel = hotelCost;
		board = gameBoard;
	}

	public void playCard(Player owner) throws IOException {
		int costTotal = 0;
		
		ArrayList<PurchasableSpace> owned = board.ProertiesOwnedBy(owner);
		for(int i = 0; i < owned.size(); i++){
			if(owned.get(i) instanceof Property){
				Property prop = (Property)owned.get(i);
				costTotal += (perHouse * prop.HousesCount()) + (prop.HasHotel()? perHotel : 0);
			}
		}
		
		owner.TakePlayerMoney(costTotal);
	}

	public String[] Render() {
		return RenderAssistant.SpliceTile(new String[]{
				name,
				"Cost per house: $" + perHouse,
				"Cost per hotel: $" + perHotel
		});
	}
}
