package CSC110.monopoly.cards.chance;

import CSC110.monopoly.cards.Card;
import CSC110.monopoly.player.Player;

public class GiveMoneyCard implements Card {
	int addMoney = 0;
	String name = "";
	int takeOtherPlayerMoney = 0;
	
	public static GiveMoneyCard makeNewMoneyCard(int giveCurrentPlayerMoney, String discription, int takeOtherPlayer){
		GiveMoneyCard GiveMoney = new GiveMoneyCard();
		GiveMoney.addMoney = giveCurrentPlayerMoney;
		GiveMoney.takeOtherPlayerMoney = takeOtherPlayer;
		GiveMoney.name = discription;
		return GiveMoney;
		
	}

	public void playCard(Player owner) {
		
		
	}
}
