package com.wipro.pos.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.wipro.pos.listener.POSCustomerViewCartPageListener;

public class POSViewCartUI extends JPanel{
	public JLabel cityl,MainLabel;
	public JTextField city;
	//public JDateChooser chooser;
	//public JPanel datePanel;
	public JButton searchButton;
	public DefaultTableModel model;
	public JTable flightsTable;
	public Object[] rows=new Object[7];
	public JScrollPane pane;
	//public Choice choice;
	//public JRadioButton domesticRadioButton,internationalRadioButton;
	//JButton backButton;
	
	public POSViewCartUI() {
		
		setLayout(null);
		setBackground(Color.white);
		
		MainLabel=new JLabel("cart ");
		MainLabel.setBounds(180, 10, 150, 25);
		add(MainLabel);
		
		
		
		
		
		
	    searchButton=new JButton("Search");
	    searchButton.setBounds(120,125, 110, 25);
	    searchButton.addActionListener(new POSCustomerViewCartPageListener(this));
	    add(searchButton);
		
		  
	    model=new DefaultTableModel();
	    model.addColumn("Cart Id");
	    model.addColumn("User Id");
	    model.addColumn("Food Id");
	    model.addColumn("Type");
	    model.addColumn("Quantity");
	    model.addColumn("Cost");
	    model.addColumn("Order Date");
	  //  model.addColumn("Arrival Time");
	  //  model.addColumn("Reservation Capacity");
	  //  model.addColumn("Distance");
	  //  model.addColumn("Fare");
		   
	   	
		flightsTable=new JTable(model);
		
		
		
		flightsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		flightsTable.setPreferredScrollableViewportSize(new Dimension(350,350));
		pane=new JScrollPane(flightsTable);
	
		
		pane.setBounds(20,200, 420,360);
}
}