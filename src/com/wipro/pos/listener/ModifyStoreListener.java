package com.wipro.pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.service.Administrator;
import com.wipro.pos.ui.AdminUI;
import com.wipro.pos.ui.ModifyStoreFrame;

public class ModifyStoreListener implements ActionListener {

	ModifyStoreFrame modifyStoreFrame;

	public ModifyStoreListener(ModifyStoreFrame modifyStoreFrame) {
		// TODO Auto-generated constructor stub
		this.modifyStoreFrame=modifyStoreFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==modifyStoreFrame.viewButton)
		{
			Administrator administrator=new Administrator();
			StoreBean routeBean=new StoreBean();
			String routeId=ModifyStoreFrame.choice.getSelectedItem();
			routeBean=administrator.viewStore(routeId);


			modifyStoreFrame.name.setVisible(true);
			modifyStoreFrame.namet.setText(routeBean.getName());
			modifyStoreFrame.namet.setVisible(true);



			modifyStoreFrame.Street.setVisible(true);
			modifyStoreFrame.Streett.setText(routeBean.getStreet());
			modifyStoreFrame.Streett.setVisible(true);


			modifyStoreFrame.mobile.setVisible(true);
			modifyStoreFrame.mobilet.setText(routeBean.getMobileNo());
			modifyStoreFrame.mobilet.setVisible(true);


			modifyStoreFrame.city.setVisible(true);
			modifyStoreFrame.cityt.setText(routeBean.getCity());
			modifyStoreFrame.cityt.setVisible(true);
			
			modifyStoreFrame.state.setVisible(true);
			modifyStoreFrame.statet.setText(routeBean.getState());
			modifyStoreFrame.statet.setVisible(true);
			
			modifyStoreFrame.pincode.setVisible(true);
			modifyStoreFrame.pincodet.setText(routeBean.getPincode());
			modifyStoreFrame.pincodet.setVisible(true);

			modifyStoreFrame.cancelButton.setVisible(true);
			modifyStoreFrame.updateButton.setVisible(true);

		}

