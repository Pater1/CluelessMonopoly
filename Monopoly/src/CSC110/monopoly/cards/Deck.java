package CSC110.monopoly.cards;

import java.util.Random;

import CSC110.monopoly.cards.chance.GetOutOfJailFreeC;
import CSC110.monopoly.cards.chance.GiveMoneyCard;
import CSC110.monopoly.cards.chance.MovePlayerCard;
import CSC110.monopoly.cards.chance.TakeMoneyCard;


public class Deck {
	private Card[] totalCards, currentCards;
	int CCSize = 15;
	int CSize = 15;
	
	public Card DrawCard(){
		//TODO: return next card in currentCards
		//#if current cards is out of cards, shuffle totalCards into new currentCards
		return new bankError();
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
		GiveMoneyCard bankError = GiveMoneyCard.makeNewMoneyCard(75, "Bank error in your favor, collect $75", 0);
		GiveMoneyCard incomeTaxRefund = GiveMoneyCard.makeNewMoneyCard(20, "Income Tax Refund, collect $20", 0);
		GiveMoneyCard lifeInsuranceMatures = GiveMoneyCard.makeNewMoneyCard(100, "Your life insurance matures, collect $100", 0);
		TakeMoneyCard hospitalFee = TakeMoneyCard.makeNewMoneyCard(100, "Hospital Fees, pay $100");
		TakeMoneyCard schoolFee = TakeMoneyCard.makeNewMoneyCard(50, "School fees, pay $50");
		GiveMoneyCard consultingFee = GiveMoneyCard.makeNewMoneyCard(50, "Recieve Consulting Fee, collect $50", 0);
		GiveMoneyCard secondPrize = GiveMoneyCard.makeNewMoneyCard(10, "Second Prize in a Beuty Contest, collect $10", 0);
		GiveMoneyCard inheritance = GiveMoneyCard.makeNewMoneyCard(100, "Inheiritance, collect $100", 0);
		TakeMoneyCard doctorFee = TakeMoneyCard.makeNewMoneyCard(50, "Pay $50 for Doctor Fees");
		GiveMoneyCard stockSale = GiveMoneyCard.makeNewMoneyCard(50, "Sale of stock, collect $50", 0);
		//MovePlayerCard toGo = MovePlayerCard.makeNewMovePlayerCard(Go, "Advance to Go", monopolyGame)
		//MovePlayerCard toJail = MovePlayerCard.makeNewMovePlayerCard(Jail, "Go to Jail, do not pass go, do not collect $200", monopolyGame)
		//GetOutOfJailFreeC getOut = GetOutOfJailFreeC.makeNewJailCard(player, "May be used once to get out of jail for free");

		
		Deck CCDeck = new Deck();
		Card[] CCCards = new Card[]{ bankError, 
				incomeTaxRefund,
				lifeInsuranceMatures,
				hospitalFee,
				schoolFee,
				consultingFee,
				secondPrize,
				inheritance,
				doctorFee,
				stockSale
		};

		return CCDeck;
	}
	public static Deck ChanceDeck(){
		//TODO: return a Deck that holds the chance cards
		
		
		
		return new Deck();
	}
}
