package CSC110.patpackages.imported;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class StandardUIInput {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Generates a console-based menu using the Strings in options as the menu
	 * items. Reserves the number 0 for the "quit" option when withQuit is true.
	 * 
	 * @param options
	 *            - Strings representing the menu options
	 * @param withQuit
	 *            - adds option 0 for "quit" when true
	 * @return the int of the selection made by the user
	 * @throws IOException
	 */
	public static int promptForMenuSelection(String[] options, boolean withQuit) throws IOException {
		if (options == null || (!withQuit && options.length <= 0)) {
			throw new IllegalArgumentException("Need options for user to select from...");
		}

		ArrayList<String> inputs = new ArrayList<String>();

		if (withQuit) {
			System.out.println("Input '0' to exit the application.");
			inputs.add("0");
		}

		for (String str : options) {
			String tmp = "";
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != '-') {
					tmp = tmp + str.charAt(i);
				} else {
					break;
				}
			}

			if (tmp.equals(str)) {
				System.out.println("Developer Error on line " + Arrays.asList(options).indexOf(str) + "!");
				System.out.println("Please format prompts with a '-' after the expected input. Like the following:");
				System.out.println("[UserInputString]-[UserPrompt]");
				return -1;
			} else {
				if (tmp.equals("0") && withQuit) {
					System.out.println("Developer Error on line " + Arrays.asList(options).indexOf(str) + "!");
					System.out.println("'0' is reserved for exitting the applicaion!");
					return -1;
				} else {
					System.out.println(str);
					inputs.add(tmp);
				}
			}
		}

		do {
			String userIn = promptForInput("Please input your selection.", false);
			if (inputs.contains(userIn)) {
				if (userIn.equals("0")) {
					System.exit(0);
				} else {
					return inputs.indexOf(userIn);
				}
			} else {
				System.out.println(userIn + " is not a valid option! Please try again...");
			}
		} while (true);
	}

	/**
	 * Generates a prompt that expects the user to enter one of two responses
	 * that will equate to a boolean value. The trueString represents the case
	 * insensitive response that will equate to true. The falseString acts
	 * similarly, but for a false boolean value. Example: Assume this method is
	 * called with a trueString argument of "yes" and a falseString argument of
	 * "no". If the enters "YES", the method returns true. If the user enters
	 * "no", the method returns false. All other inputs are considered invalid,
	 * the user will be informed, and the prompt will repeat.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param trueString
	 *            - the case insensitive value that will evaluate to true
	 * @param falseString
	 *            - the case insensitive value that will evaluate to false
	 * @return the boolean value
	 * @throws IOException
	 */
	public static boolean promptForBool(String prompt, String trueString, String falseString) throws IOException {
		if (prompt == null) {
			throw new IllegalArgumentException(
					"Please supply a user prompt. No null values (empty strings oaky though)!");
		} else if (trueString == null || falseString == null) {
			throw new IllegalArgumentException("Need options for user to select from...");
		}

		do {
			String userIn = promptForInput(prompt + "[" + trueString + " or " + falseString + "]", false);

			if (userIn.equals(falseString)) {
				return false;
			} else if (userIn.equals(trueString)) {
				return true;
			} else {
				System.out.println("Invalid input. Try '" + trueString + "' or '" + falseString + "'");
			}
		} while (true);
	}

	/**
	 * Generates a prompt that expects a numeric input representing a byte
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the byte value
	 * @throws IOException
	 */
	public static byte promptForByte(String prompt, byte min, byte max) throws IOException {
		return (byte) promptForLong(prompt, min, max);
	}

	/**
	 * Generates a prompt that expects a numeric input representing a short
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the short value
	 * @throws IOException
	 */
	public static short promptForShort(String prompt, short min, short max) throws IOException {
		return (short) promptForLong(prompt, min, max);
	}

	/**
	 * Generates a prompt that expects a numeric input representing an int
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the int value
	 * @throws IOException
	 */
	public static int promptForInt(String prompt, int min, int max) throws IOException {
		return (int) promptForLong(prompt, min, max);
	}

	/**
	 * Generates a prompt that expects a numeric input representing a long
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the long value
	 * @throws IOException
	 */
	public static long promptForLong(String prompt, long min, long max) throws IOException {
		do {
			boolean valid = true;
			String userIn = promptForInput(prompt, false);

			long output = 0;
			try {
				output = Long.parseLong(userIn);
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid input. Please input a number with no edcima places");
			}

			if (output >= min && output <= max) {
				return output;
			} else {
				System.out.println("Number out of range. Please try between " + min + " and " + max);
			}
		} while (true);
	}

	/**
	 * Generates a prompt that expects a numeric input representing a float
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the float value
	 * @throws IOException
	 */
	public static float promptForFloat(String prompt, float min, float max) throws IOException {
		return (float) promptForDouble(prompt, min, max);
	}

	/**
	 * Generates a prompt that expects a numeric input representing a double
	 * value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the double value
	 * @throws IOException
	 */
	public static double promptForDouble(String prompt, double min, double max) throws IOException {
		do {
			boolean valid = true;
			String userIn = promptForInput(prompt, false);

			double output = 0;
			try {
				output = Double.parseDouble(userIn);
			} catch (NumberFormatException nfe) {
				System.out.println("Invalid input. Please input a number...");
			}

			if (output >= min && output <= max) {
				return output;
			} else {
				System.out.println("Number out of range. Please try between " + min + " and " + max);
			}
		} while (true);
	}

	/**
	 * Generates a prompt that allows the user to enter any response and returns
	 * the String. When allowEmpty is true, empty responses are valid. When
	 * false, responses must contain at least one character (including
	 * whitespace).
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user.
	 * @param allowEmpty
	 *            - when true, makes empty responses valid
	 * @return the input from the user as a String
	 * @throws IOException
	 */
	public static String promptForInput(String prompt, boolean allowEmpty) throws IOException {
		if (prompt == null) {
			throw new IllegalArgumentException(
					"Please supply a user prompt. No null values (empty strings okay though)!");
		}
		String userIn;
		do {
			System.out.println(prompt);
			userIn = "";
			try {
				userIn = input.readLine();
			} catch (IOException ioe) {
				ioe.printStackTrace();
				ioe = new IOException("Error IOException! Can't read user input!");
				throw ioe;
			}
			if (userIn.length() > 0 || allowEmpty) {
				return userIn;
			} else {
				System.out.println("Sorry, invalid input. Please try again...");
			}
		} while (true);
	}

	/**
	 * Generates a prompt that expects a single character input representing a
	 * char value. This method loops until valid input is given.
	 * 
	 * @param prompt
	 *            - the prompt to be displayed to the user
	 * @param min
	 *            - the inclusive minimum boundary
	 * @param max
	 *            - the inclusive maximum boundary
	 * @return the char value
	 * @throws IOException
	 */
	public static char promptForChar(String prompt, char min, char max) throws IOException {
		do {
			String userIn = promptForInput(prompt, false);
			if (userIn.length() > 1) {
				System.out.println("One character [letter, single-digit number, or symbol] only please.");
			} else {
				char output = userIn.charAt(0);
				if (output >= min && output <= max) {
					return output;
				} else {
					System.out.println("Character out of scope! Try one between " + min + " and " + max + ".");
				}
			}
		} while (true);
	}
}