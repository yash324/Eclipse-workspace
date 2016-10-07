package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.flp.ems.domain.*;

public class EmployeeDaoImplForList implements IEmployeeDao {
	private static List<Employee> empList = Collections.synchronizedList(new ArrayList<Employee>());
	@Override
	public boolean AddEmployee(Employee emp) {
		for(int i=0;i<empList.size();i++) //check for email id duplication
			if(empList.get(i).equals(emp))
				return false;
		empList.add(emp);
		return true;
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
		List<Employee> list2 = new ArrayList<Employee>(empList);
		return (ArrayList<Employee>) list2;
	}

	@Override
	public boolean ModifyEmployee(Employee emp) {
		int id = emp.getEmpid();
		for(int i = 0;i<empList.size();i++) //check for email duplication
			if(empList.get(i).equals(emp) && empList.get(i).getEmpid() != id)
				return false;
		for (int i = 0; i < empList.size(); i++) //replace emp at position where id is equal
			if (empList.get(i).getEmpid() == id) {
				empList.set(i, emp);
				return true;
			}
		return false;
	}

	@Override
	public boolean RemoveEmployee(int id) {
		for (int i = 0; i < empList.size(); i++)
			if (empList.get(i).getEmpid() == id) {
				empList.remove(i);
				return true;
			}
		return false;
	}

	@Override
	public Employee SearchEmployee(int id) {
		try {
			for (int i = 0; i < empList.size(); i++) {
				if (empList.get(i).getEmpid() == id)
					return (Employee) empList.get(i).clone();
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
