package CSC110.monopoly.money;
import CSC110.monopoly.board.RenderAssistant;

public class Money {
	int money = 0;
	int fiveHundred = 2;
	int oneHundred = 2;
	int fifty = 2;
	int twenty = 6;
	int ten = 5;
	int five = 5;
	int one = 5;

	public void addChangeToBills(int money) {
		int change = (int) (Math.ceil(money * 1));
		fiveHundred += Math.round((int) change / 500);
		change = change % 500;
		oneHundred += Math.round((int) change / 100);
		change = change % 100;
		fifty += Math.round((int) change / 50);
		change = change % 50;
		twenty += Math.round((int) change / 20);
		change = change % 20;
		ten += Math.round((int) change / 10);
		change = change % 10;
		five += Math.round((int) change / 5);
		change = change % 5;
		one += Math.round((int) change / 1);
	}
	public void subChangeToBills(int money) {
		int change = (int) (Math.ceil(money * 1));
		fiveHundred -= Math.round((int) change / 500);
		change = change % 500;
		oneHundred -= Math.round((int) change / 100);
		change = change % 100;
		fifty -= Math.round((int) change / 50);
		change = change % 50;
		twenty -= Math.round((int) change / 20);
		change = change % 20;
		ten -= Math.round((int) change / 10);
		change = change % 10;
		five -= Math.round((int) change / 5);
		change = change % 5;
		one -= Math.round((int) change / 1);
	}

	public int getCurrentMoney() {
		money = (fiveHundred * 500) + (oneHundred * 100) + (fifty * 50) + (twenty * 20) + (ten * 10) + (five * 5)
				+ (one * 1);
		return money;
	}

	public int givePlayerMoney(int userMoney) {
		addChangeToBills(userMoney);
		money = getCurrentMoney();
		
		
		return money;
	}
	RenderAssistant displayMoney = new RenderAssistant();
	
	

	public int takePayerMoney(int userMoney) {
		subChangeToBills(userMoney);
		money = getCurrentMoney();
		return userMoney;
	}

}
