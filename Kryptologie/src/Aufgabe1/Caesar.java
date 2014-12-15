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
	 * �ber die kosole werden schl�sselwort, startbuchstabe und der zu
	 * verschl�sselnde text eingegeben und anschlie�end verschl�sselt
	 * 
	 * @return Verschl�sselter Text als Characterarray
	 */
	public char[] encode() {
		getKeyword();
		getKeyLetter();
		generateEncodeMap();
		System.out.println("Geben Sie den zu verschl�sselnden Text ein:");
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
	 * entschl�sselt den zuvor verschl�sselten Text
	 * 
	 * @param encode
	 *            der zu entschl�sselnde text als Characterarray
	 * @return der entschl�sselte Text
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
	 * fordert eine eingabe des schl�sselworts �ber die system.in ein
	 */
	public void getKeyword() {
		System.out.print("Bitte geben Sie das Schl�sselwort ein: ");
		word = text.deleteDuplicates(text.getText()).toCharArray();
		String temp = "";
		for (char c : word) {
			temp += Character.toString(c);
		}
		System.out.println("Schl�sselwort: " + temp);
	}

	// ------------------------------------------------------------------------
	/**
	 * fordert den schl�sselbuchstaben �ber die system.in ein
	 */
	public void getKeyLetter() {
		System.out.print("Geben Sie nun den Schl�sselbuchstaben ein: ");
		String keyLetter = text.getText();

		letter = keyLetter.charAt(0);

	}

	// ------------------------------------------------------------------------
	/**
	 * holt sich aus dem alphabets den index des zuvor eingegebenen
	 * schl�sselbuchstabens
	 * 
	 * @return den index des gew�hlten buchstabens im array
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
	 * generiert mithilfe des schl�sselwortes, des schl�sselbuchstabens und des
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
