/*package com.wipro.pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.wipro.pos.bean.OrderBean;
import com.wipro.pos.dao.OrderDAO;
import com.wipro.pos.service.Customer;
import com.wipro.pos.ui.CancelOrderFrame;
import com.wipro.pos.ui.POSCustomerMainPageUI;

public class CancelOrderListener implements ActionListener {

	public static CancelOrderFrame cancelOrderFrame;
	public static Customer customer;
	public static JTable table;
	public static String row[][];
	public static OrderBean Order;
	
	public CancelOrderListener(CancelOrderFrame cancelOrderFrame) {
		// TODO Auto-generated constructor stub
		CancelOrderListener.cancelOrderFrame=cancelOrderFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cancelOrderFrame.backButton)
		{
			cancelOrderFrame.dispose();
			POSCustomerMainPageUI posCustomerMainPageUI=new POSCustomerMainPageUI();
		}
		
		if(e.getSource()==cancelOrderFrame.buttonView)
		{
			//System.out.println("sdf");
			if(cancelOrderFrame.textorderID.getText()==null)
			{
				JOptionPane.showMessageDialog(cancelOrderFrame, "Order ID can not be Empty");
				
				//JOptionPane.showMessageDialog(Login.panel1,"Reservation ID can not be Empty","Error", JOptionPane.ERROR_MESSAGE);
			}
			else
				if(cancelOrderFrame.textorderID.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(cancelOrderFrame, "Order ID can not be Empty");
					
					//JOptionPane.showMessageDialog(Login.panel1,"Reservation ID can not be Empty","Error", JOptionPane.ERROR_MESSAGE);
				}
				else
					if(cancelOrderFrame.textorderID.getText().trim().length()!=8)
					{
						JOptionPane.showMessageDialog(cancelOrderFrame, "Invalid Order ID");
						
						//JOptionPane.showMessageDialog(Login.panel1,"Invalid Reservation ID","Error", JOptionPane.ERROR_MESSAGE);	
					}
					else
					{
						customer=new Customer();
						ArrayList<OrderBean> list=customer.viewOrder(cancelOrderFrame.textorderID.getText().trim());
						if(list==null)
						{
							JOptionPane.showMessageDialog(cancelOrderFrame, "Invalid order ID");
							
							//JOptionPane.showMessageDialog(Login.panel1,"Invalid Reservation ID","Error", JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							String col[]=new String[]{"Orderid","Userid","Order Date ","Store id","total price ","Order Status ","cart id"};
							String row[][]=new String[list.size()][7];
							int i=0;
							Iterator<OrderBean> itr=list.iterator();
							while(itr.hasNext())
							{
								Order=new OrderBean();
								Order=itr.next();
								row[i][0]=Order.getOrderID();
								row[i][1]=Order.getUserID();
								row[i][2]=Order.getOrderDate().toString();
								row[i][3]=Order.getStoreID();
								row[i][4]=String.valueOf(Order.getTotalPrice());
								row[i][5]=String.valueOf(Order.getOrderStatus());
								row[i][6]=String.valueOf(Order.getCartID());
								//row[i][7]=String.valueOf(Order.getTotalFare());
								//System.out.println("fdsdvz");
								}
							table=new JTable(row,col);
							JScrollPane pane=new JScrollPane(table);
							pane.setBounds(50, 200,600, 100);
							cancelOrderFrame.frame.add(pane);
							//cancelTicketFrame.add(table);
							//cancelOrderFrame.seatnumber.setVisible(true);
							//cancelOrderFrame.seatnumbertext.setVisible(true);
							cancelOrderFrame.creditcardnumber.setVisible(true);
							cancelOrderFrame.creditcardnumbertext.setVisible(true);
							cancelOrderFrame.buttonCancel.setVisible(true);
							
						}	
					}
		}
		
		if(e.getSource()==cancelOrderFrame.buttonCancel)
		{
			int option=JOptionPane.showConfirmDialog(cancelOrderFrame, "You can cancel one Order at a time. Do you really want to cancel the order");
			
			if(option==0)
			{
					if(customer.cancelOrder(cancelOrderFrame.textorderID.getText().trim())==true)
					{
								JOptionPane.showMessageDialog(cancelOrderFrame, "Ticket Ordered");
								POSCustomerMainPageUI posMainPageUI=new POSCustomerMainPageUI();
							}
							else
							{
									JOptionPane.showMessageDialog(cancelOrderFrame, "Invalid order id number");
									
								
							}
			}
				else
				{
					
						if(customer.deletePassenger(Integer.parseInt(cancelOrderFrame.seatnumbertext.getText()))==true)
						{
							if(customer.UpdateReservation(cancelOrderFrame.textReservationID.getText())==true)
							{
								if(customer.creditRefund(Order.getUserID(), Order.getTotalFare()/Order.getNoOfSeats(),cancelOrderFrame.creditcardnumbertext.getText())==true)
								{
									JOptionPane.showMessageDialog(cancelOrderFrame, "Ticket Cancelled");
									cancelOrderFrame.dispose();
									FRSCustomerMainPageUI frsMainPageUI=new FRSCustomerMainPageUI();
								}
								else
								{
										JOptionPane.showMessageDialog(cancelOrderFrame, "Invalid credit card number");
										
									
								}
							}
							else
							{
								JOptionPane.showMessageDialog(cancelOrderFrame, "Invalid reservation id");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(cancelOrderFrame, "Invalid seat number");
						}
					
					
				}
				
				
				
			}
		}
	}
	}

}
*/