package com.ustglobal.jdbcpractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DeleteQuery {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		
		try {
			//Step 1
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//Step 2
			
			String url = "jdbc:mysql://localhost:3306/ust_db?user=root&password=root";
			con = DriverManager.getConnection(url);
			
			//step 3
			String sql = "delete from Employee where eid=10 ";
			stmt = con.createStatement();
			
			int count = stmt.executeUpdate(sql);
			System.out.println(count+" row Effected ");
			
			
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
			} catch(SQLException s) {
				s.printStackTrace();
			}
		}
		
	}
	
}
