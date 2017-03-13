package com.wipro.pos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.service.Administrator;
import com.wipro.pos.ui.AdminDelete;
import com.wipro.pos.ui.AdminUI;
import com.wipro.pos.ui.AdminView;
import com.wipro.pos.ui.viewFoodById;

public class ViewFoodListener implements ActionListener {

	viewFoodById viewFoodById;
	Administrator administrator;
	AdminView adminView;
	public ViewFoodListener(viewFoodById viewFoodById) {
		// TODO Auto-generated constructor stub
		this.viewFoodById=viewFoodById;
	}

	public ViewFoodListener(AdminView adminView) {
		// TODO Auto-generated constructor stub
		this.adminView=adminView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==AdminView.buttonBack)
		{
			AdminView.frame.dispose();
			AdminUI.frame.setVisible(true);
		}
		if(e.getSource()==AdminView.buttonView){
			administrator=new Administrator();
			//ArrayList<String> list=new ArrayList<String>();
			
			if(AdminView.choice.getSelectedItem().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(AdminDelete.frame,"ID cann't be null","Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(AdminView.choice.getSelectedItem().trim().length()<6)
			{
				JOptionPane.showMessageDialog(AdminDelete.frame,"Invalid ID","Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				//list.add((AdminView.choice.getSelectedItem().trim()));
				if(administrator.viewFood(AdminView.choice.getSelectedItem().trim())!=null)
				{
					AdminView.model.getDataVector().removeAllElements();
					Administrator administrator=new Administrator();
					FoodBean al1=administrator.viewFood(AdminView.choice.getSelectedItem().trim());
					ArrayList<FoodBean> al=new ArrayList<FoodBean>();
					al.add(al1);
					//ViewStoreFrame viewStoreFrame.object[] = new ViewStoreFrame[7];
					int a=0;
					Iterator<FoodBean> i=al.iterator();
					while(i.hasNext())
					{
						FoodBean routeBean=i.next();
						routeBean=al.get(a);
						AdminView.object[0]=routeBean.getFoodID();
						AdminView.object[1]=routeBean.getName();
						AdminView.object[2]=routeBean.getType();
						AdminView.object[3]=routeBean.getFoodSize();
						AdminView.object[4]=routeBean.getQuantity();
						AdminView.object[5]=routeBean.getPrice();
					//	viewFoodById.object[6]=routeBean.getPincode();
						AdminView.model.addRow(AdminView.object);
						a++;
					}
					AdminView.table.setVisible(true);
					JScrollPane pane=new JScrollPane(AdminView.table);
					pane.setBounds(100,200,500,400);
					AdminView.frame.add(pane);
				}
				else
				{
					JOptionPane.showMessageDialog(AdminDelete.frame,"Failure-IncorectID or Food is ordered","Error", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		}
	}

}
