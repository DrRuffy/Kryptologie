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
	private TextArea text;
	private JButton decode;

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
		width = (int) (d.width * 0.25);
		height = (int) (d.height * 0.25);

		width = 800;
		height = 600;
		setJLabelAlphabet();
		setJLabelPercentage();
		setJLabelEncodedAlphabet();
		setJLabelEncodedPercentage();
		setText();
		setDecodeButton();
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

	public JButton getDecode() {
		return decode;
	}

	public void setDecode(JButton decode) {
		this.decode = decode;
	}

	public void setJLabelAlphabet() {
		alphabet = new JTextField[26];
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = new JTextField();
			alphabet[i].setBackground(Color.DARK_GRAY);
			alphabet[i].setForeground(Color.LIGHT_GRAY);
			alphabet[i].setFont(new Font("Times New Roman", Font.BOLD,
					(int) (height * factor)));
			alphabet[i].setBounds((int) (width * 0.04), (int) (i * height
					* factor + getHeight() * spaceHead),
					(int) (width * factor), (int) (height * factor));
			getContentPane().add(alphabet[i]);
		}
	}

	public void setText() {
		text = new TextArea();
		double x = 0.3;
		double y = 0.7;
		text.setBackground(Color.GRAY);
		text.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(text);

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

	public TextArea getText() {
		return text;
	}

	public void setText(TextArea text) {
		this.text = text;
	}

	public void setJLabelPercentage() {
		percentage = new JLabel[26];
		for (int i = 0; i < percentage.length; i++) {
			percentage[i] = new JLabel();
			percentage[i].setBackground(Color.DARK_GRAY);
			percentage[i].setForeground(Color.LIGHT_GRAY);
			getContentPane().add(percentage[i]);
		}
	}

	public void setJLabelEncodedAlphabet() {

		encodedAlphabet = new JLabel[26];
		for (int i = 0; i < encodedAlphabet.length; i++) {
			encodedAlphabet[i] = new JLabel();
			encodedAlphabet[i].setBackground(Color.DARK_GRAY);
			encodedAlphabet[i].setForeground(Color.YELLOW);
			getContentPane().add(encodedAlphabet[i]);
		}
	}

	public void setJLabelEncodedPercentage() {
		encodedPercentage = new JLabel[26];
		for (int i = 0; i < encodedPercentage.length; i++) {
			encodedPercentage[i] = new JLabel();
			encodedPercentage[i].setBackground(Color.DARK_GRAY);
			encodedPercentage[i].setForeground(Color.YELLOW);
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

			percentage[i].setBounds((int) (getWidth() * 0.04), (int) (i
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
			// ----------------------------------------------------------------
			decode.setFont(new Font("Times New Roman", Font.BOLD,
					(int) (getHeight() * 0.1)));
			decode.setBounds((int) (getWidth() * 0.01),
					(int) (getHeight() * 0.84), (int) (getWidth() * 0.99),
					(int) (getHeight() * 0.077));
			// ----------------------------------------------------------------
			text.setFont(new Font("Times New Roman", Font.BOLD,
					(int) (getHeight() * factor)));
			text.setBounds((int) (getWidth() * 0.3), (int) (getHeight() * 0.7),
					(int) (getWidth() * (0.67)), (int) (getHeight() * (0.13)));

		}
	}
}
