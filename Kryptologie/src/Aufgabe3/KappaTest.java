package Aufgabe3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import Aufgabe2.Vigenere;
import Input.Text;

public class KappaTest {
	

	

	// ------------------------------------------------------------------------
	/**
	 * 
	 * @param filename
	 * @throws IOException
	 */
	public char[] getKeyWord(String encodedText) throws IOException {
		

		int keyLength = getKeyLength(encodedText);
		char[] keyWord = new char[keyLength];
		int i = 0;
		for (LinkedList<Character> c : splitText(encodedText,keyLength)) {

			int charIndex = mostFreqLetter(countASCII(c));

			if ((charIndex + 65 - 4) < 65) {
				keyWord[i] = (char) (charIndex + 65 - 4 + 26);
			} else {
				keyWord[i] = (char) (charIndex + 65 - 4);
			}
			i++;

		}
		
		return keyWord;

	}

	// ------------------------------------------------------------------------
	/**
	 * 
	 * @return
	 */
	public int getKeyLength(String encodedText) {
		int size = encodedText.length();
		
		for (int i = 0; i < size-1; i++) {
			double anz = 0;
			for (int ii = 0; ii < size; ii++) {
				if (encodedText.charAt(ii) == encodedText.charAt((ii + 1 + i) % size)) {
					anz++;
				}
			}
			if ((anz / size) > 0.08) {
				return i+1;
			}

		}
		return -1;
	}

	// ------------------------------------------------------------------------
	/**
	 * 
	 * @param keysize
	 * @return
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
	 * 
	 * @param c_Arr
	 * @return
	 */
	public static int[] countASCII(LinkedList<Character> c_Arr) {

		int[] statistic = new int[26];
		for (char c : c_Arr) {
			int tmp = (int) c - 65;
			statistic[tmp]++;
		}
		return statistic;
	}

	// ------------------------------------------------------------------------
	/**
	 * 
	 * @param anz
	 * @return
	 */
	public static int mostFreqLetter(int[] anz) {
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
