package CSC110.monopoly.player;

import CSC110.monopoly.money.Money;

public class Piece implements Player{

	Money moneyUse = new Money();
	
	//PieceName pieceName;
	
	@Override
	public void GivePlayerMoney(int amountGiven) {
		moneyUse.givePlayerMoney(amountGiven);
		
	}

	@Override
	public void TakePlayerMoney(int amountTaken) {
		moneyUse.takePayerMoney(amountTaken);
		
	}
	@Override
	public String Identifier(String playerPiece) {
		return playerPiece;
	}
}
