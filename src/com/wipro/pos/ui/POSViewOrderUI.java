package com.wipro.pos.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.sound.midi.Soundbank;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.wipro.pos.listener.POSViewOrderListener;

//import com.wipro.pos.listener.POSViewOrderListener;

public class POSViewOrderUI extends JPanel{
	public DefaultTableModel model;
	public JTable flightsTable;
	public Object[] rows=new Object[6];
	public JScrollPane pane;
	public JPanel viewPanel;
	//verifyPanel,ticketPanel;
	public JLabel MainLabel;//ridLabel,label1,nameLabel,rTypeLabel,errorLabel,seatNumberLabel,airLabel,nameLabel1,genderLabel,ageLabel,journeyDateLabel,durationLabel,departureTimeLabel,arrivalTimeLabel,fareLabel,destinatinLabel,sourceLabel,flightLabel;
	//public JTextField IdTextField,nameTextField,seatNumberTextField,rTypeTextField,ridTextField,seatNumberTextField1,nameTextField1,genderTextField,ageTextField,journeyDateTextField,durationTextField,departureTextField,arrivalTimeTextField,fareTextField,destinatinTextField,sourceTextField,flightTextField;
	public JButton viewButton,backButton;
	//cancelButton;
	public POSViewOrderUI() {
		//setTitle("Order Details");
		setLayout(null);
		

		//Background
	  //  setContentPane(new JLabel(new ImageIcon("background.jpg")));
	    setLayout(null);
	    MainLabel=new JLabel("Order");
		MainLabel.setBounds(180, 10, 150, 25);
		add(MainLabel);
	    model=new DefaultTableModel();
	    model.addColumn("Order Id");
	    model.addColumn("User id");
	    model.addColumn("OrderDate");
	    model.addColumn("Store ID");
	    model.addColumn("Order Status");
	    model.addColumn("CartId");
	 //   model.addColumn("Pin Code");
flightsTable=new JTable(model);
		
		
		
		flightsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		flightsTable.setPreferredScrollableViewportSize(new Dimension(350,350));
		pane=new JScrollPane(flightsTable);
	
		
		pane.setBounds(20,200, 420,360);
		
	    /*
	    errorLabel=new JLabel("");
	    
		*/
		viewPanel=new JPanel(null);
		viewPanel.setBackground(Color.white);
		viewPanel.setBounds(20, 40,670, 570);
		/*
		label1=new JLabel("Ticket");
		label1.setBounds(300,20,150, 25);
		viewPanel.add(label1);
		
		errorLabel.setBounds(500, 60, 200, 25);
		viewPanel.add(errorLabel);
		
		idLabel=new JLabel("Enter Reservation ID ");
		idLabel.setBounds(20, 60, 130, 25);
		viewPanel.add(idLabel);
		
		IdTextField=new JTextField();
		IdTextField.setBounds(140, 60, 105, 25);
		viewPanel.add(IdTextField);
		
		nameLabel=new JLabel("Enter Name ");
		nameLabel.setBounds(260, 60, 130, 25);
		viewPanel.add(nameLabel);
		
		nameTextField=new JTextField();
		nameTextField.setBounds(330, 60, 130, 25);
		viewPanel.add(nameTextField);
		
		seatNumberLabel=new JLabel("Enter Seat Number ");
		seatNumberLabel.setBounds(20, 100, 130, 25);
		viewPanel.add(seatNumberLabel);
		
		seatNumberTextField=new JTextField();
		seatNumberTextField.setBounds(140,100, 105, 25);
		viewPanel.add(seatNumberTextField);
		*/
		viewButton=new JButton("View");
		viewButton.setBounds(260,540, 105, 25);
		viewButton.addActionListener(new POSViewOrderListener(this));
		viewPanel.add(viewButton);
		/*
		cancelButton=new JButton("Cancel");
		cancelButton.setBounds(390,100, 105, 25);
		//cancelButton.addActionListener(new FRSViewTicketListener(this));
		viewPanel.add(cancelButton);
	*/
		backButton=new JButton("Back");
		backButton.setBounds(560,540, 105, 25);
		backButton.addActionListener(new POSViewOrderListener(this));
		viewPanel.add(backButton);
		add(viewPanel);
		/*
		ticketPanel=new JPanel(null);
		ticketPanel.setBackground(Color.ORANGE);
		ticketPanel.setBounds(20, 150,600, 380);
		viewPanel.add(ticketPanel);
		ticketPanel.setVisible(false);
		
		airLabel=new JLabel("XYZ Air Travels Ltd. ");
		airLabel.setFont(new Font("Serif", Font.BOLD, 26));
		airLabel.setBounds(170, 10, 350, 25);
		ticketPanel.add(airLabel);
		
		ridLabel=new JLabel("Reservation ID ");
		ridLabel.setBounds(20, 80, 150, 25);
		ticketPanel.add(ridLabel);
		
		ridTextField=new JTextField();
		ridTextField.setBounds(120,80, 105, 25);
		ridTextField.setEditable(false);
		ticketPanel.add(ridTextField);
		
		seatNumberLabel=new JLabel("Seat Number ");
		seatNumberLabel.setBounds(250, 80, 130, 25);
		ticketPanel.add(seatNumberLabel);
		
		seatNumberTextField1=new JTextField();
		seatNumberTextField1.setBounds(340,80, 105, 25);
		seatNumberTextField1.setEditable(false);
		ticketPanel.add(seatNumberTextField1);
		
		
		nameLabel1=new JLabel("Name");
		nameLabel1.setBounds(20, 40, 150, 25);
		ticketPanel.add(nameLabel1);
		
		nameTextField1=new JTextField();
		nameTextField1.setBounds(120,40, 105, 25);
		nameTextField1.setEditable(false);
		ticketPanel.add(nameTextField1);
		
		genderLabel=new JLabel("Gender");
		genderLabel.setBounds(250, 40, 150, 25);
		ticketPanel.add(genderLabel);
		
		genderTextField=new JTextField();
		genderTextField.setBounds(340,40, 105, 25);
		genderTextField.setEditable(false);
		ticketPanel.add(genderTextField);
		
		ageLabel=new JLabel("Age");
		ageLabel.setBounds(470, 40, 110, 25);
		ticketPanel.add(ageLabel);
		
		ageTextField=new JTextField();
		ageTextField.setBounds(500,40, 90, 25);
		ageTextField.setEditable(false);
		ticketPanel.add(ageTextField);
		
		rTypeLabel=new JLabel("Reservation Type");
		rTypeLabel.setBounds(20, 120, 150, 25);
		ticketPanel.add(rTypeLabel);
		
		rTypeTextField=new JTextField();
		rTypeTextField.setBounds(130,120, 95, 25);
		rTypeTextField.setEditable(false);
		ticketPanel.add(rTypeTextField);
		
		rTypeLabel=new JLabel("Reservation Type");
		rTypeLabel.setBounds(20, 120, 150, 25);
		ticketPanel.add(rTypeLabel);
		
		rTypeTextField=new JTextField();
		rTypeTextField.setBounds(130,120, 95, 25);
		rTypeTextField.setEditable(false);
		ticketPanel.add(rTypeTextField);
		
		flightLabel=new JLabel("Flight Name");
		flightLabel.setBounds(250, 120, 150, 25);
		ticketPanel.add(flightLabel);
		
		flightTextField=new JTextField();
		flightTextField.setBounds(340,120, 95, 25);
		flightTextField.setEditable(false);
		ticketPanel.add(flightTextField);
		

		sourceLabel=new JLabel("Source");
		sourceLabel.setBounds(20, 160, 150, 25);
		ticketPanel.add(sourceLabel);
		
		sourceTextField=new JTextField();
		sourceTextField.setBounds(120,160, 105, 25);
		sourceTextField.setEditable(false);
		ticketPanel.add(sourceTextField);
		
		destinatinLabel=new JLabel("Destination");
		destinatinLabel.setBounds(250, 160, 150, 25);
		ticketPanel.add(destinatinLabel);
		
		destinatinTextField=new JTextField();
		destinatinTextField.setBounds(340,160, 105, 25);
		destinatinTextField.setEditable(false);
		ticketPanel.add(destinatinTextField);
		
		arrivalTimeLabel=new JLabel("Arrival Time");
		arrivalTimeLabel.setBounds(250, 200, 150, 25);
		ticketPanel.add(arrivalTimeLabel);
		
		arrivalTimeTextField=new JTextField();
		arrivalTimeTextField.setBounds(340,200, 105, 25);
		arrivalTimeTextField.setEditable(false);
		ticketPanel.add(arrivalTimeTextField);
		
		departureTimeLabel=new JLabel("Departure Time");
		departureTimeLabel.setBounds(20, 200, 150, 25);
		ticketPanel.add(departureTimeLabel);
		
		departureTextField=new JTextField();
		departureTextField.setBounds(120,200, 105, 25);
		departureTextField.setEditable(false);
		ticketPanel.add(departureTextField);
		
		journeyDateLabel=new JLabel("Journey Date");
		journeyDateLabel.setBounds(20, 240, 150, 25);
		ticketPanel.add(journeyDateLabel);
		
		journeyDateTextField=new JTextField();
		journeyDateTextField.setBounds(100,240, 200, 25);
		journeyDateTextField.setEditable(false);
		ticketPanel.add(journeyDateTextField);
		
		fareLabel=new JLabel("Fare");
		fareLabel.setBounds(310, 240, 150, 25);
		ticketPanel.add(fareLabel);
		
		fareTextField=new JTextField();
		fareTextField.setBounds(340,240, 105, 25);
		fareTextField.setEditable(false);
		ticketPanel.add(fareTextField);
		*/
		
		setSize(720, 680);
	   // setResizable(false);
	    setVisible(true);
	}
//	public static void main (String args[]){
//		new POSViewOrderUI();
//	}
}
