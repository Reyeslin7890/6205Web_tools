<%-- 
    Document   : menu
    Created on : 2018-2-3, 14:18:57
    Author     : LJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <ul>
            [<a href="login.do?action=logout">Logout</a>]&nbsp;&nbsp;
            [<a href="course.do?action=mycourses">My Courses</a>]&nbsp;&nbsp;
            [<a href='course.do?action=searchCourse'>Search Courses</a>] &nbsp;&nbsp;
            [<a href='course.do?query=&searchType=title&action=search'>View all Courses</a>]
        </ul>
    </body>
</html>
