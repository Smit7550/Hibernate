<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function fun() 
{
	var x = document.getElementById("f");
	var y = document.getElementById("l");
	if(x.value=="")
	{
	alert("Enter Firstname");
	return false;
	}
	else if(y.value=="")
	{
	alert("Enter Lastname");
	return false;
	}
}
</script>
</head>
<body>
<center>
<form action="<%=request.getContextPath()%>/cont" method="post">
<input type="text" name="fn" placeholder="Firstname" id="f"><br><br>
<input type="text" name="ln" placeholder="Lastname" id="l"><br><br>
<input type="hidden" name="flag" value="insert" >
<input type="submit" onclick="fun()"><br><br>
</form>

<form action="<%=request.getContextPath()%>/cont" method="post">
<input type="text" placeholder="Enter Your Search" name="search"><br><br>
<input type="hidden" name="flag" value="search">
<input type="submit"><br><br>
</form><br><br>
</center>
</body>
</html>