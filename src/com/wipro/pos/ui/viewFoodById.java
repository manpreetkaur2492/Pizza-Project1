package com.wipro.pos.ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.wipro.pos.listener.ViewFoodListener;

public class viewFoodById extends JFrame{
	public JTable table;
	public JLabel label;
	public DefaultTableModel model;
	public Object object[]=new  Object[6];
	public JButton ButtonBack,ButtonView;
	
	public viewFoodById()
	{

		setTitle("View Food");

		setSize(720,680);
		setResizable(false);
		setLayout(null);
		setLocation(100, 100);


		
		//Background
				setContentPane(new JLabel(new ImageIcon("background.jpg")));
				setLayout(null);
		
		label=new JLabel("View Food");
		label.setBounds(300, 10, 250, 40);
		label.setBackground(Color.orange);
		add(label);



		ButtonView=new JButton("View");
		ButtonView.setBounds(360,60,80,20);
		ButtonView.setBackground(Color.orange);
		add(ButtonView);

		ButtonBack=new JButton("Back");
		ButtonBack.setBounds(200,60,80,20);
		ButtonBack.setBackground(Color.orange);
		add(ButtonBack);
		
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
		add(table);

		
		ButtonView.addActionListener(new ViewFoodListener(this));
		ButtonBack.addActionListener(new ViewFoodListener(this));
		setVisible(true);

	}
}
