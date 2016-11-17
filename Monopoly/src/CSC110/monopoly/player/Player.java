package CSC110.monopoly.player;

import java.io.IOException;

public interface Player {
	
	public void GivePlayerMoney(int amountGiven);
	
	public void TakePlayerMoney(int amountTaken);
	
	public String playerInit() throws IOException;
	
}
