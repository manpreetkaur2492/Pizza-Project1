package com.wipro.pos.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.wipro.pos.bean.ProfileBean;
//import com.wipro.pos.service.Customer;
import com.wipro.pos.ui.POSCustomerRegisterationUI;
//import com.wipro.pos.ui.POSCustomerMainPageUI;
//import com.wipro.pos.ui.POSLoginUI;
import com.wipro.pos.ui.Login;
import com.wipro.pos.util.UserImpl;


public class POSCustomerRegistrationListener implements ActionListener{

	POSCustomerRegisterationUI customerRegistrationUI;
	public POSCustomerRegistrationListener(POSCustomerRegisterationUI customerRegistrationUI) {
		this.customerRegistrationUI=customerRegistrationUI;
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
	//	LocalDate localDate = customerRegistrationUI.datePicker.getValue();
		/* Date selectedDate = (Date) customerRegistrationUI.datePicker.getModel().getValue();
		    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		    String reportDate = df.format(selectedDate);*/
		    
		
		 Date selectedDate = (Date) customerRegistrationUI.datePicker.getModel().getValue();
		    DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		    String reportDate = df.format(selectedDate);
		    
		if(e.getSource()==customerRegistrationUI.registerButton)
		{
			
			try {
				if(customerRegistrationUI.firstNameTextField.getText().trim().matches("[a-zA-Z]+")&&customerRegistrationUI.firstNameTextField.getText().trim().length()>2)
				{
					
					if(customerRegistrationUI.lastNameTextField.getText().trim().matches("[a-zA-Z]+")&&customerRegistrationUI.lastNameTextField.getText().trim().length()>2)
					{
						if(customerRegistrationUI.datePicker!=null)
						{
							if(customerRegistrationUI.maleButton.isSelected()==true||customerRegistrationUI.femaleButton.isSelected())
							{
								if(customerRegistrationUI.streetTextField.getText().trim().matches("[a-zA-Z0-9]+"))
								{
									if(customerRegistrationUI.locationTextField.getText().trim().matches("[a-zA-Z0-9]+"))
									{
										if(customerRegistrationUI.cityTextField.getText().trim().matches("[a-zA-Z]+"))
										{
											if(customerRegistrationUI.stateTextField.getText().trim().matches("[a-zA-Z]+"))
											{
												if(customerRegistrationUI.pincodeTextField.getText().trim().matches("[a-zA-Z0-9]+" )&&customerRegistrationUI.pincodeTextField.getText().length()==6)
												{
													if(customerRegistrationUI.mobileNoTextField.getText().trim().matches("[0-9]+")&&customerRegistrationUI.mobileNoTextField.getText().length()==10)
													{
														if(customerRegistrationUI.emailIDTextField.getText().trim().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
														{
															if(!customerRegistrationUI.passwordField.getText().trim().isEmpty()&&customerRegistrationUI.passwordField.getText().length()==8)
															{	
																ProfileBean profileBean=new ProfileBean();
																profileBean.setFirstName(customerRegistrationUI.firstNameTextField.getText().trim());
																profileBean.setLastName(customerRegistrationUI.lastNameTextField.getText().trim());
																profileBean.setDateOfBirth(selectedDate);
																if(customerRegistrationUI.maleButton.isSelected()==true)
																{
																	profileBean.setGender("Male");
																}
																else
																{
																	profileBean.setGender("Female");
																}
																profileBean.setStreet(customerRegistrationUI.streetTextField.getText().trim());
																profileBean.setLocation(customerRegistrationUI.locationTextField.getText().trim());
																profileBean.setCity(customerRegistrationUI.cityTextField.getText().trim());
																profileBean.setState(customerRegistrationUI.stateTextField.getText().trim());
																profileBean.setPincode(customerRegistrationUI.pincodeTextField.getText().trim());
																profileBean.setMobileNo(customerRegistrationUI.mobileNoTextField.getText().trim());
																profileBean.setEmailID(customerRegistrationUI.emailIDTextField.getText().trim());
																profileBean.setPassword(customerRegistrationUI.passwordField.getText());
																
																UserImpl util=new UserImpl();
																String result=util.register(profileBean);
																System.out.println(result);
																if(result!="First Name should be greater than 2 characters"&&result!="Last Name should be greater than 2 characters"&&result!="Address should be greater than 2 characters"&&result!="PINCODE INVALID"&&result!="FAIL"&&result!="DATA INVALID"&&result!="MOBILE NUMBER INVALID")
																{
																	JOptionPane.showMessageDialog(customerRegistrationUI, "Registration successful!! UR USER ID IS : "+result);
																	//Login login=new Login();
																	
																	customerRegistrationUI.setVisible(false);
																}
																else
																{
																	JOptionPane.showMessageDialog(customerRegistrationUI, result);
																}
															}
															else
															{

																customerRegistrationUI.firstnameTextLabel.setText("");
																customerRegistrationUI.lastnameTextLabel.setText("");
																customerRegistrationUI.dateOfBirthTextLabel.setText("");
																customerRegistrationUI.genderTextLabel.setText("");
																customerRegistrationUI.streetTextLabel.setText("");
																customerRegistrationUI.locationTextLabel.setText("");
																customerRegistrationUI.cityTextLabel.setText("");
																customerRegistrationUI.stateTextLabel.setText("");
																customerRegistrationUI.pincodeTextLabel.setText("");
																customerRegistrationUI.mobileNoTextLabel.setText("");
																customerRegistrationUI.emailTextLabel.setText("");
																customerRegistrationUI.passwordTextLabel.setForeground(Color.red);
																
																customerRegistrationUI.passwordTextLabel.setText("*enter password of length 8");
															}
														}
														else
														{

															customerRegistrationUI.firstnameTextLabel.setText("");
															customerRegistrationUI.lastnameTextLabel.setText("");
															customerRegistrationUI.dateOfBirthTextLabel.setText("");
															customerRegistrationUI.genderTextLabel.setText("");
															customerRegistrationUI.streetTextLabel.setText("");
															customerRegistrationUI.locationTextLabel.setText("");
															customerRegistrationUI.cityTextLabel.setText("");
															customerRegistrationUI.stateTextLabel.setText("");
															customerRegistrationUI.pincodeTextLabel.setText("");
															customerRegistrationUI.mobileNoTextLabel.setText("");
															customerRegistrationUI.passwordTextLabel.setText("");
															customerRegistrationUI.emailTextLabel.setForeground(Color.red);
															
															customerRegistrationUI.emailTextLabel.setText("*Invalid emailID (abc@xyz.com)");
														}
													}
													else
													{

														customerRegistrationUI.firstnameTextLabel.setText("");
														customerRegistrationUI.lastnameTextLabel.setText("");
														customerRegistrationUI.dateOfBirthTextLabel.setText("");
														customerRegistrationUI.genderTextLabel.setText("");
														customerRegistrationUI.streetTextLabel.setText("");
														customerRegistrationUI.locationTextLabel.setText("");
														customerRegistrationUI.cityTextLabel.setText("");
														customerRegistrationUI.stateTextLabel.setText("");
														customerRegistrationUI.pincodeTextLabel.setText("");
														customerRegistrationUI.emailTextLabel.setText("");
														customerRegistrationUI.passwordTextLabel.setText("");
														customerRegistrationUI.mobileNoTextLabel.setForeground(Color.red);
														
														customerRegistrationUI.mobileNoTextLabel.setText("*Invalid Mobile Number enter 10 digits");
													}
												}
												else
												{

													customerRegistrationUI.firstnameTextLabel.setText("");
													customerRegistrationUI.lastnameTextLabel.setText("");
													customerRegistrationUI.dateOfBirthTextLabel.setText("");
													customerRegistrationUI.genderTextLabel.setText("");
													customerRegistrationUI.streetTextLabel.setText("");
													customerRegistrationUI.locationTextLabel.setText("");
													customerRegistrationUI.cityTextLabel.setText("");
													customerRegistrationUI.stateTextLabel.setText("");
													customerRegistrationUI.mobileNoTextLabel.setText("");
													customerRegistrationUI.emailTextLabel.setText("");
													customerRegistrationUI.passwordTextLabel.setText("");
													customerRegistrationUI.pincodeTextLabel.setForeground(Color.red);
													
													customerRegistrationUI.pincodeTextLabel.setText("*Invalid Pincode enter 6 digits");
												}
											}
											else
											{

												customerRegistrationUI.firstnameTextLabel.setText("");
												customerRegistrationUI.lastnameTextLabel.setText("");
												customerRegistrationUI.dateOfBirthTextLabel.setText("");
												customerRegistrationUI.genderTextLabel.setText("");
												customerRegistrationUI.streetTextLabel.setText("");
												customerRegistrationUI.locationTextLabel.setText("");
												customerRegistrationUI.cityTextLabel.setText("");
												customerRegistrationUI.pincodeTextLabel.setText("");
												customerRegistrationUI.mobileNoTextLabel.setText("");
												customerRegistrationUI.emailTextLabel.setText("");
												customerRegistrationUI.passwordTextLabel.setText("");
												customerRegistrationUI.stateTextLabel.setForeground(Color.red);
												
												customerRegistrationUI.stateTextLabel.setText("*Invalid State enter only characters");
											}
										}
										else
										{

											customerRegistrationUI.firstnameTextLabel.setText("");
											customerRegistrationUI.lastnameTextLabel.setText("");
											customerRegistrationUI.dateOfBirthTextLabel.setText("");
											customerRegistrationUI.genderTextLabel.setText("");
											customerRegistrationUI.streetTextLabel.setText("");
											customerRegistrationUI.locationTextLabel.setText("");
											customerRegistrationUI.stateTextLabel.setText("");
											customerRegistrationUI.pincodeTextLabel.setText("");
											customerRegistrationUI.mobileNoTextLabel.setText("");
											customerRegistrationUI.emailTextLabel.setText("");
											customerRegistrationUI.passwordTextLabel.setText("");
											customerRegistrationUI.cityTextLabel.setForeground(Color.red);
										
											customerRegistrationUI.cityTextLabel.setText("*Invalid City enter only characters");
										}
									}
									else
									{

										customerRegistrationUI.firstnameTextLabel.setText("");
										customerRegistrationUI.lastnameTextLabel.setText("");
										customerRegistrationUI.dateOfBirthTextLabel.setText("");
										customerRegistrationUI.genderTextLabel.setText("");
										customerRegistrationUI.streetTextLabel.setText("");
										customerRegistrationUI.cityTextLabel.setText("");
										customerRegistrationUI.stateTextLabel.setText("");
										customerRegistrationUI.pincodeTextLabel.setText("");
										customerRegistrationUI.mobileNoTextLabel.setText("");
										customerRegistrationUI.emailTextLabel.setText("");
										customerRegistrationUI.passwordTextLabel.setText("");
										customerRegistrationUI.locationTextLabel.setForeground(Color.red);
										
										customerRegistrationUI.locationTextLabel.setText("*Invalid Location enter text");
									}
								}
								else
								{

									customerRegistrationUI.firstnameTextLabel.setText("");
									customerRegistrationUI.lastnameTextLabel.setText("");
									customerRegistrationUI.dateOfBirthTextLabel.setText("");
									customerRegistrationUI.genderTextLabel.setText("");
									customerRegistrationUI.locationTextLabel.setText("");
									customerRegistrationUI.cityTextLabel.setText("");
									customerRegistrationUI.stateTextLabel.setText("");
									customerRegistrationUI.pincodeTextLabel.setText("");
									customerRegistrationUI.mobileNoTextLabel.setText("");
									customerRegistrationUI.emailTextLabel.setText("");
									customerRegistrationUI.passwordTextLabel.setText("");
									customerRegistrationUI.streetTextLabel.setForeground(Color.red);
								
									customerRegistrationUI.streetTextLabel.setText("*Invalid Street enter text");
								}
							}
							else
							{

								customerRegistrationUI.firstnameTextLabel.setText("");
								customerRegistrationUI.lastnameTextLabel.setText("");
								customerRegistrationUI.dateOfBirthTextLabel.setText("");
								customerRegistrationUI.streetTextLabel.setText("");
								customerRegistrationUI.locationTextLabel.setText("");
								customerRegistrationUI.cityTextLabel.setText("");
								customerRegistrationUI.stateTextLabel.setText("");
								customerRegistrationUI.pincodeTextLabel.setText("");
								customerRegistrationUI.mobileNoTextLabel.setText("");
								customerRegistrationUI.emailTextLabel.setText("");
								customerRegistrationUI.passwordTextLabel.setText("");
								customerRegistrationUI.genderTextLabel.setForeground(Color.red);
								
								customerRegistrationUI.genderTextLabel.setText("*Select Gender");
							}
						}
						else
						{


							customerRegistrationUI.firstnameTextLabel.setText("");
							customerRegistrationUI.lastnameTextLabel.setText("");
							customerRegistrationUI.genderTextLabel.setText("");
							customerRegistrationUI.streetTextLabel.setText("");
							customerRegistrationUI.locationTextLabel.setText("");
							customerRegistrationUI.cityTextLabel.setText("");
							customerRegistrationUI.stateTextLabel.setText("");
							customerRegistrationUI.pincodeTextLabel.setText("");
							customerRegistrationUI.mobileNoTextLabel.setText("");
							customerRegistrationUI.emailTextLabel.setText("");
							customerRegistrationUI.passwordTextLabel.setText("");
							customerRegistrationUI.dateOfBirthTextLabel.setForeground(Color.red);
							customerRegistrationUI.dateOfBirthTextLabel.setText("*Select Date");
						}
					}
					else
					{


						customerRegistrationUI.firstnameTextLabel.setText("");
						customerRegistrationUI.dateOfBirthTextLabel.setText("");
						customerRegistrationUI.genderTextLabel.setText("");
						customerRegistrationUI.streetTextLabel.setText("");
						customerRegistrationUI.locationTextLabel.setText("");
						customerRegistrationUI.cityTextLabel.setText("");
						customerRegistrationUI.stateTextLabel.setText("");
						customerRegistrationUI.pincodeTextLabel.setText("");
						customerRegistrationUI.mobileNoTextLabel.setText("");
						customerRegistrationUI.emailTextLabel.setText("");
						customerRegistrationUI.passwordTextLabel.setText("");
						customerRegistrationUI.lastnameTextLabel.setForeground(Color.red);
						customerRegistrationUI.lastnameTextLabel.setText("*only characters length>2 ");
					}
				}
						
					

					
					else
					{
						customerRegistrationUI.lastnameTextLabel.setText("");
						customerRegistrationUI.dateOfBirthTextLabel.setText("");
						customerRegistrationUI.genderTextLabel.setText("");
						customerRegistrationUI.streetTextLabel.setText("");
						customerRegistrationUI.locationTextLabel.setText("");
						customerRegistrationUI.cityTextLabel.setText("");
						customerRegistrationUI.stateTextLabel.setText("");
						customerRegistrationUI.pincodeTextLabel.setText("");
						customerRegistrationUI.mobileNoTextLabel.setText("");
						customerRegistrationUI.emailTextLabel.setText("");
						customerRegistrationUI.passwordTextLabel.setText("");
						
						customerRegistrationUI.firstnameTextLabel.setForeground(Color.red);
						customerRegistrationUI.firstnameTextLabel.setText("*only characters length >2");
					}
					
				
				
				
				
				
				
				
				
				
			} 
			
			 catch (Exception e1) {
				e1.printStackTrace();
			} 
			
		}
		if(e.getSource()==customerRegistrationUI.cancelButton)
		{
			customerRegistrationUI.firstNameTextField.setText("");
			customerRegistrationUI.lastNameTextField.setText("");
			customerRegistrationUI.stateTextField.setText("");
			customerRegistrationUI.streetTextField.setText("");
			customerRegistrationUI.locationTextField.setText("");
			customerRegistrationUI.cityTextField.setText("");
			customerRegistrationUI.passwordField.setText("");
			customerRegistrationUI.emailIDTextField.setText("");
			customerRegistrationUI.pincodeTextField.setText("");
			customerRegistrationUI.mobileNoTextField.setText("");
			customerRegistrationUI.maleButton.setSelected(false);
			customerRegistrationUI.femaleButton.setSelected(false);
			
			
			
			
		}
		if(e.getSource()==customerRegistrationUI.backButton)
		{
			customerRegistrationUI.setVisible(false);
			Login.frame.setVisible(true);
		}
		
	}
	
	
}
