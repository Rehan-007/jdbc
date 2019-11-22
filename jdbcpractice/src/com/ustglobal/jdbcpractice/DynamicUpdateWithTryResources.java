package com.ustglobal.jdbcpractice;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DynamicUpdateWithTryResources {

	public static void main(String[] args) {
		
		try(FileReader reader = new FileReader("db.properties")){
			Properties prop = new Properties();
			prop.load(reader);
			
			Class.forName(prop.getProperty("driver-class-name"));
			String url = prop.getProperty("url");
			String sql = prop.getProperty("update-query");
			
			try(Connection con = DriverManager.getConnection(url,prop);
					PreparedStatement pstmt = con.prepareStatement(sql)){
				
				String empsal = args[0];
				int sal = Integer.parseInt(empsal);
				
				String gender = args[1];
				
				pstmt.setString(2, gender);
				pstmt.setInt(1, sal);
				
				int count = pstmt.executeUpdate();
				System.out.println(count + " Rows Effected ");
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
