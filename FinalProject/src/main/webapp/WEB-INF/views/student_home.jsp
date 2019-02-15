<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Homepage</title>
</head>
<body>
	<h2>Welcome ${user}!</h2>
	<h3>${message}</h3>
	<a href="stu/upload.htm"><h3>Upload Resume</h3></a>
	<a href="stu/search.htm"><h3>Search Co-op</h3></a>
	<a href="stu/view.htm"><h3>View Co-op Status</h3></a>
</body>
</html>