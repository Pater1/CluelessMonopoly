package CSC110.monopoly.board;

import java.io.IOException;

import CSC110.monopoly.player.Player;

public abstract class BoardSpace{
	protected GameBoard board;
	protected String name;
	
	public abstract void LandOnSpace(Player whoLanded) throws IOException;
	public abstract void PassSpace(Player whoPassed);
	
	public abstract String[] Render(Player[] plas);
	public String GetName(){
		return name;
	}
}