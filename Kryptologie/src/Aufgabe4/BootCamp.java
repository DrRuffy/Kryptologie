package Aufgabe4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BootCamp {
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
	public static StatElement[] german;
	static {
		german = new StatElement[26];
		german[0]=(new StatElement('E', 17.4));
		german[1]=(new StatElement('N', 9.78));
		german[2]=(new StatElement('I', 7.55));
		german[3]=(new StatElement('S', 7.27));
		german[4]=(new StatElement('R', 7.0));
		german[5]=(new StatElement('A', 6.51));
		german[6]=(new StatElement('T', 6.15));
		german[7]=(new StatElement('D', 5.08));
		german[8]=(new StatElement('H', 4.76));
		german[9]=(new StatElement('U', 4.35));
		german[10]=(new StatElement('L', 3.44));
		german[11]=(new StatElement('C', 3.06));
		german[12]=(new StatElement('G', 3.01));
		german[13]=(new StatElement('M', 2.53));
		german[14]=(new StatElement('O', 2.51));
		german[15]=(new StatElement('W', 1.89));
		german[16]=(new StatElement('B', 1.89));
		german[17]=(new StatElement('F', 1.66));
		german[18]=(new StatElement('K', 1.21));
		german[19]=(new StatElement('Z', 1.13));
		german[20]=(new StatElement('P', 0.79));
		german[21]=(new StatElement('V', 0.67));
		german[22]=(new StatElement('J', 0.27));
		german[23]=(new StatElement('Y', 0.04));
		german[24]=(new StatElement('X', 0.03));
		german[25]=(new StatElement('Q', 0.02));

	}

	// public static final HashMap<Character, Double> germanWordFreq;
	//
	// static {
	// germanWordFreq = new HashMap<Character, Double>();
	// germanWordFreq.put('E', 17.4);
	// germanWordFreq.put('N', 9.78);
	// germanWordFreq.put('I', 7.55);
	// germanWordFreq.put('S', 7.27);
	// germanWordFreq.put('R', 7.0);
	// germanWordFreq.put('A', 6.51);
	// germanWordFreq.put('T', 6.15);
	// germanWordFreq.put('D', 5.08);
	// germanWordFreq.put('H', 4.76);
	// germanWordFreq.put('U', 4.35);
	// germanWordFreq.put('L', 3.44);
	// germanWordFreq.put('C', 3.06);
	// germanWordFreq.put('G', 3.01);
	// germanWordFreq.put('M', 2.53);
	// germanWordFreq.put('O', 2.51);
	// germanWordFreq.put('W', 1.89);
	// germanWordFreq.put('B', 1.89);
	// germanWordFreq.put('F', 1.66);
	// germanWordFreq.put('K', 1.21);
	// germanWordFreq.put('Z', 1.13);
	// germanWordFreq.put('P', 0.79);
	// germanWordFreq.put('V', 0.67);
	// germanWordFreq.put('J', 0.27);
	// germanWordFreq.put('Y', 0.04);
	// germanWordFreq.put('X', 0.03);
	// germanWordFreq.put('Q', 0.02);
	// }

	public StatElement[] wordCount(String encodedText) {
		PriorityQueue<StatElement> temp = new PriorityQueue<StatElement>(c);
		double[] statistic = new double[26];
		int anz = 0;
		for (char c : encodedText.toCharArray()) {
			int tmp = ((int) c) - 65;
			
			statistic[tmp]++;
			anz++;
		}

		return sort(statistic, anz);
	}

	public StatElement[] sort(double[] toSort, int anz) {
		StatElement[] tempArray = new StatElement[toSort.length];
		PriorityQueue<StatElement> temp = new PriorityQueue<StatElement>(c);
		for (int i = 0; i < toSort.length; i++) {
			StatElement se = new StatElement((char) (i + 65), toSort[i]
					/ anz * 100);
			System.out.println(se);
			temp.add(se);
		}
		for (int i = 0; i < tempArray.length; i++) { //
			tempArray[i] = temp.remove();
		}
		return tempArray;
	}

	public StatElement[] countMaxBeforeAfter(char[] text, char ch,
			boolean before) {
		int anz = 0;
		double[] statistic = new double[26];
		for (int i =0;i< text.length;i++) {
			
			if (text[i] == ch){
				if(before){
					
					statistic[(int)(text[i-1])-65]++;
					anz++;
				}else{
					statistic[(int)(text[i+1])-65]++;
					anz++;
				}
			}
			
		}
		return sort(statistic, anz);
	}

}
