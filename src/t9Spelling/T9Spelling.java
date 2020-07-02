package t9Spelling;

import java.util.HashMap;

/**
 * Translates a list of sentences into a sequence of key presses.
 * 
 * Each sentence may only contain characters a-z, and spaces.
 * 
 * @author Mathew Fitzerald
 *
 */
public class T9Spelling {

	public static void main(String[] args) {
		
		int sentences = 0;
		String sentence;
		String numberSequence;
		HashMap<Character, String> latinToNumber = new HashMap<>();
		
		latinToNumber.put('a', "2");
		latinToNumber.put('b', "22");
		latinToNumber.put('c', "222");
		latinToNumber.put('d', "3");
		latinToNumber.put('e', "33");
		latinToNumber.put('f', "333");
		latinToNumber.put('g', "4");
		latinToNumber.put('h', "44");
		latinToNumber.put('i', "444");
		latinToNumber.put('j', "5");
		latinToNumber.put('k', "55");
		latinToNumber.put('l', "555");
		latinToNumber.put('m', "6");
		latinToNumber.put('n', "66");
		latinToNumber.put('o', "666");
		latinToNumber.put('p', "7");
		latinToNumber.put('q', "77");
		latinToNumber.put('r', "777");
		latinToNumber.put('s', "7777");
		latinToNumber.put('t', "8");
		latinToNumber.put('u', "88");
		latinToNumber.put('v', "888");
		latinToNumber.put('w', "9");
		latinToNumber.put('x', "99");
		latinToNumber.put('y', "999");
		latinToNumber.put('z', "9999");
		latinToNumber.put(' ', "0");
		
		if (args.length == 0) {
			System.out.println("Program exited: Number of arguments was invalid.");
			System.exit(1);
		}
		
		try {
			sentences = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("Program exited: Number of sentences was invalid.");
			e.printStackTrace();
			System.exit(1);
		}
		
		if (sentences != args.length - 1) {
			System.out.println("Program exited: Number of sentences was not consistent with the number of arguments.");
			System.exit(1);
		}
		
		for (int arg = 1; arg <= Integer.parseInt(args[0]); arg++) {
			sentence = args[arg];
			numberSequence = "";
			for (int character = 0; character < sentence.length(); character++) {
				// If there is another character in front of this one
				if (character < sentence.length() - 1) {
					// If the character in front is the same character as this one
					if (latinToNumber.get(sentence.charAt(character)).charAt(0) == (latinToNumber.get(sentence.charAt(character + 1)).charAt(0))) {
						numberSequence += latinToNumber.get(sentence.charAt(character));
						numberSequence += " ";
					} else {
						numberSequence += latinToNumber.get(sentence.charAt(character));
					}
				} else {
					numberSequence += latinToNumber.get(sentence.charAt(character));
				}
			}
			System.out.println("Case #" + Integer.toString(arg) + ": " + numberSequence);
		}
	}
}
