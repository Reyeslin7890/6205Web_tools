<%-- 
    Document   : search
    Created on : Feb 24, 2018, 11:08:51 PM
    Author     : Reyes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Movies</title>
    </head>
    <body bgcolor='yellow'>
        <h1>Searching Movies</h1>
        <form method="post" action="search.htm">
            Keyword : <input type="text" name="keyword"/><br/>
            <input type="radio" name="searchby" value="title"/>Search By Title<br/>
            <input type="radio" name="searchby" value="actor"/>Search By Actor<br/>
            <input type="radio" name="searchby" value="actress"/>Search By Actress<br/>   
            <input type="submit" value="Search Movies"/>
        </form>
    </body>
</html>
