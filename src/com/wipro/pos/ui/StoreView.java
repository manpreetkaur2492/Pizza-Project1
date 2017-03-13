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
import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.listener.ViewStoreIdListener;
import com.wipro.pos.service.Administrator;

public class StoreView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTable table;
	public JLabel label;
	public static Choice choice;
	public static JLabel labelStoreId;
	public DefaultTableModel model;
	public Object object[]=new  Object[8];
	public static JButton ButtonBack;
	public static JButton ButtonView;
	
	public StoreView()
	{

		setTitle("View Store");

		setSize(720,680);
		setResizable(false);
		setLayout(null);
		setLocation(100, 100);


		
		//Background
				setContentPane(new JLabel(new ImageIcon("background.jpg")));
				setLayout(null);
				choice=new Choice();
				choice.setBounds(200, 100, 100, 20);
				labelStoreId=new JLabel("StoreId");
				labelStoreId.setBounds(100, 100, 100, 20);
		label=new JLabel("View Store");
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
		model.addColumn("Street");
		model.addColumn("MobileNo");
		model.addColumn("City");
		model.addColumn("State");
		model.addColumn("pincode");
		table=new JTable(model);
		//table.setBounds(100, 200,500,400);
		table.setBackground(Color.LIGHT_GRAY);
		table.setVisible(false);
		add(table);
		add(labelStoreId);
		add(choice);

		ArrayList<StoreBean> list=new ArrayList<StoreBean>();
		Administrator administrator = new Administrator();
		list=administrator.viewAllStore();
		
		Iterator<StoreBean> itr=list.iterator();
		while(itr.hasNext())
		{
			StoreBean flightBean = new StoreBean();
			flightBean=itr.next();
			StoreView.choice.add(flightBean.getStoreID());
		}
		ButtonView.addActionListener(new ViewStoreIdListener(this));
		ButtonBack.addActionListener(new ViewStoreIdListener(this));
		setVisible(true);

	}
}
