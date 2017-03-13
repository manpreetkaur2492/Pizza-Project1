package com.wipro.pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.service.Administrator;
import com.wipro.pos.ui.AdminUI;
import com.wipro.pos.ui.DeleteStoreFrame;

public class DeleteStoreListener implements ActionListener
{
	DeleteStoreFrame deleteStoreFrame;
	public DeleteStoreListener(DeleteStoreFrame deleteStoreFrame)
	{
		this.deleteStoreFrame=deleteStoreFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==DeleteStoreFrame.buttonDelete)
		{
			Administrator administrator=new Administrator();
			ArrayList<String> list=new ArrayList<String>();
			list.add(DeleteStoreFrame.choice.getSelectedItem());
			int a=administrator.removeStore(list);
			if(a==1)
			{
				JOptionPane.showMessageDialog(DeleteStoreFrame.frame,"Deleted Successfully..","Success", JOptionPane.PLAIN_MESSAGE);
				DeleteStoreFrame.choice.removeAll();
				
				administrator=new Administrator();
				ArrayList<StoreBean> list1;
				list1=administrator.viewAllStore();
				Iterator<StoreBean> itr=list1.iterator();
				while(itr.hasNext())
				{
					StoreBean rb=new StoreBean();
					rb=itr.next();
					DeleteStoreFrame.choice.add(rb.getStoreID());
				}
			}
			else
			{
				JOptionPane.showMessageDialog(DeleteStoreFrame.frame,"Failed: InvalidID or Flight is booked","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==DeleteStoreFrame.buttonBack)
		{
			DeleteStoreFrame.frame.dispose();
			AdminUI.frame.setVisible(true);
		}

	}

}
