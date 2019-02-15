<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Post a coop</title>
</head>
<body>
	<jsp:include page="emp_menu.jsp" />
	<h3>${message}</h3>
	<form:form action="post.htm" commandName="coop" method="post">
		<table>
			<tr>
				<td>Title:</td>
				<td><form:input path="title" size="30" required="required" />
					<font color="red"><form:errors path="title" /></font></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:input path="description" size="100" required="required" />
					<font color="red"><form:errors path="description" /></font></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Post Coop" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>