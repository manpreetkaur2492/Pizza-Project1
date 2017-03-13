package com.wipro.pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.pos.bean.CartBean;
import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.dao.CartDAO;
import com.wipro.pos.service.Customer;
import com.wipro.pos.ui.Login;
import com.wipro.pos.ui.POSViewCartUI;

public class POSCustomerViewCartPageListener implements ActionListener {

	POSViewCartUI pos;
	public POSCustomerViewCartPageListener(POSViewCartUI posViewCartUI) {
		// TODO Auto-generated constructor stub
		pos=posViewCartUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==pos.searchButton){
			int count1=0;
			
			
				
						pos.model.getDataVector().removeAllElements();
						CartDAO customer=new CartDAO();
						
						ArrayList<CartBean> al=new ArrayList<CartBean>();
						try {
							al=customer.findCart(Login.textUserID.getText().trim());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(al==null)
						{
								JOptionPane.showMessageDialog(pos, "Sorry!! No  cart  available");	
						}
						else
							{
								
								
									
									Iterator<CartBean> itr=al.iterator();
								
									
									while(itr.hasNext())
									{
										CartBean sd = new CartBean();
										
										sd=itr.next();
										
										pos.rows[0]=sd.getCartID();
										//System.out.println(pos.rows[0]);
										pos.rows[1]=sd.getUserID();
										pos.rows[2]=sd.getFoodID();
										pos.rows[3]=sd.getType();
										pos.rows[4]=sd.getQuantity();
										pos.rows[5]=sd.getCost();
										pos.rows[6]=sd.getOrderDate().toString();
											pos.model.addRow(pos.rows);
											count1++;
									}
									
									pos.add(pos.pane);
								
								
							}
		}
	}

}
