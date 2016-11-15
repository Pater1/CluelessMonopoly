package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.cards.Card;
import CSC110.monopoly.cards.Deck;
import CSC110.monopoly.player.Player;

public class CardDraw implements BoardSpace{
	private Deck deck;

	public void LandOnSpace(Player whoLanded) {
		deck.DrawCard().playCard();
	}

	public void PassSpace(Player whoPassed) {
		return; //nothing happens when passing communityChest
	}
	
	public static CardDraw _NewCardDraw(Deck deckToDrawFrom){
		CardDraw crd = new CardDraw();
		crd.deck = deckToDrawFrom;
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
