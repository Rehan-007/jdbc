package com.ustglobal.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Query {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//Step 1 load the driver class
			Driver driver  = new Driver();
			DriverManager.registerDriver(driver);
			
			//Step 2 getting the connection
			String url = "jdbc:mysql://localhost:3306/ust_db?user=root&password=root";
			con = DriverManager.getConnection(url);
			
			
			//Step 3 sql Query
			String sql = "select * from Employee";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			//step 4 
			while(rs.next()) {
				int id = rs.getInt("eid");
				String name = rs.getString("name");
				
				System.out.println("id is = "+id);
				System.out.println("name is = "+name);
				System.out.println("-----------------------------");
			}
			
		} catch(SQLException s) {
			s.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch(SQLException s) {
				s.printStackTrace();
			}
		}
		
	}
	
}
