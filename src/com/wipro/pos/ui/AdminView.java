package com.wipro.pos.ui;

import java.awt.Choice;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.listener.ViewFoodListener;
import com.wipro.pos.service.Administrator;

public class AdminView {

	public static JFrame frame;
	//public static JPanel frame;
	public static JButton buttonBack,buttonView;
	public static Choice choice;
	public static JLabel labelFoodId;
	public static DefaultTableModel model;
	public static Object object[]=new  Object[6];
	public static JTable table;
	public AdminView(){
		frame=new JFrame("View By Id");
		frame.setSize(720, 680);
		frame.setResizable(false);
		frame.setLocation(100, 100);
		
		choice=new Choice();
		choice.setBounds(200, 100, 100, 20);
		buttonView=new JButton("View");
		buttonView.setBounds(400, 100, 100, 20);
		
		frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
		frame.setLayout(null);
		
		labelFoodId=new JLabel("FoodId");
		labelFoodId.setBounds(100, 100, 100, 20);
model=new DefaultTableModel();
		
		model.addColumn("ID");
		model.addColumn("name");
		model.addColumn("Type");
		model.addColumn("FoodSize");
		model.addColumn("Quantity");
		model.addColumn("Price");
		//model.addColumn("pincode");
		table=new JTable(model);
		//table.setBounds(100, 200,500,400);
		table.setBackground(Color.LIGHT_GRAY);
		table.setVisible(false);
		frame.add(table);

		
		buttonBack=new JButton("Back");
		buttonBack.setBounds(520, 100, 100, 20);
		frame.add(buttonBack);
		frame.add(buttonView);
		buttonView.addActionListener(new ViewFoodListener(this));
		buttonBack.addActionListener(new ViewFoodListener(this));
		
		ArrayList<FoodBean> list=new ArrayList<FoodBean>();
		Administrator administrator = new Administrator();
		list=administrator.viewAllFood(null);
		
		Iterator<FoodBean> itr=list.iterator();
		while(itr.hasNext())
		{
			FoodBean flightBean = new FoodBean();
			flightBean=itr.next();
			AdminView.choice.add(flightBean.getFoodID());
		}
		
		frame.add(labelFoodId);
		frame.add(choice);
		
		frame.setVisible(true);
	}
	/*public static void main(String args[]){
		new AdminView();
	}*/
}
