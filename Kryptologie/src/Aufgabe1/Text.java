package Aufgabe1;

import java.util.Scanner;

public class Text {
	Scanner scan = new Scanner(System.in);
	private char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z' };


	// ------------------------------------------------------------------------

	Text() {

	}

	public String getText() {
		String temp = scan.nextLine().replaceAll("[^a-zA-ZöäüÖÄÜß]", "");
		temp = temp.replaceAll("ß", "SS");
		temp = temp.toUpperCase();
		temp = temp.replaceAll("Ä", "AE");
		temp = temp.replaceAll("Ö", "OE");
		temp = temp.replaceAll("Ü", "UE");
		System.out.println("Ihre Eingabe: \"" + temp + "\"");
		if (temp.compareTo("") == 0) {
			System.out
					.println("KEINE EINGABE!\nBITTE KEINE LEERE/UNZULÄSSIGE EINGABE!");
			return getText();
		}
		return temp;

	}

	// ------------------------------------------------------------------------
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
	public char[] getAlphabet() {
		return alphabet;
	}

	// ------------------------------------------------------------------------
	public void setAlphabet(char[] alphabet) {
		this.alphabet = alphabet;
	}

}
