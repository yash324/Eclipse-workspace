import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.util.DBUtility;
public class ControllerServlet extends HttpServlet {
	private static final String ACTION_KEY = "action";
	private static final String VIEW_EMP_LIST_ACTION = "viewEmpList";
	private static final String ADD_EMP_ACTION = "addEmp";
	private static final String SAVE_EMP_ACTION = "saveEmp";
	private static final String EDIT_EMP_ACTION = "editEmp";
	private static final String DELETE_EMP_ACTION = "deleteEmp";
	private static final String ERROR_KEY = "errorMessage";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		processRequest(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionName = request.getParameter(ACTION_KEY);
		String destinationPage = null;
		List<Employee> empList = null;
		EmployeeServiceImpl empService = DBUtility.getEmployeeService();
		// perform action
		if (VIEW_EMP_LIST_ACTION.equals(actionName)) {
			empList = empService.findAll();
			request.setAttribute("empList", empList);
			destinationPage = "empList.jsp";
		} else if (ADD_EMP_ACTION.equals(actionName)) {
			Employee emp = new Employee();
			request.setAttribute("emp", emp);
			destinationPage = "empForm.jsp";
		} else if (EDIT_EMP_ACTION.equals(actionName)) {
			int id = Integer.parseInt(request.getParameter("empid"));
			Employee emp = empService.findById(id);
			request.setAttribute("emp", emp);
			destinationPage = "empForm.jsp";
		} else if (SAVE_EMP_ACTION.equals(actionName)) {
			Employee emp = new Employee();
			emp.setName(request.getParameter("name"));
			emp.setEmail(request.getParameter("email"));
			emp.setPhone(Long.parseLong(request.getParameter("phone")));
			emp.setDob(request.getParameter("dob"));
			emp.setDoj(request.getParameter("doj"));
			emp.setAddress(request.getParameter("address"));
			emp.setDeptid(Integer.parseInt(request.getParameter("deptid")));
			emp.setProjid(Integer.parseInt(request.getParameter("projid")));
			emp.setRoleid(Integer.parseInt(request.getParameter("roleid")));
			int id = Integer.parseInt(request.getParameter("empid"));
			emp.setEmpid(id);
			if (id == -1)
				empService.create(emp);
			else
				empService.update(emp);
			empList = empService.findAll();
			request.setAttribute("empList", empList);
			destinationPage = "empList.jsp";
		} else if (DELETE_EMP_ACTION.equals(actionName)) {
			String[] ids = request.getParameterValues("empid");
			empService.delete(ids);
			empList = empService.findAll();
			request.setAttribute("empList", empList);
			destinationPage = "empList.jsp";
		} else {
			String errorMessage = "[" + actionName + "] is not a valid action.";
			request.setAttribute(ERROR_KEY, errorMessage);
		}
		RequestDispatcher r = request.getRequestDispatcher(destinationPage);
		r.forward(request, response);
	}
}