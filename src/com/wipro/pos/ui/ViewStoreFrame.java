package com.wipro.pos.ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.wipro.pos.listener.ViewStoreListener;

public class ViewStoreFrame extends JFrame
{

	public JTable table;
	public JLabel label;
	public DefaultTableModel model;
	public Object object[]=new  Object[7];
	public JButton ButtonBack,ButtonView;
	
	public ViewStoreFrame()
	{

		setTitle("View Route");

		setSize(720,680);
		setResizable(false);
		setLayout(null);
		setLocation(100, 100);


		
		//Background
				setContentPane(new JLabel(new ImageIcon("background.jpg")));
				setLayout(null);
		
		label=new JLabel("View All Store");
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
		model.addColumn("street");
		model.addColumn("mobileno");
		model.addColumn("city");
		model.addColumn("state");
		model.addColumn("pincode");
		table=new JTable(model);
		//table.setBounds(100, 200,500,400);
		table.setBackground(Color.LIGHT_GRAY);
		table.setVisible(false);
		add(table);

		
		ButtonView.addActionListener(new ViewStoreListener(this));
		ButtonBack.addActionListener(new ViewStoreListener(this));
		setVisible(true);

	}


	/*public static void main(String args[])
	{
		new ViewRouteFrame();
	}

*/
}
