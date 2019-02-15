<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Detail</title>
</head>
<body>
	<jsp:include page="emp_menu.jsp" />
	<div ng-app="" ng-init='students = ${students}'>
		<table>
			<tr>
				<td>Coop ID</td>
				<td>${c.cid}</td>
			</tr>
			<tr>
				<td>Title</td>
				<td>${c.title}</td>
			</tr>
			<tr>
				<td>Description</td>
				<td>${c.description}</td>
			</tr>
			<tr>
				<td>Students<br /> Student Count:${c.coopstudents.size()}
				</td>
				<td><table border=1>
						<tr>
							<td>First Name</td>
							<td>Last Name</td>
							<td>Email</td>
							<td>Resume</td>
							<td>Status</td>
							<td>Operation</td>
						</tr>
						<tr ng-repeat="s in students">
							<td>{{s.student.firstname}}</td>
							<td>{{s.student.lastname}}</td>
							<td>{{s.student.email}}</td>
							<td>{{s.student.resume.filename}}</td>
							<td>{{s.status}}</td>
							<td><a href="operation.htm?csid={{s.id}}&status=Accepted">Accept</a> <a
								href="operation.htm?csid={{s.id}}&status=Rejected">Reject</a></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>
</body>
</html>