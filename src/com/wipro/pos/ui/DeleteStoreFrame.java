package com.wipro.pos.ui;

import java.awt.Choice;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.listener.DeleteStoreListener;
import com.wipro.pos.service.Administrator;

public class DeleteStoreFrame
{
	public static JFrame frame;
	public static JLabel label;
	public static Choice choice;
	public static JButton buttonDelete,buttonBack;
	Administrator administrator;
	
	public DeleteStoreFrame()
	{
		frame=new JFrame("Delete Route");
		frame.setSize(720,680);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocation(100, 100);
frame.setLayout(null);
		
		//Background
				frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
				frame.setLayout(null);
		
		label=new JLabel("Store ID");
		label.setBounds(150, 50, 100, 20);
		frame.add(label);
		
		choice=new Choice();
		choice.setBounds(250, 50, 100, 20);
		frame.add(choice);
		
		buttonDelete=new JButton("Delete");
		buttonDelete.setBounds(400, 50, 100, 20);
		frame.add(buttonDelete);
		
		buttonBack=new JButton("Back");
		buttonBack.setBounds(300, 500, 100, 30);
		frame.add(buttonBack);
		
		buttonBack.addActionListener(new DeleteStoreListener(this)); 
		buttonDelete.addActionListener(new DeleteStoreListener(this));
		
			administrator=new Administrator();
			ArrayList<StoreBean> list;
			list=administrator.viewAllStore();
			Iterator<StoreBean> itr=list.iterator();
			while(itr.hasNext())
			{
				StoreBean rb=new StoreBean();
				rb=itr.next();
				choice.add(rb.getStoreID());
			}
			
		frame.setVisible(true);
	}
	
}
