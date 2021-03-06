package CSC110.monopoly.money;

import CSC110.monopoly.board.RenderAssistant;

public class Money {
	int fiveHundred = 2;
	int oneHundred = 2;
	int fifty = 2;
	int twenty = 6;
	int ten = 5;
	int five = 5;
	int one = 5;
	
	public static Money _NewMoney(){
		Money mny = new Money();
		mny.fiveHundred = 2;
		mny.oneHundred = 2;
		mny.fifty = 2;
		mny.twenty = 6;
		mny.ten = 5;
		mny.five = 5;
		mny.one = 5;
		return mny;
	}

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
		int money = (fiveHundred * 500) 
				+ (oneHundred * 100) 
				+ (fifty * 50) 
				+ (twenty * 20) 
				+ (ten * 10) 
				+ (five * 5)
				+ (one * 1);
		return money;
	}

	public void givePlayerMoney(int userMoney) {
		addChangeToBills(userMoney);
	}

	public String displayMoney() {

		String[] bill500 = RenderAssistant.SpliceTile(new String[] { "500", "" + fiveHundred });
		String[] bill100 = RenderAssistant.SpliceTile(new String[] { "100", "" + oneHundred });
		String[] bill50 = RenderAssistant.SpliceTile(new String[] { "50", "" + fifty });
		String[] bill20 = RenderAssistant.SpliceTile(new String[] { "20", "" + twenty });
		String[] bill10 = RenderAssistant.SpliceTile(new String[] { "10", "" + ten });
		String[] bill5 = RenderAssistant.SpliceTile(new String[] { "5", "" + five });
		String[] bill1 = RenderAssistant.SpliceTile(new String[] { "1", "" + one });
		return RenderAssistant.RenderArray(RenderAssistant.ConcantinateTiles(new String[][] {
			bill500, 
			bill100,
			bill50,
			bill20,
			bill10,
			bill5,
			bill1}));
	}
	public void takePlayerMoney(int userMoney) {
		checkBills(userMoney);
	}
	public void checkBills(int sub){
		while(sub >= 500 & fiveHundred > 0){
			sub -= 500;
			fiveHundred--;
		}
		while(sub >= 100 & oneHundred > 0){
			sub -= 100;
			oneHundred--;
			if(oneHundred <= 0 & fiveHundred > 0){
				oneHundred += 5;
				fiveHundred -= 1;
			}
		}
		while(sub >= 50 & fifty > 0){
			sub -= 50;
			fifty--;
			if(fifty <= 0 & oneHundred > 0 ){
				fifty += 2;
				oneHundred -= 0;
			}
		}
		while(sub >= 20 & twenty > 0){
			sub -= 20;
			twenty--;
			if(twenty <= 0 & fifty > 0){
				twenty += 2;
				ten += 1;
				fifty -= 1;
			}
		}
		while(sub >= 10 & ten > 0){
			sub -= 10;
			ten--;
			if (ten <= 0 & twenty > 0){
				ten += 2;
				twenty -= 1;
			}
		}
		while(sub >= 5 & five > 0){
			sub -= 5;
			five--;
			if (five <= 0 & ten > 0){
				five += 2;
				ten -= 1;
			}
		}
		while(sub >= 1 & one > 0){
			sub -= 1;
			one--;
			if (one <= 0 & five > 0){
				one += 5;
				five -=1;
			}
		}
	}

}
