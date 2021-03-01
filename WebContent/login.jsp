<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crud Sefaz</title>
</head>
<body>
	<div align="center">
		<h1>User Login</h1>
		<form action="validateLogin" method="post">
			<Table>
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login"></td>
				</tr>
			</Table>
		</form>
		<div align="center">
			<form action="newUser" method="post">
				<Table>
					<tr>
						<td></td>
						<td><input type="submit" value="New User"></td>
					</tr>
				</Table>
			</form>
		</div>
	</div>
</body>
</html>