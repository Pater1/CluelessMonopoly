package CSC110.monopoly.board.spaces;

import java.io.IOException;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.cards.Deck;
import CSC110.monopoly.player.Player;

public class CardDraw extends BoardSpace{
	private Deck deck;

	public void LandOnSpace(Player whoLanded) throws IOException {
		deck.DrawCard().playCard(whoLanded);
	}

	public void PassSpace(Player whoPassed) {
		return;
	}
	
	public static CardDraw _NewCardDraw(String thisName, Deck deckToDrawFrom, GameBoard brd){
		CardDraw crd = new CardDraw();
		crd.name = thisName;
		crd.deck = deckToDrawFrom;
		crd.board = brd;
		return crd;
	}

	public String[] Render(Player[] plas) {
		return RenderAssistant.SpliceTile(new String[]{
				"DRAW A CARD",
				"",
				RenderAssistant.FitPlayerName(plas)
			});
	}
}
