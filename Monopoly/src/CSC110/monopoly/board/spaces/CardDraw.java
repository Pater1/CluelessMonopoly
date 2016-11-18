package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.cards.Card;
import CSC110.monopoly.cards.Deck;
import CSC110.monopoly.player.Player;

public class CardDraw extends BoardSpace{
	private Deck deck;

	public void LandOnSpace(Player whoLanded) {
		deck.DrawCard().playCard();
	}

	public void PassSpace(Player whoPassed) {
		return; //nothing happens when passing communityChest/Chance
	}
	
	public static CardDraw _NewCardDraw(Deck deckToDrawFrom, GameBoard brd){
		CardDraw crd = new CardDraw();
		crd.deck = deckToDrawFrom;
		crd.name = "Draw a Card"; //replace with deck type
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

	public String GetName() {
		return null;
	}
}
