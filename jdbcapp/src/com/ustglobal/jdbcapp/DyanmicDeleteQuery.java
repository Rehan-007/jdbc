package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DyanmicDeleteQuery {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
//			Driver driver = new Driver();
//			DriverManager.registerDriver(driver);
			
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			con = DriverManager.getConnection(url);
			
			String sql = "delete from Employee where eid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(args[0]));
			int count = pstmt.executeUpdate();
			
			System.out.println(count+"rows Affected");
			
		} catch(Exception e) {
			e.printStackTrace();
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
