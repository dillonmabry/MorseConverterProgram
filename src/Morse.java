
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Morse {
	
	protected static ArrayList<String> morseList = new ArrayList<>(); /* Parallel lists for storage */
	protected static ArrayList<String> englishList = new ArrayList<>();

	/**
	 * Main method
	 * 
	 * @param args
	 *            unused
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		readFile();
		while (true) {
			String select = JOptionPane.showInputDialog("Press 0 to convert from English to Morse.\n "
					+ "Press 1 to convert from Morse to English.\n Press 2 to exit program.");
			JFrame frame = new JFrame();
			if (select == null) {
				System.out.println("Exited Program.");
				System.exit(0);
			}
			try {
				switch (Integer.parseInt(select)) {
				case 0:
					String engInput = JOptionPane
							.showInputDialog("Please enter a word or sentence without punctuation: ");
					if ((engInput.startsWith(".") || engInput.startsWith("-"))) {
						JOptionPane.showMessageDialog(frame,
								"Please enter English not Morse code!\n Returning to menu....");
						System.out.println("Please enter English not Morse code!\n Returning to menu....");
						break;
					}
					System.out.println(Code.toMorse(engInput));
					System.out.println();
					JOptionPane.showMessageDialog(frame, Code.toMorse(engInput));
					break;
				case 1:
					String morseInput = JOptionPane
							.showInputDialog("Please enter morse code delimited by spaces for each letter\n"
									+ "If entering spaces type 's' for space");
					if (!(morseInput.startsWith(".") || morseInput.startsWith("-")
							|| morseInput.toUpperCase().startsWith("S"))) {
						JOptionPane.showMessageDialog(frame,
								"Please enter Morse code not English!\n Returning to menu....");
						System.out.println("Please enter morse code not English!\n Returning to menu....");
						break;
					}
					System.out.println(Code.toEnglish(morseInput));
					System.out.println();
					JOptionPane.showMessageDialog(frame, Code.toEnglish(morseInput));
					break;
				case 2:
					System.out.println("Exited Program.");
					System.exit(0);
				}
			} catch (NumberFormatException e) {
				System.out.println("Input error! Please select options 0-2!");
				continue;
			}
		}
	}

	/**
	 * Method to read in morse.txt file to add morse code and english letters to
	 * ArrayLists
	 * 
	 * @throws FileNotFoundException
	 *             if file is not found
	 */
	private static void readFile() throws FileNotFoundException {
		File file = new File("morse.txt");  /* read file morse.txt to import conversion */
		Scanner reader = new Scanner(file);
		int i = 1;
		while (reader.hasNext()) {
			if (i++ % 2 == 1) {        /* make sure every other line is english word, morse, etc. */
				englishList.add(reader.next());
			} else {				/* add each value to the lists */
				morseList.add(reader.next());
			}
		}
		reader.close();
	}

}
