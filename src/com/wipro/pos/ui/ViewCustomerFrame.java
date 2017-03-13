package com.wipro.pos.ui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.bean.ProfileBean;
import com.wipro.pos.listener.Listener;
import com.wipro.pos.listener.ViewCustomerListener;
import com.wipro.pos.service.Administrator;

public class ViewCustomerFrame 
{
	public static JFrame frame,frame1;
	//public static JTable table;
	public static JLabel label,labelFlightID,labelDate;
	//public static DefaultTableModel model=new DefaultTableModel();
	//public static Object object[]=new  Object[5];
	public static JButton ButtonViewFlight,ButtonViewPassenger,buttonBack;
	public static Choice choice,choiceFlightID;
	Administrator administrator;
	public static JDateChooser chooser;
	
	public ViewCustomerFrame()

	{
		frame=new JFrame("View Customer Details");
		frame.setSize(720,680);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocation(100, 100);

		//frame.setLayout(null);
		
		//Background
				frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
				frame.setLayout(null);
		
		label=new JLabel("View All Details Of Passenger");
		label.setBounds(250, 10, 250, 40);
		label.setBackground(Color.orange);
		frame.add(label);
		
		/*labelFlightID=new JLabel("Food ID");
		labelFlightID.setBounds(100, 50, 100, 20);
		frame.add(labelFlightID);
		
		labelDate=new JLabel("Journey Date");
		labelDate.setBounds(100, 100, 100, 20);
		frame.add(labelDate);
		labelDate.setVisible(true);

		choiceFlightID=new Choice();
		choiceFlightID.setBounds(250, 50, 100, 20);
		frame.add(choiceFlightID);

			ArrayList<FoodBean> list=new ArrayList<FoodBean>();
			Administrator administrator = new Administrator();
			list=administrator.viewAllFood(null);
			
			Iterator<FoodBean> itr=list.iterator();
			while(itr.hasNext())
			{
				FoodBean flightBean = new FoodBean();
				flightBean=itr.next();
				choiceFlightID.add(flightBean.getFoodID());
			}
			
			 chooser = new JDateChooser();
			    JTextFieldDateEditor editor = (JTextFieldDateEditor) chooser.getDateEditor();
			    editor.setEditable(false);
			    chooser.setLocale(Locale.US);
			    chooser.setMinSelectableDate(new Date());
			    chooser.setBounds(250, 100, 100, 20);
			    frame.add(chooser);
//	
//			administrator=new Administrator();
//			ArrayList<RouteBean> list1=administrator.viewByAllRoute();
//			Iterator<RouteBean> itr1=list1.iterator();
//			while(itr1.hasNext())
//			{
//				RouteBean rb=new RouteBean();
//				rb=itr1.next();
//				choiceRouteID.add(rb.getRouteID());
//			}
//			
//			administrator=new Administrator();
//			ArrayList<String> list2=administrator.getScheduleIDForPAsseneger(choiceFlightID.getSelectedItem(), choiceRouteID.getSelectedItem());
//			Iterator<String> itr2=list2.iterator();
//			while(itr2.hasNext())
//			{
//				choiceScheduleID.add(itr2.next());
//			}
		*/
		int i=0;
		 Administrator administrator = new Administrator();
		ArrayList<ProfileBean> list=new ArrayList<ProfileBean>();
		String col[]=new String[]{"User ID","First Name","Last Name","Date Of Birth","Gender","Street","Location","City","State","Pincode","Mobile No","Email"};
		
		list=administrator.viewAllCustomer();
		String rows[][]=new String[list.size()][12];
		Iterator<ProfileBean> itr=list.iterator();
		while(itr.hasNext())
		{
			 ProfileBean profileBean = new ProfileBean();
			 profileBean=itr.next();
			rows[i][0]=profileBean.getUserID();
			rows[i][1]=profileBean.getFirstName();
			rows[i][2]=profileBean.getLastName();
			rows[i][3]=profileBean.getDateOfBirth().toString();
			rows[i][4]=profileBean.getGender();
			rows[i][5]=profileBean.getStreet();
			rows[i][6]=profileBean.getLocation();
			rows[i][7]=profileBean.getCity();
			rows[i][8]=profileBean.getState();
			rows[i][9]=profileBean.getPincode();
			rows[i][10]=profileBean.getMobileNo();
			rows[i][11]=profileBean.getEmailID();
			i++;
		}
		
		JTable tableViewAll=new JTable(rows,col);
		tableViewAll.setVisible(false);
		JScrollPane pane=new JScrollPane(tableViewAll);
		pane.setBounds(50, 50,500,300);
		((Container) ViewCustomerFrame.frame).add(pane);
		tableViewAll.setVisible(true);
		//frame.add(tableViewAll);
				buttonBack=new JButton("Back");
				buttonBack.setBounds(300,600,100,20);
				buttonBack.setBackground(Color.orange);
				frame.add(buttonBack);

		/*ButtonViewFlight=new JButton("View");
		ButtonViewFlight.setBounds(400,100,100,20);
		ButtonViewFlight.setBackground(Color.orange);
		frame.add(ButtonViewFlight);*/
		
//		ButtonViewRoute=new JButton("View");
//		ButtonViewRoute.setBounds(400,100,100,20);
//		ButtonViewRoute.setBackground(Color.orange);
//		frame.add(ButtonViewRoute);
//		ButtonViewRoute.setVisible(false);
//		
//		ButtonViewPassenger=new JButton("View Passengers");
//		ButtonViewPassenger.setBounds(400,150,100,20);
//		ButtonViewPassenger.setBackground(Color.orange);
//		frame.add(ButtonViewPassenger);
//		ButtonViewPassenger.setVisible(false);
		
		//ButtonViewFlight.addActionListener(new ViewCustomerListener(this));
//		ButtonViewRoute.addActionListener(this);
//		ButtonViewPassenger.addActionListener(new ViewPassengerListener(this));
		buttonBack.addActionListener(new Listener(this));
		/*JFrame frame1=new JFrame("Passenger Details");
		frame.setSize(720,680);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);*/
	}
//	public static void main(String[] args) 
//	{
//		new ViewPassengerFrame();
//
//	}
	//@Override
	//public void actionPerformed(ActionEvent arg0) 
	//{
		//if(arg0.getSource()==ButtonViewFlight)
		//{
			//labelDate.setVisible(true);
//			choiceRouteID.setVisible(true);
//			ButtonViewRoute.setVisible(true);
			
		//}
		
		//if(arg0.getSource()==buttonBack)
		//{
		//	ViewCustomerFrame.frame.setVisible(false);
		//	AdminUI.frame.setVisible(true);
		//}
	//}
	/*public static void main(String args[]){
		new ViewCustomerFrame();
	}*/
}

