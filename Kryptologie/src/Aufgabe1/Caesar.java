package Aufgabe1;

import java.util.HashMap;
import Input.Text;

public class Caesar {

	private Text text = new Text();
	char[] alphabet = text.getAlphabet();

	private char letter;
	private char[] word;
	HashMap<Character, Character> encodeMap = new HashMap<Character, Character>();

	// ------------------------------------------------------------------------
	/**
	 * über die kosole werden schlüsselwort, startbuchstabe und der zu
	 * verschlüsselnde text eingegeben und anschließend verschlüsselt
	 * 
	 * @return Verschlüsselter Text als Characterarray
	 */
	public char[] encode() {
		getKeyword();
		getKeyLetter();
		generateEncodeMap();
		System.out.println("Geben Sie den zu verschlüsselnden Text ein:");
		String temp = "";

		for (char c : text.getText().toCharArray()) {
			temp += Character.toString(encodeMap.get(c));
		}
		System.out.println("encode: " + temp);
		return temp.toCharArray();
	}

	// ------------------------------------------------------------------------
	/**
	 * vertauscht ind einer hashmap die keys mit ihren jeweiligen values
	 * 
	 * @param map
	 *            in der die key und values vertauscht werden sollen
	 * @return Map mit dn vertauschten Key-Values
	 */
	public HashMap<Character, Character> swapMap(
			HashMap<Character, Character> map) {
		
		HashMap<Character, Character> neu = new HashMap<Character, Character>();
		
		for (int i = 0; i < map.size(); i++) {
			
			neu.put(map.get(alphabet[i]), alphabet[i]);
		}
		return neu;
	}

	// ------------------------------------------------------------------------
	/**
	 * entschlüsselt den zuvor verschlüsselten Text
	 * 
	 * @param encode
	 *            der zu entschlüsselnde text als Characterarray
	 * @return der entschlüsselte Text
	 */
	public char[] decode(char[] encode) {
		String decode = "";
		HashMap<Character, Character> decodeMap = swapMap(encodeMap);
		for (char c : encode) {
			decode += Character.toString(decodeMap.get(c));
		}
		System.out.println("decode: " + decode);
		return decode.toCharArray();
	}

	// ------------------------------------------------------------------------
	/**
	 * fordert eine eingabe des schlüsselworts über die system.in ein
	 */
	public void getKeyword() {
		System.out.print("Bitte geben Sie das Schlüsselwort ein: ");
		word = text.deleteDuplicates(text.getText()).toCharArray();
		String temp = "";
		for (char c : word) {
			temp += Character.toString(c);
		}
		System.out.println("Schlüsselwort: " + temp);
	}

	// ------------------------------------------------------------------------
	/**
	 * fordert den schlüsselbuchstaben über die system.in ein
	 */
	public void getKeyLetter() {
		System.out.print("Geben Sie nun den Schlüsselbuchstaben ein: ");
		String keyLetter = text.getText();

		letter = keyLetter.charAt(0);

	}

	// ------------------------------------------------------------------------
	/**
	 * holt sich aus dem alphabets den index des zuvor eingegebenen
	 * schlüsselbuchstabens
	 * 
	 * @return den index des gewählten buchstabens im array
	 */
	public int getAlphabetKeyLetterIndex() {
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] == letter) {
				return i;
			}
		}
		return -1;
	}

	// ------------------------------------------------------------------------
	/**
	 * konrtolliert, ob ein character c in einem Characterarray comp vorkommt
	 * 
	 * @param c
	 * @param comp
	 * @return true wenn der Character im array vorkommt. ansonsten false
	 */
	public boolean charInArray(char c, char[] comp) {

		for (char temp : comp) {
			if (temp == c) {
				return true;
			}
		}
		return false;
	}

	// ------------------------------------------------------------------------
	/**
	 * generiert mithilfe des schlüsselwortes, des schlüsselbuchstabens und des
	 * alphabets die zeichentabelle
	 */
	public void generateEncodeMap() {

		int startIndex = getAlphabetKeyLetterIndex();
		int index = 0;

		for (int i = 0; i < word.length; i++) {
			encodeMap
					.put(word[i], alphabet[(i + startIndex) % alphabet.length]);
		}
		for (char c : alphabet) {
			if (!charInArray(c, word)) {
				encodeMap.put(c, alphabet[(index++ + startIndex + word.length)
						% alphabet.length]);
			}
		}
		encodeMap = swapMap(encodeMap);

	}
}
