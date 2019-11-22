package com.ustglobal.empapp.dao;

import java.util.List;

import com.ustglobal.empapp.dto.EmployeeBean;

public interface EmployeeDAO {

	public List<EmployeeBean> getAllEmployeeData();
	public EmployeeBean searchEmployeeData(String name);
	public int insertEmployeeData(EmployeeBean bean);
	public int updateEmployeeData(EmployeeBean bean);
	public int deleteEmployeeData(EmployeeBean bean);
	
}
