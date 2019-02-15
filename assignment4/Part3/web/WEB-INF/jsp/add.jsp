<%-- 
    Document   : add
    Created on : Feb 25, 2018, 4:10:22 AM
    Author     : Reyes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Books</title>
    </head>

    <body bgcolor='yellow'>
        <form method="post" action="add.htm">
            <table border="1" width="60%">
                <tr>
                    <th>ISBN</th>
                    <th>Book Title</th>
                    <th>Authors</th>
                    <th>Price</th>
                </tr>
                <c:forEach begin="1" end="${q}" var="i">
                    <tr>
                        <c:forEach begin="1" end="4" var="j">
                            <td align="middle"><input type="text" name="txt${i}${j}"/></td>
                            </c:forEach>
                    </tr>
                </c:forEach>
            </table>
            <input type="hidden" name='q' value="${q}">
            <input type="submit" value="Add Books">
        </form>

    </body>
</html>
