package com.wipro.pos.listener;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;







//import com.wipro.pos.ui.CancelOrderFrame;
import com.wipro.pos.ui.ChangePassword;
import com.wipro.pos.ui.Login;
import com.wipro.pos.ui.POSCustomerMainPageUI;
import com.wipro.pos.ui.POSCustomerViewPageUI;
import com.wipro.pos.ui.POSModifyCartUI;
import com.wipro.pos.ui.POSViewCartUI;
import com.wipro.pos.ui.POSViewFoodUI;
import com.wipro.pos.ui.POSViewOrderUI;
import com.wipro.pos.util.UserImpl;

public class POSCustomerMainPageUIListener implements ActionListener{
public static POSCustomerMainPageUI cmp;
	
	public POSCustomerMainPageUIListener(POSCustomerMainPageUI posCustomerMainPageUI) {
	cmp=posCustomerMainPageUI;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==cmp.viewStoreButton){
			cmp.mainPanel.removeAll();
			cmp.mainPanel.setVisible(false);
			POSCustomerViewPageUI posCustomerViewPageUI=new POSCustomerViewPageUI();
			posCustomerViewPageUI.setBounds(220, 20,460, 600);
			cmp.add(posCustomerViewPageUI);
			posCustomerViewPageUI.setVisible(true);
		}
		if(e.getSource()==cmp.viewOrderButton)
		{
			cmp.mainPanel.removeAll();
			cmp.mainPanel.setVisible(false);
			POSViewOrderUI posviewOrderUI=new POSViewOrderUI();
			posviewOrderUI.setBounds(220, 20,460, 600);
			cmp.add(posviewOrderUI);
			posviewOrderUI.setVisible(true);
		}
		if(e.getSource()==cmp.viewfButton)
		{
			cmp.mainPanel.removeAll();
			cmp.mainPanel.setVisible(false);
			POSViewFoodUI posviewfoodUI=new POSViewFoodUI();
			posviewfoodUI.setBounds(220, 20,460, 600);
			cmp.add(posviewfoodUI);
			posviewfoodUI.setVisible(true);
		}
		if(e.getSource()==cmp.viewButton)
		{
			cmp.mainPanel.removeAll();
			cmp.mainPanel.setVisible(false);
			POSViewCartUI posviewfoodUI=new POSViewCartUI();
			posviewfoodUI.setBounds(220, 20,460, 600);
			cmp.add(posviewfoodUI);
			posviewfoodUI.setVisible(true);
		}
		if(e.getSource()==cmp.viewmodifyButton)
		{
			cmp.mainPanel.removeAll();
			cmp.mainPanel.setVisible(false);
			POSModifyCartUI posviewfoodUI=new POSModifyCartUI();
		//	((Component) posviewfoodUI).setBounds(220, 20,460, 600);
		//	cmp.add(posviewfoodUI);
		//	posviewfoodUI.setVisible(true);
		}
	}
}
