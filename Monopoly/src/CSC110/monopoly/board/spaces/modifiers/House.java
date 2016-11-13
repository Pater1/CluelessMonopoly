package CSC110.monopoly.board.spaces.modifiers;

public class House implements Construction{
	private boolean isPurchased = false;
	private int newRent, purchasePrice;
	
	public void Purchase(){
		
	}
	
	public static House _NewHouse(int purchase, int rent){
		House hot = new House();
		hot.newRent = rent;
		hot.purchasePrice = purchase;
		hot.isPurchased = false;
		return hot;
	}
}
