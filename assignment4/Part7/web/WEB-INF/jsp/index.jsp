<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri='/WEB-INF/tlds/mytag.tld' prefix="my" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part7</title>
    </head>

    <body>
        <c:if test="${requestScope.filename==null}">
            <c:if test="${requestScope.rowcount==null}">
                <form action="part7.htm?action=conn" method="post">
                    <h3>Please enter the csv file name</h3>
                    <input type="text" name="filename"/>            
                    <input type="submit" value="Submit"/>
                </form>
            </c:if>
            <c:if test="${requestScope.rowcount!=null}">
                <h2>${requestScope.rowcount} rows added to MySQL Database</h2>
                <a href="index.htm">click here to go back to home page</a>
            </c:if>
        </c:if>
        <c:if test="${requestScope.filename!=null}">
            <my:reader filename="${requestScope.filename}"/>
        </c:if>
    </body>
</html>
