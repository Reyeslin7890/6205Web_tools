<%-- 
    Document   : result
    Created on : Feb 24, 2018, 11:18:09 PM
    Author     : Reyes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Result</title>
</head>
<body bgcolor='green'>
	<h2>You searched for "${requestScope.keyword}"</h2>
	<b><u>Here are the search results</u></b>
	<br />
	<table border="1" width="50%">
		<tr>
			<th>Movie Title</th>
			<th>Lead Actor</th>
			<th>Lead Actress</th>
			<th>Genre</th>
			<th>Year</th>
		</tr>
		<c:forEach items='${sessionScope.result}' var='rs'>
			<tr>
				<td>${rs.title}</td>
				<td>${rs.actor}</td>
				<td>${rs.actress}</td>
				<td>${rs.genre}</td>
				<td>${rs.year}</td>
			</tr>
		</c:forEach>

	</table>
	<a href="index.jsp">Click here to go back to the main page</a>
</body>
</html>
