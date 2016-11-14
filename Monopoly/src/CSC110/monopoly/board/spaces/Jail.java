package CSC110.monopoly.board.spaces;

import java.util.ArrayList;

import CSC110.monopoly.board.BoardSpace;
import CSC110.monopoly.board.RenderAssistant;
import CSC110.monopoly.testing.Player;

public class Jail implements BoardSpace{
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

	public static Jail _NewJail(){
		Jail jl = new Jail();
		jl.holding = false;
		jl.holdingDuration = 0;
		jl.jailed = null;
		return jl;
	}
	public static Jail _NewJail(int holdForTurns){
		Jail jl = new Jail();
		jl.holding = true;
		jl.holdingDuration = holdForTurns;
		jl.jailed = new ArrayList<Jailed>();
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
		if(holding){
			return RenderAssistant.SpliceTile(new String[]{"JAIL"});
		}else{
			return RenderAssistant.SpliceTile(new String[]{"GO TO JAIL"});
		}
	}
}
