package com.ustglobal.empapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.ustglobal.empapp.dto.EmployeeBean;

public class EmployeeDAOImpl implements EmployeeDAO {

  public List<EmployeeBean> getAllEmployeeData() {
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql = "select * from Employee";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ArrayList<EmployeeBean>  result = new ArrayList<EmployeeBean>();
			while(rs.next()) {
		
				EmployeeBean bean = new EmployeeBean();
				bean.setId(rs.getInt("eid"));
				bean.setName(rs.getString("ename"));
				bean.setSal(rs.getInt("sal"));
				bean.setGender(rs.getString("gender"));
				
				result.add(bean);
				
			}
			return result;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} 
		finally {

			try {
				if(con != null) {
					con.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}	
		
		}
	
	}// End of Method
	
  public EmployeeBean searchEmployeeData(String name) {
	  
	  String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
	  String sql = "select * from Employee where  ename = ? ";
	  
	  Connection con = null;
//	  Statement stmt = null;
	  ResultSet rs = null;
	  PreparedStatement pstmt = null;
	  
	  try {
		  
		  Class.forName("com.mysql.jdbc.Driver");
		  
		  con = DriverManager.getConnection(url);
		  
		  pstmt = con.prepareStatement(sql);
		  pstmt.setString(1, name);
		  rs  = pstmt.executeQuery();
		  
		  if(rs.next()) {
			  EmployeeBean bean = new EmployeeBean();
			  bean.setId(rs.getInt("eid"));
			  bean.setName(rs.getString("ename"));
			  bean.setSal(rs.getInt("sal"));
			  bean.setGender(rs.getString("gender"));
			  return bean;
		  } else {
			  return null;
		  }
		  
		  
	  } catch(Exception e) {
		  e.printStackTrace();
		  return null;
	  } finally {
		  
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
		  } catch(Exception e1) {
			  e1.printStackTrace();
		  }
	  }
  } //end of search method
  
  public int insertEmployeeData(EmployeeBean bean) {
	  String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
	  String sql = "insert into Employee values(?,?,?,?) ";
	  
	  Connection con = null;
	  PreparedStatement pstmt = null;
	  
	  
	  try {
		  
		  Class.forName("com.mysql.jdbc.Driver");
		  
		  con = DriverManager.getConnection(url);
		  
		  pstmt = con.prepareStatement(sql);
		  
		  pstmt.setInt(1, bean.getId());
		  pstmt.setString(2, bean.getName());
		  pstmt.setInt(3, bean.getSal());
		  pstmt.setString(4, bean.getGender());
		  
		  int count  = pstmt.executeUpdate();
		  return count;
		  
	  } catch(Exception e) {
		  e.printStackTrace();
	  } finally {
		  
		  try {
			  if(con != null) {
				  con.close();
			  }
			  if(pstmt != null) {
				  pstmt.close();
			  }
		  } catch(Exception e1) {
			  e1.printStackTrace();
		  }
	  }
     return 0;
  } // end of insert method
  
	public int updateEmployeeData(EmployeeBean bean) {
		
		  String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		  String sql = "update Employee set ename=? where eid= ?";
		  
		  Connection con = null;
		  PreparedStatement pstmt = null;
		  
		  
		  try {
			  
			  Class.forName("com.mysql.jdbc.Driver");
			  
			  con = DriverManager.getConnection(url);
			  
			  pstmt = con.prepareStatement(sql);
			  
			  pstmt.setString(1, bean.getName());
			  pstmt.setInt(2, bean.getId());
//			  pstmt.setInt(3, bean.getSal());
//			  pstmt.setString(4, bean.getGender());
			  
			  int count  = pstmt.executeUpdate();
			  return count;
			  
		  } catch(Exception e) {
			  e.printStackTrace();
		  } finally {
			  
			  try {
				  if(con != null) {
					  con.close();
				  }
				  if(pstmt != null) {
					  pstmt.close();
				  }
			  } catch(Exception e1) {
				  e1.printStackTrace();
			  }
		  }
	     return 0;
		
	}//end of update method
  
	public int deleteEmployeeData(EmployeeBean bean) {
		
		  String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		  String sql = "delete from Employee where eid=36 ";
		  
		  Connection con = null;
		  PreparedStatement pstmt = null;
		  
		  
		  try {
			  
			  Class.forName("com.mysql.jdbc.Driver");
			  
			  con = DriverManager.getConnection(url);
			  
			  pstmt = con.prepareStatement(sql);
			  
//			  pstmt.setInt(1, bean.getId());
//			  pstmt.setString(2, bean.getName());
//			  pstmt.setInt(3, bean.getSal());
//			  pstmt.setString(4, bean.getGender());
			  
			  
			  int count  = pstmt.executeUpdate();
			  return count;
			  
		  } catch(Exception e) {
			  e.printStackTrace();
		  } finally {
			  
			  try {
				  if(con != null) {
					  con.close();
				  }
				  if(pstmt != null) {
					  pstmt.close();
				  }
			  } catch(Exception e1) {
				  e1.printStackTrace();
			  }
		  }
	     return 0;
		
	}
	
}//End of class Body
