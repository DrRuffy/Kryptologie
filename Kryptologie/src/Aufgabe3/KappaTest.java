package Aufgabe3;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import Aufgabe2.Vigenere;
import Input.Text;

public class KappaTest {
	Vigenere v = new Vigenere();
	Text text = new Text();
	char[] encodedText;

	public void getEncodedText(String filename) throws IOException {
		encodedText = text.getTextFromFile(filename).toCharArray();
	}

	public void run(String filename) throws IOException {
		this.getEncodedText(filename);
		int keyLength = getKeyLength(getKappaValues());
		char[] keyLetter = new char[keyLength];
		int i = 0;
		for (LinkedList<Character> c : splitText(keyLength)) {

			int charIndex = highestNumber(count_ASCII(c));

			if ((charIndex + 65 - 4) < 65) {
				keyLetter[i] = (char) (charIndex + 65 - 4 + 26);
			} else {
				keyLetter[i] = (char) (charIndex + 65 - 4);
			}
			i++;

		}
		System.out.println(v.entsch(encodedText, keyLetter));

	}

	public double[] getKappaValues() {
		double[] kappaValues = new double[encodedText.length - 1];
		for (int i = 0; i < kappaValues.length; i++) {
			double anz = 0;
			for (int ii = 0; ii < kappaValues.length; ii++) {
				if (encodedText[ii] == encodedText[(ii + 1 + i)
						% kappaValues.length]) {
					anz++;
				}
			}
			kappaValues[i] = anz / encodedText.length;
		}
		return kappaValues;
	}

	public int getKeyLength(double[] werte) {

		double maxi = 0;
		ArrayList<double[]> max = new ArrayList<double[]>();

		for (int i = 0; i < werte.length - 2; i++) {
			if (werte[i] <= werte[i + 1]) {
				maxi = i + 1;

			} else {

				max.add(new double[] { maxi + 1, werte[(int) maxi] });
			}

		}

		return 6;

	}

	public LinkedList<Character>[] splitText(int keysize) {
		
		LinkedList<Character>[] temp = new LinkedList[keysize];
		for (int i = 0; i < keysize; i++) {
			temp[i] = new LinkedList<Character>();
		}
		for (int i = 0; i < encodedText.length; i++) {
			temp[i % keysize].add(encodedText[i]);

		}
		return temp;
	}

	public static int[] count_ASCII(LinkedList<Character> c_Arr) {

		int[] statistic = new int[26];
		for (char c : c_Arr) {
			int tmp = (int) c - 65;
			statistic[tmp]++;
		}
		return statistic;
	}

	public static int highestNumber(int[] numbers) {
		int highest = 0;
		int index = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > highest) {
				highest = numbers[i];
				index = i;
			}

		}
		return index;
	}
}
