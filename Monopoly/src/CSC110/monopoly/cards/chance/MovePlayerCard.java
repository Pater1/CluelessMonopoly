package CSC110.monopoly.cards.chance;

import CSC110.monopoly.cards.Card;
import CSC110.monopoly.player.Player;

import java.io.IOException;

import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.board.spaces.RailRoad;
import CSC110.monopoly.board.spaces.Utility;

public class MovePlayerCard extends Card{
	int locationToMoveTo = 0;
	GameBoard board;
	boolean doubleRent = false, nearestRail = false, nearestUtil = false, toJail = false, moveBy = false;

	public static MovePlayerCard _MakeNewMovePlayerCard(String spaceName, String discription, GameBoard monopolyGame){
		MovePlayerCard movePlayer = new MovePlayerCard();
		movePlayer.locationToMoveTo = monopolyGame.FindSpaceIndexByName(spaceName);
		movePlayer.board = monopolyGame;
		movePlayer.name = discription;
		return movePlayer;
	}
	public static MovePlayerCard _NewMoveToNearestRail(String discription, GameBoard monopolyGame, boolean payDouble){
		MovePlayerCard movePlayer = new MovePlayerCard();
		movePlayer.nearestRail = true;
		movePlayer.board = monopolyGame;
		movePlayer.name = discription;
		movePlayer.doubleRent = payDouble;
		return movePlayer;
	}
	public static MovePlayerCard _NewMoveToNearestUtil(String discription, GameBoard monopolyGame, boolean payDouble){
		MovePlayerCard movePlayer = new MovePlayerCard();
		movePlayer.nearestUtil = true;
		movePlayer.board = monopolyGame;
		movePlayer.name = discription;
		movePlayer.doubleRent = payDouble;
		return movePlayer;
	}
	public static MovePlayerCard _NewGoToJail(GameBoard monopolyGame){
		MovePlayerCard movePlayer = new MovePlayerCard();
		movePlayer.locationToMoveTo = monopolyGame.FindSpaceIndexByName("Jail");
		movePlayer.toJail = true;
		movePlayer.board = monopolyGame;
		movePlayer.name = "Go directly to Jail";
		return movePlayer;
	}
	public static MovePlayerCard _NewMoveByCard(int movePlayerBy, GameBoard monopolyGame){
		MovePlayerCard movePlayer = new MovePlayerCard();
		movePlayer.locationToMoveTo = movePlayerBy;
		movePlayer.moveBy = true;
		movePlayer.board = monopolyGame;
		movePlayer.name = "Go back " + movePlayerBy + " spaces.";
		return movePlayer;
	}

	public void playCard(Player owner) throws IOException {
		if(toJail){
			owner.setPlayerLocation(locationToMoveTo);
			return;
		}
		
		if(moveBy){
			owner.setPlayerLocation(owner.getCurrentPlayerLocation()+locationToMoveTo);
			return;
		}
		
		if(nearestRail) locationToMoveTo = NearestRail(owner);
		if(nearestUtil) locationToMoveTo = NearestUtil(owner);
		
		board.MovePlayerTo(owner,locationToMoveTo,doubleRent);
		if(doubleRent){
			RailRoad psp = (RailRoad) board.board[locationToMoveTo];
			if(psp.DoesOwn(owner) || !psp.isOwned()){
				board.board[locationToMoveTo].LandOnSpace(owner);
			}else{
				psp.PayDoubleRent(owner);
			}
		}else{
			board.board[locationToMoveTo].LandOnSpace(owner);
		}
	}
	
	private int NearestUtil(Player owner){
		int i = owner.getCurrentPlayerLocation();
		while(true){
			if(board.board[i] instanceof Utility){
				return i;
			}
			i = (i+1)%board.board.length;
		}
	}
	
	private int NearestRail(Player owner){
		int i = owner.getCurrentPlayerLocation();
		while(true){
			if(board.board[i] instanceof RailRoad){
				return i;
			}
			i++;
			i %= board.board.length;
		}
	}

	public String[] Render() {
		return RenderAssistant.SpliceTile(new String[]{
				name,
				"Move to: " + board.board[locationToMoveTo].GetName()
		});
	}
		
}
