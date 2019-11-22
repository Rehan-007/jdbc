package com.ustglobal.jdbcapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertWithCSVFile {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql = "insert into Employee values(?,?,?,?)";
		try(FileReader in = new FileReader("csv.txt");
				BufferedReader reader = new BufferedReader(in);
				Connection con = DriverManager.getConnection(url);
						PreparedStatement pstmt = con.prepareStatement(sql)){
			
			while(reader.ready()) {
				String line = reader.readLine();
				String[] data = line.split(",");
				
				int id = Integer.parseInt(data[0]);
				String name = data[1];
				int sal = Integer.parseInt(data[2]);
				String gender = data[3];
				
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setInt(3, sal);
				pstmt.setString(4, gender);
				
				pstmt.addBatch();
			}//end of while loop
			int[] counts = pstmt.executeBatch();
			System.out.println(counts.length+" Rows Inserted ");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
;
				