<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Catalog</title>
</head>
<body>
	<center>
		<h1>User Catalog</h1>
        <h2>
        	<a href="${pageContext.request.contextPath}/phoneNumberServlet?action=new&user_id=<c:out value='${user.id}'/>">Add New Phone Number</a>
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
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Açtions</th>
            </tr>
            <c:forEach var="phoneNumber" items="${phoneNumbers}">
                <tr>
                    <td scope="row"><c:out value="${phoneNumber.id}" /></td>
                    <td><c:out value="${phoneNumber.ddd}" /></td>
                    <td><c:out value="${PhoneNumber.number}" /></td>
                    <td><c:out value="${PhoneNumber.type}" /></td>
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