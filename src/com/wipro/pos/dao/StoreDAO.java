package com.wipro.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.util.DBUtil;

public class StoreDAO {
	Connection con;
	public StoreDAO(){
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
	public String createStore(StoreBean storebean) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into POS_TBL_PizzaStore values(?,?,?,?,?,?,?)");
			ps.setString(1, storebean.getStoreID());
			ps.setString(2, storebean.getName());
			ps.setString(3, storebean.getStreet());
			ps.setString(4,storebean.getMobileNo());
			ps.setString(5, storebean.getCity());
			ps.setString(6,storebean.getState());
			ps.setString(7,storebean.getPincode());
			int update=ps.executeUpdate();
			if(update==1){
				return "SUCCESS";
			}
			else{
				return "FAIL";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		} 

	}
	public ArrayList<StoreBean> findAll(String city){
		ArrayList<StoreBean> view = new ArrayList<StoreBean>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from POS_TBL_PizzaStore where city = ?");
			ps.setString(1, city);
			//System.out.println("**selecting from table**");
			ResultSet rs= ps.executeQuery();
			//System.out.println("**adding to array**");
			while(rs.next()){
				//System.out.println("**adding to array**");
				StoreBean sb= new StoreBean();
				//System.out.println("**adding to array**");
				sb.setStoreID(rs.getString(1));
				//System.out.println("**adding to array**");
				sb.setName(rs.getString(2));
			//	System.out.println("**adding to array**");
				sb.setStreet(rs.getString(3));
				//System.out.println("**adding to array**");
				sb.setMobileNo(rs.getString(4));
				//System.out.println("**adding to array**");
				sb.setCity(rs.getString(5));
				//System.out.println("**adding to array**");
				sb.setState(rs.getString(6));
				//System.out.println("**adding to array**");
				sb.setPincode(rs.getString(7));
				view.add(sb);
			}
			//System.out.println(rs.getString(1));
			return view;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
}
	public int deleteStore(ArrayList<String> storeId){
		int array[]=new int[storeId.size()];
		int flag=0;
		for (int i=0;i < storeId.size();i++)
		{
		  String id=storeId.get(i);
		  try {
			PreparedStatement ps = con.prepareStatement("delete from POS_TBL_PizzaStore where StoreId=?");
			ps.setString(1, id);
			array[i]=ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}
		}
		for(int i=0;i<array.length;i++){
			if(array[i]==1){
				flag=1;
			}
			else{
				flag=0;
				break;
			}
		}
		if(flag==1){
			return 1;
		}
		else{
			return 0;
		}
	}
	public boolean updateStore(StoreBean storebean) {
		try {
			PreparedStatement ps = con.prepareStatement("update POS_TBL_PizzaStore set Storeid=?,Name=? ,Street=?,MobileNo=?,City=?,State=?,Pincode=? where StoreId=?");
			String id=generateStoreId(storebean);
			ps.setString(1,id);
			ps.setString(2, storebean.getName());
			ps.setString(3, storebean.getStreet());
			ps.setString(4,storebean.getMobileNo());
			ps.setString(5, storebean.getCity());
			ps.setString(6,storebean.getState());
			ps.setString(7,storebean.getPincode());
			ps.setString(8, storebean.getStoreID());
			int update=ps.executeUpdate();
			//boolean update=ps.execute();
			System.out.println(update);
			if(update>0){
				return true;
			}
			else{
				return false;
			}
				//return update;
		}catch(Exception e){
			return false;
		}
	}
	public StoreBean findByID(String storeId) {
		StoreBean sb=null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from POS_TBL_PizzaStore where StoreId=?");
			ps.setString(1, storeId);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				sb= new StoreBean();
				sb.setStoreID(rs.getString(1));
				sb.setName(rs.getString(2));
				sb.setStreet(rs.getString(3));
				sb.setMobileNo(rs.getString(4));
				sb.setCity(rs.getString(5));
				sb.setState(rs.getString(6));
				sb.setPincode(rs.getString(7));
				
			}
			return sb;
		}catch(Exception e){
			return null;
		}
	}
	public ArrayList<StoreBean> findAll(){
		ArrayList<StoreBean> view = new ArrayList<StoreBean>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from POS_TBL_PizzaStore");
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				StoreBean sb= new StoreBean();
				sb.setStoreID(rs.getString(1));
				sb.setName(rs.getString(2));
				sb.setStreet(rs.getString(3));
				sb.setMobileNo(rs.getString(4));
				sb.setCity(rs.getString(5));
				sb.setState(rs.getString(6));
				sb.setPincode(rs.getString(7));
				view.add(sb);
			}
			return view;
		}catch(Exception e){
			return null;
		}

	}
	public String generateStoreId(StoreBean storebean) throws SQLException {
		// TODO Auto-generated method stub
		String sid = null;
		String id=null;
		String s =storebean.getName().toUpperCase();
	     s= s.substring(0, 2);
	    PreparedStatement ps = con.prepareStatement("select pos_seq_storeId.nextval from dual");
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()){
	    	 sid = rs.getString(1);
	    
	     id = s.concat(sid); 
	    }
	    return id;
	}
}
