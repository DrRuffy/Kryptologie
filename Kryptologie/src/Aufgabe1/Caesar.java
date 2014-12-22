package Aufgabe1;

import java.util.HashMap;
import Input.Text;

public class Caesar {

	private Text text = new Text();
	char[] alphabet = text.getAlphabet();

	// ------------------------------------------------------------------------
	/**
	 * Verschl�sselt mittels Caesarverschl�sselung
	 * 
	 * @param text
	 *            - Der zu verschl�sselnde Quelltext
	 * @param word
	 *            - Das Schl�sselwort
	 * @param letter
	 *            - Der Startbuchstabe
	 * @return Verschl�sselter Text als String
	 */
	public String encode(String text, String word, char letter) {
		HashMap<Character, Character> encodeMap = swapMap(generateEncodeMap(
				word, letter));
		String temp = "";
		for (char c : text.toCharArray()) {
			temp += Character.toString(encodeMap.get(c));
		}
		return temp;
	}

	// ------------------------------------------------------------------------
	/**
	 * Vertauscht die Key- und Valuewerte in einer HashMap
	 * 
	 * @param map
	 * @return HashMap mit vertauschten Key-Values
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
	 * Entschl�sselt mittels Caesarverschl�sselung
	 * 
	 * @param text
	 *            - Der zu entschl�sselnde Quelltext
	 * @param word
	 *            - Das Schl�sselwort
	 * @param letter
	 *            - Der Startbuchstabe
	 * @return Verschl�sselter Text als String
	 */
	public String decode(String text, String word, char letter) {
		String decode = "";
		HashMap<Character, Character> decodeMap = generateEncodeMap(word,
				letter);
		for (char c : text.toCharArray()) {
			decode += Character.toString(decodeMap.get(c));
		}
		System.out.println("decode: " + decode);
		return decode;
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
	 * generiert das Ver-/Entschl�sselungsalphabet
	 * 
	 * @param word
	 *            - Schl�sselwort
	 * @param letter
	 *            - Startbuchstabe
	 * @return HashMap zur Ent-/Verschl�sselung
	 */
	public HashMap<Character, Character> generateEncodeMap(String word,
			char letter) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		int startIndex = ((int) letter) - 65;
		int index = 0;
		word = text.deleteDuplicates(word);
		for (int i = 0; i < word.length(); i++) {
			map.put(word.charAt(i),
					alphabet[(i + startIndex) % alphabet.length]);
		}
		for (char c : alphabet) {
			if (!charInArray(c, word.toCharArray())) {
				map.put(c, alphabet[(index++ + startIndex + word.length())
						% alphabet.length]);
			}
		}
		return map;

	}

}
