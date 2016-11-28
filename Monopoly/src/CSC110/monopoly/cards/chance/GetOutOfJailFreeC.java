package CSC110.monopoly.cards.chance;

import java.io.IOException;

import CSC110.monopoly.Game.Game;
import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.board.spaces.Jail;
import CSC110.monopoly.cards.Card;
import CSC110.monopoly.cards.Deck;
import CSC110.monopoly.player.Player;

public class GetOutOfJailFreeC extends Card {
	Deck thisDeck;
	GameBoard board;
	
	public String[] Render() {
		return RenderAssistant.SpliceTile(new String[]{
				"Get out of Jail free"
		});
	}
	
	public GetOutOfJailFreeC(Deck myDeck, GameBoard brd){
		thisDeck = myDeck;
		board = brd;
	}

	public void playCard(Player owner) throws IOException {
		owner.storePlayerCard(this);
		thisDeck.RemoveCard(this);
		
		System.out.println("You drew: \n" + RenderAssistant.RenderArray(Render()));
		Game._Stall();
	}
	
	public void JailBreak(Player owner){
		Jail jail = (Jail)board.FindSpaceByName("Jail");
		if(jail.IsJailing(owner)){
			jail.Release(owner);
			thisDeck.AddCard(this);
		}
	}
}
