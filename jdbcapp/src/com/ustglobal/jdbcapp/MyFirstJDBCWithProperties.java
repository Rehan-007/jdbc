package com.ustglobal.jdbcapp;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//import com.mysql.jdbc.Driver;

public class MyFirstJDBCWithProperties {

public static void main(String[] args) {
		
		Connection conn = null;
		Statement  stmt  = null;
		ResultSet rs = null;
		FileReader reader = null;
		try {
			reader = new FileReader("db.properties");
			Properties prop = new Properties();
			prop.load(reader);
			//Step 1 loading driver class
			
		    Class.forName(prop.getProperty("driver-class-name"));
			
			// Step 2 get the connection
			String url = prop.getProperty("url");
			conn = DriverManager.getConnection(url, prop);
			stmt = conn.createStatement();
			String sql  = prop.getProperty("sql-query");
			rs = stmt.executeQuery(sql);
		    while(rs.next()) {
		    	int id = rs.getInt("eid");
		    	String name  = rs.getString("ename");
		    	int sal = rs.getInt("sal");
		    	String gender =  rs.getString("gender");
		    	
		    	System.out.println("Id is = "+id);
		    	System.out.println("name is = "+name);
		    	System.out.println("Salary is = "+sal);
		    	System.out.println("Gender is = "+gender);
		    	System.out.println("-------------------------------------");
		    } 
		    
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException s) {
					s.printStackTrace();
				}
			} 
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException s) {
					s.printStackTrace();
				}
				if(reader != null) {
					try {
						reader.close();
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	
}
