<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Fetch Data</h2>
	<form method="get" action="AddProductServlet">
		Fetch Flights: <input type="submit" />
	
	 <div align="center">
        <table border="1" cellpadding="5">
            <tr>
 				<th>Product Id</th>
                <th>Product Name</th>
                
            </tr>
            <c:forEach items="${data}" var="post">
                <tr>
                    <td><c:out value="${post.productId}" /></td>
                    <td><c:out value="${post.productName}" /></td>
                  
                </tr>
            </c:forEach>
        </table>
    </div>
	</form>

</body>
</html>