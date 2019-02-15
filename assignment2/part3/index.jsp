<%@ page import="java.util.*" %>
<html>
	<head>
		<title> Headers Using JSP Page </title>
	</head>
	<body>
		<h1>Headers Using JSP Page </h1>
		<table border=1>
			<tr bgcolor='ffad00'>
			<th>CGI Variable Name<th>Value
			<%
				Enumeration<String> headers = request.getHeaderNames();
				while (headers.hasMoreElements()){
				String header = headers.nextElement();
				Enumeration<String> values = request.getHeaders(header);
				%><TR><TD><%= header %><TD><%
				while (values.hasMoreElements()){
				out.print(values.nextElement());			
				}
				}
			%>
		</table>
	</body>
</html>