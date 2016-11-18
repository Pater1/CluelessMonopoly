package CSC110.monopoly.player;

import java.io.IOException;

import CSC110.monopoly.Driver.AskForInput;
import CSC110.monopoly.money.Money;

public class Piece implements Player{

	Money moneyUse = new Money();
	String rawInput;
	
	public void GivePlayerMoney(int amountGiven) {
		moneyUse.givePlayerMoney(amountGiven);
		
	}

	public void TakePlayerMoney(int amountTaken) {
		moneyUse.takePayerMoney(amountTaken);
		
	}
	
	public String playerInit() throws IOException {
		boolean isValidInput = false;
		while(isValidInput){
			for(int i=0;i<AskForInput.numOfPlayers();i++){
				rawInput = AskForInput.enumInput();
				if(rawInput.equals("")){
				}else if(rawInput.equals("")){
				}else{
					
				}
			}
		}
		return rawInput;
	}
	
	public int howMuchMonetaryOwned(){
		return moneyUse.getCurrentMoney();
	}
	
	public void wherePlayerIs(){
		
	}
}
