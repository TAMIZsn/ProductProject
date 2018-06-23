<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Registration Form</h2>
	<form method="post" action="RegisterServlet">
		Emp Id:<input type="text" name="firstname" value="empid"> <br> 
		Emp name:<input type="text" name="lastname" value="empname"> <br>
		Dept Code:<input type="text" name="firstname" value="deptcode"> <br> 
		DOJ:<input type="date" name="lastname" value="doj"> <br>
		User Active:<input type="checkbox" name="firstname" value="active"> <br> 
		Password:<input type="text" name="lastname" value="password"> <br>
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>