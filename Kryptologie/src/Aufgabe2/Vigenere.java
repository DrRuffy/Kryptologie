package Aufgabe2;

public class Vigenere {

	public Vigenere() {

	}

	/**
	 * Verschlüsselt mittels Vigenere
	 * 
	 * @param Eingabetext
	 *            als char Array
	 * @param Schlüsseltext
	 *            als char Array
	 * @return Verschlüsseltertext als char Array
	 */
	public char[] swap(char[] input, char[] key) {
		char[] out = new char[input.length];
		for (int x = 0; x < input.length; x++) {
			int ascii = (input[x] + key[x % key.length]) % 26 + 65;
			out[x] = (char) ascii;
		}

		return out;
	}

	/**
	 * Entschlüsselt mittels Vigenere
	 * 
	 * @param Eingabetext
	 *            als char Array
	 * @param Schlüsseltext
	 *            als char Array
	 * @return Entschlüsseltertext als char Array
	 */
	public char[] entsch(char[] input, char[] key) {

		char[] out = new char[input.length];
		for (int i = 0; i < input.length; i++) {
			int ascii = (input[i] - key[i % key.length]) % 26 + 65;

			ascii = ascii < 65 ? ascii + 26 : ascii + 0; // Wenn ascii wert < 65
															// addiere 26
			out[i] = (char) (ascii);
		}
		return out;
	}

}
