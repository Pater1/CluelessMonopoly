package CSC110.monopoly.Driver;

import java.util.Random;

public class DiceRoller {
	public static int diceRoll () {
		Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(6);
		 int trueRandomInt = randomInt + 1;
		return trueRandomInt;
	}
}
