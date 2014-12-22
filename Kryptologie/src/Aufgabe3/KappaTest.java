package Aufgabe3;

import java.io.IOException;
import java.util.LinkedList;

public class KappaTest {

	// ------------------------------------------------------------------------
	/**
	 * ermittelt �ber den h�ufugsten vorkommenden buchstaben in einem
	 * deutschsprachen Text (E), das wahrscheinlichste Schl�sselwort
	 * 
	 * @param encodedText (String)
	 *            - verschl�sselter Text
	 * @return Schl�sselwort der Vigenereverschl�sselung als String
	 * @throws IOException
	 */
	public String getKeyWord(String encodedText) throws IOException {

		int keyLength = getKeyLength(encodedText);
		char[] keyWord = new char[keyLength];
		int i = 0;
		for (LinkedList<Character> c : splitText(encodedText, keyLength)) {

			int charIndex = mostFreqLetter(countASCII(c));

			if ((charIndex + 65 - 4) < 65) {
				keyWord[i] = (char) (charIndex + 65 - 4 + 26);
			} else {
				keyWord[i] = (char) (charIndex + 65 - 4);
			}
			i++;

		}

		return String.valueOf(keyWord);

	}

	// ------------------------------------------------------------------------
	/**
	 * Z�hlt die gleichen buchstabenpaare der verschobenen Listen und gibt den
	 * index des ersten Maximums zur�ck
	 * 
	 * @param encodedText (String)
	 *            - verschl�sselter Text
	 * @return die wahrscheinliche Schl�sselwortl�nge als int
	 */
	public int getKeyLength(String encodedText) {
		int size = encodedText.length();

		for (int i = 0; i < size - 1; i++) {
			double anz = 0;
			for (int ii = 0; ii < size; ii++) {
				if (encodedText.charAt(ii) == encodedText.charAt((ii + 1 + i)
						% size)) {
					anz++;
				}
			}
			if ((anz / size) > 0.08) {
				return i + 1;
			}

		}
		return -1;
	}

	// ------------------------------------------------------------------------
	/**
	 * teilt den Text in keysize Listen auf, sodass jeder n-te buchstabe in
	 * einer Liste ist
	 * 
	 * @param encodedText (String) - verschl�sselter Text
	 * @param keysize (int) - l�nge des wahrscheilnichen Schl�sselworts
	 * @return jeder n-te buchstabe ist ein einer Liste
	 */
	public LinkedList<Character>[] splitText(String encodedText, int keysize) {

		LinkedList<Character>[] temp = new LinkedList[keysize];
		for (int i = 0; i < keysize; i++) {
			temp[i] = new LinkedList<Character>();
		}
		for (int i = 0; i < encodedText.length(); i++) {
			temp[i % keysize].add(encodedText.charAt(i));

		}
		return temp;
	}

	// ------------------------------------------------------------------------
	/**
	 * Z�hlt die h�figkeit der buchstaben in erner Liste und gibt das Ergebnis
	 * als integerarray zur�ck
	 * 
	 * @param c_Arr (LinkedList<Character>) 
	 * @return Array mit buchstabenh�ufigkeiten
	 */
	public int[] countASCII(LinkedList<Character> c_Arr) {

		int[] statistic = new int[26];
		for (char c : c_Arr) {
			int tmp = (int) c - 65;
			statistic[tmp]++;
		}
		return statistic;
	}

	// ------------------------------------------------------------------------
	/**
	 * gibt die position des h�figsten Buchstaben aus
	 * index +65 => char
	 * 
	 * @param anz
	 * @return position des gr��ten elements
	 */
	public int mostFreqLetter(int[] anz) {
		int max = 0;
		int index = 0;
		for (int i = 0; i < anz.length; i++) {
			if (anz[i] > max) {
				max = anz[i];
				index = i;
			}

		}
		return index;
	}
}
