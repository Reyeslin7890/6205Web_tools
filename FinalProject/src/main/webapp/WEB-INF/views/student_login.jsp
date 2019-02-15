<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Login</title>
</head>
<body>

	<h2>Student Login</h2>

	<form action="login.htm" method="post">
		<table>
			<tr>
				<td>User Name:</td>
				<td><input name="username" size="30" required="required" /></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" size="30" required="required" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Login" /></td>
			</tr>
			<tr>
				<td><a href="register.htm">Register</a></td>
			</tr>
		</table>

	</form>


</body>
</html>