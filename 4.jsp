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
<a:forEach items="${sessionScope.List}" var="i">
<center>
<form action="<%=request.getContextPath()%>/cont" method="post">
Firstname<input type="text" name="fn" value="${i.firstname}" style="color: red"><br><br>
Lastname<input type="text" name="ln" value="${i.lastname}" style="color: red"><br><br>
<input type="hidden" name="flag" value="update">
<input type="submit">
</form>
</center>
</a:forEach>
</body>
</html>