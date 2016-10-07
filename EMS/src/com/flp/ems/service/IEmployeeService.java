package com.flp.ems.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface IEmployeeService {
	public boolean AddEmployee(HashMap<String, String> data);

	public boolean ModifyEmployee(HashMap<String, String> data);

	public boolean RemoveEmployee(String id);

	public String SearchEmployee(String id);

	public ArrayList<String> getAllEmployee();
}
