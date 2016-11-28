package CSC110.monopoly.cards.chance;

import java.io.IOException;

import CSC110.monopoly.Game.Game;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.cards.Card;
import CSC110.monopoly.player.Player;

public class GiveMoneyCard extends Card {
	int addMoney = 0;
	
	public static GiveMoneyCard _MakeNewMoneyCard(String discription, int giveToThisPlayer){
		GiveMoneyCard GiveMoney = new GiveMoneyCard();
		GiveMoney.addMoney = giveToThisPlayer;
		GiveMoney.name = discription;
		return GiveMoney;
		
	}

	public void playCard(Player owner) throws IOException {
		if(addMoney > 0){
			owner.GivePlayerMoney(addMoney);
		}else{
			owner.TakePlayerMoney(-addMoney);
		}

		System.out.println("You drew: \n" + RenderAssistant.RenderArray(Render()));
		Game._Stall();
	}
	
	public String[] Render() {
		String prnt = "";
		if(addMoney > 0){
			prnt = "Recieve: " + addMoney + " from the bank.";
		}else{
			prnt = "Give: " + (-addMoney) + " to the bank.";
		}
		
		return RenderAssistant.SpliceTile(new String[]{
				name,
				prnt
		});
	}
}
