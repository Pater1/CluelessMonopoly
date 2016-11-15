package CSC110.monopoly.player;

public interface Player {
	
	public void GivePlayerMoney(int amountGiven);
	
	public void TakePlayerMoney(int amountTaken);
	
	public String Identifier(String playerPiece);
	
}
