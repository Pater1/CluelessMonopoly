package CSC110.monopoly.board;

import CSC110.monopoly.player.Player;

public interface BoardSpace {
	public void LandOnSpace(Player whoLanded);
	public void PassSpace(Player whoPassed);
	
	public String[] Render(Player[] plas);
}