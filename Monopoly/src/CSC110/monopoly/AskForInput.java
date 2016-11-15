package CSC110.monopoly;

import java.io.IOException;

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
				System.out.println("Oops, keep the prompt under a max of 26");
				System.exit(0);
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
	public static String enumInput(String prompt) throws IOException {
		return StandardUIInput.promptForInput(prompt, false);
		
	}
}
