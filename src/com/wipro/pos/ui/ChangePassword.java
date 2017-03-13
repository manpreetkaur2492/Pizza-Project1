package com.wipro.pos.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.wipro.pos.listener.Listener;

public class ChangePassword 
{

	public static JFrame frame;
	//public static JPanel frame;
	public static JTextField textUserID;
	public static JPasswordField textOldPassword,textNewPassword,textReEnter;
	public static JButton buttonSubmit,buttonCancel,buttonBack;
	public static JLabel labelUserID,labelOldPassword,labelNewPassword,LabelReEnter;
	
	public ChangePassword()
	{
		frame=new JFrame("Change Password");
		frame.setSize(720, 680);
		frame.setResizable(false);
		frame.setLocation(100, 100);
		
		
//frame.setLayout(null);
		
		//Background
				frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
				frame.setLayout(null);
		
		//frame=new JPanel(null);
		
		labelUserID=new JLabel("UserId");
		labelUserID.setBounds(100, 100, 150, 20);
		frame.add(labelUserID);
		
		textUserID=new JTextField();
		textUserID.setBounds(250, 100, 100, 20);
		frame.add(textUserID);
		
		labelOldPassword=new JLabel("Old Password");
		labelOldPassword.setBounds(100, 150, 150, 20);
		frame.add(labelOldPassword);
		
		textOldPassword=new JPasswordField();
		textOldPassword.setBounds(250, 150, 100, 20);
		frame.add(textOldPassword);
		
		labelNewPassword=new JLabel("New Password");
		labelNewPassword.setBounds(100, 200, 150, 20);
		frame.add(labelNewPassword);
		
		textNewPassword=new JPasswordField();
		textNewPassword.setBounds(250, 200, 100, 20);
		frame.add(textNewPassword);
		
		
		LabelReEnter=new JLabel("Re-Enter Password");
		LabelReEnter.setBounds(100, 250, 150, 20);
		frame.add(LabelReEnter);
		
		textReEnter=new JPasswordField();
		textReEnter.setBounds(250, 250, 100, 20);
		frame.add(textReEnter);
		
		buttonSubmit=new JButton("Submit");
		buttonSubmit.setBounds(100, 300, 80, 20);
		frame.add(buttonSubmit);
		
		buttonCancel=new JButton("Cancel");
		buttonCancel.setBounds(250, 300, 80, 20);
		frame.add(buttonCancel);
		
		buttonBack=new JButton("Back");
		buttonBack.setBounds(400, 300, 80, 20);
		frame.add(buttonBack);
		
		//frame.add(frame);

		frame.setVisible(true);
		buttonBack.addActionListener(new Listener(this));
		buttonSubmit.addActionListener(new Listener(this));
		buttonCancel.addActionListener(new Listener(this));
		
		
	}
}
