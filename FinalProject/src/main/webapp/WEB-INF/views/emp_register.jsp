<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>Register Employer</title>
</head>
<body>
	<h2>Register Employer</h2>
	<form:form action="register.htm" commandName="employer" method="post">

		<table>
			<tr>
				<td>User Name:</td>
				<td><form:input path="username" size="30" required="required"
						onkeyup="check()" id="username" /> <font color="red"><form:errors
							path="username" /></font>
					<div id="udiv"></div></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" size="30"
						required="required" /> <font color="red"><form:errors
							path="password" /></font></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstname" size="30" required="required" />
					<font color="red"><form:errors path="firstname" /></font></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastname" size="30" required="required" />
					<font color="red"><form:errors path="lastname" /></font></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><form:input path="email" size="30" required="required"
						type="email" /> <font color="red"><form:errors path="email" /></font></td>
			</tr>

			<tr>
				<td>Organization Name:</td>
				<td><form:input path="orgname" size="30" required="required" />
					<font color="red"><form:errors path="orgname" /></font></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Register User" /></td>
			</tr>
		</table>
	</form:form>
	<script>
		function check() {
			$.post("ajax.htm", {
				'username' : document.getElementById("username").value
			}).done(function(data) {
				document.getElementById("udiv").innerHTML = data;
			});

		}
	</script>
</body>
</html>