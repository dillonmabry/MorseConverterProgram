/**
 * Dillon Mabry Student ID: 800854402
 */
public class Code {

	/**
	 * Method to convert English to Morse code
	 * @param input the string to convert
	 * @return the converted string
	 */
	protected static String toMorse(String input) {
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < Morse.englishList.size(); j++) {
				if (input.toUpperCase().charAt(i) == Morse.englishList.get(j).charAt(0)) {
					output += Morse.morseList.get(j);
				} else if (input.toUpperCase().charAt(i) == ' ') {
					output += ' ';
					break;
				}
			}
		}
		return output;
	}
	
	/**
	 * Method to convert Morse code to English
	 * @param input the string to convert
	 * @return the converted string
	 */
	protected static String toEnglish(String input) {
		String[] tokens = input.split(" ");
		String output = "";
		for (int i = 0; i < tokens.length; i++) {
			for (int j = 0; j < Morse.morseList.size(); j++) {
				if (tokens[i].equals(Morse.morseList.get(j))) {
					output += Morse.englishList.get(j);
				} else if (tokens[i].toUpperCase().equals("S")) {
					output += " ";
					break;
				}
			}
		}
		return output;
	}

}
