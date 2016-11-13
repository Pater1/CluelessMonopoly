package CSC110.monopoly.cards;

public class Deck {
	private Card[] totalCards, currentCards;
	
	public Card DrawCard(){
		//TODO: return next card in currentCards
		//#if current cards is out of cards, shuffle totalCards into new currentCards
		return new AdvanceToGoCC();
	}
	
	private Card[] Shuffle(Card[] toShuffle){
		//TODO: shuffle toShuffle deck, and return it
		//CHECK: make sure shuffle does not duplicate or skip cards! 
		//Recommend not changing order of toShuffle array
		return new Card[0];
	}
	
	public static Deck CommunityChestDeck(){
		//TODO: return a Deck that holds the community chest cards
		return new Deck();
	}
	public static Deck ChanceDeck(){
		//TODO: return a Deck that holds the chance cards
		return new Deck();
	}
}
