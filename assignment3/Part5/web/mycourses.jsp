<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.HashSet"%>
<%@page import="Bean.Course"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course View</title>
    </head>
    <body>
        <jsp:include page='menu.jsp' />
        [<a href='searchCourse.jsp'>Go to Search page</a>] 
        [<a href="login.do?action=logout">Logout</a>]
        <h3> Courses Added:</h3>
        <!--if there are no course in the set-->
        <c:choose>
            <c:when test='${sessionScope.myCourseSet == null}'><div><p> No Course Added for you.</p></div></c:when>
            <c:otherwise>
                <c:forEach items="${sessionScope.myCourseSet}" var="course">
                    CRN: ${course.crn} - Course Name: ${course.name} [<a href='course.do?action=remove&crn=${course.crn}'>Remove Course</a>]<br/>
                </c:forEach>
            </c:otherwise>
        </c:choose>        
    </body>
</html>
