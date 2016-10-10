<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th> Header Name </th>
<th> Header Value </th>
</tr>
<%! Enumeration<String> names; %>
<% names = request.getHeaderNames();
	while(names.hasMoreElements())
	{
		String name = names.nextElement();
		out.print("<tr><td>"+ name+"</td>");
		out.print("<td>" + request.getHeader(name) + "</td></tr>");
	}
%>
</table>

</body>
</html>