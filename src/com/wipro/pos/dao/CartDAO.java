package com.wipro.pos.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.pos.bean.CartBean;
import com.wipro.pos.bean.OrderBean;
import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.util.DBUtil;

public class CartDAO {
	Connection con;
	public   CartDAO() {
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
	
	
	public String createCart(CartBean cartbean) {
		try {
			System.out.println(cartbean.getCartID());
			PreparedStatement ps = con.prepareStatement("insert into POS_TBL_Cart values(?,?,?,?,?,?,?)");
			System.out.println(cartbean.getCartID());
			ps.setInt(1, cartbean.getCartID());
			System.out.println(cartbean.getCartID());
			ps.setString(2, cartbean.getUserID());
			ps.setString(3,  cartbean.getFoodID());
			ps.setString(4, cartbean.getType());
			ps.setInt(5, cartbean.getQuantity());
			ps.setDouble(6,cartbean.getCost());
			ps.setDate(7,new Date(cartbean.getOrderDate().getTime()));
			int r = ps.executeUpdate();
			if(r>0) {
				return "SUCCESS";
			}else{
				return "FAIL";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	public boolean updateCart(CartBean cartbean) throws SQLException{
		PreparedStatement ps = con.prepareStatement("update POS_TBL_PizzaStore set UserId=? ,FoodId=?,Type=?,quantity=?,Cost=?,OrderDate=? where CartId=?");
		ps.setString(1, cartbean.getUserID());
		ps.setString(2, cartbean.getFoodID());
		ps.setString(3, cartbean.getType());
		ps.setInt(4, cartbean.getQuantity());
		ps.setDouble(5, cartbean.getCost());
		ps.setDate(6, new Date(cartbean.getOrderDate().getTime()));
		ps.setInt(7, cartbean.getCartID());
		return ps.execute();
	}
	
	public String deleteCart (String orderId) throws SQLException {
		String cartId = "";
		PreparedStatement ps = con.prepareStatement("select cartId from POS_TBL_PizzaStore where orderId=?");
		ps.setString(1, orderId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			cartId = rs.getString(1);
		}
		PreparedStatement ps1 = con.prepareStatement("delete from POS_TBL_PizzaStore where orderId=?");
		ps1.setString(1, cartId);
		int r = ps1.executeUpdate();
		if(r>0){
			return "Order Cancelled";
		}else{
			return "Order cannot be Cancelled";
		}
	}
	
	public ArrayList<StoreBean> findStore(String city) throws SQLException{
		ArrayList<StoreBean> ar = new ArrayList<StoreBean>();
		PreparedStatement ps = con.prepareStatement("Select * from POS_TBL_PizzaStore where City =? ");
		ps.setString(1, city);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			StoreBean sB = new StoreBean();
			sB.setStoreID(rs.getString(1));
			sB.setName(rs.getString(2));
			sB.setStreet(rs.getString(3));
			sB.setMobileNo(rs.getString(4));
			sB.setCity(rs.getString(5));
			sB.setState(rs.getString(6));
			sB.setPincode(rs.getString(7));
			ar.add(sB);
		}
		return ar;
	}
	
	/*public ArrayList<CartBean> findCart(String userid) throws SQLException{
		ArrayList<CartBean> cr = new ArrayList<CartBean>();
		PreparedStatement ps = con.prepareStatement("Select * from POS_TBL_Cart where City =? ");
		ps.setString(1, userid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			CartBean cB = new CartBean();
			cB.setCartID(rs.getInt(1));
			cB.setUserID(rs.getString(2));
			cB.setFoodID(rs.getString(3));
			cB.setType(rs.getString(4));
			cB.setQuantity(rs.getInt(5));
			cB.setCost(rs.getDouble(6));
			cB.setOrderDate(rs.getDate(7));
			cr.add(cB);
		}
		return cr;
	}*/
	public ArrayList<CartBean> findCart(String userid) throws SQLException{
		double tp =0;
		ArrayList<CartBean> cr = new ArrayList<CartBean>();
		PreparedStatement ps = con.prepareStatement("Select * from POS_TBL_Cart where Userid=? ");
		ps.setString(1, userid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			double price =0;
			CartBean cB = new CartBean();
			cB.setCartID(rs.getInt(1));
			cB.setUserID(rs.getString(2));
			cB.setFoodID(rs.getString(3));
			cB.setType(rs.getString(4));
			cB.setQuantity(rs.getInt(5));
			cB.setCost(rs.getDouble(6));
			cB.setOrderDate(rs.getDate(7));
			cr.add(cB);
			int q = rs.getInt(5);
			double c = rs.getDouble(6);
			price = q*c;
			tp = tp+price;
		}
		OrderBean oB = new OrderBean();
		oB.setTotalPrice(tp);
		return cr;
	}
	
	public ArrayList<OrderBean> findOrder() throws SQLException{
		ArrayList<OrderBean> or = new ArrayList<OrderBean>();
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
			or.add(oB);
		}
		
		return or;
	}
}
