package CSC110.monopoly.cards.chance;

import CSC110.monopoly.player.Player;

public class GetOutOfJailFreeC {

	String name = "";

	public static GetOutOfJailFreeC makeNewJailCard(Player player, String discription){
		
		GetOutOfJailFreeC GetOut = new GetOutOfJailFreeC();
		
		GetOut.name = discription;
		return GetOut;
		
	}
	public void playCard(Player owner) {
		
		
	}
}
