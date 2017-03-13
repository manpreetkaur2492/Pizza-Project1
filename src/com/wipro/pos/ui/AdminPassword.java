package com.wipro.pos.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import com.wipro.pos.listener.Listener;

public class AdminPassword 
{
	public static JFrame frame;
	//public static JPanel frame;
	public static JPasswordField textPassword,textReEnter;
	public static JButton buttonSubmit,buttonCancel;
	public static JLabel labelPassword,LabelReEnter,labelInfo;
	
	public AdminPassword()
	{
		frame=new JFrame("Change Admin Password");
		frame.setSize(720, 680);
		frame.setResizable(false);
		frame.setLocation(100, 100);
		
frame.setLayout(null);
		
		//Background
				frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
				frame.setLayout(null);
		
	//frame=new JPanel(null);
		//frame.setBackground(Color.cyan);
		
				labelInfo=new JLabel("You need to change your password on first login!!!");
				labelInfo.setBounds(100, 50, 400, 20);
		frame.add(labelInfo);
		
		/*labelPassword=new JLabel("User Id");
		labelPassword.setBounds(100, 100, 150, 20);
		frame.add(labelPassword);*/
		
		labelPassword=new JLabel("New Password");
		labelPassword.setBounds(100, 100, 150, 20);
		frame.add(labelPassword);
		
		textPassword=new JPasswordField();
		textPassword.setBounds(250, 100, 100, 20);
		frame.add(textPassword);
		
		LabelReEnter=new JLabel("Re-Enter Password");
		LabelReEnter.setBounds(100, 150, 150, 20);
		frame.add(LabelReEnter);
		
		textReEnter=new JPasswordField();
		textReEnter.setBounds(250, 150, 100, 20);
		frame.add(textReEnter);
		
		buttonSubmit=new JButton("Submit");
		buttonSubmit.setBounds(100, 200, 80, 20);
		frame.add(buttonSubmit);
		
		buttonCancel=new JButton("Cancel");
		buttonCancel.setBounds(250, 200, 80, 20);
		frame.add(buttonCancel);
		
	//	frame.add(frame);
		
		
		
		buttonSubmit.addActionListener(new Listener(this));
		buttonCancel.addActionListener(new Listener(this));
		frame.setVisible(true);
	}
}
