package com.wipro.pos.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.pos.bean.CartBean;
import com.wipro.pos.bean.OrderBean;
import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.dao.CartDAO;
import com.wipro.pos.dao.OrderDAO;
import com.wipro.pos.dao.StoreDAO;

public class Customer {
	CartDAO cD = new CartDAO();
	
	public int addToCart(CartBean cartBean){
		//System.out.println(cartBean.getCartID());
		String b = cD.createCart(cartBean);
		if(b.equals("SUCCESS")){
			return 1;
		}else{
			return 0;
		}
	}
	boolean modifyCart(CartBean cartBean) throws SQLException{
		return cD.updateCart(cartBean);
	}
	
	String confirmOrder(OrderBean orderBean, ArrayList<CartBean> cartbean) throws SQLException{
		OrderDAO oD = new OrderDAO();
		orderBean.setOrderStatus("Confirmed");
		return oD.createOrder(orderBean);
	}
	
	//CANCELING ORDER
	public boolean cancelOrder(String orderId) throws SQLException {
		OrderDAO oD = new OrderDAO();
		int r = oD.updateOrder(orderId);
		if(r == 1){
			return true;
		}else{
			return false;
		}
		
	}
	public ArrayList<StoreBean> viewStore(String city) throws SQLException{
		StoreDAO sD = new StoreDAO();
		
		return sD.findAll(city);
		
		
	}
	ArrayList<CartBean> viewCart(String userid) throws SQLException{
		return cD.findCart(userid);
	}
	ArrayList <OrderBean> viewOrder() throws SQLException{
		OrderDAO oD = new OrderDAO();
		return oD.findAll();
	}
	public ArrayList<OrderBean> viewOrder(String trim) {
		// TODO Auto-generated method stub
		return null;
	}
}
