package com.flp.ems.util;
import com.flp.ems.domain.Employee;
public class DBUtility {
	private static Employee emp = new Employee();
	public static Employee getEmployee()
	{
		return emp; 
	}
}
