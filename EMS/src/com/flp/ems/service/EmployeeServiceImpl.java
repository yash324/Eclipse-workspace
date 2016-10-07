package com.flp.ems.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Employee;

public class EmployeeServiceImpl implements IEmployeeService {
	@Override
	public boolean AddEmployee(HashMap<String, String> data) {
		long phone = Long.parseLong(data.get("phone"));
		int deptid = Integer.parseInt(data.get("dept"));
		int projid = Integer.parseInt(data.get("proj"));
		int roleid = Integer.parseInt(data.get("role"));
		DateFormat df = new SimpleDateFormat("mm/dd/yy");
		Date dob, doj;
		dob = doj = null;
		try {
			dob = df.parse(data.get("dob"));
			doj = df.parse(data.get("doj"));
		} catch (ParseException e) {
			System.out.println("Invalid Date");
			e.printStackTrace();
		}
		Employee emp = new Employee(data.get("name"), data.get("email"), phone, dob, doj, data.get("address"), deptid,
				projid, roleid);
		return new EmployeeDaoImplForList().AddEmployee(emp);

	}

	@Override
	public boolean ModifyEmployee(HashMap<String, String> data) {
		String name = data.get("name");
		String email = data.get("email");
		String address = data.get("address");
		long phone = Long.parseLong(data.get("phone"));
		int deptid = Integer.parseInt(data.get("dept"));
		int projid = Integer.parseInt(data.get("proj"));
		int roleid = Integer.parseInt(data.get("role"));
		DateFormat df = new SimpleDateFormat("mm/dd/yy");
		Date dob, doj;
		dob = doj = null;
		try {
			dob = df.parse(data.get("dob"));
			doj = df.parse(data.get("doj"));
		} catch (ParseException e) {
			System.out.println("Invalid Date");
			e.printStackTrace();
		}
		int modid = Integer.parseInt(data.get("modid"));
		Employee newEmp = new EmployeeDaoImplForList().SearchEmployee(modid);
		if (newEmp == null)
			return false;
		newEmp.setName(name);
		newEmp.setEmail(email);
		newEmp.setPhone(phone);
		newEmp.setDob(dob);
		newEmp.setDoj(doj);
		newEmp.setAddress(address);
		newEmp.setDeptid(deptid);
		newEmp.setProjid(projid);
		newEmp.setRoleid(roleid);
		return new EmployeeDaoImplForList().ModifyEmployee(newEmp);
	}

	@Override
	public boolean RemoveEmployee(String id) {
		return new EmployeeDaoImplForList().RemoveEmployee(Integer.parseInt(id));
	}

	@Override
	public String SearchEmployee(String id) {
		Employee emp = new EmployeeDaoImplForList().SearchEmployee(Integer.parseInt(id));
		if (emp == null)
			return null;
		return emp.toString();
	}

	@Override
	public ArrayList<String> getAllEmployee() {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<Employee> empList = new EmployeeDaoImplForList().getAllEmployee();
		for (int i = 0; i < empList.size(); i++)
			arr.add(empList.get(i).toString());
		return arr;
	}
}
