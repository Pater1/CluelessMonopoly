package CSC110.monopoly.Input;

import java.io.IOException;
import java.util.ArrayList;

import CSC110.monopoly.player.PieceName;
import CSC110.patpackages.imported.StandardUIInput;

public class AskForInput {
	// allows you to call this method and put in your own prompt for user input
	// use this format to use the method where you can change each string.
	// AskForInput.Input(new String[] {"1-hi","2-hey", "3-hello","4-sup","5-wassup" });
	StandardUIInput Input = new StandardUIInput();

	public static int Input(String[] options) throws IOException {
		char a = (char) 96;
		for (int i = 0; i < options.length; i++) {
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
		// hyphen after char when asking for input
	}

	public static PieceName _EnumInput(ArrayList<PieceName> piecesTaken) throws IOException {
		PieceName allPieces[] = PieceName.values();
		ArrayList<PieceName> piecesAvailiable = new ArrayList<PieceName>();
		ArrayList<String> selections = new ArrayList<String>();
		for(int i = 0; i < allPieces.length; i++) {
			if(!piecesTaken.contains(allPieces[i])){
				piecesAvailiable.add(allPieces[i]);
				selections.add(allPieces[i].name());
			}
		}
		
		String[] strs = new String[selections.size()];
		for(int i = 0; i < strs.length; i++){
			strs[i] = selections.get(i);
		}

		int selection = Input(strs);
		return piecesAvailiable.get(selection);
	}

	public static boolean boolInput(String prompt, String trueString, String falseString) throws IOException {
		return StandardUIInput.promptForBool(prompt, trueString, falseString);
	}

	public static int numOfPlayers() throws IOException {
		return StandardUIInput.promptForInt("How many players are there?", 1, 8);
	}
	public static int AskInt(String prompt) throws IOException {
		return StandardUIInput.promptForInt(prompt, 0, Integer.MAX_VALUE);
	}
}
