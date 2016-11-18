package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.player.Player;

public class FreeSpace extends BoardSpace{
	public void LandOnSpace(Player whoLanded) {
		return;
	}

	public void PassSpace(Player whoPassed) {
		return;
	}
	
	public static FreeSpace _NewFreeSpace(String name){
		FreeSpace fs = new FreeSpace();
		fs.name = name;
		return fs;
	}

	public String[] Render(Player[] plas) {
		return RenderAssistant.SpliceTile(new String[]{
				"FREE PARKING",
				"",
				RenderAssistant.FitPlayerName(plas)});
	}
}
