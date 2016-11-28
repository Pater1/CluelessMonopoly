package CSC110.monopoly.cards.chance;

import java.io.IOException;

import CSC110.monopoly.Game.Game;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.cards.Card;
import CSC110.monopoly.player.Player;

public class TakeMoneyFromOtherPlayersCard extends Card{
	int subMoney = 0;
	Game game;
	
	public static TakeMoneyFromOtherPlayersCard _MakeNewMoneyCard(String name, int takePlayersMoney, Game gm){
		TakeMoneyFromOtherPlayersCard takeMoney = new TakeMoneyFromOtherPlayersCard();
		takeMoney.subMoney = takePlayersMoney;
		takeMoney.name = name;
		takeMoney.game = gm;
		return takeMoney;
	}
	public void playCard(Player owner) throws IOException {
		int total = 0;
		if(subMoney > 0){
			for(int i = 0; i < game.GetPlayers().length; i++){
				if(game.GetPlayers()[i] != owner){
					game.GetPlayers()[i].TakePlayerMoney(subMoney);
					total += subMoney;
				}
			}
			owner.GivePlayerMoney(total);
		}else{
			for(int i = 0; i < game.GetPlayers().length; i++){
				if(game.GetPlayers()[i] != owner){
					game.GetPlayers()[i].GivePlayerMoney(subMoney);
					total += subMoney;
				}
			}
			owner.TakePlayerMoney(total);
		}
		
		System.out.println("You drew: \n" + RenderAssistant.RenderArray(Render()));
		Game._Stall();
	}
	@Override
	public String[] Render() {
		return RenderAssistant.SpliceTile(new String[]{
				name,
				"Take $" + subMoney + " from each player"
		});
	}
}
