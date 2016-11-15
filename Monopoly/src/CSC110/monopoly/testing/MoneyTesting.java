package CSC110.monopoly.testing;

import CSC110.monopoly.money.*;
public class MoneyTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Money userMoney = new Money();
		userMoney.initStartMoney();
		System.out.println(userMoney.getCurrentMoney());
		userMoney.givePlayerMoney(1234);
		System.out.println(userMoney.getCurrentMoney());
		userMoney.takePayerMoney(1234);
		System.out.println(userMoney.getCurrentMoney());
		
	}

}
