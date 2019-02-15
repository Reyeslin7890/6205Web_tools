<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Coop</title>
</head>
<body>
	<jsp:include page="student_menu.jsp" />

	<div ng-app="" ng-init='cs = ${cs}'>
		<h3>
			<table border=1>
				<tr>
					<td>Coop Id</td>
					<td>Title</td>
					<td>Description</td>
					<td>Status</td>
				</tr>
				<tr ng-repeat="c in cs">
					<td>{{c.coop.cid}}</td>
					<td>{{c.coop.title}}</td>
					<td>{{c.coop.description}}</td>
					<td>{{c.status}}</td>
				</tr>
			</table>
		</h3>

	</div>
</body>
</html>