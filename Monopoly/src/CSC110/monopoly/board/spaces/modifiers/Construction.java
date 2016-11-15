package CSC110.monopoly.board.spaces.modifiers;

public interface Construction {
	public void Purchase();
	public void Sell();
	public boolean IsPurchased();
	public int GetRent();
}
