package com.ustglobal.jdbcapp;

import java.sql.*;

import com.mysql.jdbc.Driver;

public class MyFirstJDBC {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement  stmt  = null;
		ResultSet rs = null;
		
		try {
			//Step 1 loading driver class
			
			Driver driver  = new Driver();
			DriverManager.registerDriver(driver);
			
			// Step 2 get the connection
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?";
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();
			String sql  = "select * from Employee";
			rs = stmt.executeQuery(sql);
		    while(rs.next()) {
		    	int id = rs.getInt("eid");
		    	String name  = rs.getString("ename");
		    	int sal = rs.getInt("sal");
		    	String gender =  rs.getString("gender");
		    	
		    	System.out.println("Id is = "+id);
		    	System.out.println("name is = "+name);
		    	System.out.println("Salary is = "+sal);
		    	System.out.println("Gender is = "+gender);
		    	System.out.println("-------------------------------------");
		    } 
		    
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException s) {
					s.printStackTrace();
				}
			} 
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException s) {
					s.printStackTrace();
				}
			}
		}
		
	}
}
