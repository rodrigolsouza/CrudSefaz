<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<div align= "center">
<h1>You have successfully login</h1> 
</div>
	<!-- redirect to Menu page -->
	<jsp:forward page="/userServlet?action=menu" />
</body>
</html>