<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="a" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table border="1">
<th>ID</th>
<th>FirstName</th>
<th>LastName</th>
<th colspan="2">Action</th>
<a:forEach items="${sessionScope.List}" var="i">
<tr>
<td>${i.id}</td>
<td>${i.firstname}</td>
<td>${i.lastname}</td>
<td><a href="<%=request.getContextPath()%>/cont?id=${i.id}&flag=delete">Delete</a></td>
<td><a href="<%=request.getContextPath()%>/cont?id=${i.id}&flag=edit">Edit</a></td>
</tr>
</a:forEach>
</table>
<a href="2.jsp"><h1>Next Search</h1></a>
</center>

</body>
</html>