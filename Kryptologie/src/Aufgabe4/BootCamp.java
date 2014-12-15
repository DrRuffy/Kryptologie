package Aufgabe4;

import java.util.HashMap;

public class BootCamp {
	   public static final HashMap<Character, Double> germanWordFreq;
	    static
	    {
	    	germanWordFreq =  new HashMap<Character, Double>();
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
	
	

	public HashMap<Character,Double> wordCount(String encodedText) {
		HashMap<Character, Double> temp = new HashMap<Character, Double>();
			double[] statistic = new double[26];
			for (char c : encodedText.toCharArray()) {
				int tmp = (int) c - 65;
				statistic[tmp]++;
			}
			for(int i=0;i<statistic.length;i++){
				temp.put((char)(i+65), statistic[i]/encodedText.length()*100);
			}
			return temp;
		}		
	

	
	
}
