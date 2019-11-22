package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DynamicExcecutionQuery {


	public static void main(String[] args) {
	
		Connection con = null;
		Statement stmt = null;
        PreparedStatement pstmt = null;
		
		try {
		    // Step 1 loading driver class
			Class.forName("com.mysql.jdbc.Driver");

			
			//Step 2 Connection
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			con = DriverManager.getConnection(url);
			
			//step 3 Issue Sql Query
			String sql = " insert into Employee values(?,?,?,?) " ;
			pstmt = con.prepareStatement(sql);
			
			String empid = args[0];
			int id = Integer.parseInt(empid);
			pstmt.setInt(1,id);
			
			String name = args[1];
			pstmt.setString(2,name);
			
			String empsal = args[2];
			int sal = Integer.parseInt(empsal);
			pstmt.setInt(3,sal);
			
			String gender = args[3];
			pstmt.setString(4, gender);
			
			int count = pstmt.executeUpdate();
			System.out.println(count+" Rows Effected");
			
			
			//stmt = con.createStatement();
			//int count = stmt.executeUpdate(sql);
			
			//step 4 Read the Results
			//System.out.println(count + " Rows Inserted ");
			
		} catch (Exception s) {
			s.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
//				if(stmt != null) {
//					stmt.close();
//				}
				if(pstmt != null){
					pstmt.close();
				}
				
			} catch (Exception s) {
				s.printStackTrace();
			}
		}
		
	}
	
}
