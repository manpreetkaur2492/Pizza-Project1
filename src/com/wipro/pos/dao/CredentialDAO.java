package com.wipro.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wipro.pos.bean.ProfileBean;
import com.wipro.pos.util.DBUtil;

public class CredentialDAO {

	Connection con;
	CredentialDAO(){
		try {
			con=DBUtil.getDBConnection("thin");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String registerUser(ProfileBean profileBean) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("insert into POS_TBL_User_Credentials values(?,?,?,?)");
			ps.setString(1, profileBean.getUserID());
			ps.setString(2, profileBean.getPassword());
			ps.setString(3,"C");
			//ps.setDate(3, new java.sql.Date(date.getTime()));
			//pstmt1.setDate(4,new java.sql.Date(reservationbean.getJourneyDate().getTime()));
			ps.setInt(4,0);
			int num=ps.executeUpdate();
			System.out.println(num);
			if(num==1){
				return "REGISTERED";
			}
			else{
				return "Failure";
			}
	}catch(Exception e){
		System.out.println(e);
		return "Failure";
	}
	}

}
