package com.wipro.pos.listener;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.bean.ProfileBean;
import com.wipro.pos.service.Administrator;
import com.wipro.pos.ui.AdminUI;
import com.wipro.pos.ui.AdminViewAll;
import com.wipro.pos.ui.ViewCustomerFrame;

public class ViewCustomerListener implements ActionListener {

	ViewCustomerFrame viewCustomerFrame;

	public ViewCustomerListener(ViewCustomerFrame viewCustomerFrame) {
		// TODO Auto-generated constructor stub
		this.viewCustomerFrame=viewCustomerFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		/*String scheduleID="";
		if(e.getSource()==ViewPassengerFrame.ButtonViewFlight)
		{
			ViewPassengerFrame.choiceFlightID.setVisible(false);
			ViewPassengerFrame.chooser.setVisible(false);
			ArrayList<ReservationBean> list=new ArrayList<ReservationBean>();
			Administrator administrator=new Administrator();
			Connection con;
			try {
				con = DBUtil.getDBConnection("thin");
				PreparedStatement ps=con.prepareStatement("select * from FRS_TBL_Schedule where Flightid=? and departureDate=?");
				ps.setString(1, ViewPassengerFrame.choiceFlightID.getSelectedItem());
				ps.setDate(2, new java.sql.Date(ViewPassengerFrame.chooser.getDate().getTime()));
				ResultSet rs= ps.executeQuery();
				while(rs.next())
				{
					scheduleID=rs.getString(1);
				}
			} 
			catch (ClassNotFoundException | SQLException e1) 
			{
				e1.printStackTrace();
			}
			
			if(scheduleID=="")
			{
				JOptionPane.showMessageDialog(ViewPassengerFrame.frame, "No schedule on this Date");
			}
			else
			{
				list=administrator.getPassengerDetails(scheduleID);
				
				String col[]=new String[]{"Reservationid","Userid","Scheduleid","Reservationtype","Bookingdate","Journeydate","Noofseats","Totalfare","Bookingstatus"};
				String rows[][]=new String[list.size()][9];
				int i=0;
				Iterator<ReservationBean> itr=list.iterator();
				while(itr.hasNext())
				{
					ReservationBean reservationBean=new ReservationBean();
					reservationBean=itr.next();
					rows[i][0]=reservationBean.getReservationID();
					rows[i][1]=reservationBean.getUserID();
					rows[i][2]=reservationBean.getScheduleID();
					rows[i][3]=reservationBean.getReservationType();
					rows[i][4]=String.valueOf(reservationBean.getBookingDate());
					rows[i][5]=String.valueOf(reservationBean.getJourneyDate());
					rows[i][6]=String.valueOf(reservationBean.getNoOfSeats());
					rows[i][7]=String.valueOf(reservationBean.getTotalFare());
					rows[i][8]=String.valueOf(reservationBean.getBookingStatus());
				}
				
				JTable table=new JTable(rows,col);
				JScrollPane pane=new JScrollPane(table);
				pane.setBounds(50,250,600,350);
				ViewCustomerFrame.frame.add(pane);
			}
			
			/*
			viewPassengerFrame.model.getDataVector().removeAllElements();

			
			Administrator administrator=new Administrator();
			ArrayList<String> list=new ArrayList<String>();
			ArrayList<ScheduleBean> al=administrator.viewByAllSchedule();
			list.add(viewPassengerFrame.jc.getSelectedItem().toString());
			
			int a=0;
			Iterator<String> i=list.iterator();
			while(i.hasNext())
			{
				
				PassengerBean passengerBean= (PassengerBean) i.next();
				
				viewPassengerFrame.object[0]=passengerBean.getReservationID();
				viewPassengerFrame.object[1]=passengerBean.getName();
				viewPassengerFrame.object[2]=passengerBean.getGender();
				viewPassengerFrame.object[3]=passengerBean.getAge();
				viewPassengerFrame.object[4]=passengerBean.getSeatNo();
				
				viewPassengerFrame.model.addRow(viewPassengerFrame.object);
				
				viewPassengerFrame.table.setVisible(true);
				*/	
						
			
			if(arg0.getSource()==AdminUI.item4View){
			AdminUI.frame.setVisible(false);
			new ViewCustomerFrame();
			
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
				rows[i][5]=profileBean.getLocation();
				rows[i][5]=profileBean.getCity();
				rows[i][5]=profileBean.getState();
				rows[i][5]=profileBean.getPincode();
				rows[i][5]=profileBean.getMobileNo();
				rows[i][5]=profileBean.getEmailID();
				i++;
			}
			
			JTable tableViewAll=new JTable(rows,col);
			tableViewAll.setVisible(false);
			JScrollPane pane=new JScrollPane(tableViewAll);
			pane.setBounds(50, 50,500,300);
			((Container) AdminViewAll.frame).add(pane);
			tableViewAll.setVisible(true);
			}
	}
}


