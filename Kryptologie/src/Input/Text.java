package Input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.util.Scanner;

public class Text {
	Scanner scan = new Scanner(System.in);
	public char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z' };

	// ------------------------------------------------------------------------

	public Text() {
	}

	/**
	 * filtert alle zeichen au�en gro�-und kleinbuchstaben aus der eingabe �ber
	 * die konsole, tauscht alle �->SS,�->AE, �->OE und �->UE und gibt den text
	 * nur in Gro�buchstaben aus
	 * 
	 * @return gefilterter text als String
	 */
	public String getText() {
		String temp = scan.nextLine().replaceAll("[^a-zA-Z�������]", "");
		temp = temp.replaceAll("�", "SS");
		temp = temp.toUpperCase();
		temp = temp.replaceAll("�", "AE");
		temp = temp.replaceAll("�", "OE");
		temp = temp.replaceAll("�", "UE");
		System.out.println("Ihre Eingabe: \"" + temp + "\"");
		if (temp.compareTo("") == 0) {
			System.out
					.println("KEINE EINGABE!\nBITTE KEINE LEERE/UNZUL�SSIGE EINGABE!");
			return getText();
		}
		return temp;

	}

	// ------------------------------------------------------------------------
	/**
	 * entfernt aus einem Text alle duplikete, sodass jedes zeichen nur
	 * h�chstens einmal im text vorkommt
	 * 
	 * @param text
	 *            mit evtl. duplikaten
	 * @return String mit keinen duplikaten
	 */
	public String deleteDuplicates(String text) {
		String temp;
		for (int i = 0; i < text.length() - 1; i++) {

			if (text.substring(i + 1).contains(
					Character.toString(text.charAt(i)))) {

				temp = text.substring(i + 1).replaceAll(
						Character.toString(text.charAt(i)), "");
				text = text.substring(0, i + 1) + temp;
			}

		}
		return text;
	}

	// ------------------------------------------------------------------------
	/**
	 * 
	 * @param filename
	 * @return
	 * @throws IOException 
	 */
	public String getTextFromFile(String filename) throws IOException {
		String text="";
		String temp;
		 FileReader fr = new FileReader(filename);
		    BufferedReader br = new BufferedReader(fr);
		    while((temp=br.readLine())!=null){
		    	text+=temp;
		    }
		return text;
	}

	// ------------------------------------------------------------------------
	public char[] getAlphabet() {
		return alphabet;
	}

	// ------------------------------------------------------------------------
	public void setAlphabet(char[] alphabet) {
		this.alphabet = alphabet;
	}

}
