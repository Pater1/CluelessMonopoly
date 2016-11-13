package CSC110.monopoly.board.spaces.modifiers;

public class Hotel implements Construction{
	private boolean isPurchased = false;
	private int newRent, purchasePrice;
	
	public void Purchase(){
		
	}
	
	public static Hotel _NewHotel(int rent, int purchase){
		Hotel hot = new Hotel();
		hot.newRent = rent;
		hot.purchasePrice = purchase;
		hot.isPurchased = false;
		return hot;
	}
}
