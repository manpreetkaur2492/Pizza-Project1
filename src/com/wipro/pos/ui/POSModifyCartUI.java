package com.wipro.pos.ui;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.listener.Listener;
import com.wipro.pos.service.Administrator;

public class POSModifyCartUI {
	public static JFrame frame;
	//public static JPanel frame;
	public static JTextField textFoodID,textFoodtName,textFoodQuantity,textFoodPrice,textFoodType,TextFoodSize;
	public static JButton buttonUpdate,buttonCancel,buttonBack,buttonView;
	public static JLabel labelFoodID,labelFoodName,labelFoodQuantity,labelFoodPrice,labelFoodType,labelFoodSize;
	public static Choice choice;
	public  POSModifyCartUI()
	{
		frame=new JFrame("Update Cart");
		frame.setSize(720, 680);
		frame.setResizable(false);
		frame.setLocation(100, 100);
	
		
//frame.setLayout(null);
		
		//Background
				frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
				frame.setLayout(null);
		
		//frame=new JPanel(null);
		
		labelFoodID=new JLabel("CartID");
		labelFoodID.setBounds(100, 100, 100, 20);
		
		labelFoodName=new JLabel("Food Name");
		labelFoodName.setBounds(100, 140, 100, 20);
		
		labelFoodType=new JLabel("Quantity");
		labelFoodType.setBounds(100, 180, 100, 20);
		
		
		choice=new Choice();
		
		choice.setBounds(210, 140, 100, 20);
		
	/*	textFoodID=new JTextField();
		textFoodID.setBounds(250, 140, 100, 20);*/
		
		JTextField textcartid = new JTextField();
		textcartid.setBounds(250, 140, 100, 20);
		
		JTextField textQuantity = new JTextField();
		textQuantity.setBounds(250, 180, 100, 20);
		
		buttonUpdate=new JButton("Update");
		buttonUpdate.setBounds(100, 450, 100, 20);
		
		
		buttonBack=new JButton("Back");
		buttonBack.setBounds(320, 450, 100, 20);
		
		
		
		ArrayList<FoodBean> list=new ArrayList<FoodBean>();
		Administrator administrator = new Administrator();
		list=administrator.viewAllFood(null);
		
		Iterator<FoodBean> itr=list.iterator();
		while(itr.hasNext())
		{
			FoodBean FoodBean = new FoodBean();
			FoodBean=itr.next();
			AdminUpdate.choice.add(FoodBean.getName());
		}
		
		frame.add(labelFoodID);
		frame.add(textcartid);
		frame.add(labelFoodName);
		frame.add(choice);
		frame.add(labelFoodType);
		frame.add(textQuantity);
		
		frame.add(buttonUpdate);
	//	frame.add(buttonCancel);
		frame.add(buttonBack);
		//frame.add(buttonView);
		frame.setVisible(true);
	//	frame.add(frame);
		
		buttonUpdate.addActionListener(new Listener(this));
		//buttonCancel.addActionListener(new Listener(this));
		buttonBack.addActionListener(new Listener(this));
	//	buttonView.addActionListener(new Listener(this));
}
}
