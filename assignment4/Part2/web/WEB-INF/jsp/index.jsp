<%-- 
    Document   : index
    Created on : Feb 24, 2018, 8:56:18 PM
    Author     : Reyes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Store</title>
    </head>
    <body bgcolor='pink'>
        <h1>Welcome to our Movie Store</h1>
        <h2>Please make your selection below</h2>
        <form method="post" action="moive.htm">
            <select name="selection">
                <option value="Browse Movies">Browse Movies</option>
                <option value="Add New Movie to Database">Add New Movie to Database</option>
            </select>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
