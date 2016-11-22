package CSC110.monopoly.player;

import java.io.IOException;

import CSC110.monopoly.Driver.AskForInput;
import CSC110.monopoly.money.Money;

public class Piece implements Player{

	Money moneyUse = new Money();
	String rawInput;
	int locationalInt;
	
	public void GivePlayerMoney(int amountGiven) {
		moneyUse.givePlayerMoney(amountGiven);
		
	}

	public void TakePlayerMoney(int amountTaken) {
		moneyUse.takePayerMoney(amountTaken);
		
	}
	
	public String playerInit() throws IOException {
		return AskForInput.enumInput();					
	}
	
	public void getPlayerName(){
		
	}
	
	public int howMuchMonetaryOwned(){
		return moneyUse.getCurrentMoney();
	}
	
	public int getCurrentPlayerLocation(){
		locationalInt = 0;
		
		return locationalInt;
	}
	
	public int setPlayerLocation(){
		return locationalInt;
	}
}
