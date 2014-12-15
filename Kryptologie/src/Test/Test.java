package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Aufgabe1.Caesar;
import Aufgabe2.Vigenere;
import Aufgabe3.KappaTest;
import Aufgabe4.BootCamp;
import Input.Text;

public class Test {
	public static void main(String[] args) throws IOException {

		KappaTest kappa = new KappaTest();
		Vigenere v = new Vigenere();
		Text t = new Text();
		
		
		String geheim1 = t.getTextFromFile("geheim1.txt");
		System.out.println(v.entsch(geheim1.toCharArray(),kappa.getKeyWord(geheim1)));
		
		String geheim2 = t.getTextFromFile("geheim2.txt");
		
		
	}
}
