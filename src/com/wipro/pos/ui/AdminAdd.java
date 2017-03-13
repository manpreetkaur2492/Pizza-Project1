package com.wipro.pos.ui;

import java.awt.Choice;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.wipro.pos.listener.Listener;

public class AdminAdd 
{
	public static JFrame frame;
	//public static JPanel frame;
	public static JTextField textFoodID,textFoodtName,textFoodQuantity,textFoodPrice,textFoodType,TextFoodSize;
	public static JButton buttonAdd,buttonCancel,buttonBack;
	public static JLabel labelFoodID,labelFoodName,labelFoodQuantity,labelFoodPrice,labelFoodType,labelFoodSize;
	public static Choice choice;
	
	public AdminAdd()
	{
		frame=new JFrame("Add Food");
		frame.setSize(720, 680);
		frame.setResizable(false);
		frame.setLocation(100, 100);
		frame.setVisible(true);
		frame.setLayout(null);
		
		//Background
				frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
				//frame.setLayout(null);
			    
		
		//frame=new JPanel(null);
		
		/*labelFoodID=new JLabel("FoodID");
		labelFoodID.setBounds(100, 100, 150, 20);
		frame.add(labelFoodID);*/
		
		labelFoodName=new JLabel("Food Name");
		labelFoodName.setBounds(100, 100, 150, 20);
		frame.add(labelFoodName);
		
		labelFoodName=new JLabel("Food Type");
		labelFoodName.setBounds(100, 150, 150, 20);
		frame.add(labelFoodName);
		
		labelFoodName=new JLabel("Food Size");
		labelFoodName.setBounds(100, 200, 150, 20);
		frame.add(labelFoodName);
		
		labelFoodQuantity=new JLabel("Food Quantity");
		labelFoodQuantity.setBounds(100, 250, 150, 20);
		frame.add(labelFoodQuantity);
		
		labelFoodPrice=new JLabel("Food Price");
		labelFoodPrice.setBounds(100, 300, 150, 20);
		frame.add(labelFoodPrice);
		
		
		/*textFoodID=new JTextField();
		textFoodID.setEditable(false);
		textFoodID.setBounds(250, 100, 100, 20);
		frame.add(textFoodID);*/
		
		textFoodtName=new JTextField();
		textFoodtName.setBounds(250, 100, 100, 20);
		frame.add(textFoodtName);
		
		
		textFoodType=new JTextField();
		textFoodType.setBounds(250, 150, 100, 20);
		frame.add(textFoodType);
		
		TextFoodSize=new JTextField();
		TextFoodSize.setBounds(250, 200, 100, 20);
		frame.add(TextFoodSize);
		
		textFoodQuantity=new JTextField();
		textFoodQuantity.setBounds(250, 250, 100, 20);
		frame.add(textFoodQuantity);
		
		textFoodPrice=new JTextField();
		textFoodPrice.setBounds(250, 300, 100, 20);
		frame.add(textFoodPrice);
		
		
		buttonAdd=new JButton("Add");
		buttonAdd.setBounds(100, 450, 100, 20);
		frame.add(buttonAdd);
		
		buttonCancel=new JButton("Cancel");
		buttonCancel.setBounds(210, 450, 100, 20);
		frame.add(buttonCancel);
		
		buttonBack=new JButton("Back");
		buttonBack.setBounds(320, 450, 100, 20);
		frame.add(buttonBack);
		
		//frame.add(frame);
		
		buttonAdd.addActionListener(new Listener(this));
		buttonCancel.addActionListener(new Listener(this));
		buttonBack.addActionListener(new Listener(this));
	}
/*	public static void main(String args[]){
		new AdminAdd();
	}*/
}
