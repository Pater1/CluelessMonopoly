package CSC110.monopoly.player;

import java.io.IOException;

public class Piece implements Player{

	PieceName pieceName;
	
	@Override
	public void GivePlayerMoney(int amountGiven) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void TakePlayerMoney(int amountTaken) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String Identifier(String playerPiece) {
		return playerPiece;
	}
	
	public static Piece choosePlayerPiece(String pieceName) throws IOException{
		Piece playerPiece = new Piece();
		
		return playerPiece;
	}
}
