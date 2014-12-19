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
public StatElement[] germanHashToSortedArray(){
	StatElement[] tempArray = new StatElement[germanWordFreq.size()];
	PriorityQueue<StatElement> temp = new PriorityQueue<StatElement>(c);
	
	for (int i = 0; i < tempArray.length; i++) {
		StatElement se = new StatElement((char) (i+65),new Double(germanWordFreq.get((char)(i+65))));
		temp.add(se);
	}
	for (int i = 0; i < tempArray.length; i++) { //
		tempArray[i] = temp.remove();
	}
	return tempArray;
}
	public StatElement[] sort(double[] toSort, int anz) {
		StatElement[] tempArray = new StatElement[toSort.length];
		PriorityQueue<StatElement> temp = new PriorityQueue<StatElement>(c);
		for (int i = 0; i < toSort.length; i++) {
			StatElement se = new StatElement((char) (i + 65), toSort[i]
					/ anz * 100);
			
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
				if((before)&&(i-1>=0)){
					
					statistic[(int)(text[i-1])-65]++;
					anz++;
				}else if((!before)&&(i+1<text.length)){
					statistic[(int)(text[i+1])-65]++;
					anz++;
				}
			}
			
		}
		return sort(statistic, anz);
	}

}
