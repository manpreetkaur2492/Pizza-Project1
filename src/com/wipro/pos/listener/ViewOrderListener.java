package com.wipro.pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JScrollPane;

import com.wipro.pos.bean.OrderBean;
import com.wipro.pos.service.Administrator;
import com.wipro.pos.ui.AdminUI;
import com.wipro.pos.ui.ViewOrderFrame;

public class ViewOrderListener implements ActionListener {

	ViewOrderFrame viewOrderFrame;

	public ViewOrderListener(ViewOrderFrame viewOrderFrame) {
		// TODO Auto-generated constructor stub
		this.viewOrderFrame=viewOrderFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==viewOrderFrame.backButton)
		{
			viewOrderFrame.dispose();
			AdminUI.frame.setVisible(true);
		}
		if(e.getSource()==viewOrderFrame.viewButton)
		{
			viewOrderFrame.model.getDataVector().removeAllElements();
			
			Administrator administrator=new Administrator();
			ArrayList<OrderBean> al=administrator.viewAllOrder();

			int a=0;
			Iterator<OrderBean> i=al.iterator();
			while(i.hasNext())
			{
				OrderBean scheduleBean=new OrderBean();
				scheduleBean=i.next();
				//scheduleBean=al.get(a);
				viewOrderFrame.object[0]=scheduleBean.getOrderID();
				viewOrderFrame.object[1]=scheduleBean.getUserID();
				viewOrderFrame.object[2]=scheduleBean.getOrderDate();
				viewOrderFrame.object[3]=scheduleBean.getStoreID();
				viewOrderFrame.object[4]=scheduleBean.getTotalPrice();
				viewOrderFrame.object[5]=scheduleBean.getOrderStatus();
				viewOrderFrame.object[6]=scheduleBean.getCartID();
				viewOrderFrame.object[7]=scheduleBean.getStreet();
				viewOrderFrame.object[8]=scheduleBean.getCity();
				viewOrderFrame.object[9]=scheduleBean.getState();
				viewOrderFrame.object[10]=scheduleBean.getPincode();
				viewOrderFrame.object[11]=scheduleBean.getMobileNo();
				
				viewOrderFrame.model.addRow(viewOrderFrame.object);
				a++;
			}
			JScrollPane pane=new JScrollPane(viewOrderFrame.table);
			pane.setBounds(100, 200,500,400);
			viewOrderFrame.add(pane);
			viewOrderFrame.table.setVisible(true);
			}
	}	
	}


