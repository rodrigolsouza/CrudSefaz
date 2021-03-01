<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>User Catalog</title>
</head>
<body>
	<center>
		<h1>User Catalog</h1>
        <h2>
        	<a href="${pageContext.request.contextPath}/user?action=list">List Users</a>
 
        </h2>
	</center>
    <div align="center">
    	<h2>
        	User: <c:out value='${user.name}'/>
        </h2>
		<c:if test="${phoneNumber != null}">
			<form action="${pageContext.request.contextPath}/phoneNumberServlet?action=update&user_id=<c:out value='${user.id}'/>" method="post">
        </c:if>
        <c:if test="${phoneNumber == null}">
			<form action="${pageContext.request.contextPath}/phoneNumberServlet?action=insert&user_id=<c:out value='${user.id}'/>" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${phoneNumber != null}">
            			Update PhoneNumber
            		</c:if>
            		<c:if test="${phoneNumber == null}">
            			Add phoneNumber
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${phoneNumber != null}">
        			<input type="hidden" name="id" value="<c:out value='${phoneNumber.id}' />" />
        		</c:if>            
            <tr>
                <th>DDD: </th>
                <td>
                	<input type="number" name="ddd" size="45"
                			value="<c:out value='${phoneNumber.ddd}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Number: </th>
                <td>
                	<input type="text" name="number" size="45"
                			value="<c:out value='${phoneNumber.number}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Type: </th>
                <td>
                	<input type="text" name="type" size="45"
                			value="<c:out value='${phoneNumber.type}' />"
                	/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            	<c:if test="${phoneNumber != null}">
							<input type="submit" value="Update" />
		        </c:if>
		        <c:if test="${phoneNumber == null}">
							<input type="submit" value="Save" />
		        </c:if>
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
