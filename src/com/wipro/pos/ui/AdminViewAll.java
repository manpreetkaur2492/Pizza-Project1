package com.wipro.pos.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.wipro.pos.listener.Listener;

public class AdminViewAll 
{
	public static JFrame frame;
	//public static JPanel frame;
	public static JButton buttonBack;
	
	public AdminViewAll()
	{
		frame=new JFrame("View");
		frame.setSize(720, 680);
		frame.setResizable(false);
		frame.setLocation(100, 100);
		
//frame.setLayout(null);
		
		//Background
				frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
				frame.setLayout(null);
		
		
		//frame=new JPanel(null);
		
		buttonBack=new JButton("Back");
		buttonBack.setBounds(250, 350, 90, 20);
		frame.add(buttonBack);
		
		//frame.add(frame);
		
		buttonBack.addActionListener(new Listener(this));
		frame.setVisible(true);
	}
}
