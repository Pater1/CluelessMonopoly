package CSC110.monopoly.cards.chance;

import CSC110.monopoly.cards.Card;
import CSC110.monopoly.player.Player;

public class TakeMoneyCard implements Card{
	int subMoney = 0;
	String name = "";
	
	public static TakeMoneyCard makeNewMoneyCard(int takeCurrentPlayerMoney, String discription){
		TakeMoneyCard takeMoney = new TakeMoneyCard();
		takeMoney.subMoney = takeCurrentPlayerMoney;
		takeMoney.name = discription;
		return takeMoney;
		
	}
	public void playCard(Player owner) {
		
		
	}
}
