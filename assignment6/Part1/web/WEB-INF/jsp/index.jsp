<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part1</title>
    </head>

    <body>

        <c:if test="${rs==null}">
            <c:if test="${requestScope.rowcount==null}">
                <form action="part1.htm?action=conn" method="post">
                    <h3>Please enter the csv file name</h3>
                    <input type="text" name="filename"/>            
                    <input type="submit" value="Submit"/>
                </form>
            </c:if>
            <c:if test="${requestScope.rowcount!=null}">
                <h2>${requestScope.rowcount} rows are inserted to MySQL Database</h2>
                <a href="index.htm">click here to go back to homepage</a>
            </c:if>
        </c:if>
        <c:if test="${rs!=null}">
            <c:set var="i" value="${0}"/>
            <c:set var="pg" value="${pg}"/>
            <form action="part1.htm?action=add" method="post">
                <input type="submit" value="Submit to Mysql Database"/>
                <table border="1" align="center" width="100%">
                    <c:forEach items="${rs}" var="row">
                        <c:set var="i" value="${i+1}"/>
                        <c:if test="${i<=pg*100 && i>(pg-1)*100 && i<=rs.size()}">
                            <tr>
                                <c:forEach items="${row}" var="unit">
                                    <td>
                                        <input type="text" value="${unit}">
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:if>
                    </c:forEach>            
                </table>                
            </form>
            <
            <c:forEach begin="1" end="${rs.size()/100+1}" var="k">
                <c:if test="${k!=pg}">
                    <a href="index.htm?pg=${k}"><u>${k}</u></a>
                        </c:if>
                        <c:if test="${k==pg}">${k}</c:if>
                    </c:forEach>>
        </c:if>


    </body>
</html>
