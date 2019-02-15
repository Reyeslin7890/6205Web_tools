<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

<script>
	function tit() {
		document.getElementById("const").innerHTML = "Title";
		document.getElementById("by").value = "title";
	}
</script>
<script>
	function org() {
		document.getElementById("const").innerHTML = "Organization";
		document.getElementById("by").value = "org";
	}
</script>
<title>Search Coop</title>
</head>
<body>
	<jsp:include page="student_menu.jsp" />
	<h2>Search Coop</h2>
	<h3><button onclick="tit()">Search by Title</button>
	<button onclick="org()">Search by Organization</button>
	<div id="const">Title</div>
	<form action="search.htm" method="get">
		<input type="hidden" id="by" name="by" value="title" /> <input
			type="text" name="search" /> <input type="submit" value="submit" />
	</form></h3>
	<h3>${message}</h3>
	<h3>
		<table border=1 ng-app="" ng-init='coops = ${coops}'>
			<tr>
				<td>Coop ID</td>
				<td>Organization</td>
				<td>Title</td>
				<td>Description</td>
				<td>Apply</td>
			</tr>
			<tr ng-repeat="c in coops">
				<td>{{c.cid}}</td>
				<td>{{c.postedby.orgname}}</td>
				<td>{{c.title}}</td>
				<td>{{c.description}}</td>
				<td><a href="apply.htm?cid={{c.cid}}">Apply</a></td>
			</tr>
		</table>
	</h3>


</body>
</html>