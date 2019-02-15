<%-- 
    Document   : movie_form
    Created on : Feb 24, 2018, 9:07:20 PM
    Author     : Reyes
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movie to Database</title>
    </head>
    <body bgcolor='blue'>
        <h1>Please enter the details below:</h1>
        <form:form commandName="movie" method="post">
            Movie Title<form:input path='title' /><br/>
            Lead Actor<form:input path='actor' /><br/>
            Lead Actress<form:input path='actress' /><br/>
            Genre<form:input path='genre' /><br/>
            Year<form:input path='year' /><br/>
            <input type="submit" value="submit"/>
        </form:form>
    </body>
</html>
