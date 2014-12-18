package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.lang.reflect.Method;

public class Luncher extends JFrame {

	private JPanel contentPane;
	private JButton exit;
	private JButton btnAufgabe1 = new JButton();
	private JButton btnAufgabe2 = new JButton();
	private JButton btnAufgabe3 = new JButton();
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
		int width = (int) (d.width * 0.25);
		int height = (int) (d.height * 0.25);

		width = 800;
		height = 600;

		this.setResizable(true);
		this.setTitle("Kryptologie)");
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		addButton(btnAufgabe1);
		addButton(btnAufgabe2);
		addButton(btnAufgabe3);
		addButton(btnAufgabe4);

		btnAufgabe1.setText("Zur Aufgabe 1");
		btnAufgabe2.setText("Zur Aufgabe 2");
		btnAufgabe3.setText("Zur Aufgabe 3");
		btnAufgabe4.setText("Zur Aufgabe 4");
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent evt) {

				exit.setBounds((int) (getWidth() * 0.9), 10,
						(int) (getWidth() * 0.05), (int) (getHeight() * 0.05));
				btnAufgabe1.setBounds((int) (getWidth() * 0.1),
						(int) (getHeight() * 0.3), (int) (getWidth() * 0.8),
						(int) (getHeight() * 0.075));
				btnAufgabe2.setBounds((int) (getWidth() * 0.1),
						(int) (getHeight() * 0.45), (int) (getWidth() * 0.8),
						(int) (getHeight() * 0.075));
				btnAufgabe3.setBounds((int) (getWidth() * 0.1),
						(int) (getHeight() * 0.60), (int) (getWidth() * 0.8),
						(int) (getHeight() * 0.075));
				btnAufgabe4.setBounds((int) (getWidth() * 0.1),
						(int) (getHeight() * 0.75), (int) (getWidth() * 0.8),
						(int) (getHeight() * 0.075));
				setButtonTextSize();
			}
		});

		exit = new JButton();
		exit.setBorderPainted(false);
		exit.setBackground(Color.RED);
		exit.setForeground(Color.BLACK);
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exit.setBounds((int) (width - width * 0.5), 0, width / 30, height / 30);
		this.getContentPane().add(exit);

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
				case "Zur Aufgabe 1":
					new ContA1();
					break;
				case "Zur Aufgabe 2":
					new ContA2();
					break;
				case "Zur Aufgabe 3":
					new ContA3();
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
		btnAufgabe1.setFont(new Font("Times New Roman", Font.BOLD, size));
		btnAufgabe2.setFont(new Font("Times New Roman", Font.BOLD, size));
		btnAufgabe3.setFont(new Font("Times New Roman", Font.BOLD, size));
		btnAufgabe4.setFont(new Font("Times New Roman", Font.BOLD, size));
	}
}
