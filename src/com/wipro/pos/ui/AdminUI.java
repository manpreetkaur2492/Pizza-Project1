package com.wipro.pos.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.wipro.pos.listener.Listener;

public class AdminUI 
{
	public static JFrame frame;
	//public static JPanel frame;
	public static JMenuBar menuBar;
	public static JMenu menuFlight,menuSchedule,menuRoute,menuPassenger;
	public static JMenuItem item1Add,item1Update,item1Delete,item1ViewAll,item1View,
	item2Add,item2Update,item2Delete,item2ViewAll,item2View,
	item3Add,item3Update,item3Delete,item3ViewAll,
	item4View;
	public static JButton buttonLogout;
	
	
	public AdminUI()
	{
		frame=new JFrame("Administrator Main Page");
		frame.setSize(720, 680);
		frame.setResizable(false);
		frame.setLocation(100, 100);
		frame.setVisible(true);
		
		frame.setLayout(null);
		
		//Background
				frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
				//frame.setLayout(null);
		
		//frame=new JPanel(null);
		
		buttonLogout=new JButton("Logout");
		buttonLogout.setBounds(550, 10, 80, 30);
		frame.add(buttonLogout);
		
		menuBar=new JMenuBar();
		menuBar.setBounds(250, 10,230, 30);
		frame.add(menuBar);
		
		
		menuFlight=new JMenu("Food");
		item1Add=new JMenuItem("Add food");
		item1Update=new JMenuItem("Update food");
		item1Delete=new JMenuItem("Delete food");
		item1ViewAll=new JMenuItem("View all food");
		item1View=new JMenuItem("View By Id");
		menuFlight.add(item1Add);
		menuFlight.add(item1Delete);
		menuFlight.add(item1Update);
		menuFlight.add(item1ViewAll);
		menuFlight.add(item1View);
		menuBar.add(menuFlight);
		
		
		menuRoute=new JMenu("store");
		item2Add=new JMenuItem("Add store");
		item2Update=new JMenuItem("Update store");
		item2Delete=new JMenuItem("Delete store");
		item2ViewAll=new JMenuItem("View all store");
		item2View = new JMenuItem("View By Id");
		menuRoute.add(item2Add);
		menuRoute.add(item2Delete);
		menuRoute.add(item2Update);
		menuRoute.add(item2ViewAll);
		menuRoute.add(item2View);
		menuBar.add(menuRoute);
		
		
		menuSchedule=new JMenu("Order");
	//	item3Add=new JMenuItem("Add Order");
		item3Update=new JMenuItem("Update Order");
		//item3Delete=new JMenuItem("Delete Order");
		item3ViewAll=new JMenuItem("View all Order");
	//	menuSchedule.add(item3Add);
	//	menuSchedule.add(item3Delete);
		menuSchedule.add(item3Update);
		menuSchedule.add(item3ViewAll);
		
		menuBar.add(menuSchedule);
		
		
		menuPassenger=new JMenu("Customer");
		item4View=new JMenuItem("View Customer");
		menuPassenger.add(item4View);
		menuBar.add(menuPassenger);
		
		
		item1Add.addActionListener(new Listener(this));
		item1Update.addActionListener(new Listener(this));
		item1Delete.addActionListener(new Listener(this));
		item1ViewAll.addActionListener(new Listener(this));
		item1View.addActionListener(new Listener(this));
		item2Add.addActionListener(new Listener(this));
		item2Update.addActionListener(new Listener(this));
		item2Delete.addActionListener(new Listener(this));
		item2ViewAll.addActionListener(new Listener(this));
		item2View.addActionListener(new Listener(this));
		//item3Add.addActionListener(new Listener(this));
		item3Update.addActionListener(new Listener(this));
		//item3Delete.addActionListener(new Listener(this));
		item3ViewAll.addActionListener(new Listener(this));
		item4View.addActionListener(new Listener(this));
		buttonLogout.addActionListener(new Listener(this));
		/*
		buttonAdd=new JButton("Add");
		buttonDelete=new JButton("Delete");
		buttonViewById=new JButton("View by ID");
		buttonUpdate=new JButton("Update");
		buttonViewAll=new JButton("View All");
		
		panel1.add(buttonAdd);
		panel1.add(buttonDelete);
		panel1.add(buttonUpdate);
		panel1.add(buttonViewById);
		panel1.add(buttonViewAll);
		
		
		
		buttonAdd.addActionListener(new Listener(this));
		buttonDelete.addActionListener(new Listener(this));
		buttonViewById.addActionListener(new Listener(this));
		buttonUpdate.addActionListener(new Listener(this));
		buttonViewAll.addActionListener(new Listener(this));*/
		
		//frame.add(frame);
	}
}
