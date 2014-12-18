package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

import javax.swing.*;

import Aufgabe4.*;
import Input.Text;

public class ContA4 {
	Aufgabe4 a4 = new Aufgabe4();
	BootCamp b = new BootCamp();
	JTextField[] alphabet = a4.getAlphabet();
	JLabel[] percentage = a4.getPercentage();
	JLabel[] encodedAlphabet = a4.getEncodedAlphabet();
	JLabel[] encodedPercentage = a4.getEncodedPercentage();
	String text = new Text().getTextFromFile("geheim2.txt");
	StatElement[] german = BootCamp.german;
	StatElement[] encoded = b.wordCount(text);

	ContA4() {
		for(int i =0;i<26;i++){
			//System.out.println(german[i]);
			System.out.println(encoded[i]);
		}
	
		System.out.println("DONE");
		setText();
		setListener();
	}

	public void decode() {
		a4.getText().setText("");
		alphabet = a4.getAlphabet();
		char[] charText = text.toCharArray();
		for (int i = 0; i < charText.length; i++) {
			for (int index = 0; index < 26; index++) {
				// System.out.println((encoded[index].letter+"=="+charText[i])+" "+i+" "+index);
				if (encoded[index].letter == charText[i]) {

					charText[i] = (alphabet[index].getText().trim().charAt(0));
					break;
				}
			}

			a4.getText().append(String.format("%c", charText[i]));
		}

	}

	public void setText() {
		for (int i = 0; i < encoded.length; i++) {


		}
		for (int i = 0; i < 26; i++) {
			alphabet[i].setText(String.format("%c",
					((StatElement) (german[i])).letter));
			percentage[i].setText(String.format("%.2f %%",
					((StatElement) (german[i])).percentage));
			encodedAlphabet[i].setText(String.format("%c",
					((StatElement) (encoded[i])).letter));

			encodedPercentage[i].setText(String.format("%.2f %%",
					((StatElement) (encoded[i])).percentage));

		}
	}

	public void setListener() {
		JButton decode = a4.getDecode();
		decode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				decode();
			}
		});
	}

}
