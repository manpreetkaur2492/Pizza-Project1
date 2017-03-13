package com.wipro.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.wipro.pos.bean.OrderBean;
import com.wipro.pos.util.DBUtil;

public class OrderDAO {
	Connection con;
	public OrderDAO(){
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
	public String createOrder(OrderBean bean) throws SQLException{
		PreparedStatement ps = con.prepareStatement("insert into POS_TBL_PizzaStore OrderId=? Userid =? OrderDate=? StoreId =? TotalPrice=? OrderStatus=? cartId=? Street=? City=? State=? Pincode=? MobileNo=?");
		ps.setString(1, bean.getOrderID());
		ps.setString(2, bean.getUserID());
		ps.setDate(3, bean.getOrderDate());
		ps.setString(4,bean.getStoreID());
		ps.setDouble(5, bean.getTotalPrice());
		ps.setString(6, bean.getOrderStatus());
		ps.setInt(7, bean.getCartID());
		ps.setString(8, bean.getStreet());
		ps.setString(9, bean.getCity());
		ps.setString(10, bean.getState());
		ps.setString(11, bean.getPincode());
		ps.setString(12, bean.getMobileNo());
		
		int r = ps.executeUpdate();
		if(r>0){
			return "Confirmed";
		} else{
			return "Pending";
		}
		
	}
	public int deleteOrder(String orderId) throws SQLException{
		
		PreparedStatement ps = con.prepareStatement("delete from POS_TBL_Order where orderId=?");
		ps.setString(1, orderId);
		int r = ps.executeUpdate();
		if(r>0){
			return 1;
		}else{
		return 0;
		}
	}
	public int updateOrder(String orderid) {
		try {
			PreparedStatement ps = con.prepareStatement("update POS_TBL_Order set OrderStatus=? where OrderId=?");
			ps.setString(1,"Cancelled");
			ps.setString(2,orderid);
			int update=ps.executeUpdate();
			return update;
		}catch(Exception e){
			return 0;
		}	
	}
	public OrderBean findByID(String ar) {
		OrderBean fb=null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from POS_TBL_Order where orderId=?");
			ps.setString(1, ar);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				fb= new OrderBean();
				fb.setOrderID(rs.getString(1));
				fb.setUserID(rs.getString(2));
				fb.setOrderDate(rs.getDate(3));
				fb.setStoreID(rs.getString(4));
				fb.setTotalPrice(rs.getDouble(5));
				fb.setOrderStatus(rs.getString(6));
				fb.setCartID(rs.getInt(7));
				fb.setStreet(rs.getString(8));
				fb.setCity(rs.getString(9));
				fb.setState(rs.getString(10));
				fb.setPincode(rs.getString(11));
				fb.setMobileNo(rs.getString(12));
			}
			return fb;
		}catch(Exception e){
			return null;
		}
		
	}
	public ArrayList<OrderBean> findAll() throws SQLException{
		ArrayList<OrderBean> view = new ArrayList<OrderBean>();
		PreparedStatement ps = con.prepareStatement("Select * from POS_TBL_Cart ");
		ResultSet rs = ps.executeQuery(); 
		while (rs.next()){
			OrderBean oB = new OrderBean();
			oB.setOrderID(rs.getString(1));
			oB.setOrderStatus(rs.getString(2));
			oB.setOrderDate(rs.getDate(3));
			oB.setStoreID(rs.getString(4));
			oB.setTotalPrice(rs.getDouble(5));
			oB.setOrderStatus(rs.getString(6));
			oB.setCartID(rs.getInt(7));
			oB.setStreet(rs.getString(8));
			oB.setCity(rs.getString(9));
			oB.setState(rs.getString(10));
			oB.setPincode(rs.getString(11));
			oB.setMobileNo(rs.getString(12));
			view.add(oB);
		}
		
		return view;
		
	}
	public String generateOrderId(OrderBean orderbean) throws SQLException {
		// TODO Auto-generated method stub
		String sid = null;
		String id=null;
		String s =orderbean.getOrderDate().toString().toUpperCase();
	     s= s.substring(0, 2);
	    PreparedStatement ps = con.prepareStatement("select pos_seq_orderId.nextval from dual");
	    ResultSet rs = ps.executeQuery();
	    while(rs.next()){
	    	 sid = rs.getString(1);
	    
	     id = s.concat(sid); 
	    }
	    return id;
	}
	public boolean updateOrder(OrderBean ob) {
		// TODO Auto-generated method stub
		return false;
	}
	public ArrayList<OrderBean> viewOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
