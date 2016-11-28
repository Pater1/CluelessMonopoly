package CSC110.monopoly.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import CSC110.monopoly.Game.Game;
import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.cards.chance.*;

public class Deck {
	private ArrayList<Card> totalCards, currentCards;
	
	public Card DrawCard(){
		if(currentCards.size() <= 0) currentCards = Shuffle(ListToArray(totalCards));
		Card crd = currentCards.get(new Random().nextInt(currentCards.size()));
		currentCards.remove(crd);
		return crd;
	}
	
	private static ArrayList<Card> Shuffle(Card[] toShuffle){
	    Random randIndex = new Random();
	    for (int i = 0; i < toShuffle.length; i++) {
	    	int indx = randIndex.nextInt(toShuffle.length);
	    	Card temp = toShuffle[i];
	        toShuffle[i] = toShuffle[indx];
	        toShuffle[indx] = temp;
	    }
		return new ArrayList<Card>(Arrays.asList(toShuffle));
	}
	
	private static Card[] ListToArray(ArrayList<Card> toConvert){
		Card[] crd = new Card[toConvert.size()];
		for(int i = 0; i < crd.length; i++){
			crd[i] = toConvert.get(i);
		}
		return crd;
	}
	
	public static Deck CommunityChestDeck(GameBoard monopolyGame, Deck communityChest){		
		Deck CCDeck = communityChest;
		Card[] CCCards = new Card[]{
				//Grand opening (collect $50 from each Player)
				TakeMoneyFromOtherPlayersCard._MakeNewMoneyCard("Grand opening!", 50, monopolyGame.game),
				//Recieve $25 for services
				GiveMoneyCard._MakeNewMoneyCard("Income for services", 25),
				//Advance to GO
				MovePlayerCard._MakeNewMovePlayerCard("Go", "Advance to GO", monopolyGame),
				//Pay Hospital (Bank) $100
				GiveMoneyCard._MakeNewMoneyCard("Pay Hospital Fee", -100),
				//Doctor's Fee (pay $50)
				GiveMoneyCard._MakeNewMoneyCard("Pay Doctor's Fees", -50),
				//Get out of Jail Free
				new GetOutOfJailFreeC(CCDeck, monopolyGame),
				//Get $45 for sale of stock
				GiveMoneyCard._MakeNewMoneyCard("Stock sale", 45),
				//You inherit $100
				GiveMoneyCard._MakeNewMoneyCard("Collect your inheritance", 100),
				//Go directly to jail
				MovePlayerCard._NewGoToJail(monopolyGame),
				//Life insurance matures (Collect $100)
				GiveMoneyCard._MakeNewMoneyCard("Life insurance matures", 100),
				//You've won 2nd place in a beauty contest (Collect $10)
				GiveMoneyCard._MakeNewMoneyCard("2nd place in beauty contest", 10),
				//Christmas fund matures (Collect $100)
				GiveMoneyCard._MakeNewMoneyCard("Xmas fund matures", 100),
				//Street repairs (Pay $40 per House, $115 per Hotel)
				new PropertyRenovations("Street repairs",40,115,monopolyGame),
				//Bank error in your favor (Collect $200)
				GiveMoneyCard._MakeNewMoneyCard("Bank error", 200),
				//Income tax refund (Collect $20)
				GiveMoneyCard._MakeNewMoneyCard("Income tax refund", 20),
		};

		CCDeck.totalCards = new ArrayList<Card>(Arrays.asList(CCCards));
		CCDeck.currentCards = Shuffle(ListToArray(CCDeck.totalCards));
		return CCDeck;
	}
	public static Deck ChanceDeck(GameBoard monopolyGame, Deck chance){
		Deck CCDeck = chance;
		Card[] CCCards = new Card[]{
				//Advance to go
				MovePlayerCard._MakeNewMovePlayerCard("Go", "Advance to GO", monopolyGame),
				//$50 Dividend from bank
				GiveMoneyCard._MakeNewMoneyCard("Bank dividend", 50),
				//Go back 3 spaces
				MovePlayerCard._NewMoveByCard(-3, monopolyGame),
				//advance to nearest Utility
				MovePlayerCard._NewMoveToNearestRail("Move to nearest Utility", monopolyGame, false),
				//Go to Jail
				MovePlayerCard._NewGoToJail(monopolyGame),
				//Pay poor tax $15
				GiveMoneyCard._MakeNewMoneyCard("Pay poor tax", -15),
				//Advance to St. Charles place
				MovePlayerCard._MakeNewMovePlayerCard("St. Charles Place", "Advance to St. Charles Place", monopolyGame),
				//You've been elected chairman of the board (pay each player $50)
				TakeMoneyFromOtherPlayersCard._MakeNewMoneyCard("You've been elected chairman of the board!", -50, monopolyGame.game),
				//Advance to nearest railroad (pay 2X rent) (2 of this card)
				MovePlayerCard._NewMoveToNearestRail("Pay 2x rent on nearest rail", monopolyGame, true),
				MovePlayerCard._NewMoveToNearestRail("Pay 2x rent on nearest rail", monopolyGame, true),
				//Go to Reading Railroad
				MovePlayerCard._MakeNewMovePlayerCard("Reading Railroad", "Ride the Reading Railroad", monopolyGame),
				//Advance to boardwalk
				MovePlayerCard._MakeNewMovePlayerCard("Boardwalk", "Advance to Boardwalk", monopolyGame),
				//Your loan matures (collect $150 from the bank)
				GiveMoneyCard._MakeNewMoneyCard("Loan matures", 150),
				//Advance to Illinois Avenue
				MovePlayerCard._MakeNewMovePlayerCard("Illinois Avenue", "Advance to Illinois Avenue", monopolyGame),
				//Get out of Jail free
				new GetOutOfJailFreeC(CCDeck, monopolyGame),
				//General property repairs ($25 per House, $100 per Hotel)
				new PropertyRenovations("General property repairs",25,100,monopolyGame)
		};

		CCDeck.totalCards = new ArrayList<Card>(Arrays.asList(CCCards));
		CCDeck.currentCards = Shuffle(ListToArray(CCDeck.totalCards));
		return CCDeck;
	}


	public void RemoveCard(Card crd) {
		totalCards.remove(crd);
	}
	public void AddCard(Card crd) {
		totalCards.add(crd);
	}
}
