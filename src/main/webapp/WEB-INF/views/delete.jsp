<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
delete

<form:form action="delete" modelAttribute="employeeid" method="post"> 
Id: <form:input path="id" /> <br>
 <input type="submit" value="Delete" />  
</form:form>
</body>
</html>