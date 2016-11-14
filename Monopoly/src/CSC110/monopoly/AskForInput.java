package CSC110.monopoly;

import java.io.IOException;

import CSC110.patpackages.imported.StandardUIInput;

public class AskForInput {
	//allows you to call this method and put in your own prompt for user input
	StandardUIInput Input = new StandardUIInput();
	public void Input (String[] options, boolean withQuit) throws IOException {
		StandardUIInput.promptForMenuSelection(options, withQuit);
		//steals your coffee
	}
}
