<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix = "x"  uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Standard Tags Library</title>
    </head>
    <body>
        <h2>Core Tags</h2>
        <c:set var="num" scope="session" value="${101}"/>
        <c:choose>
            <c:when test="${sessionScope.num  % 2== 0}">
                <c:out value="${num}"/> is a Even number.
            </c:when>
            <c:otherwise>
                <c:out value="${num}"/> is a Odd number.
            </c:otherwise>
        </c:choose>

        <h2>XML Tags</h2>
        <c:import var = "users" url = "http://localhost:8080/Part4/users.xml"/>
        <x:parse xml = "${users}" var = "output"/>
        The first name of the first user is: 
        <x:out select = "$output/users/user[1]/firstname" />
        <br/>
        The userid of the second user is: 
        <x:out select = "$output/users/user[2]/userid" /><br/><br/>
        <b>XML Information:</b><br/>    
        <x:forEach select="$output/users/user" var="us">
            First Name : <x:out select="$us/firstname"/><br/>
            Last Name : <x:out select="$us/lastname"/><br/>
            User ID : <x:out select="$us/userid"/><br/>
        </x:forEach>        

        <h2>Function Tags</h2>
        <table border='1' width='80%'>
            <c:set  var="str" value="Create a JSP page that uses at least 3 JSTL tags from each tag library group."/>
            <tr><td>Original Sentence <td><c:out value="${str}"/><br/><br/>
                    <c:set var="str1" value="${fn:toUpperCase(str)}" />
            <tr><td>UpperCase <td><c:out value="${str1}"/><br/><br/>
                    <c:set var="str2" value="${fn:replace(str, 'a', '{@}')}" />
            <tr><td>Replace a by {@} <td><c:out value="${str2}"/><br/><br/>
                    <c:set var="str3" value="${fn:split(str,' ')}" />
                    <c:set var="str4" value="${fn:join(str3,'/')}" />
            <tr><td>Split by space and Join with slash <td><c:out value="${str4}"/><br/>
        </table>

        <h2>Formatting Tags</h2>
        <table border='1' width='40%'>
            <c:set var="num" value="${100000/7}"/>
            <c:set var="now" value='<%= new java.util.Date()%>'/>
            <tr><td>Formatted Number<td> <fmt:formatNumber type = "number" pattern = "#.###E0" value = "${num}"/><br/>
            <fmt:parseNumber var = "i" type = "number" value = "${num}" />
            <tr><td>Parsed Number<td> <c:out value = "${i}" /><br/>
            <tr><td>Formatted Date<td> <fmt:formatDate type = "both" dateStyle = "long" timeStyle = "long" value = "${now}" />       
        </table>
        <h2>SQL Tags</h2>
        <sql:setDataSource var = "moviedb" driver = "com.mysql.jdbc.Driver" url = "jdbc:mysql://localhost/moviedb" user = "root"  password = "7890"/>
        <c:set var="id" value="7"/>
        <sql:query dataSource = "${moviedb}" var = "result">
            SELECT * from memberdetails where MemberId >= ?
            <sql:param value="${id}" />
        </sql:query>
        <table border = "1" width = "50%">
            <tr>
                <th>Member ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Date of Birth</th>
            </tr>

            <c:forEach var = "row" items = "${result.rows}">
                <tr>
                    <td> <c:out value = "${row.MemberId}"/></td>
                    <td> <c:out value = "${row.FirstName}"/></td>
                    <td> <c:out value = "${row.LastName}"/></td>
                    <td> <c:out value = "${row.DateOfBirth}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
