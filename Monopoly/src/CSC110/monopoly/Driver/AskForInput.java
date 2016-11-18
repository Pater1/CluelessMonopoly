package CSC110.monopoly.Driver;

import java.io.IOException;

import CSC110.monopoly.player.PieceName;
import CSC110.patpackages.imported.StandardUIInput;

public class AskForInput {
	// allows you to call this method and put in your own prompt for user input
	// use this format to use the method where you can change each string.         AskForInput.Input(new String[] {"hi","hey", "hello","sup","wassup" });
	StandardUIInput Input = new StandardUIInput();

	public static int Input (String[] options) throws IOException {
		
		char a = (char) 96;
		for (int i=0;i<options.length;i++) {
			int charAsInt = (int) a;
			if (charAsInt > 122) {
				throw new IOException("Keep your number of prompts under 26");
			}
			charAsInt++;
			char intAsChar = (char) charAsInt;
			a = intAsChar;
			String charAsString = "" + intAsChar;
			options[i] = charAsString + "-" + options[i];
			
		}
		return StandardUIInput.promptForMenuSelection(options, false);
		//hyphen after char when asking for input
	}
	public static String enumInput() throws IOException {
		String userInput = StandardUIInput.promptForInput("What piece would you like to be? Thimble, Wheelbarrow, Shoe, Canine, Automobile, Iron, Navalship, or Tophat" , false);
		return userInput;
	}
	public static boolean boolInput (String prompt, String trueString, String falseString) throws IOException {
		return StandardUIInput.promptForBool(prompt, trueString, falseString);
	}
	public static int numOfPlayers () throws IOException {
		return StandardUIInput.promptForInt("How many players are there?",1,8);
	}
}
