package com.wipro.pos.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.bean.OrderBean;
import com.wipro.pos.bean.ProfileBean;
import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.dao.CustomerDAO;
import com.wipro.pos.dao.FoodDAO;
import com.wipro.pos.dao.OrderDAO;
import com.wipro.pos.dao.StoreDAO;


public class Administrator {

	public String addStore(StoreBean storebean) throws SQLException{
		StoreDAO sd=new StoreDAO();
		String id=sd.generateStoreId(storebean);
		storebean.setStoreID(id);
		String status=sd.createStore(storebean);
		return status;
	}
	public boolean modifyStore(StoreBean storebean){
		StoreDAO sd=new StoreDAO();
		Boolean status=sd.updateStore(storebean);
		System.out.println(status);
		return status;
	}
	public int removeStore(ArrayList<String> storeId){
		StoreDAO sd=new StoreDAO();
		int value=sd.deleteStore(storeId);
		return value;
	}
	public StoreBean viewStore(String storeId){
		StoreDAO sd=new StoreDAO();
		StoreBean value=sd.findByID(storeId);
		return value;
	}
	public ArrayList <StoreBean> viewAllStore() {
		StoreDAO sd=new StoreDAO();
		ArrayList<StoreBean> value=new ArrayList<StoreBean>();
		value=sd.findAll();
		return value;
	}
	public String addFood(FoodBean foodbean) throws SQLException {
		FoodDAO fd= new FoodDAO();
		String id=fd.generateFoodId(foodbean);
		foodbean.setFoodID(id);
		System.out.println(id);
		String status=fd.createFood(foodbean);
		return status;
	}
	public boolean modifyFood(FoodBean foodbean){
		FoodDAO fd = new FoodDAO();
		System.out.println(foodbean.getFoodID());
		boolean value=fd.updateFood(foodbean);
		System.out.println(value);
		return value;
	}
	public boolean removeFood(String storeId, String foodId) {
		if(storeId!=null){
		ArrayList<String> ar=new ArrayList<String>();
		ar.add(storeId);
		StoreDAO sd=new StoreDAO();
		int value=sd.deleteStore(ar);
		ArrayList<String> ar1=new ArrayList<String>();
		ar1.add(foodId);
		FoodDAO fd=new FoodDAO();
		int value1=fd.deleteFood(ar1);
		if(value==1&&value1==1){
			return true;
		}
		else{
			return false;
		}
		}
		else{
			ArrayList<String> ar1=new ArrayList<String>();
			ar1.add(foodId);
			FoodDAO fd=new FoodDAO();
			int value1=fd.deleteFood(ar1);
			if(value1==1){
				return true;
			}
			else{
				return false;
			}
		}
	}
	public FoodBean viewFood(String foodId) {
		FoodDAO fd = new FoodDAO();
		FoodBean fb=fd.findByID(foodId);
		return fb;
	}
	public ArrayList<FoodBean> viewAllFood(String storeId){
		FoodDAO fd = new FoodDAO ();
		ArrayList<FoodBean> ar= new ArrayList<FoodBean>();
		ar=fd.findAll();
		return ar;
	}
	String changeOrderStatus(String orderId) {
		OrderDAO od=new OrderDAO();
		OrderBean ob= new OrderBean();
		ob=od.findByID(orderId);
		boolean value=od.updateOrder(ob);
		if(value==true){
			return "SUCCESS";
		}
		else{
			return "FAIL";
		}
		
	}
	public ArrayList<ProfileBean> viewAllCustomer() {
		// TODO Auto-generated method stub
		CustomerDAO dao=new CustomerDAO();
		ArrayList<ProfileBean> ab= new ArrayList<ProfileBean>();
		ab=dao.viewCustomer();
		return ab;
	}
	public ArrayList<OrderBean> viewAllOrder() {
		// TODO Auto-generated method stub
		OrderDAO od=new OrderDAO();
		ArrayList<OrderBean> al=new ArrayList<OrderBean>();
		try {
			al=od.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
}
