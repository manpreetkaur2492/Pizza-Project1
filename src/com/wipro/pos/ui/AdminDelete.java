package com.wipro.pos.ui;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.listener.Listener;
import com.wipro.pos.service.Administrator;

public class AdminDelete 
{
	public static JFrame frame;
	//public static JPanel frame;
	public static JButton buttonDelete,buttonBack;
	public static Choice choice;
	public static JLabel labelFoodId;
	
	public AdminDelete()
	{
		
		frame=new JFrame("Delete");
		frame.setSize(720, 680);
		frame.setResizable(false);
		frame.setLocation(100, 100);
		frame.setVisible(true);
		
frame.setLayout(null);
		
		//Background
				frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
				frame.setLayout(null);
		
		
		//frame=new JPanel();
		choice=new Choice();
		choice.setBounds(200, 100, 100, 20);
		
		buttonDelete=new JButton("Delete");
		buttonDelete.setBounds(300, 100, 100, 20);
		
		labelFoodId=new JLabel("FoodId");
		labelFoodId.setBounds(100, 100, 100, 20);
		
		buttonBack=new JButton("Back");
		buttonBack.setBounds(200, 300, 100, 20);
		
		frame.add(labelFoodId);
		frame.add(choice);
		frame.add(buttonDelete);
		frame.add(buttonBack);
		
		ArrayList<FoodBean> list=new ArrayList<FoodBean>();
		Administrator administrator = new Administrator();
		list=administrator.viewAllFood(null);
		
		Iterator<FoodBean> itr=list.iterator();
		while(itr.hasNext())
		{
			FoodBean flightBean = new FoodBean();
			flightBean=itr.next();
			AdminDelete.choice.add(flightBean.getFoodID());
		}
		
		//frame.add(frame);
		
		buttonDelete.addActionListener(new Listener(this));
		buttonBack.addActionListener(new Listener(this));
	}
}
