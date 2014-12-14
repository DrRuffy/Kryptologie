package Test;

import java.io.IOException;
import java.util.ArrayList;

import Aufgabe1.Save;
import Aufgabe2.Vigenere;
import Aufgabe3.KappaTest;
import Input.Text;

public class Test {
	public static void main(String[] args) throws IOException {

		// Save save = new Save();
		// save.decode(save.encode());
		Text t = new Text();
		KappaTest kt = new KappaTest();
		Vigenere v = new Vigenere();
		String encodedText = t.getTextFromFile("geheim1.txt");
		char[] keyWord = kt.getKeyWord(encodedText);
		
		System.out.println(keyWord);
		System.out.println(encodedText);
		System.out.println(v.entsch(encodedText.toCharArray(), keyWord));
	}
}
