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
	public static PriorityQueue<StatElement> german; 
	static {
		german  = new PriorityQueue<StatElement>(1000,c);
		
		german.add(new StatElement('N', 9.78));
		german.add(new StatElement('I', 7.55));
		german.add(new StatElement('E', 17.4));
		german.add(new StatElement('S', 7.27));
		german.add(new StatElement('R', 7.0));
		german.add(new StatElement('A', 6.51));
		german.add(new StatElement('T', 6.15));
		german.add(new StatElement('D', 5.08));
		german.add(new StatElement('H', 4.76));
		german.add(new StatElement('U', 4.35));
		german.add(new StatElement('L', 3.44));
		german.add(new StatElement('C', 3.06));
		german.add(new StatElement('G', 3.01));
		german.add(new StatElement('M', 2.53));
		german.add(new StatElement('O', 2.51));
		german.add(new StatElement('W', 1.89));
		german.add(new StatElement('B', 1.89));
		german.add(new StatElement('F', 1.66));
		german.add(new StatElement('K', 1.21));
		german.add(new StatElement('Z', 1.13));
		german.add(new StatElement('P', 0.79));
		german.add(new StatElement('V', 0.67));
		german.add(new StatElement('J', 0.27));
		german.add(new StatElement('Y', 0.04));
		german.add(new StatElement('X', 0.03));
		german.add(new StatElement('Q', 0.02));
		
	}
//	public static final HashMap<Character, Double> germanWordFreq;
//
//	static {
//		germanWordFreq = new HashMap<Character, Double>();
//		germanWordFreq.put('E', 17.4);
//		germanWordFreq.put('N', 9.78);
//		germanWordFreq.put('I', 7.55);
//		germanWordFreq.put('S', 7.27);
//		germanWordFreq.put('R', 7.0);
//		germanWordFreq.put('A', 6.51);
//		germanWordFreq.put('T', 6.15);
//		germanWordFreq.put('D', 5.08);
//		germanWordFreq.put('H', 4.76);
//		germanWordFreq.put('U', 4.35);
//		germanWordFreq.put('L', 3.44);
//		germanWordFreq.put('C', 3.06);
//		germanWordFreq.put('G', 3.01);
//		germanWordFreq.put('M', 2.53);
//		germanWordFreq.put('O', 2.51);
//		germanWordFreq.put('W', 1.89);
//		germanWordFreq.put('B', 1.89);
//		germanWordFreq.put('F', 1.66);
//		germanWordFreq.put('K', 1.21);
//		germanWordFreq.put('Z', 1.13);
//		germanWordFreq.put('P', 0.79);
//		germanWordFreq.put('V', 0.67);
//		germanWordFreq.put('J', 0.27);
//		germanWordFreq.put('Y', 0.04);
//		germanWordFreq.put('X', 0.03);
//		germanWordFreq.put('Q', 0.02);
//	}
	

	public PriorityQueue<StatElement> wordCount(String encodedText) {
		PriorityQueue<StatElement> temp = new PriorityQueue<StatElement>(1000,c);
		double[] statistic = new double[26];
		for (char c : encodedText.toCharArray()) {
			int tmp = (int) c - 65;
			statistic[tmp]++;
		}
		for (int i = 0; i < statistic.length; i++) {
			temp.add(new StatElement((char) (i + 65), new Double(statistic[i] / encodedText.length() * 100)));
		}
		return temp;
	}

}
