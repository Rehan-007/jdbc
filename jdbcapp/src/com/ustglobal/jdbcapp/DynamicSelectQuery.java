package com.ustglobal.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DynamicSelectQuery {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql = "select * from Employee where eid=?";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			// step 1 loading
			Class.forName("com.mysql.jdbc.Driver");

			
			// step 2 connection 
			con = DriverManager.getConnection(url);
			
			//step 3 sql Query
			pstmt = con.prepareStatement(sql);
			String empid = args[0];
			int id = Integer.parseInt(empid);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int sid = rs.getInt("eid");
				int sal = rs.getInt("sal");
				String name = rs.getString("ename");
				String gender = rs.getString("gender");
				
				System.out.println("id is  = "+sid);
				System.out.println("salary is = "+sal);
				System.out.println("name is = "+name);
				System.out.println("gender is = "+gender);
				System.out.println("-----------------------------");
				
			}
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
				if(rs != null) {
					rs.close();
				}
			} catch(SQLException s) {
				s.printStackTrace();
			}
		}
		
	}
	
}
