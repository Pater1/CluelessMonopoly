package CSC110.monopoly.cards.chance;

import CSC110.monopoly.cards.Card;

public class GiveMoneyCard implements Card {
	int currentMoney = 0;
	String name = "";
	int takeOtherPlayerMoney = 0;
	
	public static GiveMoneyCard makeNewMoneyCard(int giveCurrentPlayerMoney, String discription, int takeOtherPlayer){
		GiveMoneyCard GiveMoney = new GiveMoneyCard();
		GiveMoney.currentMoney = giveCurrentPlayerMoney;
		GiveMoney.takeOtherPlayerMoney = takeOtherPlayer;
		GiveMoney.name = discription;
		return GiveMoney;
		
	}

	@Override
	public void playCard() {
		
		
	}
}
