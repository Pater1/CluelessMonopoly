package CSC110.monopoly.cards.chance;

import CSC110.monopoly.cards.Card;
import CSC110.monopoly.player.Player;
import CSC110.monopoly.board.GameBoard;

public class MovePlayerCard implements Card{
	String name = "";
	int locationToMoveTo = 0;
	
	
	public static MovePlayerCard makeNewMovePlayerCard(String spaceName, String discription, GameBoard monopolyGame){
		MovePlayerCard movePlayer = new MovePlayerCard();
		movePlayer.locationToMoveTo = monopolyGame.FindSpaceIndexByName(spaceName); 
		movePlayer.name = discription;
		return movePlayer;
		
	}

	public void playCard(Player owner) {
		
	}
		
}
