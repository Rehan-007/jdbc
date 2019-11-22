package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DeleteWithProperties {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		FileReader reader = null;
		
		try {
			
			reader = new FileReader("db.properties");
			Properties prop = new Properties();
			prop.load(reader);
			
			Class.forName(prop.getProperty("driver-class-name"));
			
//			Driver driver = new Driver();
//			DriverManager.registerDriver(driver);
			
			String url = prop.getProperty("url") ;
			con = DriverManager.getConnection(url,prop);
			
			String sql = prop.getProperty("delete-query");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(args[0]));
			int count = pstmt.executeUpdate();
			
			System.out.println(count+" rows Affected");
			
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
