package com.flp.ems.util;
import com.flp.ems.service.EmployeeServiceImpl;
public class DBUtility {
	private static EmployeeServiceImpl empService = new EmployeeServiceImpl();
	public static EmployeeServiceImpl getEmployeeService()
	{
		return empService; 
	}
}
