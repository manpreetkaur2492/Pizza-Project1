package com.wipro.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.pos.bean.CreditCardBean;
import com.wipro.pos.bean.ProfileBean;
import com.wipro.pos.util.DBUtil;
import com.wipro.pos.util.Payment;

public class CustomerDAO {

	Connection con;
	public CustomerDAO(){
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
	public boolean findByCardNumber(String userid, String cardnumber) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("select * from POS_TBL_CreditCard where userId=? and creditcardnumber=?");
			ps.setString(1, userid);
			ps.setString(2,cardnumber);
			ResultSet rs= ps.executeQuery();
			if(rs==null){
				return false;
			}
			else{
				return true;
			}
		}catch(Exception e){
			return false;
		}
		
	}
	public String process(Payment payment, float totalamount) {
		// TODO Auto-generated method stub
		return null;
	}
	public CreditCardBean getCardDetails(String userid, String cardnumber,
			String validFrom, String validTo) {
		// TODO Auto-generated method stub
		CreditCardBean ccb = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from POS_TBL_CreditCard where userId=? and creditcardnumber=? and validfrom=? and validto=?");
			ps.setString(1, userid);
			ps.setString(2,cardnumber);
			ps.setString(3,validFrom);
			ps.setString(4,validTo);
			ResultSet rs= ps.executeQuery();
			if(rs==null){
				return null;
			}
			else{
				while(rs.next()){
					 ccb=new CreditCardBean();
					ccb.setCreditCardNumber(rs.getString(1));
					ccb.setValidFrom(rs.getString(2));
					ccb.setValidTo(rs.getString(3));
					ccb.setBalance(rs.getDouble(4));
					ccb.setUserId(rs.getString(5));
				}
				return ccb;
			}
		}catch(Exception e){
			return null;
		}
		
	}
	public String generateCustomerID(ProfileBean profileBean) throws SQLException {
		// TODO Auto-generated method stub
		String sid = null;
		String id=null;
		String s =profileBean.getFirstName().toUpperCase();
	     s= s.substring(0, 2);
	    PreparedStatement ps = con.prepareStatement("select pos_seq_userid.nextval from dual");
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()){
	    	 sid = rs.getString(1);
	    
	     id = s.concat(sid); 
	    }
	    return id;
	}
	public String registerCustomer(ProfileBean profileBean) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = con.prepareStatement("insert into POS_TBL_User_Profile values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, profileBean.getUserID());
			ps.setString(2, profileBean.getFirstName());
			ps.setString(3, profileBean.getLastName());
			//ps.setDate(3, new java.sql.Date(date.getTime()));
			//pstmt1.setDate(4,new java.sql.Date(reservationbean.getJourneyDate().getTime()));
			ps.setDate(4,new java.sql.Date(profileBean.getDateOfBirth().getTime()));
			ps.setString(5, profileBean.getGender());
			ps.setString(6, profileBean.getStreet());
			ps.setString(7, profileBean.getLocation());
			ps.setString(8, profileBean.getCity());
			ps.setString(9, profileBean.getState());
			ps.setString(10, profileBean.getPincode());
			ps.setString(11,profileBean.getMobileNo());
			ps.setString(12,profileBean.getEmailID());
			int num=ps.executeUpdate();
			System.out.println(num);
			if(num==1){
				CredentialDAO dao= new CredentialDAO();
				String result=dao.registerUser(profileBean);
				if(result.equals("REGISTERED")){
					return "REGISTERED";
				}
				return "REGISTERED";
			}
			else{
				return "Failure";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		return "Failure";
		}
	}
	public ArrayList<ProfileBean> viewCustomer() {
		// TODO Auto-generated method stub
		ArrayList<ProfileBean> view = new ArrayList<ProfileBean>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from POS_TBL_User_Profile");
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				ProfileBean fb= new ProfileBean();
				fb.setUserID(rs.getString(1));
				fb.setFirstName(rs.getString(2));
				fb.setLastName(rs.getString(3));
				fb.setDateOfBirth(rs.getDate(4));
				fb.setGender(rs.getString(5));
				fb.setStreet(rs.getString(6));
				fb.setLocation(rs.getString(7));
				fb.setCity(rs.getString(8));
				fb.setState(rs.getString(9));
				fb.setPincode(rs.getString(10));
				fb.setMobileNo(rs.getString(11));
				fb.setEmailID(rs.getString(12));
				view.add(fb);
			}
			return view;
		}catch(Exception e){
			return null;
		}
		
	}
	

}
