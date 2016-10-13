<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.Map"%>
<%@page import="com.seed.beans.Product"%>
<%@page import="com.seed.util.ProductsRepository"%>
<%@page import="com.seed.util.ProductsRepositoryInMemoryImpl"%>
<%@page import="java.util.Set"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="storeWishListDetails.jsp" method="post">

	<h1>Select books</h1>
<c:forEach items="${entries.products}" var="prod">
      <tr>
      <td><input type="checkbox" name="id" value="${prod.key}"></td>
      <td>${prod.value.name}</td>
      <td>${prod.value.price}</td>
      </tr>
      <br/>
</c:forEach>
	<br/>
	<input type="submit" value="Add to Wish List & shop more?" name="addToList"/>
	<input type="submit" value="Check Out" name="checkout"/>
</form>

</body>
</html>