<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@page errorPage="WEB-INF/showErrorMessage.jsp" %><html><head>  <link rel="stylesheet" type="text/css" href="default.css"></head><body>  <p><a href="controller?action=viewEmpList">[Return to List]</a></p>
    <form method="post" action="controller?action=saveEmp">
  <!--input type="hidden" name="action" value="saveEmp" /-->
  <input type="hidden" name="id" value="${emp.id}" />

  <table>
    <!-- input fields -->    <tr>      <td>Name<font color="red"><sup>*</sup></font> </td>
      <td><input type="text" name="name"  value="${emp.name}" /></td>
    </tr>  
    <tr>        <td>Email</td>
      <td><input type="text" name="email" value="${emp.email}" /></td>
    </tr>
    <tr>      <td>Phone</td>
      <td><input type="text" name="phone" value="${emp.phone}" /></td>
    </tr>
	<tr>      <td>Date of Birth</td>      <td><input type="date" name="dob" value="${emp.dob}" /></td>    </tr>        <tr>      <td>Date of Joining</td>      <td><input type="date" name="doj" value="${emp.doj}" /></td>    </tr> <tr>      <td>Address</td>      <td><input type="text" name="address" value="${emp.address}" /></td>    </tr>     <tr>      <td>Department</td>      <td><input type="text" name="deptid" value="${emp.deptid}" /></td>    </tr>     <tr>      <td>Project</td>      <td><input type="text" name="projid" value="${emp.projid}" /></td>    </tr>     <tr>      <td>Role</td>      <td><input type="text" name="roleid" value="${emp.roleid}" /></td>    </tr>        
    <!-- Save/Reset buttons -->
    <tr>
      <td colspan="2">
        <input type="submit" name="save" value="Save" /> 
        &nbsp;&nbsp;
        <input type="reset" name="reset" value="Reset" />
      </td>
    </tr>                  </table>
  </form></body></html>