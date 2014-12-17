package Aufgabe4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Kryptographie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String geheimtext = null;
		try {
			geheimtext = getTextFromFile("geheim2.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(geheimtext);
		
		int[] worthaeufigkeiten = count_ASCII(geheimtext);
		double[] prozVorkommen = new double[worthaeufigkeiten.length];
		for (int i=0; i<worthaeufigkeiten.length; i++){
			prozVorkommen[i] = worthaeufigkeiten[i]/(double)geheimtext.length();
		}
//		for (double i : prozVorkommen)
//			System.out.println("Vorkommen : " + i);
//		
		double[] afterE = countISRATafterE(geheimtext);
		for(double d : afterE)
			System.out.println("Nach e : " + d);
		
		double[] beforeE = countISRATbehindE(geheimtext);
		for(double d : beforeE)
			System.out.println("Vor e : " + d);
		
		//geheimtext.
		// manuelles dechiffrieren :
//		int eIndex = highestNumber(worthaeufigkeiten);
//		char eGeheim = (char) (eIndex +65);
//		System.out.println(eGeheim);
//		geheimtext = geheimtext.replaceAll("N", "E");
//		worthaeufigkeiten[eIndex] = -1;
//		int nIndex = highestNumber(worthaeufigkeiten);
//		char nGeheim = (char) (nIndex +65);
//		System.out.println(nGeheim);
//		geheimtext = geheimtext.replace("F", "N");
//		worthaeufigkeiten[nIndex] = -1;
		
		
		
//		geheimtext = geheimtext.replace("T", "H");
//		geheimtext = geheimtext.replace("E", "T");
//		geheimtext = geheimtext.replace("N", "E");
//		geheimtext = geheimtext.replace("F", "N");
//		geheimtext = geheimtext.replace("R", "F");
//		geheimtext = geheimtext.replace("A", "R");
//		geheimtext = geheimtext.replace("Y", "A");
//		geheimtext = geheimtext.replace("D", "Y");
//		geheimtext = geheimtext.replace("P", "D");
//		geheimtext = geheimtext.replace("I", "P");
//		geheimtext = geheimtext.replace("Q", "I");
//		geheimtext = geheimtext.replace("B", "U");
//		geheimtext = geheimtext.replace("K", "S");
//		geheimtext = geheimtext.replace("Z", "G");
//		geheimtext = geheimtext.replace("C", "M");
//		geheimtext = geheimtext.replace("W", "C");
//		geheimtext = geheimtext.replace("L", "W");
//		geheimtext = geheimtext.replace("K", "U");
//		geheimtext = geheimtext.replace("U", "K");
//		geheimtext = geheimtext.replace("M", "L");
//		geheimtext = geheimtext.replace("O", "Z");
//		geheimtext = geheimtext.replace("X", "O");
		
		char[] clear = dechiffrieren(geheimtext);
		StringBuffer buf = new StringBuffer();
		for (char c : clear){
			buf.append(c);
		}
		System.out.println(buf.toString());
		//System.out.println(geheimtext);
	}
	
	public static char[] dechiffrieren(String text){
		char[] charText = text.toCharArray();
		for (int i=0; i<charText.length; i++){
			switch (charText[i]){
			case 'A' :
				charText[i]= 'R';
				break;
			case 'B' :
				charText[i]= 'U';
				break;
			case 'C' :
				charText[i]= 'M';
				break;
			case 'D' :
				charText[i]= 'Y';
				break;
			case 'E' :
				charText[i]= 'T';
				break;
			case 'F' :
				charText[i]= 'N';
				break;
			case 'G' :
				charText[i]= 'X';
				break;
			case 'H' :
				charText[i]= 'V';
				break;
			case 'I' :
				charText[i]= 'P';
				break;
			case 'J' :
				charText[i]= 'Q';
				break;
			case 'K' :
				charText[i]= 'S';
				break;
			case 'L' :
				charText[i]= 'W';
				break;
			case 'M' :
				charText[i]= 'L';
				break;
			case 'N' :
				charText[i]= 'E';
				break;
			case 'O' :
				charText[i]= 'Z';
				break;
			case 'P' :
				charText[i]= 'D';
				break;
			case 'Q' :
				charText[i]= 'I';
				break;
			case 'R' :
				charText[i]= 'F';
				break;
			case 'S' :
				charText[i]= 'J';
				break;
			case 'T' :
				charText[i]= 'H';
				break;
			case 'U' :
				charText[i]= 'K';
				break;
			case 'V' :
				charText[i]= 'B';
				break;
			case 'W' :
				charText[i]= 'C';
				break;
			case 'X' :
				charText[i]= 'O';
				break;
			case 'Y' :
				charText[i]= 'A';
				break;
			case 'Z' :
				charText[i]= 'G';
				break;
			}		
		}
		return charText;
	}
	
	public static double[] countISRATafterE(String text){
		char[] charText = text.toCharArray();
		double[] eISRAT = new double[5];
		for (int i=0; i<charText.length; i++){
			if (charText[i] == 'N'){
				switch (charText[i+1]){
				case 'Q': 
					eISRAT[0]++;
					break;
				case 'A':
					eISRAT[1]++;
					break;
				case 'B':
					eISRAT[2]++;
					break;
				case 'E':
					eISRAT[3]++;
					break;
				case 'K':
					eISRAT[4]++;
					break;
				default:
					break;
				}
			}
		}
		return eISRAT;
		
	}
	
	public static double[] countISRATbehindE(String text){
		char[] charText = text.toCharArray();
		double[] eISRAT = new double[5];
		for (int i=0; i<charText.length; i++){
			if (charText[i] == 'N'){
				switch (charText[i-1]){
				case 'Q': 
					eISRAT[0]++;
					break;
				case 'A':
					eISRAT[1]++;
					break;
				case 'B':
					eISRAT[2]++;
					break;
				case 'E':
					eISRAT[3]++;
					break;
				case 'K':
					eISRAT[4]++;
					break;
				default:
					break;
				}
			}
		}
		return eISRAT;
		
	}
	

	public static String getTextFromFile(String filename) throws IOException {
		String text = "";
		String temp;
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		while ((temp = br.readLine()) != null) {
			text += temp;
		}
		return text;
	}
	
	/**
	 * Zählt Häufigkeit jedes Buchstabens im Text
	 * 
	 * @param text
	 *            Text
	 * @return Liste mit Häufigkeiten
	 */
	private static int[] count_ASCII(String text) {

		int[] statistic = new int[26];
		char[] c_Arr = text.toCharArray();
		for (int i = 0; i < c_Arr.length; i++) {
			int tmp = (int) c_Arr[i] - 65;
			statistic[tmp]++;
		}
		return statistic;
	}
	
	/**
	 * Liefert Index des höchsten Wertes aus int[]
	 * 
	 * @param numbers
	 *            Liste aus Werte
	 * @return Index des höchsten Wertes
	 */
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
