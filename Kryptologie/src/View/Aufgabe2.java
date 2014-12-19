
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Aufgabe2 extends JFrame {
	int width;
	int height;
	double factor = 0.03;
	double spaceHead = 0.05;
	private TextArea textDecoded, textEncoded;
	private JTextField keyWord_txtbox;
	private JButton decode;
	private JLabel t1, t2, t3, t4;
	private JToggleButton toggleButton;
	private String toggleText = "Decode";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Aufgabe2 frame = new Aufgabe2();

	}

	/**
	 * Create the frame.
	 */
	public Aufgabe2() {

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) (d.width * 0.75);
		height = (int) (d.height * 0.75);

		
		setText();
		setButton();
		this.setResizable(true);
		this.setTitle("Kryptologie - Aufgabe 2");
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
		t1 = new JLabel("Decoded Text:");
		t1.setBackground(Color.GRAY);
		t1.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(t1);
		t2 = new JLabel("Encoded Text:");
		t2.setBackground(Color.GRAY);
		t2.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(t2);
		t3 = new JLabel("Vigenere Cipher");
		t3.setBackground(Color.GRAY);
		t3.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(t3);
		t4 = new JLabel("Key Word:");
		t4.setBackground(Color.GRAY);
		t4.setForeground(Color.LIGHT_GRAY);
		getContentPane().add(t4);
		
	}

	public void setButton() {
		
		toggleButton = new JToggleButton();
		toggleButton.setForeground(Color.LIGHT_GRAY);
		toggleButton.setBackground(Color.GRAY);
		toggleButton.setText(toggleText);
		toggleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(toggleButton.isSelected()){
					toggleButton.setBackground(Color.LIGHT_GRAY);
					toggleButton.setForeground(Color.GRAY);
					toggleText = "Encode";
					t1.setText("Decoded Text:");
					t2.setText("Encoded Text:");
				}else{
					toggleButton.setForeground(Color.LIGHT_GRAY);
					toggleButton.setBackground(Color.GRAY);
					toggleText="Decode";
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
				* factor * 0.75)));
		t3.setBounds((int) (getWidth() * 0.01), (int) (getHeight() * 0.01),
				(int) (getWidth() * (0.3)), (int) (getHeight() * (0.05)));
		// -----------------------------------------------------------------
		t4.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		t4.setBounds((int) (getWidth() * 0.2), (int) (getHeight() * 0.15),
				(int) (getWidth() * (0.3)), (int) (getHeight() * (0.05)));
		// -----------------------------------------------------------------
		keyWord_txtbox.setFont(new Font("Times New Roman", Font.BOLD, (int) (getHeight()
				* factor * 0.75)));
		keyWord_txtbox.setBounds((int) (getWidth() * 0.3), (int) (getHeight() * 0.15),
				(int) (getWidth() * (0.5)), (int) (getHeight() * (0.05)));
		// -----------------------------------------------------------------
		toggleButton.setFont(new Font("Times New Roman", Font.BOLD,
				(int) (getHeight() * factor)));
		toggleButton.setBounds((int) (getWidth() * 0.3),
				(int) (getHeight() * spaceHead), (int) (getWidth() * 0.2),
				(int) (getHeight() * factor));
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

