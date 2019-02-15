<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Resume</title>
</head>
<body>
	<jsp:include page="student_menu.jsp" />
	<h3>Please upload your resume here</h3>
	<h3>${message}</h3>
	<form:form commandName="resume" method="post" action="upload.htm"
		enctype="multipart/form-data">
		<form:input type="file" name="resume" path="resume" size="30"
			required="required" />
		<input type="submit" value="submit" />
	</form:form>

</body>
</html>