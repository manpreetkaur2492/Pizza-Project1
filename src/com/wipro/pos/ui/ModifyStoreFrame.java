package com.wipro.pos.ui;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.listener.ModifyStoreListener;
import com.wipro.pos.service.Administrator;

public class ModifyStoreFrame
{
	public JFrame frame;
	public JLabel storeid,name,Street,mobile,city,state,pincode;
	public JTextField storeidt,namet,Streett,mobilet,cityt,statet,pincodet;
	public JButton updateButton,cancelButton,viewButton,buttonBack;
	public JOptionPane pane;
	public static Choice choice;
	Administrator administrator;
	ArrayList<StoreBean> list;
	
	public ModifyStoreFrame()
	{
		frame=new JFrame("Modify Store");
		frame.setSize(720,680);
		frame.setResizable(false);
		frame.setLocation(100,100);
		frame.setLayout(null);

		
		//Background
				frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
				frame.setLayout(null);
		

		storeid=new JLabel("StoreID");
		storeid.setBounds(150, 100, 100, 20);
		
		
		name=new JLabel("Name");
		name.setBounds(150, 140, 100, 20);
		
		Street=new JLabel("street");
		Street.setBounds(150, 180, 100, 20);
		
		mobile=new JLabel("Mobile no");
		mobile.setBounds(150, 220, 100, 20);
		
		city=new JLabel("city");
		city.setBounds(150, 260, 100, 20);
		
		state=new JLabel("state");
		state.setBounds(150, 300, 100, 20);
		
		pincode=new JLabel("pincode");
		pincode.setBounds(150, 340, 100, 20);
		
		choice=new Choice();
		choice.setBounds(250, 100, 100, 20);
		
		namet=new JTextField();
		namet.setBounds(250, 140, 100, 20);
		
		Streett=new JTextField();
		Streett.setBounds(250, 180, 100, 20);
		
		mobilet=new JTextField();
		mobilet.setBounds(250, 220, 100, 20);
		
		cityt=new JTextField();
		cityt.setBounds(250, 260, 100, 20);
		
		statet=new JTextField();
		statet.setBounds(250, 300, 100, 20);
		
		pincodet=new JTextField();
		pincodet.setBounds(250, 340, 100, 20);
		
		viewButton=new JButton("View");
		viewButton.setBounds(100, 450, 100, 20);
		updateButton=new JButton("Update");
		updateButton.setBounds(210, 450, 100, 20);
		updateButton.setVisible(true);
		cancelButton=new JButton("Cancel");
		cancelButton.setBounds(320, 450, 100, 20);
		cancelButton.setVisible(true);
		buttonBack=new JButton("Back");
		buttonBack.setBounds(430, 450, 100, 20);
		

		frame.add(storeid);
		frame.add(choice);

		frame.add(name);
		//name.setVisible(false);
		frame.add(namet);
		//namet.setVisible(false);

		frame.add(Street);
		//Street.setVisible(false);
		frame.add(Streett);
		//Streett.setVisible(false);

		frame.add(mobile);
		//mobile.setVisible(false);
		frame.add(mobilet);
		//mobilet.setVisible(false);

		frame.add(city);
		//city.setVisible(false);
		frame.add(cityt);
		//cityt.setVisible(false);

		frame.add(state);
		//city.setVisible(false);
		frame.add(statet);
		//cityt.setVisible(false);
		
		frame.add(pincode);
		//city.setVisible(false);
		frame.add(pincodet);
		//cityt.setVisible(false);

		frame.add(cancelButton);
		frame.add(updateButton);
		frame.add(viewButton);
		frame.add(buttonBack);
		
				administrator=new Administrator();
				list=administrator.viewAllStore();
				Iterator<StoreBean> itr=list.iterator();
				while(itr.hasNext())
				{
					StoreBean storeBean=new StoreBean();
					storeBean=itr.next();
					choice.add(storeBean.getStoreID());
				}
		
		viewButton.addActionListener(new ModifyStoreListener(this));
		updateButton.addActionListener(new ModifyStoreListener(this));
		cancelButton.addActionListener(new ModifyStoreListener(this));
		buttonBack.addActionListener(new ModifyStoreListener(this));
		frame.setVisible(true);
	}
	/*public static void main(String args[]){
		new ModifyStoreFrame();
	}*/

}
