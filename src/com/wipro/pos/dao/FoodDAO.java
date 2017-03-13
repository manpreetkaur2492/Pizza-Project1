package com.wipro.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.util.DBUtil;

public class FoodDAO {

	Connection con;
	public FoodDAO(){
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
	public String createFood(FoodBean foodbean) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into POS_TBL_Food values(?,?,?,?,?,?)");
			ps.setString(1, foodbean.getFoodID());
			ps.setString(2, foodbean.getName());
			ps.setString(3, foodbean.getType());
			ps.setString(4,foodbean.getFoodSize());
			ps.setInt(5, foodbean.getQuantity());
			ps.setDouble(6,foodbean.getPrice());
			int update=ps.executeUpdate();
			if(update==1){
				return "SUCCESS";
			}
			else{
				return "FAIL";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return "ERROR";
		} 
	}
	public int deleteFood(ArrayList<String> ar1) {
		int array[]=new int[ar1.size()];
		int flag=0;
		for (int i=0;i <ar1.size();i++)
		{
		  String id=ar1.get(i);
		  try {
				PreparedStatement ps = con.prepareStatement("delete from POS_TBL_Food where FoodId=?");
				ps.setString(1,id);
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
	public boolean updateFood(FoodBean foodbean) {
		try {
			System.out.println("1111111111111111111111111111111111");
			PreparedStatement ps = con.prepareStatement("update POS_TBL_Food set FoodId=?,Name=? ,Type=?,FoodSize=?,Quantity=?,Price=? where FoodId=?");
			System.out.println("222222222");
			String id=generateFoodId(foodbean);
			System.out.println("33333333333"+id);
			ps.setString(1,id);
			System.out.println("4444444444"+foodbean.getName());
			ps.setString(2, foodbean.getName());
			System.out.println("555555555555");
			ps.setString(3,  foodbean.getType());
			System.out.println("6666666666");
			ps.setString(4,foodbean.getFoodSize());
			System.out.println("7777777"+foodbean.getFoodSize());
			ps.setInt(5, foodbean.getQuantity());
			System.out.println("888");
			ps.setDouble(6,foodbean.getPrice());
			System.out.println("99999999");
			ps.setString(7, foodbean.getFoodID());
			System.out.println("00000000000"+foodbean.getFoodID());
			int update=ps.executeUpdate();
			System.out.println("====="+update);
			if(update>0){
				return true;
			}
			else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
	}
	public FoodBean findByID(String foodId){
		FoodBean fb=null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from POS_TBL_Food where foodId=?");
			ps.setString(1, foodId);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				fb= new FoodBean();
				fb.setFoodID(rs.getString(1));
				fb.setName(rs.getString(2));
				fb.setType(rs.getString(3));
				fb.setFoodSize(rs.getString(4));
				fb.setQuantity(rs.getInt(5));
				fb.setPrice(rs.getDouble(6));
			}
			return fb;
		}catch(Exception e){
			return null;
		}
	}
	public ArrayList<FoodBean> findAll() {
		ArrayList<FoodBean> view = new ArrayList<FoodBean>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from POS_TBL_Food");
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				FoodBean fb= new FoodBean();
				fb.setFoodID(rs.getString(1));
				fb.setName(rs.getString(2));
				fb.setType(rs.getString(3));
				fb.setFoodSize(rs.getString(4));
				fb.setQuantity(rs.getInt(5));
				fb.setPrice(rs.getDouble(6));
				view.add(fb);
			}
			return view;
		}catch(Exception e){
			return null;
		}
	}
	public String generateFoodId(FoodBean foodbean) throws SQLException {
		// TODO Auto-generated method stub
		String sid = null;
		String id=null;
		String s =foodbean.getName().toUpperCase();
	     s= s.substring(0, 2);
	    PreparedStatement ps = con.prepareStatement("select pos_seq_foodId.nextval from dual");
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()){
	    	 sid = rs.getString(1);
	    
	     id = s.concat(sid); 
	    }
	    return id;
	}
	public String getId(String id) {
		// TODO Auto-generated method stub
		FoodBean fb=null;
		try {
			PreparedStatement ps = con.prepareStatement("select FoodId from POS_TBL_Food where name=?");
			ps.setString(1, id);
			String x=null;
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				x=rs.getString(1);
			}
			return x;
		}catch(Exception e){
			return null;
		}
	}
}
