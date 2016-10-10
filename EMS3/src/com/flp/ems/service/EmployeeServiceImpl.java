package com.flp.ems.service;

import java.util.ArrayList;
import com.flp.ems.dao.JDBCEmployeeDAO;
import com.flp.ems.domain.Employee;

public class EmployeeServiceImpl {

	public void create(Employee emp) {
		new JDBCEmployeeDAO().create(emp);
	}

	public void update(Employee emp) {
		new JDBCEmployeeDAO().update(emp);
	}

	public void delete(String[] ids) {
		new JDBCEmployeeDAO().delete(ids);
	}

	public Employee findById(int id) {
		return new JDBCEmployeeDAO().findById(id);
	}

	public ArrayList<Employee> findAll() {
		return new JDBCEmployeeDAO().findAll();
	}
}
