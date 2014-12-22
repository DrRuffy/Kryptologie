package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Aufgabe1_3 extends JFrame {
	int width;
	int height;
	double factor = 0.03;
	double spaceHead = 0.05;
	private TextArea textDecoded, textEncoded;
	private JTextField keyWord_txtbox, keyLetter_txtbox;
	private JButton decode;
	private JLabel t1, t2, t3, tw, tl, t6;

	private JToggleButton toggleButton;
	private String toggleText = "Decode";
	private JComboBox<String> select;

	public JLabel getTw() {
		return tw;
	}

	public void setTw(JLabel tw) {
		this.tw = tw;
	}

	public JLabel getTl() {
		return tl;
	}

	public void setTl(JLabel tl) {
		this.tl = tl;
	}

	/**
 * 
 */
	public Aufgabe1_3() {

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) (d.width * 0.75);
		height = (int) (d.height * 0.75);

		setText();
		setButton();

		this.setResizable(true);
		this.setTitle("Kryptologie - Aufgabe 2");
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

	public JTextField getKeyWord_txtbox() {
		return keyWord_txtbox;
	}

	public void setKeyWord_txtbox(JTextField keyWord_txtbox) {
		this.keyWord_txtbox = keyWord_txtbox;
	}

	public JTextField getKeyLetter_txtbox() {
		return keyLetter_txtbox;
	}

	public void setKeyLetter_txtbox(JTextField keyLetter_txtbox) {
		this.keyLetter_txtbox = keyLetter_txtbox;
	}

	public JToggleButton getToggleButton() {
		return toggleButton;
	}

	public void setToggleButton(JToggleButton toggleButton) {
		this.toggleButton = toggleButton;
	}

	public String getToggleText() {
		return toggleText;
	}

	public void setToggleText(String toggleText) {
		this.toggleText = toggleText;
	}

	public JComboBox<String> getSelect() {
		return select;
	}

	public void setSelect(JComboBox<String> select) {
		this.select = select;
	}

	public JButton getDecode() {
		return decode;
	}

	public void setDecode(JButton decode) {
		this.decode = decode;
	}

	/**
 * 
 */
	public void setText() {
		textDecoded = new TextArea();
		textDecoded.setBackground(Color.LIGHT_GRAY);
		textDecoded.setForeground(Color.DARK_GRAY);
		getContentPane().add(textDecoded);
		textEncoded = new TextArea();
		textEncoded.setBackground(Color.LIGHT_GRAY);
		textEncoded.setForeground(Color.DARK_GRAY);
		getContentPane().add(textEncoded);
		keyWord_txtbox = new JTextField();
		keyWord_txtbox.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(keyWord_txtbox);
		keyLetter_txtbox = new JTextField();
		keyLetter_txtbox.setBackground(Color.LIGHT_GRAY);

		getContentPane().add(keyLetter_txtbox);
		t1 = new JLabel("Encoded Text:");
		t1.setBackground(Color.GRAY);
		t1.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(t1);
		t2 = new JLabel("Decoded Text:");
		t2.setBackground(Color.GRAY);
		t2.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(t2);
		t3 = new JLabel("(c) Artur Gruber, Eike Petersen, Patrick Strehlke");
		t3.setBackground(Color.GRAY);
		t3.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(t3);
		tw = new JLabel("Key Word:");
		tw.setBackground(Color.GRAY);
		tw.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(tw);
		tl = new JLabel("Key Letter:");
		tl.setBackground(Color.GRAY);
		tl.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(tl);
		t6 = new JLabel("select:");
		t6.setBackground(Color.GRAY);
		t6.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(t6);

	}

	/**
 * 
 */
	public void setButton() {
		select = new JComboBox<String>();

		select.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Aufgabe 1", "Aufgabe 2", "Aufgabe 3" }));
		select.setForeground(Color.DARK_GRAY);
		select.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(select);

		toggleButton = new JToggleButton();
		toggleButton.setForeground(Color.LIGHT_GRAY);
		toggleButton.setBackground(Color.GRAY);
		toggleButton.setText(toggleText);
		toggleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (toggleButton.isSelected()) {
					toggleButton.setBackground(Color.LIGHT_GRAY);
					toggleButton.setForeground(Color.GRAY);
					toggleText = "Encode";
					t1.setText("Decoded Text:");
					t2.setText("Encoded Text:");
				} else {
					toggleButton.setForeground(Color.LIGHT_GRAY);
					toggleButton.setBackground(Color.GRAY);
					toggleText = "Decode";
					t1.setText("Encoded Text:");
					t2.setText("Decoded Text:");
				}
				toggleButton.setText(toggleText);
				decode.setText(toggleText);
			}
		});

		getContentPane().add(toggleButton);

		decode = new JButton();
		decode.setBorderPainted(false);
		decode.setBackground(Color.LIGHT_GRAY);
		decode.setForeground(Color.DARK_GRAY);
		decode.setText(toggleText);

		this.getContentPane().add(decode);

	}

	/**
 * 
 */
	public void resize() {
		// ----------------------------------------------------------------
		decode.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * 0.1)));
		decode.setBounds((int) (getWidth() * 0.01), (int) (getHeight() * 0.84),
				(int) (getWidth() * 0.96), (int) (getHeight() * 0.077));
		// ----------------------------------------------------------------
		textDecoded.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		textDecoded.setBounds((int) (getWidth() * 0.01),
				(int) (getHeight() * 0.3), (int) (getWidth() * (0.96)),
				(int) (getHeight() * (0.2)));
		// ----------------------------------------------------------------
		textEncoded.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		textEncoded.setBounds((int) (getWidth() * 0.01),
				(int) (getHeight() * 0.6), (int) (getWidth() * (0.96)),
				(int) (getHeight() * (0.2)));

		// ----------------------------------------------------------------
		t2.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		t2.setBounds((int) (getWidth() * 0.1), (int) (getHeight() * 0.55),
				(int) (getWidth() * (0.3)), (int) (getHeight() * (0.05)));
		// ----------------------------------------------------------------
		t1.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		t1.setBounds((int) (getWidth() * 0.1), (int) (getHeight() * 0.25),
				(int) (getWidth() * (0.3)), (int) (getHeight() * (0.05)));
		// ----------------------------------------------------------------
		t3.setFont(new Font("Times New Roman", Font.BOLD, (int) (getHeight()
				* factor * 0.5)));
		t3.setBounds((int) (getWidth() * 0.75), (int) (getHeight() * 0.9),
				(int) (getWidth() * (0.2)), (int) (getHeight() * (0.05)));
		// -----------------------------------------------------------------
		tw.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		tw.setBounds((int) (getWidth() * 0.2), (int) (getHeight() * 0.1),
				(int) (getWidth() * (0.3)), (int) (getHeight() * (0.05)));
		// -----------------------------------------------------------------
		tl.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		tl.setBounds((int) (getWidth() * 0.2), (int) (getHeight() * 0.17),
				(int) (getWidth() * (0.3)), (int) (getHeight() * (0.05)));
		// -----------------------------------------------------------------
		t6.setFont(new Font("Times New Roman", Font.BOLD, (int) (getHeight()
				* factor * 0.75)));
		t6.setBounds((int) (getWidth() * 0.01), (int) (getHeight() * 0.01),
				(int) (getWidth() * (0.3)), (int) (getHeight() * (0.05)));
		// -----------------------------------------------------------------
		keyWord_txtbox.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		keyWord_txtbox.setBounds((int) (getWidth() * 0.3),
				(int) (getHeight() * 0.1), (int) (getWidth() * (0.5)),
				(int) (getHeight() * (0.05)));
		// -----------------------------------------------------------------
		keyLetter_txtbox.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		keyLetter_txtbox.setBounds((int) (getWidth() * 0.3),
				(int) (getHeight() * 0.17), (int) (getWidth() * (0.025)),
				(int) (getHeight() * (0.05)));
		// -----------------------------------------------------------------
		toggleButton.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		toggleButton.setBounds((int) (getWidth() * 0.3),
				(int) (getHeight() * spaceHead), (int) (getWidth() * 0.2),
				(int) (getHeight() * factor));
		// ----------------------------------------------------------------
		select.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor * 0.5)));
		select.setBounds((int) (getWidth() * 0.01), (int) (getHeight() * 0.05),
				(int) (getWidth() * (0.1)), (int) (getHeight() * (0.03)));
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
