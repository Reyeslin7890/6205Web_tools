<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--By default this is true-->
<!--Even if this line is removed, by default the session will continue.-->
<!--Session is an implicit object in JSP-->
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <title>NEU Courses</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>
    <body>
        <jsp:include page='menu.jsp' />
    
        <c:if test='${sessionScope.username!=null}'>
            <c:redirect url="searchCourse.jsp"></c:redirect>
        </c:if>
        <c:forEach items="${pageContext.request.cookies}" var="ck">
            <c:if test='${ck.name.equals("username")}'>
                <c:set var="username" scope="page" value="${ck.value}" />
            </c:if>
            <c:if test='${ck.name.equals("password")}'>
                <c:set var="password" scope="page" value="${ck.value}" />
            </c:if>
        </c:forEach>

        <div>
            <h1>Login</h1>
            <form name='myForm' method="post" action="login.do?action=login">
                <input type="text" name="username" placeholder="Username" value='${pageScope.username}' /><br/><br/>
                <input type="password" name="password" placeholder="Password" value='${pageScope.password}' /><br/><br/>                
                <input type="checkbox" name="rememberMe" value="remember" /> Remember me  <br/><br/>
                <input type="submit" value="Log In" />
            </form>
        </div>
    </body>
</html>
