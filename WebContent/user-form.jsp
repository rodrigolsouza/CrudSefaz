<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Catalog</title>
</head>
<body>
	<center>
		<h1>User Catalog</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/userServlet?action=list">List
				Users</a>
		</h2>
	</center>
	<div align="center">
		<c:if test="${user != null}">
			<form
				action="${pageContext.request.contextPath}/userServlet?action=update"
				method="post">
		</c:if>
		<c:if test="${user == null}">
			<form
				action="${pageContext.request.contextPath}/userServlet?action=insert"
				method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${user != null}">
            			Update User
            		</c:if>
					<c:if test="${user == null}">
            			Add User
            		</c:if>
				</h2>
			</caption>
			<c:if test="${user != null}">
				<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
			</c:if>
			<tr>
				<th>Name:</th>
				<td><input type="text" name="name" size="45"
					value="<c:out value='${user.name}' />" /></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="text" name="email" size="45"
					value="<c:out value='${user.email}' />" /></td>
			</tr>
			<tr>
				<th>PassWord:</th>
				<td><input type="password" id="pass" name="passWord" size="45"
					value="<c:out value='${user.passWord}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><c:if test="${user != null}">
						<input type="submit" value="update" />
					</c:if> <c:if test="${user == null}">
						<input type="submit" value="Save" />
					</c:if></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
