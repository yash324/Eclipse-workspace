package com.flp.ems.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Employee;

public class EmployeeServiceImpl implements IEmployeeService {
	
	public Employee getEmployee(HashMap<String,String> data)
	{
		long phone = Long.parseLong(data.get("phone"));
		int deptid = Integer.parseInt(data.get("dept"));
		int projid = Integer.parseInt(data.get("proj"));
		int roleid = Integer.parseInt(data.get("role"));
		Employee emp = new Employee(Integer.parseInt(data.get("empid")), data.get("name"), data.get("email"), phone, data.get("dob"), data.get("doj"), data.get("address"), deptid, projid, roleid);
		return emp;
	}
	
	@Override
	public boolean AddEmployee(HashMap<String,String> data) {
		return new EmployeeDaoImplForList().AddEmployee(getEmployee(data));		
	}

	@Override
	public boolean ModifyEmployee(HashMap<String,String> data) {
		return new EmployeeDaoImplForList().ModifyEmployee(getEmployee(data));
	}

	@Override
	public boolean RemoveEmployee(String id) {
		return new EmployeeDaoImplForList().RemoveEmployee(Integer.parseInt(id));
	}

	@Override
	public String SearchEmployee(String id) {
		Employee emp = new EmployeeDaoImplForList().SearchEmployee(Integer.parseInt(id));
		if(emp==null)
			return null;
		return emp.toString();
		
	}

	@Override
	public ArrayList<String> getAllEmployee() {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<Employee> empList = new EmployeeDaoImplForList().getAllEmployee();
		for(int i=0;i<empList.size();i++)
			arr.add(empList.get(i).toString());
		return arr;
	}
}