		else if(e.getSource()==modifyStoreFrame.updateButton)
		{
			if(modifyStoreFrame.namet.getText().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(modifyStoreFrame.frame, "Store name can not be empty","Error", JOptionPane.ERROR_MESSAGE);
			}
			else
				if(modifyStoreFrame.namet.getText().trim().length()<2)
				{
					JOptionPane.showMessageDialog(modifyStoreFrame.frame, "Store feild must contains 2 characters","Error", JOptionPane.ERROR_MESSAGE);
					modifyStoreFrame.namet.setText("");
				}
				else
					if(modifyStoreFrame.namet.getText().trim().matches("[0-9]+"))
					{
						JOptionPane.showMessageDialog(modifyStoreFrame.frame, "Store name feild must contains only words with length greater than 2","Error", JOptionPane.ERROR_MESSAGE);
						modifyStoreFrame.namet.setText("");
					}
					else
						if(modifyStoreFrame.Streett.getText().trim().isEmpty())
						{
							JOptionPane.showMessageDialog(modifyStoreFrame.frame, "Street can not be empty","Error", JOptionPane.ERROR_MESSAGE);
							
						}
						else
							if(modifyStoreFrame.Streett.getText().trim().length()<2)
							{
								JOptionPane.showMessageDialog(modifyStoreFrame.frame, "Destination feild must contains 2 characters","Error", JOptionPane.ERROR_MESSAGE);
								modifyStoreFrame.Streett.setText("");

							}
							else
								if(modifyStoreFrame.Streett.getText().trim().matches("[0-9]+"))
								{
									JOptionPane.showMessageDialog(modifyStoreFrame.frame, "Destination feild must contains only words with length greater than 2","Error", JOptionPane.ERROR_MESSAGE);
									modifyStoreFrame.Streett.setText("");

								}
								else
									if(modifyStoreFrame.mobilet.getText().trim().isEmpty())
									{
										JOptionPane.showMessageDialog(modifyStoreFrame.frame, "Distance can not be empty","Error", JOptionPane.ERROR_MESSAGE);
									}
									else
										if(modifyStoreFrame.mobilet.getText().trim().matches("[a-zA-Z]+"))
										{
											JOptionPane.showMessageDialog(modifyStoreFrame.frame, "Mobile feild must contains only digits","Error", JOptionPane.PLAIN_MESSAGE);
											modifyStoreFrame.mobilet.setText("");
										}
										else
										try
										{
											if(Integer.valueOf(modifyStoreFrame.mobilet.getText().trim())<=0) 
											{
												JOptionPane.showMessageDialog(modifyStoreFrame.frame, "Mobile Should be greater than 0","Error", JOptionPane.ERROR_MESSAGE);
												modifyStoreFrame.mobilet.setText("");
											}
											else
												if(modifyStoreFrame.cityt.getText().trim().isEmpty())
												{
													JOptionPane.showMessageDialog(modifyStoreFrame.frame, "City can not be empty","Error", JOptionPane.ERROR_MESSAGE);
												}
												else
													if(modifyStoreFrame.cityt.getText().trim().matches("[0-9]+"))
													{
														JOptionPane.showMessageDialog(modifyStoreFrame.frame, "City feild must contains only alphabets","Error", JOptionPane.PLAIN_MESSAGE);
														modifyStoreFrame.cityt.setText("");
													}
													else
														if(modifyStoreFrame.cityt.getText().trim()==null)
														{
															JOptionPane.showMessageDialog(modifyStoreFrame.frame, "City Should be greater than 0","Error", JOptionPane.ERROR_MESSAGE);
															modifyStoreFrame.cityt.setText("");
														}
														else if(modifyStoreFrame.statet.getText().trim().isEmpty()){
															JOptionPane.showMessageDialog(modifyStoreFrame.frame, "State can not be empty","Error", JOptionPane.ERROR_MESSAGE);
														}
														else if(modifyStoreFrame.statet.getText().trim().matches("[0-9]+"))
														{
															JOptionPane.showMessageDialog(modifyStoreFrame.frame, "State feild must contains only alphabets","Error", JOptionPane.PLAIN_MESSAGE);
															modifyStoreFrame.cityt.setText("");
														}
														else if(modifyStoreFrame.pincodet.getText().trim().isEmpty()){
															JOptionPane.showMessageDialog(modifyStoreFrame.frame, "Pincode can not be empty","Error", JOptionPane.ERROR_MESSAGE);
														}
														else if(modifyStoreFrame.pincodet.getText().trim().matches("[a-zA-Z]+"))
														{
															JOptionPane.showMessageDialog(modifyStoreFrame.frame, "pincode feild must contains only number","Error", JOptionPane.PLAIN_MESSAGE);
															modifyStoreFrame.cityt.setText("");
														}
														else if(modifyStoreFrame.pincodet.getText().trim().length()!=6){
															JOptionPane.showMessageDialog(modifyStoreFrame.frame, "pincode feild must be of exact six digits","Error", JOptionPane.PLAIN_MESSAGE);
															modifyStoreFrame.cityt.setText("");
														}
														else
														{
															Administrator administrator=new Administrator();
															StoreBean routeBean=new StoreBean();
															routeBean.setStoreID(ModifyStoreFrame.choice.getSelectedItem());
															routeBean.setName(modifyStoreFrame.namet.getText().trim());
															routeBean.setStreet(modifyStoreFrame.Streett.getText().trim());
															routeBean.setMobileNo(modifyStoreFrame.mobilet.getText().trim());
															routeBean.setCity(modifyStoreFrame.cityt.getText().trim());
															routeBean.setState(modifyStoreFrame.statet.getText().trim());
															routeBean.setPincode(modifyStoreFrame.pincodet.getText().trim());
															boolean b=administrator.modifyStore(routeBean);
															if(b)
															{
																JOptionPane.showMessageDialog(modifyStoreFrame.frame, "Successfully Updated","Success", JOptionPane.PLAIN_MESSAGE);
																modifyStoreFrame.frame.dispose();
																AdminUI.frame.setVisible(true);
																
																ModifyStoreFrame.choice.removeAll();
																ArrayList<StoreBean> list;
																	administrator=new Administrator();
																	list=administrator.viewAllStore();
																	Iterator<StoreBean> itr=list.iterator();
																	while(itr.hasNext())
																	{
																		StoreBean routeBean1=new StoreBean();
																		routeBean1=itr.next();
																		ModifyStoreFrame.choice.add(routeBean1.getStoreID());
																	}
															}
												
															else
															{
																JOptionPane.showMessageDialog(modifyStoreFrame.frame,"Invalid Data","Error", JOptionPane.ERROR_MESSAGE);
																
																modifyStoreFrame.namet.setText("");
																modifyStoreFrame.Streett.setText("");
																modifyStoreFrame.mobilet.setText("");
																modifyStoreFrame.cityt.setText("");
																modifyStoreFrame.statet.setText("");
																modifyStoreFrame.pincodet.setText("");
															}
														}
										}
			catch(NumberFormatException e1)
			{
				JOptionPane.showMessageDialog(modifyStoreFrame.frame,"Format for name is characters and for distance and fair is integer","Error", JOptionPane.ERROR_MESSAGE);
				
			}
		}
		
		if(e.getSource()==modifyStoreFrame.cancelButton)
		{
			modifyStoreFrame.namet.setText("");
			modifyStoreFrame.Streett.setText("");
			modifyStoreFrame.mobilet.setText("");
			modifyStoreFrame.cityt.setText("");
			modifyStoreFrame.statet.setText("");
			modifyStoreFrame.pincodet.setText("");
		}
		
		if(e.getSource()==modifyStoreFrame.buttonBack)
		{
			modifyStoreFrame.frame.dispose();
			AdminUI.frame.setVisible(true);
		}

	}

}
