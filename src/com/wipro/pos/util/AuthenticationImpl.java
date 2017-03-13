package com.wipro.pos.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.wipro.pos.bean.CredentialsBean;
import com.wipro.pos.dao.LoginDAO;
import com.wipro.pos.ui.Login;

public class AuthenticationImpl implements Authentication{

	LoginDAO logindao;
	public boolean authenticate(CredentialsBean credentialsBean) {
		if(credentialsBean.getUserID()==null||credentialsBean.getPassword()==null){
			JOptionPane.showMessageDialog(Login.panel1, "User Name or password is null","Warning",JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if(credentialsBean.getUserID().isEmpty()||credentialsBean.getPassword().isEmpty()){
				JOptionPane.showMessageDialog(Login.panel1, "User Name or password is empty","Warning",JOptionPane.WARNING_MESSAGE);
				return false;
			}
		
		else if(credentialsBean.getUserID()==credentialsBean.getPassword()){
				JOptionPane.showMessageDialog(Login.panel1, "Please enter a different password","error",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		
		else{
			try {
				logindao = new LoginDAO();
				boolean result2=false;
				boolean result= logindao.authenticate(credentialsBean);
				if(result==true){
					result2=changeLoginStatus(credentialsBean,1);
					
				}
				return result2;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				return false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return false;
			}
			
		}
	}
	public String authorize(String userId)   {
		try {
			logindao=new LoginDAO();
			return logindao.authorize(userId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus){

		Connection con;
		int rows=0;
		try {
			con = DBUtil.getDBConnection("thin");
			PreparedStatement ps= con.prepareStatement("update POS_TBL_User_Credentials set Loginstatus=? where Userid=?");
			ps.setInt(1,loginStatus);
			ps.setString(2,credentialsBean.getUserID());
			rows=ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rows==1){
			return true;
		}
		else{
			return false;
		}
	}
	public CredentialsBean authenticate(String userID) {
		// TODO Auto-generated method stub
			try {
				logindao = new LoginDAO();
				//boolean result2=false;
				CredentialsBean cb= logindao.authenticate(userID);
				return cb;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				return null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return null;
			}
	}
}
