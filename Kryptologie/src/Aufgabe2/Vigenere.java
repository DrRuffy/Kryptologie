package Aufgabe2;

public class Vigenere {

	public Vigenere() {

	}

	/**
	 * Verschl�sselt mittels Vigenere. Addiert den ascii Wert des
	 * Schl�ssenwortbuchstaben auf den jeweiligen Buchstaben des zu
	 * verschl�sselden Textes.
	 * 
	 * @param Eingabetext
	 *            als char Array
	 * @param Schl�sseltext
	 *            als char Array
	 * @return Verschl�sseltertext als char Array
	 */
	public String versch(char[] input, char[] key) {
		char[] out = new char[input.length];
		for (int x = 0; x < input.length; x++) {
			int ascii = (input[x] + key[x % key.length]) % 26 + 65;
			out[x] = (char) ascii;
		}

		return String.valueOf(out);
	}

	/**
	 * Entschl�sselt mittels Vigenere.
	 * Subtrahiert den ascii Wert des
	 * Schl�ssenwortbuchstaben von dem jeweiligen Buchstaben des zu
	 * entschl�sselden Textes.
	 * 
	 * @param Eingabetext
	 *            als char Array
	 * @param Schl�sseltext
	 *            als char Array
	 * @return Entschl�sseltertext als char Array
	 */
	public String entsch(char[] input, char[] key) {

		char[] out = new char[input.length];
		for (int i = 0; i < input.length; i++) {
			int ascii = (input[i] - key[i % key.length]) % 26 + 65;

			ascii = ascii < 65 ? ascii + 26 : ascii + 0; // Wenn ascii wert < 65
															// addiere 26
			out[i] = (char) (ascii);
		}
		return String.valueOf(out);
	}

}
