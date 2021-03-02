<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>User Catalog</title>
</head>
<body>
	<center>
		<h1>User Catalog</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/userServlet?action=new">New
				User</a> &nbsp;&nbsp;&nbsp;
		</h2>

	</center>
	<div style='text-align: right'>
		<h3>
			<a href="${pageContext.request.contextPath}/userServlet?action">Log
				Out</a> &nbsp;&nbsp;&nbsp;
		</h3>
	</div>
	<div align="center">
		<table class="table table-striped table-bordered" style="width: 100%">
			<tr class="thead-dark">
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Actions</th>
			</tr>
			<c:forEach var="user" items="${users}">
				<tr>
					<td scope="row"><c:out value="${user.id}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><a
						href="${pageContext.request.contextPath}/userServlet?action=edit&id=<c:out value='${user.id}'/>">Update</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="${pageContext.request.contextPath}/userServlet?action=delete&id=<c:out value='${user.id}'/>">Delete</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="${pageContext.request.contextPath}/phoneNumberServlet?action=list&user_id=<c:out value='${user.id}'/>">List
							Numbers</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
