package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Aufgabe1.Caesar;
import Aufgabe2.Vigenere;
import Aufgabe3.KappaTest;
import Input.Text;

public class ContA1_3 {
	Aufgabe1_3 a1_3;
	Caesar c = new Caesar();
	Vigenere v = new Vigenere();
	KappaTest k = new KappaTest();
	Text t = new Text();

	ContA1_3() {
		a1_3 = new Aufgabe1_3();
		setListener();
	}

	/**
 * 
 */
	public void setListener() {
		a1_3.getSelect().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("action");
				JLabel tl = a1_3.getTl();
				tl.setVisible(true);
				JLabel tw = a1_3.getTw();
				tw.setVisible(true);
				JTextField letter = a1_3.getKeyLetter_txtbox();
				letter.setVisible(true);
				JTextField word = a1_3.getKeyWord_txtbox();
				word.setVisible(true);

				String temp = (String) a1_3.getSelect().getSelectedItem();
				switch (temp) {
				case "Aufgabe 1":
					System.out.println("1");
					break;
				case "Aufgabe 2":
					System.out.println("2");
					letter.setVisible(false);
					tl.setVisible(false);
					break;
				case "Aufgabe 3":
					System.out.println("3");
					tl.setVisible(false);
					tw.setVisible(false);
					letter.setVisible(false);
					word.setVisible(false);
					break;
				}

			}

		});
		a1_3.getDecode().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String temp = (String) a1_3.getSelect().getSelectedItem();
				String text = a1_3.getTextDecoded().getText().toUpperCase();
				String word = a1_3.getKeyWord_txtbox().getText().toUpperCase();
				char letter = ' ';
				if (a1_3.getKeyLetter_txtbox().getText().length() > 0) {
					letter = a1_3.getKeyLetter_txtbox().getText().toUpperCase()
							.charAt(0);
				}
				switch (temp) {
				case "Aufgabe 1":
					if (letter != ' ') {
						word = t.deleteDuplicates(word);
						a1_3.getKeyWord_txtbox().setText(word);
						if (a1_3.getDecode().getText().compareTo("Decode") == 0) {
							a1_3.getTextEncoded().setText(
									c.decode(text, word, letter));
						} else {
							a1_3.getTextEncoded().setText(
									c.encode(text, word, letter));
						}
					}

					break;
				case "Aufgabe 2":
					if (!word.isEmpty()) {
						word = t.deleteDuplicates(word);
						a1_3.getKeyWord_txtbox().setText(word);
						if (a1_3.getDecode().getText().compareTo("Decode") == 0) {
							a1_3.getTextEncoded().setText(
									v.entsch(text.toCharArray(),
											word.toCharArray()));
						} else {
							a1_3.getTextEncoded().setText(
									v.versch(text.toCharArray(),
											word.toCharArray()));
						}
					}
					break;

				case "Aufgabe 3":

					try {
						text = t.getTextFromFile("geheim1.txt");
						word = k.getKeyWord(text).toString();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					a1_3.getTextDecoded().setText(text);
					a1_3.getTextEncoded().setText(
							"Keyword: "
									+ word
									+ "\n"
									+ v.entsch(text.toCharArray(),
											word.toCharArray()));
					break;
				}

			}

		});

	}
}
