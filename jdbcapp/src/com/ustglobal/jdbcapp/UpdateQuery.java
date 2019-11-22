package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class UpdateQuery {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			//step 1 loading driver
			
			Class.forName("com.mysql.jdbc.Driver");

			
			//Step 2 Connection
			
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			con = DriverManager.getConnection(url);
			
			//Step 3 issue Sql Query
			
			String sql = "update Employee set sal = 10000 where eid = 5";
			stmt = con.createStatement();
			int count = stmt.executeUpdate(sql);
			
			System.out.println("Updated row is = "+count);
			
		} catch (Exception s) {
			s.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				} 
				if(stmt != null) {
					stmt.close();
				} 
			} catch(SQLException s) {
				s.printStackTrace();
			}
		}
		
	}
	
}
