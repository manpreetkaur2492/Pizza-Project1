package com.wipro.pos.ui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
//import com.wipro.pos.listener.POSCustomerViewBookPageListener;
//import com.wipro.pos.listener.POSViewTicketListener;
import com.wipro.pos.listener.POSCustomerViewStorePageListener;

public class POSCustomerViewPageUI extends JPanel {

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
	
	public POSCustomerViewPageUI() {
		
		setLayout(null);
		setBackground(Color.white);
		
		MainLabel=new JLabel("Search Store ");
		MainLabel.setBounds(180, 10, 150, 25);
		add(MainLabel);
		
		
		
		cityl=new JLabel("Enter city ");
		cityl.setBounds(20, 40, 100, 25);
		add(cityl);
		city=new JTextField();
		city.setBounds(100, 40, 100, 20);
		add(city);
		
		/*destinationLabel=new JLabel("Enter Destination ");
		destinationLabel.setBounds(220, 40, 100, 25);
		add(destinationLabel);
		destinationTextField=new JTextField(15);
		destinationTextField.setBounds(335, 40, 100, 20);
		add(destinationTextField);
		
		seatsLabel=new JLabel("Number of Travellers ");
		seatsLabel.setBounds(20, 80, 130, 25);
		add(seatsLabel);
		seatsTextField=new JTextField(15);
		seatsTextField.setBounds(150, 80, 90, 25);
		add(seatsTextField);
		
		
		departureDateLabel=new JLabel("Departure Date");
		departureDateLabel.setBounds(250, 80, 90, 25);
		add(departureDateLabel);
		chooser = new JDateChooser();
	    chooser.setLocale(Locale.US);
	    chooser.setMinSelectableDate(new Date());
	    datePanel = new JPanel();
	    datePanel.setBackground(Color.white);
	    datePanel.add(chooser);
	    datePanel.setBounds(350, 80, 90, 25);
	    add(datePanel);
	    */
	    searchButton=new JButton("Search");
	    searchButton.setBounds(120,125, 110, 25);
	    searchButton.addActionListener(new POSCustomerViewStorePageListener(this));
	    add(searchButton);
		
	   /* cancelButton=new JButton("Cancel");
	    cancelButton.setBounds(240,125, 110, 25);
	   // cancelButton.addActionListener(new FRSCustomerViewBookPageListener(this));
	    add(cancelButton);
	    */
	  /*  choiceLabel=new JLabel("Select Schedule Id");
	    choiceLabel.setBounds(20,170, 110, 25);
	    add(choiceLabel);
	    choice=new Choice();
	    choice.setBounds(140,170, 90, 25);
	   // choice.addItemListener(new FRSCustomerViewBookPageListener(this));
	    add(choice);
	    
	    bookButton=new JButton("Book Flight");
	    bookButton.setBounds(240,165, 110, 25);
	   // bookButton.addActionListener(new FRSCustomerViewBookPageListener(this));
	    add(bookButton);
	    
	    errorLabel=new JLabel();
	    add(errorLabel);
	    */

		
		  
	    model=new DefaultTableModel();
	    model.addColumn("Store Id");
	    model.addColumn("Name");
	    model.addColumn("Street");
	    model.addColumn("Mobile No.");
	    model.addColumn("City");
	    model.addColumn("State");
	    model.addColumn("Pin Code");
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
//	public static void main(String args[]){
//		new POSCustomerViewPageUI();
//	}
}
