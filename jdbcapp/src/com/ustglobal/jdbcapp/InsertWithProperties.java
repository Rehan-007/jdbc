package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class InsertWithProperties {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		FileReader reader = null;
		
	
//		ResultSet rs = null; needed only in select Query
		
		try {
			
			reader = new FileReader("db.properties");
			Properties prop = new Properties();
			prop.load(reader);
		    // Step 1 loading driver class
			Class.forName(prop.getProperty("driver-class-name"));

			
			//Step 2 Connection
			String url = prop.getProperty("url");
			con = DriverManager.getConnection(url,prop);
			
			//step 3 Issue Sql Query
			String sql = prop.getProperty("insert-query");
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
				if(reader != null) {
					reader.close();
				}
			} catch (Exception s) {
				s.printStackTrace();
			}
		}
		
	}
	
}
