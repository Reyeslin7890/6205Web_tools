<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<title>View Posted Coop</title>
</head>
<body>
	<jsp:include page="emp_menu.jsp" />
	<h2>Posted Coop</h2>
	<div ng-app="" ng-init='coops = ${coops}'>
		<h3>
			<table border=1>
				<tr>
					<td>Coop Id</td>
					<td>Title</td>
					<td>Description</td>
				</tr>
				<tr ng-repeat="c in coops">
					<td>{{c.cid}}</td>
					<td><a href='coop.htm?cid={{c.cid}}'>{{c.title}}</a></td>
					<td>{{c.description}}</td>
				</tr>
			</table>
		</h3>

	</div>
</body>
</html>