package CSC110.monopoly.board.spaces;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.player.Player;

public class Go extends BoardSpace {
	private int cashGo = 20;
	
	public static Go _NewGo(int passCash, GameBoard brd){
		Go g = new Go();
		g.cashGo = passCash;
		g.name = "Go";
		g.board = brd;
		return g;
	}

	public void LandOnSpace(Player whoLanded) {
		return;
	}

	public void PassSpace(Player whoPassed) {
		whoPassed.GivePlayerMoney(cashGo);
	}

	@Override
	public String[] Render(Player[] plas) {
		// TODO Auto-generated method stub
		return RenderAssistant.SpliceTile(new String[]{
				"GO",
				"",
				"--->",
				"",
				RenderAssistant.FitPlayerName(plas)
			});
	}

	public String GetName() {
		return name;
	}

}
