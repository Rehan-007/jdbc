package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DynamicUpdateQuery {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql = "update  Employee set ename = ?, sal= ?,gender = ? where eid=?";
		
		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			// step 1 loading
			Class.forName("com.mysql.jdbc.Driver");

			
			// step 2 connection 
			con = DriverManager.getConnection(url);
			
			//step 3 sql Query
			pstmt = con.prepareStatement(sql);
			String empid = args[3];
			int id = Integer.parseInt(empid);
			
			
			String name = args[0];
		
			String empsal = args[1];
			int sal = Integer.parseInt(empsal);
			
			String gender = args[2];
			
			pstmt.setInt(4, id);
			pstmt.setString(1, name);
			pstmt.setInt(2, sal);
			pstmt.setString(3, gender);
	
			int count = pstmt.executeUpdate();
			System.out.println(count+" Rows affected");
			
			//step 4 read result
			
			
//			String name  = args[1];
//			pstmt.setString(2, name);
//			
//			String empsal = args[2];
//			int sal = Integer.parseInt(empsal);
//			pstmt.setInt(3, sal);
			
			
			
		} catch(Exception s) {
			s.printStackTrace();
		}
		finally {
			try {
				if(con != null) {
					con.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
//				if(rs != null) {
//					rs.close();
//				}
			} catch(SQLException s) {
				s.printStackTrace();
			}
		}
		
	}
	
	
}
