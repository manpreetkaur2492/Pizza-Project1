package com.wipro.pos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBUtil {

	public static Connection getDBConnection(String driverType) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con;
	
		
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "oracle");
				return con;
	}

}
