package Test;


import java.io.IOException;

import Aufgabe1.Save;
import Input.Text;
public class Test {
	public static void main(String[] args) throws IOException {

//		Save save = new Save();
//		save.decode(save.encode());
		
		Text text = new Text();
		System.out.println(text.getTextFromFile("geheim1.txt"));

		
	}
}
