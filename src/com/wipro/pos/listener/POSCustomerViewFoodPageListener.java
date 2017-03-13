package com.wipro.pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.service.Administrator;
import com.wipro.pos.service.Customer;
import com.wipro.pos.ui.POSCustomerViewPageUI;
import com.wipro.pos.ui.POSViewFoodUI;

public class POSCustomerViewFoodPageListener implements ActionListener {
	POSViewFoodUI pos;
	public POSCustomerViewFoodPageListener(POSViewFoodUI posViewFoodUI) {
		// TODO Auto-generated constructor stub
		pos = posViewFoodUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==pos.searchButton)
		{
			int count1=0;
			//customerViewPageUI.errorLabel.setText("");	
						pos.model.getDataVector().removeAllElements();
						Administrator admin=new Administrator();
						//StoreBean routeBean=customer.getRouteById(pos.city.getText().toLowerCase(), pos.destinationTextField.getText().toLowerCase());
						ArrayList<FoodBean> al=new ArrayList<FoodBean>();
						al=admin.viewAllFood(null);
						if(al==null)
						{
								JOptionPane.showMessageDialog(pos, "Sorry!! No  food  available");	
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
									
									Iterator<FoodBean> itr=al.iterator();
								//	Iterator<FlightBean> itr1=flightBeanList.iterator();
									
									while(itr.hasNext())
									{
										FoodBean sd = new FoodBean();
										//fb=new FlightBean();
										sd=itr.next();
										//fb=itr1.next();
										//reservationcapacity=fb.getReservationCapacity();
										pos.rows[0]=sd.getFoodID();
										//System.out.println(pos.rows[0]);
										pos.rows[1]=sd.getName();
										pos.rows[2]=sd.getType();
										pos.rows[3]=sd.getFoodSize();
										pos.rows[4]=sd.getQuantity();
										pos.rows[5]=sd.getPrice();
										//pos.rows[6]=sd.getPincode();
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


