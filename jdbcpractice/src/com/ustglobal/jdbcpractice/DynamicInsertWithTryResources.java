package com.ustglobal.jdbcpractice;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class DynamicInsertWithTryResources {

	public static void main(String[] args) {
		
		try(FileReader reader = new FileReader("db.properties")) {
			
			Properties prop = new Properties();
			prop.load(reader);
			
			Class.forName(prop.getProperty("driver-class-name"));
			String url = prop.getProperty("url");
			String sql = prop.getProperty("insert-query");
			
			try (Connection con = DriverManager.getConnection(url,prop);
				PreparedStatement pstmt = con.prepareStatement(sql)	){
				
				String empid = args[0];
				int id = Integer.parseInt(empid);
				pstmt.setInt(1, id);
				
				String name = args[1];
				pstmt.setString(2, name);
				
				String empsal = args[2];
				int sal = Integer.parseInt(empsal);
				pstmt.setInt(3, sal);
				
				String gender = args[3];
				pstmt.setString(4, gender);
				
				int count = pstmt.executeUpdate();
				System.out.println(count + " Rows Inserted ");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
