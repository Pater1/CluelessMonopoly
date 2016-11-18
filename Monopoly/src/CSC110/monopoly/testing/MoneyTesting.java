package CSC110.monopoly.testing;

import CSC110.monopoly.money.*;
public class MoneyTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Money userMoney = new Money();
		System.out.println(userMoney.getCurrentMoney());
		userMoney.takePayerMoney(401);
		System.out.println(userMoney.getCurrentMoney());
		userMoney.givePlayerMoney(4455);
		System.out.println(userMoney.getCurrentMoney());
		System.out.println(userMoney.displayMoney());
		
	}

}
