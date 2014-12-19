package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

public class Aufgabe4 extends JFrame {
	int width;
	int height;
	double factor = 0.03;
	double spaceHead = 0.05;
	private JTextField[] alphabet;
	private JLabel[] percentage;
	private JLabel[] encodedAlphabet;
	private JLabel[] encodedPercentage;
	private TextArea textDecoded, textEncoded, charStat;
	private JTextField charSearch;
	private JButton decode, search;
	private JLabel t1, t2, t3;
	private JToggleButton toggleButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Aufgabe4 frame = new Aufgabe4();

	}

	/**
	 * Create the frame.
	 */
	public Aufgabe4() {

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) (d.width * 0.5);
		height = (int) (d.height * 0.5);

		// width = 800;
		// height = 600;
		setGerman();
		
		setEncoded();
		setText();
		setDecodeButton();
		setSearch();
		this.setResizable(true);
		this.setTitle("Kryptologie - Aufgabe 4");
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(width, height);

		this.setLocationRelativeTo(null);

		this.getContentPane().setLayout(null);

		this.setVisible(true);

		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent evt) {

				resize();

			}
		});

	}

	public void setSearch() {
		search = new JButton();
		search.setBorderPainted(false);
		search.setBackground(Color.LIGHT_GRAY);
		search.setForeground(Color.DARK_GRAY);
		search.setText("SEARCH");
		getContentPane().add(search);

		toggleButton = new JToggleButton();
		toggleButton.setForeground(Color.LIGHT_GRAY);
		toggleButton.setBackground(Color.GRAY);
		toggleButton.setText("Search After");
		toggleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(toggleButton.isSelected()){
					toggleButton.setBackground(Color.LIGHT_GRAY);
					toggleButton.setForeground(Color.GRAY);
					toggleButton.setText("Search Before");
				}else{
					toggleButton.setForeground(Color.LIGHT_GRAY);
					toggleButton.setBackground(Color.GRAY);
					toggleButton.setText("Search After");
				}
			}
		});
		getContentPane().add(toggleButton);
		
		charSearch = new JTextField();
		charSearch.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(charSearch);
		
		
		charStat = new TextArea();
		charStat.setBackground(Color.LIGHT_GRAY);
		charStat.setForeground(Color.DARK_GRAY);
		getContentPane().add(charStat);
	}

	public JButton getSearch() {
		return search;
	}

	public void setSearch(JButton search) {
		this.search = search;
	}

	public JButton getDecode() {
		return decode;
	}

	public void setDecode(JButton decode) {
		this.decode = decode;
	}

	public void setJLabelAlphabet() {
		alphabet = new JTextField[26];
		for (int i = 0; i < alphabet.length; i++) {
			
		}
	}

	public void setText() {
		textDecoded = new TextArea();
		textDecoded.setBackground(Color.LIGHT_GRAY);
		textDecoded.setForeground(Color.DARK_GRAY);
		getContentPane().add(textDecoded);
		textEncoded = new TextArea();
		textEncoded.setBackground(Color.LIGHT_GRAY);
		textEncoded.setForeground(Color.DARK_GRAY);
		getContentPane().add(textEncoded);
		t1 = new JLabel("Decoded Text:");
		t1.setBackground(Color.GRAY);
		t1.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(t1);
		t2 = new JLabel("Encoded Text:");
		t2.setBackground(Color.GRAY);
		t2.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(t2);
		t3 = new JLabel("German Word Statistic|Encoded Word Statistic:");
		t3.setBackground(Color.GRAY);
		t3.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(t3);
	}

	public void setDecodeButton() {
		decode = new JButton();
		decode.setBorderPainted(false);
		decode.setBackground(Color.LIGHT_GRAY);
		decode.setForeground(Color.DARK_GRAY);
		decode.setText("DECODE");

		this.getContentPane().add(decode);

	}

	public JTextField[] getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(JTextField[] alphabet) {
		this.alphabet = alphabet;
	}

	public JLabel[] getPercentage() {
		return percentage;
	}

	public void setPercentage(JLabel[] percentage) {
		this.percentage = percentage;
	}

	public JLabel[] getEncodedAlphabet() {
		return encodedAlphabet;
	}

	public void setEncodedAlphabet(JLabel[] encodedAlphabet) {
		this.encodedAlphabet = encodedAlphabet;
	}

	public JLabel[] getEncodedPercentage() {
		return encodedPercentage;
	}

	public void setEncodedPercentage(JLabel[] encodedPercentage) {
		this.encodedPercentage = encodedPercentage;
	}

	public void setGerman() {
		percentage = new JLabel[26];
		alphabet = new JTextField[26];
		for (int i = 0; i < alphabet.length; i++) {	
			alphabet[i] = new JTextField();
			alphabet[i].setBackground(Color.DARK_GRAY);
			alphabet[i].setForeground(Color.YELLOW);
			getContentPane().add(alphabet[i]);
			
			percentage[i] = new JLabel();
			percentage[i].setBackground(Color.DARK_GRAY);
			percentage[i].setForeground(Color.YELLOW);
			getContentPane().add(percentage[i]);
		}
	}

	public void setEncoded() {
		encodedPercentage= new JLabel[26];
		encodedAlphabet = new JLabel[26];
		for (int i = 0; i < encodedAlphabet.length; i++) {
			encodedAlphabet[i] = new JLabel();
			encodedAlphabet[i].setBackground(Color.DARK_GRAY);
			encodedAlphabet[i].setForeground(Color.LIGHT_GRAY);
			getContentPane().add(encodedAlphabet[i]);
			
			encodedPercentage[i] = new JLabel();
			encodedPercentage[i].setBackground(Color.DARK_GRAY);
			encodedPercentage[i].setForeground(Color.LIGHT_GRAY);
			getContentPane().add(encodedPercentage[i]);
		}
	}


	public void resize() {
		for (int i = 0; i < alphabet.length; i++) {
			// ----------------------------------------------------------------
			alphabet[i].setFont(new Font("Times New Roman", Font.BOLD,
					(int) (getHeight() * factor)));
			alphabet[i].setBounds((int) (getWidth() * 0.01), (int) (i
					* getHeight() * factor + getHeight() * spaceHead),
					(int) (getWidth() * factor), (int) (getHeight() * factor));
			// ----------------------------------------------------------------
			percentage[i].setFont(new Font("Times New Roman", Font.BOLD,
					(int) (getHeight() * factor)));

			percentage[i].setBounds((int) (getWidth() * 0.05), (int) (i
					* getHeight() * factor + getHeight() * spaceHead),
					(int) (getWidth() * 0.1), (int) (getHeight() * factor));
			// ----------------------------------------------------------------
			encodedAlphabet[i].setFont(new Font("Times New Roman", Font.BOLD,
					(int) (getHeight() * factor)));
			encodedAlphabet[i].setBounds((int) (getWidth() * 0.14), (int) (i
					* getHeight() * factor + getHeight() * spaceHead),
					(int) (getWidth() * factor), (int) (getHeight() * factor));
			// ----------------------------------------------------------------
			encodedPercentage[i].setFont(new Font("Times New Roman", Font.BOLD,
					(int) (getHeight() * factor)));

			encodedPercentage[i].setBounds((int) (getWidth() * 0.18), (int) (i
					* getHeight() * factor + getHeight() * spaceHead),
					(int) (getWidth() * 0.1), (int) (getHeight() * factor));

		}
		// ----------------------------------------------------------------
		decode.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * 0.1)));
		decode.setBounds((int) (getWidth() * 0.01), (int) (getHeight() * 0.84),
				(int) (getWidth() * 0.96), (int) (getHeight() * 0.077));
		// ----------------------------------------------------------------
		textDecoded.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		textDecoded.setBounds((int) (getWidth() * 0.3),
				(int) (getHeight() * 0.5), (int) (getWidth() * (0.67)),
				(int) (getHeight() * (0.13)));
		// ----------------------------------------------------------------
		textEncoded.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		textEncoded.setBounds((int) (getWidth() * 0.3),
				(int) (getHeight() * 0.7), (int) (getWidth() * (0.67)),
				(int) (getHeight() * (0.13)));

		// ----------------------------------------------------------------
		t2.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		t2.setBounds((int) (getWidth() * 0.3), (int) (getHeight() * 0.65),
				(int) (getWidth() * (0.3)), (int) (getHeight() * (0.05)));
		// ----------------------------------------------------------------
		t1.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		t1.setBounds((int) (getWidth() * 0.3), (int) (getHeight() * 0.45),
				(int) (getWidth() * (0.3)), (int) (getHeight() * (0.05)));
		// ----------------------------------------------------------------
		t3.setFont(new Font("Times New Roman", Font.BOLD, (int) (getHeight()
				* factor * 0.75)));
		t3.setBounds((int) (getWidth() * 0.01), (int) (getHeight() * 0.01),
				(int) (getWidth() * (0.3)), (int) (getHeight() * (0.05)));
		// -----------------------------------------------------------------
		toggleButton.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		toggleButton.setBounds((int) (getWidth() * 0.3),
				(int) (getHeight() * spaceHead), (int) (getWidth() * 0.15),
				(int) (getHeight() * factor));
		// -----------------------------------------------------------------
		charSearch.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		charSearch.setBounds((int) (getWidth() * 0.465),
				(int) (getHeight() * spaceHead), (int) (getWidth() * 0.02),
				(int) (getHeight() * factor));
		// -----------------------------------------------------------------
		search.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		search.setBounds((int) (getWidth() * 0.3),
				(int) (getHeight() * 0.1), (int) (getWidth() * 0.15),
				(int) (getHeight() * factor));
		// -----------------------------------------------------------------
		charStat.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		charStat.setBounds((int) (getWidth() * 0.5),
				(int) (getHeight() * spaceHead), (int) (getWidth() * 0.47),
				(int) (getHeight() * 0.25));
	}

	public TextArea getCharStat() {
		return charStat;
	}

	public void setCharStat(TextArea charStat) {
		this.charStat = charStat;
	}

	public JTextField getCharSearch() {
		return charSearch;
	}

	public void setCharSearch(JTextField charSearch) {
		this.charSearch = charSearch;
	}

	public JToggleButton getToggleButton() {
		return toggleButton;
	}

	public void setToggleButton(JToggleButton toggleButton) {
		this.toggleButton = toggleButton;
	}

	public TextArea getTextDecoded() {
		return textDecoded;
	}

	public void setTextDecoded(TextArea textDecoded) {
		this.textDecoded = textDecoded;
	}

	public TextArea getTextEncoded() {
		return textEncoded;
	}

	public void setTextEncoded(TextArea textEncoded) {
		this.textEncoded = textEncoded;
	}
}
