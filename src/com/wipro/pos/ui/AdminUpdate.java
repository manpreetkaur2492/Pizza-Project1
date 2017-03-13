package com.wipro.pos.ui;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.listener.Listener;
import com.wipro.pos.service.Administrator;

public class AdminUpdate 
{
	public static JFrame frame;
	//public static JPanel frame;
	public static JTextField textFoodID,textFoodtName,textFoodQuantity,textFoodPrice,textFoodType,TextFoodSize;
	public static JButton buttonUpdate,buttonCancel,buttonBack,buttonView;
	public static JLabel labelFoodID,labelFoodName,labelFoodQuantity,labelFoodPrice,labelFoodType,labelFoodSize;
	public static Choice choice;
	
	public AdminUpdate()
	{
		frame=new JFrame("Update Food");
		frame.setSize(720, 680);
		frame.setResizable(false);
		frame.setLocation(100, 100);
	
		
//frame.setLayout(null);
		
		//Background
				frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
				frame.setLayout(null);
		
		//frame=new JPanel(null);
		
		labelFoodID=new JLabel("FoodID");
		labelFoodID.setBounds(100, 100, 100, 20);
		
		labelFoodName=new JLabel("Food Name");
		labelFoodName.setBounds(100, 140, 100, 20);
		
		labelFoodType=new JLabel("Food Type");
		labelFoodType.setBounds(100, 180, 100, 20);
		
		labelFoodSize=new JLabel("Food Size");
		labelFoodSize.setBounds(100, 220, 100, 20);
		
		labelFoodQuantity=new JLabel("Food Quantity");
		labelFoodQuantity.setBounds(100, 260, 100, 20);
		
		labelFoodPrice=new JLabel("Food Price");
		labelFoodPrice.setBounds(100, 300, 100, 20);
		
		choice=new Choice();
		
		choice.setBounds(250, 100, 100, 20);
		
	/*	textFoodID=new JTextField();
		textFoodID.setBounds(250, 140, 100, 20);*/
		
		textFoodtName=new JTextField();
		textFoodtName.setBounds(250, 140, 100, 20);
		
		textFoodType=new JTextField();
		textFoodType.setBounds(250, 180, 100, 20);
		
		TextFoodSize=new JTextField();
		TextFoodSize.setBounds(250, 220, 100, 20);
		
		textFoodQuantity=new JTextField();
		textFoodQuantity.setBounds(250, 260, 100, 20);
		
		textFoodPrice=new JTextField();
		textFoodPrice.setBounds(250, 300, 100, 20);
		
		
		buttonUpdate=new JButton("Update");
		buttonUpdate.setBounds(100, 450, 100, 20);
		
		buttonCancel=new JButton("Cancel");
		buttonCancel.setBounds(210, 450, 100, 20);
		
		buttonBack=new JButton("Back");
		buttonBack.setBounds(320, 450, 100, 20);
		
		buttonView=new JButton("View");
		buttonView.setBounds(430, 450, 100, 20);
		
		ArrayList<FoodBean> list=new ArrayList<FoodBean>();
		Administrator administrator = new Administrator();
		list=administrator.viewAllFood(null);
		
		Iterator<FoodBean> itr=list.iterator();
		while(itr.hasNext())
		{
			FoodBean FoodBean = new FoodBean();
			FoodBean=itr.next();
			AdminUpdate.choice.add(FoodBean.getFoodID());
		}
		
		frame.add(labelFoodID);
		frame.add(choice);
		frame.add(labelFoodName);
		frame.add(textFoodtName);
		frame.add(labelFoodQuantity);
		frame.add(textFoodQuantity);
		frame.add(labelFoodType);
		frame.add(textFoodType);
		frame.add(labelFoodSize);
		frame.add(TextFoodSize);
		frame.add(labelFoodPrice);
		frame.add(textFoodPrice);
		frame.add(buttonUpdate);
		frame.add(buttonCancel);
		frame.add(buttonBack);
		frame.add(buttonView);
		frame.setVisible(true);
	//	frame.add(frame);
		
		buttonUpdate.addActionListener(new Listener(this));
		buttonCancel.addActionListener(new Listener(this));
		buttonBack.addActionListener(new Listener(this));
		buttonView.addActionListener(new Listener(this));
	}
	/*public static void main (String args[]){
		new AdminUpdate();
	}*/
}
