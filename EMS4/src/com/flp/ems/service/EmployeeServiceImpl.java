package com.flp.ems.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flp.ems.dao.JDBCEmployeeDAO;
import com.flp.ems.domain.Employee;
@Service
public class EmployeeServiceImpl {
	@Autowired
	JDBCEmployeeDAO empDAO;
	public void create(Employee emp) {
		empDAO.create(emp);
	}

	public void update(Employee emp) {
		empDAO.update(emp);
	}

	public void delete(String[] ids) {
		empDAO.delete(ids);
	}

	public Employee findById(int id) {
		return empDAO.findById(id);
	}

	public ArrayList<Employee> findAll() {
		return empDAO.findAll();
	}
}
