package com.wipro.pos.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
//import java.util.Date;
//import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import com.wipro.pos.listener.POSCustomerRegistrationListener;

//import com.toedter.calendar.JDateChooser;
//import com.toedter.calendar.JTextFieldDateEditor;
//import com.wipro.frs.listener.FRSCustomerRegistrationListener;

public class POSCustomerRegisterationUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel label1,firstNameLabel,lastNameLabel,dateOfBirthLabel,genderLabel,streetLabel,locationLabel,cityLabel,stateLabel,pincodeLabel,mobileNoLabel,emailIDLabel,passwordLabel,firstnameTextLabel,lastnameTextLabel,dateOfBirthTextLabel,genderTextLabel,streetTextLabel,locationTextLabel,cityTextLabel,stateTextLabel,pincodeTextLabel,mobileNoTextLabel,emailTextLabel,passwordTextLabel;
	public JTextField firstNameTextField,lastNameTextField,streetTextField,locationTextField,cityTextField,stateTextField,pincodeTextField,mobileNoTextField,emailIDTextField;
	public JPasswordField passwordField;
	public JPanel registrationPanel,genderPanel,datePanel1;
	public JButton registerButton,cancelButton,backButton;
	public ButtonGroup bg;
	public JRadioButton maleButton,femaleButton;
	//public JDateChooser chooser;
	 UtilDateModel model;
	 JDatePanelImpl datePanel;
	 public JDatePickerImpl datePicker;
	public POSCustomerRegisterationUI() {
	
		setTitle("Registration");
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Background
	    setContentPane(new JLabel(new ImageIcon("background.jpg")));
	    setLayout(new BorderLayout());
	    
	    //Label
	    label1=new JLabel("Create your Account");
	    label1.setFont(new Font("Papyrus", Font.ITALIC, 50));
	    label1.setHorizontalAlignment(SwingConstants.CENTER);
	    add(label1,BorderLayout.NORTH);
	    
	    //Panel
	    registrationPanel=new JPanel();
	    registrationPanel.setLayout(new GridLayout(0,3,8,8));
	    registrationPanel.setBackground((Color.white));
	   
	    
	    
	    //Components
	    firstNameLabel=new JLabel("First Name : ");
	    registrationPanel.add(firstNameLabel);
	    firstNameTextField=new JTextField(15);
	    registrationPanel.add(firstNameTextField);
	    firstnameTextLabel=new JLabel();
	    registrationPanel.add(firstnameTextLabel);
	    
	    
	    lastNameLabel=new JLabel("Last Name : ");
	    registrationPanel.add(lastNameLabel);
	    lastNameTextField=new JTextField(15);
	    registrationPanel.add(lastNameTextField);
	    lastnameTextLabel=new JLabel();
	    registrationPanel.add(lastnameTextLabel);
	    
	    dateOfBirthLabel=new JLabel("Date OF Birth : ");
	    registrationPanel.add(dateOfBirthLabel);
	    /*chooser = new JDateChooser();
	    JTextFieldDateEditor editor = (JTextFieldDateEditor) chooser.getDateEditor();
	    editor.setEditable(false);
	    chooser.setLocale(Locale.US);
	    chooser.setMaxSelectableDate(new Date());*/
	    model = new UtilDateModel();
	    datePanel = new JDatePanelImpl(model);
	    datePicker = new JDatePickerImpl(datePanel);
	     
	   // frame.add(datePicker);
	    datePanel1=  new JPanel();
	   datePanel1.setBackground(Color.white);
	    datePanel1.add(datePicker);
	    registrationPanel.add(datePanel1);
	    dateOfBirthTextLabel=new JLabel();
	    registrationPanel.add(dateOfBirthTextLabel);
	    
	    genderLabel=new JLabel("Gender : ");
	    registrationPanel.add(genderLabel);
	    maleButton=new JRadioButton("Male");
	    femaleButton=new JRadioButton("Female");
	    bg=new ButtonGroup();
	    bg.add(maleButton);
	    bg.add(femaleButton);
	    genderPanel=new JPanel();
	    genderPanel.setBackground(Color.white);
	    genderPanel.add(maleButton);
	    genderPanel.add(femaleButton);
	    registrationPanel.add(genderPanel);
	    genderTextLabel=new JLabel();
	    registrationPanel.add(genderTextLabel);
	    
	    streetLabel=new JLabel("Street : ");
	    registrationPanel.add(streetLabel);
	    streetTextField=new JTextField(15);
	    registrationPanel.add(streetTextField);
	    streetTextLabel=new JLabel();
	    registrationPanel.add(streetTextLabel);
	    
	    locationLabel=new JLabel("Location : ");
	    registrationPanel.add(locationLabel);
	    locationTextField=new JTextField(15);
	    registrationPanel.add(locationTextField);
	    locationTextLabel=new JLabel();
	    registrationPanel.add(locationTextLabel);
	    
	    cityLabel=new JLabel("City : ");
	    registrationPanel.add(cityLabel);
	    cityTextField=new JTextField(15);
	    registrationPanel.add(cityTextField);
	    cityTextLabel=new JLabel();
	    registrationPanel.add(cityTextLabel);
	    
	    stateLabel=new JLabel("State : ");
	    registrationPanel.add(stateLabel);
	    stateTextField=new JTextField(15);
	    registrationPanel.add(stateTextField);
	    stateTextLabel=new JLabel();
	    registrationPanel.add(stateTextLabel);
	    
	    pincodeLabel=new JLabel("Pincode : ");
	    registrationPanel.add(pincodeLabel);
	    pincodeTextField=new JTextField(15);
	    registrationPanel.add(pincodeTextField);
	    pincodeTextLabel=new JLabel();
	    registrationPanel.add(pincodeTextLabel);
	    
	    mobileNoLabel=new JLabel("MobileNo : ");
	    registrationPanel.add(mobileNoLabel);
	    mobileNoTextField=new JTextField(15);
	    registrationPanel.add(mobileNoTextField);
	    mobileNoTextLabel=new JLabel();
	    registrationPanel.add(mobileNoTextLabel);
	    
	    emailIDLabel=new JLabel("EmailID : ");
	    registrationPanel.add(emailIDLabel);
	    emailIDTextField=new JTextField(15);
	    registrationPanel.add(emailIDTextField);
	    emailTextLabel=new JLabel();
	    registrationPanel.add(emailTextLabel);
	    
	    passwordLabel=new JLabel("Password : ");
	    registrationPanel.add(passwordLabel);
	    passwordField=new JPasswordField(15);
	    registrationPanel.add(passwordField);
	    passwordTextLabel=new JLabel();
	    registrationPanel.add(passwordTextLabel);
	    
	    
	    registerButton=new JButton("Register");
	    registrationPanel.add(registerButton);
	    registerButton.addActionListener(new POSCustomerRegistrationListener(this) );
	    
	    
	    cancelButton=new JButton("Cancel");
	    cancelButton.addActionListener(new POSCustomerRegistrationListener(this) );
	    registrationPanel.add(cancelButton);
	    
	    backButton=new JButton("Back");
	    backButton.addActionListener(new POSCustomerRegistrationListener(this) );
	    registrationPanel.add(backButton);
	    
	    add(registrationPanel,BorderLayout.CENTER);
	    //setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	    setResizable(false);
	    setSize(720, 680);
	    setVisible(true);
		
	}
	
}
