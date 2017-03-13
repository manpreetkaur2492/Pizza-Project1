package com.wipro.pos.util;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.wipro.pos.bean.CredentialsBean;
import com.wipro.pos.bean.ProfileBean;
import com.wipro.pos.dao.CustomerDAO;
import com.wipro.pos.dao.LoginDAO;
import com.wipro.pos.ui.AdminPassword;

public class UserImpl implements User{

	AuthenticationImpl auth;
	LoginDAO dao;
	public String login(CredentialsBean credentialsBean)  {
		//CredentialsBean cb=new CredentialsBean();
		String cb;
		try {
			dao=new LoginDAO();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String flag="invalid";
		auth=new AuthenticationImpl();
		boolean result=auth.authenticate(credentialsBean);
		/*if(result==true){
			cb=auth.authorize(credentialsBean.getUserID());
			if(!cb.getUserType().isEmpty()){
				credentialsBean.setUserType(cb.getUserType());
			}
		}*/
		if(result==true){
			cb=auth.authorize(credentialsBean.getUserID());
			if(!cb.isEmpty()){
				credentialsBean.setUserType(cb);
				boolean result1;
				try {
					result1 = auth.changeLoginStatus(credentialsBean, 1);
					if(result1==true){
						flag=credentialsBean.getUserType();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
			return flag;
		
	}
	public boolean logout(String userId) {
		boolean flag=false;
		LoginDAO dao;
		try {
			dao = new LoginDAO();
			flag=dao.logout(userId);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return flag;
	}
	public String changePassword(CredentialsBean credentialsBean, String newPassword) {
		String flag="Failure";
		if(credentialsBean.getUserID()==null||credentialsBean.getPassword()==null||newPassword.isEmpty()){
				JOptionPane.showMessageDialog(AdminPassword.frame, "User name or password is null","Warning",JOptionPane.WARNING_MESSAGE);
				return "Failure";
		}
		else{
			LoginDAO dao;
			try {
				System.out.println(credentialsBean.getUserID()+" ****************   "+newPassword);
				dao = new LoginDAO();
				flag= dao.changePassword(credentialsBean,newPassword);
				System.out.println(flag);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}
	}
	public String register(ProfileBean profileBean) {
		String flag="FAIL";
		if(profileBean==null){
			flag="DATA INVALID";	
		}
		else if(profileBean.getFirstName().isEmpty()||profileBean.getLastName().isEmpty()||profileBean.getDateOfBirth().toString().isEmpty()||profileBean.getGender().isEmpty()||profileBean.getStreet().isEmpty()||profileBean.getLocation().isEmpty()||profileBean.getCity().isEmpty()||profileBean.getState().isEmpty()||profileBean.getPincode().isEmpty()||profileBean.getMobileNo().isEmpty()||profileBean.getEmailID().isEmpty()||profileBean.getPassword().isEmpty()){
				flag="DATA INVALID";
		}
		else if(profileBean.getFirstName().length()<2){
			flag="First Name should be greater than 2 characters";
		}
		else if(profileBean.getLastName().length()<2){
			flag="Last Name should be greater than 2 characters";
		}
		else if(profileBean.getCity().length()<2||profileBean.getState().length()<2||profileBean.getLocation().length()<2||profileBean.getStreet().length()<2)
		{
			flag="Address should be greater than 2 characters";
		}
		else if(profileBean.getPincode().length()!=6){
			flag="PINCODE INVALID";
		}
		else if(profileBean.getMobileNo().length()<10||profileBean.getMobileNo().length()>10){
			flag="MOBILE NUMBER INVALID";
		}
		else{
			CustomerDAO dao= new CustomerDAO();
			String id=null;
			try {
				id = dao.generateCustomerID(profileBean);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(id);
			profileBean.setUserID(id);
			if(id.equals("Failure")){
				
			}
			else{
				String result=dao.registerCustomer(profileBean);
				System.out.println(result);
				if(result.equals("REGISTERED")){
					flag=profileBean.getUserID();
				}
			}
		}
		return flag;
	}
/*	public String[] getRememberedData() {
		// TODO Auto-generated method stub
		String arr[]=new String[2];
		
		try{
			LoginDAO dao=new LoginDAO();
			arr=dao.getRememberData();
		}catch(Exception e){
			e.printStackTrace();
		}
		return arr;
	}
	public boolean remember(String text, String text2) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		try{
			LoginDAO dao=new LoginDAO();
			result=dao.remember(text,text2);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}*/
}
