<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
	<title>User Catalog</title>
</head>
<body>
	<center>
		<h1>User Catalog</h1>
        <h2>
        	<a href="${pageContext.request.contextPath}/phoneNumberServlet?action=new&user_id=<c:out value='${user.id}'/>">New Number</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="${pageContext.request.contextPath}/userServlet?action=list">List Users</a>
        </h2>
	</center>
    <div align="center">
    	<h2>
        	User: <c:out value='${user.name}'/>
        </h2>
        <table class="table table-striped table-bordered" style="width:100%">
            <tr class="thead-dark">
                <th scope="col">ID</th>
                <th scope="col">DDD</th>
                <th scope="col">Number</th>
                <th scope="col">Type</th>
                <th scope="col">Actions</th>
            </tr>
            <c:forEach var="phoneNumber" items="${phoneNumbers}">
                <tr>
                    <td scope="row"><c:out value="${phoneNumber.id}" /></td>
                    <td><c:out value="${phoneNumber.ddd}" /></td>
                    <td><c:out value="${phoneNumber.number}" /></td>
                    <td><c:out value="${phoneNumber.type}" /></td>
                    <td>
                    <a href="${pageContext.request.contextPath}/phoneNumberServlet?action=edit&user_id=<c:out value='${user.id}'/>&id=<c:out value='${phoneNumber.id}'/>">Update</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                   	<a href="${pageContext.request.contextPath}/phoneNumberServlet?action=delete&user_id=<c:out value='${user.id}'/>&id=<c:out value='${phoneNumber.id}'/>">Delete</a>
                    	                	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
</body>
</html>
