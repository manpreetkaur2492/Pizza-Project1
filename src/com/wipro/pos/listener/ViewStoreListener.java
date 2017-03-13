package com.wipro.pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JScrollPane;

import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.service.Administrator;
import com.wipro.pos.ui.AdminUI;
import com.wipro.pos.ui.ViewStoreFrame;

public class ViewStoreListener implements ActionListener {

	ViewStoreFrame viewStoreFrame;

	public ViewStoreListener(ViewStoreFrame viewStoreFrame) {
		// TODO Auto-generated constructor stub

		this.viewStoreFrame=viewStoreFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==viewStoreFrame.ButtonBack)
		{
			viewStoreFrame.dispose();
			AdminUI.frame.setVisible(true);
		}	
		if(e.getSource()==viewStoreFrame.ButtonView)
		{

			
			viewStoreFrame.model.getDataVector().removeAllElements();
			Administrator administrator=new Administrator();
			ArrayList<StoreBean> al=administrator.viewAllStore();
			//ViewStoreFrame viewStoreFrame.object[] = new ViewStoreFrame[7];
			int a=0;
			Iterator<StoreBean> i=al.iterator();
			while(i.hasNext())
			{
				StoreBean routeBean=i.next();
				routeBean=al.get(a);
				viewStoreFrame.object[0]=routeBean.getStoreID();
				viewStoreFrame.object[1]=routeBean.getName();
				viewStoreFrame.object[2]=routeBean.getStreet();
				viewStoreFrame.object[3]=routeBean.getMobileNo();
				viewStoreFrame.object[4]=routeBean.getCity();
				viewStoreFrame.object[5]=routeBean.getState();
				viewStoreFrame.object[6]=routeBean.getPincode();
				viewStoreFrame.model.addRow(viewStoreFrame.object);
				a++;
			}
			viewStoreFrame.table.setVisible(true);
			JScrollPane pane=new JScrollPane(viewStoreFrame.table);
			pane.setBounds(100,200,500,400);
			viewStoreFrame.add(pane);

		}
	}
	}

