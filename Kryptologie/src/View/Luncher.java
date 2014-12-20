package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Luncher extends JFrame {


	private JButton btnAufgabe1_3 = new JButton();
	private JButton btnAufgabe4 = new JButton();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Luncher frame = new Luncher();

	}

	/**
	 * Create the frame.
	 */
	public Luncher() {

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (d.width *0.3);
		int height = (int) (d.height*0.3);


		this.setResizable(true);
		this.setTitle("Kryptologie)");
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		addButton(btnAufgabe1_3);
		addButton(btnAufgabe4);

		btnAufgabe1_3.setText("Zur Aufgabe 1-3");
		
		btnAufgabe4.setText("Zur Aufgabe 4");
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent evt) {

				
				btnAufgabe1_3.setBounds((int) (getWidth() * 0.1),
						(int) (getHeight() * 0.25), (int) (getWidth() * 0.8),
						(int) (getHeight() * 0.15));
				
				btnAufgabe4.setBounds((int) (getWidth() * 0.1),
						(int) (getHeight() * 0.5), (int) (getWidth() * 0.8),
						(int) (getHeight() * 0.15));
				setButtonTextSize();
			}
		});


		this.getContentPane().setLayout(null);
		this.setVisible(true);

	}

	public void addButton(JButton button) {

		button.setBorderPainted(false);
		button.setBackground(Color.GRAY);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(((JButton) e.getSource()).getText());
				switch (((JButton) e.getSource()).getText()) {
				case "Zur Aufgabe 1-3":
					new ContA1_3();
					break;
				
				case "Zur Aufgabe 4":
					new ContA4();
					break;
				}

			}
		});
		this.getContentPane().add(button);
	}

	public void setButtonTextSize() {
		int size = (int) (getHeight() * 0.075);
		btnAufgabe1_3.setFont(new Font("Times New Roman", Font.BOLD, size));
		btnAufgabe4.setFont(new Font("Times New Roman", Font.BOLD, size));
	}
}
