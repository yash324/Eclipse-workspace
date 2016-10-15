import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flp.ems.dao.JDBCEmployeeDAO;
import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.util.DBUtility;

@Controller
@RequestMapping(value = "/*")
public class myController {
	@Autowired
	EmployeeServiceImpl empservice;

	@RequestMapping(method = RequestMethod.GET)
	public String viewEmployees(Map<String, Object> model) {
		// check if add or modify and 
		if(model.get("action")=="editEmp")
		{
			Employee emp = empservice.findById(Integer.parseInt((String) model.get("empid")));
			model.put("emp", emp);
			return "empForm";
		}
		
		if(model.get("action")=="addEmp")
		return "empForm";	

		List<Employee> empList = empservice.findAll();
		model.put("empList", empList);
		return "empList";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processEmployee(@ModelAttribute("empForm") Employee emp) {
		//check if delete / returning from save form and act accordingly
		return "empList.jsp";
	}

	@ModelAttribute("empForm")
	Employee getUser() {
		// if(add)
		// create new employee
		// else
		// get existing employee by id
		//return employee
	}

	}else if(SAVE_EMP_ACTION.equals(actionName))
	{
		Employee emp = new Employee();
		int id = Integer.parseInt(request.getParameter("empid"));
		emp.setEmpid(id);
		if (id == -1)
			empService.create(emp);
		else
			empService.update(emp);
		empList = empService.findAll();
		request.setAttribute("empList", empList);
		destinationPage = "empList.jsp";
	}else if(DELETE_EMP_ACTION.equals(actionName))
	{
		String[] ids = request.getParameterValues("empid");
		empService.delete(ids);
		empList = empService.findAll();
		request.setAttribute("empList", empList);
		destinationPage = "empList.jsp";
	}else
	{
		String errorMessage = "[" + actionName + "] is not a valid action.";
		request.setAttribute(ERROR_KEY, errorMessage);
	}}}