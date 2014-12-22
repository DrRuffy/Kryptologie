package Aufgabe2;

public class Vigenere {

	public Vigenere() {

	}

	/**
	 * Verschlüsselt mittels Vigenere. Addiert den ascii Wert des
	 * Schlüssenwortbuchstaben auf den jeweiligen Buchstaben des zu
	 * verschlüsselden Textes.
	 * 
	 * @param Eingabetext
	 *            als char Array
	 * @param Schlüsseltext
	 *            als char Array
	 * @return Verschlüsseltertext als char Array
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
	 * Entschlüsselt mittels Vigenere.
	 * Subtrahiert den ascii Wert des
	 * Schlüssenwortbuchstaben von dem jeweiligen Buchstaben des zu
	 * entschlüsselden Textes.
	 * 
	 * @param Eingabetext
	 *            als char Array
	 * @param Schlüsseltext
	 *            als char Array
	 * @return Entschlüsseltertext als char Array
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
