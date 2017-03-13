package com.wipro.pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.service.Administrator;
import com.wipro.pos.ui.AdminDelete;
import com.wipro.pos.ui.AdminUI;
import com.wipro.pos.ui.AdminView;
import com.wipro.pos.ui.StoreView;

public class ViewStoreIdListener implements ActionListener {

	Administrator administrator;
	StoreView storeView;
	
	public ViewStoreIdListener(StoreView storeView) {
		// TODO Auto-generated constructor stub
		this.storeView=storeView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==StoreView.ButtonBack)
		{
			storeView.dispose();
			AdminUI.frame.setVisible(true);
		}
		if(e.getSource()==StoreView.ButtonView){
			administrator=new Administrator();
			//ArrayList<String> list=new ArrayList<String>();
			
			if(StoreView.choice.getSelectedItem().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(AdminDelete.frame,"ID cann't be null","Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(StoreView.choice.getSelectedItem().trim().length()<6)
			{
				JOptionPane.showMessageDialog(AdminDelete.frame,"Invalid ID","Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				//list.add((AdminView.choice.getSelectedItem().trim()));
				if(administrator.viewStore(StoreView.choice.getSelectedItem().trim())!=null)
				{
					storeView.model.getDataVector().removeAllElements();
					Administrator administrator=new Administrator();
					StoreBean al1=administrator.viewStore(StoreView.choice.getSelectedItem().trim());
					ArrayList<StoreBean> al=new ArrayList<StoreBean>();
					al.add(al1);
					//ViewStoreFrame viewStoreFrame.object[] = new ViewStoreFrame[7];
					int a=0;
					Iterator<StoreBean> i=al.iterator();
					while(i.hasNext())
					{
						StoreBean routeBean=i.next();
						routeBean=al.get(a);
						storeView.object[0]=routeBean.getStoreID();
						storeView.object[1]=routeBean.getName();
						storeView.object[2]=routeBean.getStreet();
						storeView.object[3]=routeBean.getMobileNo();
						storeView.object[4]=routeBean.getCity();
						storeView.object[5]=routeBean.getState();
						storeView.object[6]=routeBean.getPincode();
						storeView.model.addRow(storeView.object);
						a++;
					}
					storeView.table.setVisible(true);
					JScrollPane pane=new JScrollPane(storeView.table);
					pane.setBounds(100,200,500,400);
					storeView.add(pane);
				}
				else
				{
					JOptionPane.showMessageDialog(AdminDelete.frame,"Failure-IncorectID","Error", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		}
	}

}
