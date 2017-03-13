/*package com.wipro.pos.ui;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.wipro.pos.listener.CancelOrderListener;

public class CancelOrderFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	public static JFrame frame;
	public static JLabel label,label1,label2,creditcardnumber;
	public static JTextField textorderID,seatnumbertext,creditcardnumbertext;
	public static JButton buttonCancel,buttonBack,buttonView;
	public static JButton backButton;
	public CancelOrderFrame()
	{
		frame=new JFrame("Cancel Order");
		frame.setSize(720,680);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocation(100, 100);
		

		//Background
	   frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
	   frame.setLayout(null);
	    
	    backButton=new JButton("Back");
		backButton.setBounds(210, 450, 105, 25);
		backButton.addActionListener(new CancelOrderListener(this));
		frame.add(backButton);

	    
		label=new JLabel("Enter order ID");
		label.setBounds(20, 120, 130, 25);
		frame.add(label);
		
		textorderID=new JTextField();
		textorderID.setBounds(160, 120, 105, 25);
		frame.add(textorderID);
		
		/*seatnumber=new JLabel("Enter seat number to be cancelled");
		seatnumber.setBounds(20,350, 200, 25);
		seatnumber.setVisible(false);
		frame.add(seatnumber);*/
		
		/*seatnumbertext=new JTextField();
		seatnumbertext.setVisible(false);
		seatnumbertext.setBounds(250, 350, 105, 25);
		
		frame.add(seatnumbertext);
		
		creditcardnumber=new JLabel("Enter credit card number");
		creditcardnumber.setBounds(20,220, 130, 25);
		//creditcardnumber.setVisible(false);
		frame.add(creditcardnumber);
		
		creditcardnumbertext=new JTextField();
		creditcardnumbertext.setBounds(160, 220, 105, 25);
		//creditcardnumbertext.setVisible(false);
		frame.add(creditcardnumbertext);
		
		buttonView=new JButton("View");
		buttonView.setBounds(100, 450, 105, 25);
		frame.add(buttonView);
		
		buttonCancel=new JButton("Cancel Order");
		buttonCancel.setBounds(100, 450, 100, 25);
		buttonCancel.setVisible(false);
		frame.add(buttonCancel);
		

	    label2=new JLabel("Cancel Order");
	    label2.setFont(new Font("Papyrus", Font.ITALIC, 30));
	    label2.setBounds(250, 20, 300, 50);
	    frame.add(label2);
	    
	    buttonView.addActionListener(new CancelOrderListener(this));
		buttonCancel.addActionListener(new CancelOrderListener(this));
		
		frame.setVisible(true);
		
		
	}*/
	//public static void main(String args[]){
		//new CancelOrderFrame();
//	}


