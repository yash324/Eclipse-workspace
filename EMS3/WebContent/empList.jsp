<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="WEB-INF/showErrorMessage.jsp" %>

<html>

<head>  
  <link rel="stylesheet" type="text/css" href="default.css">

  <script>
  	  function checkAll(field)
      {
          for (i=0; i < field.length; i++)
          {
              field[i].checked = true;
          }
      }
  </script>
</head>

<body>
  <p><a href="controller?action=addEmp">[Add Employee]</a></p>
  
  <form name="deleteForm" method="post" action="controller">
  <input type="hidden" name="action" value="deleteEmp" />
  <table>    <tr>
      <th><a href="javascript:checkAll(document.deleteForm.id)">Select All</a></th>
      <th> Action</th>      <th> Name </th>
      <th> Email </th>
      <th> Phone </th>
      <th> Date of Birth </th>
      <th> Date of Joining </th>
      <th> Address </th>
      <th> Department </th>
      <th> Project </th>
      <th> Role </th>
    </tr>        <c:forEach items='${empList}' var="emp">      <tr>
      <td><input type="checkbox" name="empid" value="${emp.empid}"></td>
      <td><a href="controller?action=editEmp&empid=${emp.empid}">Edit</a></td>      <td>${emp.name}</td>      <td>${emp.email}</td>
      <td>${emp.phone}</td>
      <td>${emp.dob}</td>
      <td>${emp.doj}</td>
      <td>${emp.address}</td>
      <td>${emp.deptid}</td>
      <td>${emp.projid}</td>
      <td>${emp.roleid}</td>      </tr>    </c:forEach>
    
    <tr>
      <td colspan="11">
        <input type="submit" name="Delete Checked" value="Delete Checked" />
        &nbsp;&nbsp;
        <input type="reset" name="Reset" value="Reset" />
      </td>
    </tr>
  </table>
  </form></body>

</html>