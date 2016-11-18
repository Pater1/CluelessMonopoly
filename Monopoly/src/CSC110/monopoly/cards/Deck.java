package CSC110.monopoly.cards;

import java.util.Random;

import CSC110.monopoly.cards.comchest.AdvanceToGoCC;

public class Deck {
	private Card[] totalCards, currentCards;
	int CCSize = 15;
	int CSize = 15;
	
	public Card DrawCard(){
		//TODO: return next card in currentCards
		//#if current cards is out of cards, shuffle totalCards into new currentCards
		return new AdvanceToGoCC();
	}
	
	private static Card[] Shuffle(Card[] toShuffle){
		//TODO: shuffle toShuffle deck, and return it
		 int test;
		    Card temp;
		    Random randIndex = new Random();
		    for (int i = 0; i < 15; i++) {
		    	test = randIndex.nextInt(15);
		        temp = toShuffle[i];
		        toShuffle[i] = toShuffle[test];
		        toShuffle[test] = temp;
		    }
		//CHECK: make sure shuffle does not duplicate or skip cards! 
		//Recommend not changing order of toShuffle array
		return new Card[0];
	}
	
	public static Deck CommunityChestDeck(){
		//TODO: return a Deck that holds the community chest cards
		Deck CCDeck = new Deck();
		//CCDeck.
		Card[] CCCards = new Card[]{
				
		}

		return CCDeck;
	}
	public static Deck ChanceDeck(){
		//TODO: return a Deck that holds the chance cards
		return new Deck();
	}
}
