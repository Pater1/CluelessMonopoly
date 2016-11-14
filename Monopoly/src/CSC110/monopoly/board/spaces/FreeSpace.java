package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.player.Player;

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

	@Override
	public String[] Render(Player[] plas) {
		// TODO Auto-generated method stub
		/*
		 ***********************
		 *North Carolina Avenue*
		 *     Rent: $2000     *
		 *    Upgrade: $150    *
		 *  Buy/Mortgage: $200 *
		 *   1,2,3,4,5,6,7,8   *
		 *   Owner: Thimble    *
		 ***********************
		 */
		return RenderAssistant.SpliceTile(new String[]{"FREE PARKING"});
	}
}
