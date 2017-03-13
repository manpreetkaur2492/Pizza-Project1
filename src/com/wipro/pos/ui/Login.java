package com.wipro.pos.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.wipro.pos.bean.CredentialsBean;
import com.wipro.pos.listener.Listener;
import com.wipro.pos.util.AuthenticationImpl;
import com.wipro.pos.util.UserImpl;

public class Login {

	public static JFrame frame;
	public static JPanel panel1;
	public static JTextField textUserID;
	public static JPasswordField textPassword;
	public static JButton buttonLogin,buttonSignUp;
	public static JCheckBox rememberBox;
	public static JLabel label1,labelUserId,labelPssword,labelClick,labelForgot;
	UserImpl user;
	public Login(){
		frame=new JFrame("Login page");
		frame.setSize(720,680);
		frame.setResizable(false);
		frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
		frame.setLayout(null);
		panel1=new JPanel(null);
		panel1.setBounds(20, 100, 550, 300);
		panel1.setBackground(Color.white);
		label1=new JLabel("Pizza Ordering System");
		label1.setFont(new Font("Papyrus",Font.ITALIC,25));
		label1.setBounds(110,30,500,40);
		panel1.add(label1);
		buttonSignUp= new JButton("Sign Up");
		buttonSignUp.setBounds(350, 230, 100, 20);
		panel1.add(buttonSignUp);
		labelForgot= new JLabel("Forgot Your Password?");
		labelForgot.setBounds(160, 500, 300, 20);
		panel1.add(labelForgot);
		labelClick=new JLabel("Click here to reset it");
		labelClick.setBounds(300,500,300,20);
		panel1.add(labelClick);
		labelUserId=new JLabel ("User Id");
		labelUserId.setBounds(100,100,80,40);
		panel1.add(labelUserId);
		textUserID = new JTextField();
		textUserID.setBounds(200,100,200,30);
		panel1.add(textUserID);
		labelPssword=new JLabel ("Password");
		labelPssword.setBounds(100,150,80,40);
		panel1.add(labelPssword);
		textPassword =new JPasswordField();
		textPassword.setBounds(200,150,200,30);
		panel1.add(textPassword);
		buttonLogin = new JButton("Login");
		buttonLogin.setBounds(350, 200, 100, 20);
		panel1.add(buttonLogin);
		rememberBox=new JCheckBox("Remember me on this computer");
		rememberBox.setBounds(100,200,250,30);
		rememberBox.setBackground(Color.white);
		panel1.add(rememberBox);
		buttonSignUp.addActionListener(new Listener(this));
		buttonLogin.addActionListener(new Listener(this));
		labelClick.addMouseListener(new Listener(this));
		frame.setVisible(true);
		frame.add(panel1);
		//String arr[];
		user = new UserImpl();
		try{
			AuthenticationImpl auth=new AuthenticationImpl();
		//	arr=user.getRememberedData();
		//	textUserID.setText(arr[0]);
		//	textPassword.setText(arr[1]);
			String userId=textUserID.getText();
			//@SuppressWarnings("deprecation")
			char[] password=textPassword.getPassword();
			String output1 = new String(password);
			//int length=output1.length();
		//	System.out.println(length);
			for(int i=0;i<password.length;i++){
				System.out.print(password[i]);
			}
			for(int i=0;i<password.length;i++){
				System.out.print(password[i]);
			}
			CredentialsBean cred=new CredentialsBean();
			CredentialsBean cb = new CredentialsBean();
			cred.setUserID(userId);
			cred.setPassword(output1);
			boolean result=auth.authenticate(cred);
			if(result==true){
				cb=auth.authenticate(cred.getUserID());
				if(cb.getLoginStatus()==1){
					if(cb.getUserType().equalsIgnoreCase("a")){
						new AdminUI();
						frame.dispose();
					}
					else{
						new POSCustomerMainPageUI();
						Login.frame.dispose();
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		new Login();
	}
}
