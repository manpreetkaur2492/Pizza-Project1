package com.wipro.pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.dao.CustomerDAO;
import com.wipro.pos.service.Customer;
import com.wipro.pos.ui.POSCustomerViewPageUI;

public class POSCustomerViewStorePageListener implements ActionListener {

	POSCustomerViewPageUI pos;
	public POSCustomerViewStorePageListener(
			POSCustomerViewPageUI posCustomerViewPageUI) {
		// TODO Auto-generated constructor stub
		pos = posCustomerViewPageUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==pos.searchButton)
		{
			int count1=0;
			//customerViewPageUI.errorLabel.setText("");
			if(pos.city.getText().trim().matches("[a-zA-Z ]+")&&!pos.city.getText().trim().isEmpty())
			{
				
						pos.model.getDataVector().removeAllElements();
						Customer customer=new Customer();
						//StoreBean routeBean=customer.getRouteById(pos.city.getText().toLowerCase(), pos.destinationTextField.getText().toLowerCase());
						ArrayList<StoreBean> al=new ArrayList<StoreBean>();
						try {
							al=customer.viewStore(pos.city.getText().trim());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(al==null)
						{
								JOptionPane.showMessageDialog(pos, "Sorry!! No  such city  available");	
						}
						else
							{
								
								//seats=Integer.parseInt(customerViewPageUI.seatsTextField.getText());
								//System.out.println(customerViewPageUI.sourceTextField.getText());
								//CustomerDAO customerDAO=new CustomerDAO();
								//ArrayList<SchedBean> list;
								//try {
									//list = customerDAO.viewScheduleByRoute11(customerViewPageUI.sourceTextField.getText().toLowerCase(), customerViewPageUI.destinationTextField.getText().toLowerCase(), customerViewPageUI.chooser.getDate());
									
					
									//ArrayList<FlightBean> flightBeanList=customer.viewFlightBySchedule(list);
									
									Iterator<StoreBean> itr=al.iterator();
								//	Iterator<FlightBean> itr1=flightBeanList.iterator();
									
									while(itr.hasNext())
									{
										StoreBean sd = new StoreBean();
										//fb=new FlightBean();
										sd=itr.next();
										//fb=itr1.next();
										//reservationcapacity=fb.getReservationCapacity();
										pos.rows[0]=sd.getStoreID();
										//System.out.println(pos.rows[0]);
										pos.rows[1]=sd.getName();
										pos.rows[2]=sd.getStreet();
										pos.rows[3]=sd.getMobileNo();
										pos.rows[4]=sd.getCity();
										pos.rows[5]=sd.getState();
										pos.rows[6]=sd.getPincode();
									//	customerViewPageUI.rows[7]=sd.getArrivalTime();
										//customerViewPageUI.rows[8]=fb.getReservationCapacity();
										//customerViewPageUI.rows[9]=routeBean.getDistance();
										//customerViewPageUI.rows[10]=routeBean.getFare();
										//if(seats<=fb.getReservationCapacity())
										//{
											pos.model.addRow(pos.rows);
											//customerViewPageUI.choice.add(sd.getScheduleID());
											count1++;
											//System.out.println("ZXcv");
										//}
										//System.out.println("fsv");
//										else
//										{
//											JOptionPane.showMessageDialog(customerViewPageUI, "Not enough number of seats on this route");
//										}
										
									}
									
									pos.add(pos.pane);
								
								
							}
			}
		}
	}
}
							
							
													
						
					
	/*				else
					{
						customerViewPageUI.errorLabel.setBounds(360, 100, 155, 25);
						customerViewPageUI.errorLabel.setForeground(Color.RED);
						customerViewPageUI.errorLabel.setText("*select date");
					}
					
				}
				else
				{
					customerViewPageUI.errorLabel.setBounds(140, 100, 155, 25);
					customerViewPageUI.errorLabel.setForeground(Color.RED);
					customerViewPageUI.errorLabel.setText("*enter numbers ");
				}
			}
				else
				{
					customerViewPageUI.errorLabel.setBounds(330, 55, 200, 25);
					customerViewPageUI.errorLabel.setForeground(Color.RED);
					customerViewPageUI.errorLabel.setText("*enter alphabets");
				}
			}
			else
			{
				customerViewPageUI.errorLabel.setBounds(100, 55, 200, 25);
				customerViewPageUI.errorLabel.setForeground(Color.RED);
				customerViewPageUI.errorLabel.setText("*enter alphabets");
			}
			 
			
	}
*/

