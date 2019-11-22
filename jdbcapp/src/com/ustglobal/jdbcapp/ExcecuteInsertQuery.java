package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExcecuteInsertQuery {

	public static void main(String[] args) {
	
		Connection con = null;
		Statement stmt = null;
//		ResultSet rs = null; needed only in select Query
		
		try {
		    // Step 1 loading driver class
			Class.forName("com.mysql.jdbc.Driver");

			
			//Step 2 Connection
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			con = DriverManager.getConnection(url);
			
			//step 3 Issue Sql Query
			String sql = " insert into Employee " + " values("+args[0]+",'"+args[1]+"',"+args[2]+",'"+args[3]+"') ";
			stmt = con.createStatement();
			int count = stmt.executeUpdate(sql);
			
			//step 4 Read the Results
			System.out.println(count + " Rows Inserted ");
			
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
			} catch (SQLException s) {
				s.printStackTrace();
			}
		}
		
	}
}
