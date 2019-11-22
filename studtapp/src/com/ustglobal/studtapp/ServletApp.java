package com.ustglobal.studtapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.EscapeTokenizer;

public class ServletApp extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String empId = req.getParameter("empid");
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql = "select * from Employee where eid=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PrintWriter out = resp.getWriter();
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empId);
			rs = pstmt.executeQuery();
			
			out.println("<table>");
			out.println("<thead>");
			out.println("<th>id</th>");
			out.println("<th>name</th>");
			out.println("<th>salary</th>");
			out.println("<th>gender</th>");
			out.println("</thead>");
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.println(rs.getInt(1));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(2));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getInt(3));
				out.println("</td>");
				
				out.println("<td>");
				out.println(rs.getString(4));
				out.println("</td>");
				
				out.println("</tr>");
			}
			out.println("</table>");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
			    if(con != null) {
			    	con.close();
			    } if(pstmt != null) {
			    	pstmt.close();
			    }
			    if(rs != null) {
			    	rs.close();
			    }
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	} // End of DoPost()
	
}//End of ClassBody
