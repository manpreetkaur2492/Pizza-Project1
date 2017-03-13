package com.wipro.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.pos.bean.CredentialsBean;
import com.wipro.pos.util.AuthenticationImpl;
import com.wipro.pos.util.DBUtil;

public class LoginDAO {

	Connection con;
	public LoginDAO() throws ClassNotFoundException, SQLException{
		con=DBUtil.getDBConnection("thin");
	}
	public boolean authenticate(CredentialsBean credentialsBean) {
		// TODO Auto-generated method stub
	//	String userId,password;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select Userid,Password from POS_TBL_User_Credentials where Userid=? and Password=?");
			ps.setString(1,credentialsBean.getUserID());
			ps.setString(2,credentialsBean.getPassword());
			ResultSet rs=ps.executeQuery();
			if(rs!=null){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public String authorize(String userId) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		String type=null;
		try {
			ps = con.prepareStatement("select UserType from POS_TBL_User_Credentials where Userid=?");
			ps.setString(1,userId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				type=rs.getString(1);
			}
			return type;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}

	public String changePassword(CredentialsBean credentialsBean,
			String newPassword) {
		// TODO Auto-generated method stub
		PreparedStatement ps;
		//String type=null;
		try {
			System.out.println(credentialsBean.getUserID()+" *******999999999999*********   "+newPassword);
			ps = con.prepareStatement("update POS_TBL_User_Credentials set Password=? where Password=?");
			ps.setString(1,newPassword);
			ps.setString(2,credentialsBean.getPassword());
			int r=ps.executeUpdate();
			System.out.println(r);
			if(r>0){
				return "Success";
			}
			else{
				return "Failure" ;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return "Failure";
		}
	}

	public boolean logout(String userId) {
		// TODO Auto-generated method stub
		AuthenticationImpl auth=new AuthenticationImpl();
		CredentialsBean bean = new CredentialsBean();
		bean.setUserID(userId);
		boolean result=false;
		result = auth.changeLoginStatus(bean, 0);
		return result;
	}
	public CredentialsBean authenticate(String userID) {
		// TODO Auto-generated method stub
		CredentialsBean cb = new CredentialsBean();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from POS_TBL_User_Credentials where userId=?");
			ps.setString(1,userID);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				cb.setUserID(rs.getString(1));
				cb.setPassword(rs.getString(2));
				cb.setUserType(rs.getString(3));
				cb.setLoginStatus(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		return cb;
	}

	/*public boolean remember(String text, String text2) {
		// TODO Auto-generated method stub
		return false;
	}

	public String[] getRememberData() {
		// TODO Auto-generated method stub
		return null;
	}

	*/

}
