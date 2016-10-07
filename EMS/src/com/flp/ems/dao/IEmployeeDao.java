package com.flp.ems.dao;
import java.util.ArrayList;
import com.flp.ems.domain.*;


public interface IEmployeeDao {
	
	public boolean AddEmployee(Employee emp);

	public boolean ModifyEmployee(Employee emp);

	public boolean RemoveEmployee(int id);

	public Employee SearchEmployee(int id);

	public ArrayList<Employee> getAllEmployee();
}
