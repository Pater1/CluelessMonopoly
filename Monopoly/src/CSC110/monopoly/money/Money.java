package CSC110.monopoly.money;

public class Money {
	int fiveHundred = 0;
	int oneHundred = 0;
	int fifty = 0;
	int twenty = 0;
	int ten = 0;
	int five = 0;
	int one = 0;
	public void makeChange(int money){
	int change = (int) (Math.ceil(money * 100));
	int fiveHundred = Math.round((int)change/500);
	change = change % 500;
	int oneHundred = Math.round((int)change/100);
	change = change % 100;
	int fifty = Math.round((int) change / 50);
	change = change % 50;
	int twenty = Math.round((int) change / 20);
	change = change % 20;
	int ten = Math.round((int) change / 10);
	change = change % 10;
	int five = Math.round((int) change / 5);
	change = change % 5;
	int one = Math.round((int) change / 1);
	}
	public int getMoney(){
		int money = (fiveHundred * 500) + (oneHundred * 100) + (fifty * 50) + (twenty * 20) + (ten * 10) + (five * 5) + (one * 1);
		return money;
	}
}
