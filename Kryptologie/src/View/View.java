package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class View extends JFrame {
	private JButton exit;

	public static void main(String[] args) {
		View v = new View();
	}

	View() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
//		width-=width/2;
//		height-=height/2;
		this.setResizable(true);
		this.setTitle("Kryptologie)");
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setUndecorated(true);
		
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		
		this.addComponentListener(new ComponentAdapter() 
		{  
		        public void componentResized(ComponentEvent evt) {
		        	
		        	exit.setBounds(getWidth()-20-getWidth()/30,10,getWidth()/20,getHeight()/30);
		        }
		});
		
		
		exit = new JButton();
		exit.setBorderPainted(false);
		exit.setBackground(Color.RED);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		//exit.setBounds(width-(width/20),height-(height/20),width/20,height/20);
		exit.setBounds(width-width/30,0,width/30,height/30);
		this.getContentPane().add(exit);
		
		this.getContentPane().setLayout(null);
		this.setVisible(true);
		
	}
}
