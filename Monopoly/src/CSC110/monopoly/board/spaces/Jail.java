package CSC110.monopoly.board.spaces;

import java.util.ArrayList;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.GameBoard;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.player.Player;

public class Jail extends BoardSpace{
	private int holdingDuration;
	private boolean holding;
	private ArrayList<Jailed> jailed;
	
	public void LandOnSpace(Player whoLanded) {
		if(!holding){
			//TODO: set whoLanded to jailed
			//TODO: move whoLanded to holding Jail Space
			jailed.add(Jailed._NewJailed(whoLanded, holdingDuration));
		}
	}

	public void PassSpace(Player whoPassed) {
		return;
	}

	public static Jail _NewJail(GameBoard brd){
		Jail jl = new Jail();
		jl.holding = false;
		jl.holdingDuration = 0;
		jl.jailed = null;
		jl.name = "Go To Jail";
		jl.board = brd;
		return jl;
	}
	public static Jail _NewJail(int holdForTurns, GameBoard brd){
		Jail jl = new Jail();
		jl.holding = true;
		jl.holdingDuration = holdForTurns;
		jl.jailed = new ArrayList<Jailed>();
		jl.name = "Jail";
		jl.board = brd;
		return jl;
	}
	
	private static class Jailed{
		public Player jailedPlayer;
		public int turnsInJail;
		
		public static Jailed _NewJailed(Player toJail, int forTurns){
			Jailed jl = new Jailed();
			jl.jailedPlayer = toJail;
			jl.turnsInJail = forTurns;
			return jl;
		}
	}

	@Override
	public String[] Render(Player[] plas) {
		return RenderAssistant.SpliceTile(new String[]{
				name,
				"",
				RenderAssistant.FitPlayerName(plas)
		});
	}

	public String GetName() {
		return name;
	}
}
