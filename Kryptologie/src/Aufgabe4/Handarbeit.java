package Aufgabe4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Handarbeit {
	static Comparator<StatElement> c = new Comparator<StatElement>() {

		@Override
		public int compare(StatElement one, StatElement two) {
			if (one.percentage < two.percentage) {
				return 1;
			}
			if (one.percentage > two.percentage) {
				return -1;
			}

			return 0;

		}
	};

	public static final char[] solve;

	static {
		solve = new char[26];
		solve[0] = 'E';
		solve[1] = 'N';
		solve[2] = 'I';
		solve[3] = 'T';
		solve[4] = 'R';
		solve[5] = 'U';
		solve[6] = 'S';
		solve[7] = 'H';
		solve[8] = 'A';
		solve[9] = 'C';
		solve[10] = 'D';
		solve[11] = 'G';
		solve[12] = 'L';
		solve[13] = 'O';
		solve[14] = 'F';
		solve[15] = 'Z';
		solve[16] = 'M';
		solve[17] = 'W';
		solve[18] = 'K';
		solve[19] = 'B';
		solve[20] = 'P';
		solve[21] = 'V';
		solve[22] = 'Y';
		solve[23] = 'Q';
		solve[24] = 'J';
		solve[25] = 'X';

	}
	public static final HashMap<Character, Double> germanWordFreq;

	static {
		germanWordFreq = new HashMap<Character, Double>();
		germanWordFreq.put('E', 17.4);
		germanWordFreq.put('N', 9.78);
		germanWordFreq.put('I', 7.55);
		germanWordFreq.put('S', 7.27);
		germanWordFreq.put('R', 7.0);
		germanWordFreq.put('A', 6.51);
		germanWordFreq.put('T', 6.15);
		germanWordFreq.put('D', 5.08);
		germanWordFreq.put('H', 4.76);
		germanWordFreq.put('U', 4.35);
		germanWordFreq.put('L', 3.44);
		germanWordFreq.put('C', 3.06);
		germanWordFreq.put('G', 3.01);
		germanWordFreq.put('M', 2.53);
		germanWordFreq.put('O', 2.51);
		germanWordFreq.put('W', 1.89);
		germanWordFreq.put('B', 1.89);
		germanWordFreq.put('F', 1.66);
		germanWordFreq.put('K', 1.21);
		germanWordFreq.put('Z', 1.13);
		germanWordFreq.put('P', 0.79);
		germanWordFreq.put('V', 0.67);
		germanWordFreq.put('J', 0.27);
		germanWordFreq.put('Y', 0.04);
		germanWordFreq.put('X', 0.03);
		germanWordFreq.put('Q', 0.02);
	}

	/**
	 * Zählt die Häufigkeit der Auftretenden Buchstaben des zu Entschlüsselnden
	 * Textes
	 * 
	 * @param Verschlüsselter
	 *            Input Text
	 * @return Array aus Sortierten StatElement`s
	 */
	public StatElement[] wordCount(String encodedText) {
		double[] statistic = new double[26];
		for (char c : encodedText.toCharArray()) {
			int tmp = ((int) c) - 65;

			statistic[tmp]++;
		}

		return sort(statistic, encodedText.length());
	}

	/**
	 * 
	 * @return
	 */
	public StatElement[] germanHashToSortedArray() {
		StatElement[] tempArray = new StatElement[germanWordFreq.size()];
		PriorityQueue<StatElement> temp = new PriorityQueue<StatElement>(c);

		for (int i = 0; i < tempArray.length; i++) {
			StatElement se = new StatElement((char) (i + 65), new Double(
					germanWordFreq.get((char) (i + 65))));
			temp.add(se);
		}
		for (int i = 0; i < tempArray.length; i++) { //
			tempArray[i] = temp.remove();
		}
		return tempArray;
	}

	/**
	 * Sortiert die Häufigkeit der auftretenden Buchstaben mithilfe einer
	 * PriorityQueue.
	 * 
	 * @param toSort
	 *            (double[]) - Array aus Doublewerten mit der Häufigkeit der
	 *            auftretenden Buchstaben
	 * @param anz
	 *            (int) - Anzahl der gezählten Buchstaben
	 * @return Sortiertes Array aus StatElement`s
	 */
	public StatElement[] sort(double[] toSort, int anz) {
		StatElement[] tempArray = new StatElement[toSort.length];
		PriorityQueue<StatElement> temp = new PriorityQueue<StatElement>(c);
		for (int i = 0; i < toSort.length; i++) {
			StatElement se = new StatElement((char) (i + 65), toSort[i] / anz
					* 100);

			temp.add(se);
		}
		for (int i = 0; i < tempArray.length; i++) { //
			tempArray[i] = temp.remove();
		}
		return tempArray;
	}

	/**
	 * Gibt ein Array aus sortierten StatElement`s zurück, welche die
	 * Häufigkeiten der vorgehenden/nachfolgenden Buchstaben, des zu prüfenden
	 * Buchstaben enthält.
	 * 
	 * @param text
	 *            (char[]) - des Eingabe Textes
	 * @param ch
	 *            (char) - Buchstabe der geprüft wird
	 * @param before
	 *            (Boolean) - true= vorher, false= folgende
	 * @return  Sortiertes Array aus StatElement`s 
	 */
	public StatElement[] countMaxBeforeAfter(char[] text, char ch,
			boolean before) {
		int anz = 0;
		double[] statistic = new double[26];

		for (int i = 0; i < text.length; i++) {

			if (text[i] == ch) {
				if ((before) && (i - 1 >= 0)) {

					statistic[(int) (text[i - 1]) - 65]++;
					anz++;
				} else if ((!before) && (i + 1 < text.length)) {
					statistic[(int) (text[i + 1]) - 65]++;
					anz++;
				}
			}

		}
		return sort(statistic, anz);
	}

}
