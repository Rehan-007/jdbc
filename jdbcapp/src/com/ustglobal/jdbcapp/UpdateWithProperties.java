package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UpdateWithProperties {

	public static void main(String[] args) {
		
		
		
		
		Connection con = null;
//		Statement stmt = null;
//		ResultSet rs = null;
		PreparedStatement pstmt = null;
		FileReader reader = null;
		
		try {
			reader = new FileReader("db.properties");
			Properties prop = new Properties();
			prop.load(reader);
			// step 1 loading
		    Class.forName(prop.getProperty("driver-class-name"));

			
			// step 2 connection 
			String url = prop.getProperty("url");
			con = DriverManager.getConnection(url,prop);
			
			//step 3 sql Query
			String sql = prop.getProperty("update-query");
			pstmt = con.prepareStatement(sql);
//			String empid = args[1];
//			int id = Integer.parseInt(empid);
			
			
//			String name = args[0];
		
			String empsal = args[0];
			int sal = Integer.parseInt(empsal);
			
			String gender = args[1];
			
//			pstmt.setInt(4, id);
//			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setInt(1, sal);
			
	
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
				if(reader != null) {
					reader.close();
				}
			} catch(Exception s) {
				s.printStackTrace();
			}
		}
		
	}
	
}
