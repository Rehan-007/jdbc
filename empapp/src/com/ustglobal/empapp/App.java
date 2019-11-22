package com.ustglobal.empapp;


import java.util.List;
import java.util.Scanner;

import com.ustglobal.empapp.dao.EmployeeDAO;
import com.ustglobal.empapp.dao.EmployeeDAOImpl;
import com.ustglobal.empapp.dto.EmployeeBean;
import com.ustglobal.empapp.util.EmployeeManager;

public class App {

	public static void main(String[] args) {

		System.out.println("Press 1 to get All Employees Data");
		System.out.println("Press 2 to Insert Employees Data");
		System.out.println("Press 3 to Update Employees Data");
		System.out.println("Press 4 to Delete Employees Data");
		System.out.println("Press 5 to Search For Single Employee Data");

		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();

		switch(ch) {

		case 1 : 
			
			EmployeeDAO dao = EmployeeManager.getEmployeeDAO();
			List<EmployeeBean> result = dao.getAllEmployeeData();

			for(EmployeeBean bean : result) {
				System.out.println("Name : "+bean.getName());
				System.out.println("ID : "+bean.getId());
				System.out.println("Salary : "+bean.getSal());
				System.out.println("Gender : "+bean.getGender());
			}
			break;
			
		case 2 :
			
			EmployeeDAO dao2 = EmployeeManager.getEmployeeDAO();
		    EmployeeBean bean2 = new EmployeeBean();
		    System.out.println("Enter Id");
		    int id2 = sc.nextInt();
		    bean2.setId(id2);
		    
		    System.out.println("Enter the name");
		    String name = sc.next();
		    bean2.setName(name);
		    
		    System.out.println("Enter salary");
		    int sal = sc.nextInt();
		    bean2.setSal(sal);
		    
		    System.out.println("Enter Gender");
		    String gender = sc.next();
		    bean2.setGender(gender);
		    
		    int count = dao2.insertEmployeeData(bean2);
		    System.out.println(count+" Rows Inserted");
			break;
			
		case 3 :
		
			EmployeeDAO dao3 = EmployeeManager.getEmployeeDAO();
		    EmployeeBean bean3 = new EmployeeBean();
		    
		    System.out.println("Enter Id");
		    int id3 = sc.nextInt();
		    bean3.setId(id3);
		    
		    System.out.println("Enter Name");
		    String name3 = sc.next();
		    bean3.setName(name3);
		    
		    int count3  = dao3.updateEmployeeData(bean3);
		    System.out.println(count3+" Rows Updated");
			break;
			
		case 4 :
			
			EmployeeDAO dao4 = EmployeeManager.getEmployeeDAO();
		    EmployeeBean bean4 = new EmployeeBean();
//		    
//		    int id4 = sc.nextInt();
//		    bean4.setId(id4);
		    
		    int count4 = dao4.deleteEmployeeData(bean4);
		    System.out.println(count4 +" Rows Deleted");
			break;

		case 5 : 
			
			EmployeeDAO dao5 = EmployeeManager.getEmployeeDAO();
			System.out.println("Enter Employee Name");
			String name5 = sc.next();
			EmployeeBean bean =	dao5.searchEmployeeData(name5);
			if(bean != null) {

				System.out.println("Name : "+bean.getName());
				System.out.println("ID : "+bean.getId());
				System.out.println("Salary : "+bean.getSal());
				System.out.println("Gender : "+bean.getGender());

			} else {
				System.out.println("no Data Found");
			}

		}
	}// end of Main()
}//End of class Body
