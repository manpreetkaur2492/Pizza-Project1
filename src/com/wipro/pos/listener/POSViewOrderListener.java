package com.wipro.pos.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import com.wipro.pos.bean.OrderBean;
import com.wipro.pos.bean.StoreBean;
//import com.wipro.pos.bean.PassengerBean;
//import com.wipro.pos.bean.ReservationBean;
//import com.wipro.frs.bean.RouteBean;
//import com.wipro.frs.bean.ScheduleBean;
import com.wipro.pos.service.Customer;
import com.wipro.pos.ui.Login;
import com.wipro.pos.ui.POSCustomerMainPageUI;
import com.wipro.pos.ui.POSViewOrderUI;

public class POSViewOrderListener implements ActionListener{

	POSViewOrderUI pos;
	public POSViewOrderListener(POSViewOrderUI fRSViewTicketUI) {
		pos=fRSViewTicketUI;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pos.backButton)
		{
			//pos.dispose();
			POSCustomerMainPageUI frsCustomerMainPageUI=new POSCustomerMainPageUI();
		}
		if(e.getSource()==pos.viewButton)
		{
			int count1=0;

						Customer obj=new Customer();
						ArrayList<OrderBean> bean=obj.viewOrder(Login.textUserID.getText().trim());
						if(bean!=null)
						{
							Iterator<OrderBean> itr=bean.iterator();
							while(itr.hasNext())
							{
								OrderBean sd = new OrderBean();
								//fb=new FlightBean();
								sd=itr.next();
								//fb=itr1.next();
								//reservationcapacity=fb.getReservationCapacity();
								pos.rows[0]=sd.getStoreID();
								//System.out.println(pos.rows[0]);
								pos.rows[1]=sd.getUserID();
								pos.rows[2]=sd.getOrderDate().toString();
								pos.rows[3]=sd.getStoreID();
								pos.rows[4]=sd.getOrderStatus();
								pos.rows[5]=sd.getCartID();
								//pos.rows[6]=sd.getPincode();
								pos.model.addRow(pos.rows);
								//customerViewPageUI.choice.add(sd.getScheduleID());
								count1++;
							}
							pos.add(pos.pane);
						}
										/*	fRSViewTicketUI.nameTextField1.setText(passengerBean.getName());
											fRSViewTicketUI.genderTextField.setText(passengerBean.getGender());
											fRSViewTicketUI.ageTextField.setText(String.valueOf(passengerBean.getAge()));
											fRSViewTicketUI.ridTextField.setText(reservationBean.getReservationID());
											fRSViewTicketUI.seatNumberTextField1.setText(String.valueOf(passengerBean.getSeatNo()));
											System.out.println(reservationBean.getReservationType());
											fRSViewTicketUI.rTypeTextField.setText(reservationBean.getReservationType());
											fRSViewTicketUI.flightTextField.setText(flightBean.getFlightName());
											fRSViewTicketUI.sourceTextField.setText(routeBean.getSource());
											fRSViewTicketUI.destinatinTextField.setText(routeBean.getDestination());
											fRSViewTicketUI.departureTextField.setText(scheduleBean.getDepartureTime());
											fRSViewTicketUI.arrivalTimeTextField.setText(scheduleBean.getArrivalTime());
											fRSViewTicketUI.journeyDateTextField.setText(reservationBean.getJourneyDate().toString());
											fRSViewTicketUI.fareTextField.setText(String.valueOf(reservationBean.getTotalFare()/reservationBean.getNoOfSeats()));
											fRSViewTicketUI.ticketPanel.setVisible(true);
										}*/
										else
										{
											JOptionPane.showMessageDialog(pos, "No Such Record found");
										}
								/*	}
									else
									{
										JOptionPane.showMessageDialog(fRSViewTicketUI, "No Such Record found");
									}
								}
								else
								{
									JOptionPane.showMessageDialog(fRSViewTicketUI, "No Such Record found");
								}
							}
						}
					}
					else
					{
						fRSViewTicketUI.errorLabel.setForeground(Color.RED);
						fRSViewTicketUI.errorLabel.setText("*select gender");
					}
				}
				else
				{
					fRSViewTicketUI.errorLabel.setForeground(Color.RED);
					fRSViewTicketUI.errorLabel.setText("*select gender");
				}
			}
			else
			{
				fRSViewTicketUI.errorLabel.setForeground(Color.RED);
				fRSViewTicketUI.errorLabel.setText("*enter alphanumerics");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}*/
	}
	}
	
}
