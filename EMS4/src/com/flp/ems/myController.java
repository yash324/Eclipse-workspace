package com.flp.ems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeServiceImpl;

@Controller
@RequestMapping(value = "/*")
public class myController {
	@Autowired
	EmployeeServiceImpl empservice;
	ArrayList<Employee> empList;

	@RequestMapping(value = "/")
	public String viewEmployees(Map<String, Object> model) {
		empList = empservice.findAll();
		model.put("empList", empList);
		return "empList";
	}

	@RequestMapping(value = "/editEmp")
	public String editEmployee(Map<String, Object> model, @RequestParam("empid") String empid) {
		Employee emp = empservice.findById(Integer.parseInt(empid));
		model.put("emp", emp);
		return "empForm";
	}

	@RequestMapping(value = "/addEmp")
	public String addEmployee(Map<String, Object> model) {
		Employee emp = new Employee();
		model.put("emp", emp);
		return "empForm";
	}
	
	@RequestMapping(value = "/delEmp")
	public String delEmployee(Map<String, Object> model) {
		empservice.delete((String[]) model.get("empid"));
		return "empList";
	}
	
	@RequestMapping(value = "/saveEmp")
	public String processEmployee(Map<String, Object> model, @ModelAttribute("emp") Employee emp) {
		System.out.println("within save emp");
		if (emp.getEmpid() == -1)
			empservice.create(emp);
		else
			empservice.update(emp);
		return "empList";
	}
}