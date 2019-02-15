<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.me.pojo.Course"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Available Courses are:</title>
    </head>
    <body>
        <jsp:include page='menu.jsp' />
        
        
        <form method='post' action='course.do'>
            <h2> Results found </h2>
            <c:forEach items="${requestScope.searchResults}" var="course">
            <input type ='checkbox' name ='crn' value='${course.crn}' /> ${course.crn}-${course.name}
            [<a href='course.do?action=add&crn=${course.crn}'>Add Course</a>]<br/>
            </c:forEach>            
            <input type='hidden' name='action' value='add'/>
            <input type='submit' value='Add selected courses'>
        </form>
    </body>
</html>
