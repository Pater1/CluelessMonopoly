package CSC110.monopoly.money;

public class Money {
	int money = 1251;
	int fiveHundred = 0;
	int oneHundred = 0;
	int fifty = 0;
	int twenty = 0;
	int ten = 0;
	int five = 0;
	int one = 0;

	int change = (int) (Math.ceil(money * 100));
	int dollars = Math.round((int)change/100);change=(change%100);
	int quarters = Math.round((int) change / 25);change=change%25;
	int dimes = Math.round((int) change / 10);change=change%10;
	int nickels = Math.round((int) change / 5);change=change%5;
	int pennies = Math.round((int) change / 1);

}}
