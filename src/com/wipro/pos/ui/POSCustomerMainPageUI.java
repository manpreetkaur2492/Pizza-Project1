package com.wipro.pos.ui;
import java.awt.Color;

import javax.swing.*;

import com.wipro.pos.listener.POSCustomerMainPageUIListener;
public class POSCustomerMainPageUI extends JFrame{
	public JPanel menuPanel,mainPanel,footerPanel;
	public JButton accountButton,viewButton,viewmodifyButton,viewOrderButton,cancelOrderButton,changePasswordButton,logoutButton,viewStoreButton,viewfButton;
	public JLabel mainLabel,footerLabel;
	public POSCustomerMainPageUI() {
	
		setTitle("Main Page");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Background
	    setContentPane(new JLabel(new ImageIcon("background.jpg")));
	    setLayout(null);
	    
		
		
		footerLabel=new JLabel("");
	
		
		footerPanel=new JPanel();
		footerPanel.add(footerLabel);
		footerPanel.setBackground(Color.gray);
		footerPanel.setBounds(20, 620,72, 60);
		//add(footerPanel);
		
		menuPanel=new JPanel(null);
		menuPanel.setBackground(Color.white);
		menuPanel.setBounds(20, 20,180, 600);
		
		accountButton=new JButton("Account");
		accountButton.setBounds(10, 10, 160, 25);
		
		viewButton=new JButton("View Cart");
		viewButton.setBounds(10, 50, 160, 25);
		viewButton.addActionListener(new POSCustomerMainPageUIListener(this));
		
		viewfButton=new JButton("View Food");
		viewfButton.setBounds(10, 90, 160, 25);
		viewfButton.addActionListener(new POSCustomerMainPageUIListener(this));
		
		viewOrderButton=new JButton("View Order");
		viewOrderButton.setBounds(10, 130, 160, 25);
		
		viewmodifyButton=new JButton("Modify cart");
		viewmodifyButton.setBounds(10, 170, 160, 25);
		viewmodifyButton.addActionListener(new POSCustomerMainPageUIListener(this));
		
		viewStoreButton=new JButton("View Store");
		viewStoreButton.setBounds(10, 210, 160, 25);
		
		/*cancelOrderButton=new JButton("Cancel Order");
		cancelOrderButton.setBounds(10, 170, 160, 25);
		*/
		
		changePasswordButton=new JButton("Change Password");
		changePasswordButton.setBounds(10, 210, 160, 25);
		
		logoutButton=new JButton("Logout");
		logoutButton.setBounds(10, 250, 160, 25);
		
		//menuPanel.add(accountButton);
		menuPanel.add(viewButton);
		menuPanel.add(viewStoreButton);
		menuPanel.add(viewOrderButton);
		viewOrderButton.addActionListener(new POSCustomerMainPageUIListener(this));
		viewStoreButton.addActionListener(new POSCustomerMainPageUIListener(this));
		menuPanel.add(changePasswordButton);
		changePasswordButton.addActionListener(new POSCustomerMainPageUIListener(this));
		
		
		menuPanel.add(viewfButton);
		viewfButton.addActionListener(new POSCustomerMainPageUIListener(this));
		
		menuPanel.add(logoutButton);
		logoutButton.addActionListener(new POSCustomerMainPageUIListener(this));
		mainPanel=new JPanel(null);
		mainPanel.setBounds(220, 20,460, 600);
		mainPanel.setBackground(Color.white);
		
		mainLabel=new JLabel("Welcome Customer!!");
		mainLabel.setBounds(180, 40,150, 30);
		mainPanel.add(mainLabel);
		add(mainPanel);
		
		add(menuPanel);
		setSize(720, 680);
		setVisible(true);
	}
//	public static void main (String args[]){
	//	new POSCustomerMainPageUI();
	//}
}
