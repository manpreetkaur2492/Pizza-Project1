package com.wipro.pos.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//import com.wipro.pos.listener.POSCustomerViewBookPageListener;
import com.wipro.pos.listener.POSLoginListener;

public class POSLoginUI extends JFrame {
	
	public JLabel userIdLabel,passwordLabel;
	public JTextField userIdTextField;
	public JPasswordField passwordField;
	public JButton loginbutton,cancelbutton;
	public JCheckBox rememberBox;
	
	
	public POSLoginUI() {
	
		setTitle("Login");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Background
	    setContentPane(new JLabel(new ImageIcon("background.jpg")));
	    setLayout(null);
	    
		
		userIdLabel=new JLabel("Enter Username : ");
		userIdLabel.setBounds(150, 150, 150, 25);
		add(userIdLabel);
		userIdTextField=new JTextField();
		userIdTextField.setBounds(260, 150, 150, 25);
		add(userIdTextField);
		
		passwordLabel=new JLabel("Enter Password : ");
		passwordLabel.setBounds(150, 200, 150, 25);
		add(passwordLabel);
		passwordField=new JPasswordField();
		passwordField.setBounds(260, 200, 150, 25);
		add(passwordField);
		
		loginbutton=new JButton("LOGIN");
	    loginbutton.setBounds(150, 250, 120, 25);
	    loginbutton.addActionListener(new 	POSLoginListener(this));
	    add(loginbutton);
	    
	    cancelbutton=new JButton("CANCEL");
	    cancelbutton.setBounds(290, 250, 120, 25);
	    cancelbutton.addActionListener(new POSLoginListener(this));
	    add(cancelbutton);
	    
	    setResizable(false);
	    setSize(720, 680);
		setVisible(true);
		
	}

}
