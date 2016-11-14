package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.testing.Player;

public class FreeSpace implements BoardSpace{
	private String spaceName;

	public void LandOnSpace(Player whoLanded) {
		return;
	}

	public void PassSpace(Player whoPassed) {
		return;
	}
	
	public static FreeSpace _NewFreeSpace(String name){
		FreeSpace fs = new FreeSpace();
		fs.spaceName = name;
		return fs;
	}
}
