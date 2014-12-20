package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
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
	StatElement[] german = b.germanHashToSortedArray();
	StatElement[] encoded = b.wordCount(text);
	char selectedChar;
	char[] mySolution;

	ContA4() {

		setText();
		setListener();
	}
/**
 * 
 */
	public void decode() {
		a4.getTextEncoded().setText("");
		alphabet = a4.getAlphabet();
		char[] charText = text.toCharArray();
		
		for (int i = 0; i < charText.length; i++) {
			for (int index = 0; index < 26; index++) {
				if (encoded[index].letter == charText[i]) {
					charText[i] = (alphabet[index].getText().trim().toUpperCase().charAt(0));
					break;
				}
			}

			a4.getTextEncoded().append(String.format("%c", charText[i]));
		}
		a4.getTextEncoded().append("\n");

	}
/**
 * 
 */
	public void setText() {
		a4.getTextDecoded().setText(text + "\n");
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
/**
 * 
 */
	public void setListener() {
		a4.getSolveEncodedText().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (mySolution == null) {
					mySolution = new char[26];
				}
				if (!a4.getSolveEncodedText().isSelected()) {
					for (int i = 0; i < BootCamp.solve.length; i++) {
						String temp = a4.getAlphabet()[i].getText().trim()
								.toUpperCase();
						if (temp.length() > 0)
							mySolution[i] = temp.charAt(0);
						// a4.getAlphabet()[i].setForeground(Color.green);
					}

				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (a4.getSolveEncodedText().isSelected()) {
					for (int i = 0; i < BootCamp.solve.length; i++) {
						a4.getAlphabet()[i].setText(String.format("%c",
								BootCamp.solve[i]));
					}
				} else {
					if (mySolution != null) {
						for (int i = 0; i < BootCamp.solve.length; i++) {
							a4.getAlphabet()[i].setText(String.format("%c",
									mySolution[i]));
						}
					}
				}
			}

		});
		a4.getDecode().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				decode();
			}
		});

		final JTextField[] t = a4.getAlphabet();
		for (int i = 0; i < t.length; i++) {
			t[i].addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyReleased(KeyEvent arg0) {
					JTextField textfield = ((JTextField) arg0.getSource());
					char c = textfield.getText().trim().toUpperCase().charAt(0);

					for (int i = 0; i < t.length; i++) {

						if (t[i].getText().trim().toUpperCase().charAt(0) == c) {

							a4.getPercentage()[i].setText(String.format(
									"%.2f %%", BootCamp.germanWordFreq.get(c)));

							  if (german[i].letter == c) {
								textfield.setForeground(Color.YELLOW);
								a4.getPercentage()[i]
										.setForeground(Color.YELLOW);

							} else {
								textfield.setForeground(Color.orange);
								a4.getPercentage()[i]
										.setForeground(Color.orange);
							}
						}
						
					}
					LinkedList<Integer> doppelt = new LinkedList<Integer>();
					if (true) {
						for (int i = 0; i < 26; i++) {
							t[i].setForeground(Color.YELLOW);
							for (int j = i + 1; j < 26; j++) {
								if (t[i].getText().trim().toUpperCase()
										.charAt(0) == t[j].getText().trim()
										.toUpperCase().charAt(0)) {
									doppelt.add(i);
									doppelt.add(j);
								}
							}
							;
						}
					}

					for (int i : doppelt) {
						t[i].setForeground(Color.red);
					}

				}

				@Override
				public void keyTyped(KeyEvent arg0) {

				}

			});
			t[i].addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent arg0) {

				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					for (int i = 0; i < t.length; i++) {
						String temp = ((JTextField) arg0.getSource()).getText()
								.trim().toUpperCase();
						if (temp.length() > 0) {
							selectedChar = temp.charAt(0);
						}
					}

				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub

				}

			});

		}
		a4.getSearch().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String search = a4.getCharSearch().getText().trim()
						.toUpperCase();
				if (search.length() > 0) {
					StatElement[] se = b.countMaxBeforeAfter(
							text.toCharArray(), a4.getCharSearch().getText()
									.trim().toUpperCase().charAt(0), a4
									.getToggleButton().isSelected());
					for (int i = 0; i < 5; i++) {
						a4.getCharStat().append(
								String.format("%s\n", se[i].toString()));
					}
				}
			}
		});

	}

}
