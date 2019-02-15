<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.me.pojo.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Books</title>
		</style>
	</head>
	<body>
		<div style="float:left; width:20%;">
			<jsp:include page='menu.jsp' />			
		</div>
		<div style="float:right; width:80%; ">
			
                    <%
                       HashSet<Merchandise> newItem = (HashSet<Merchandise>) session.getAttribute("newItem");
                       if (newItem == null){
                            out.println("<h2>No item is added!</h2>");
                       }
                       else {
                           out.println("<b>The following item has been added to your shopping cart successfully.</b><br/><br/>");
                           for (Merchandise mer : newItem)
                               out.println(mer.getName()+"<br/><br/>");
                       }
                    %>
                    <ul>
                        [<a href='shop.do?action=viewcart'>View Cart</a>]
                        [<a href='shop.do?action=books'>Go To Book Page</a>]
                        [<a href='shop.do?action=music'>Go To Music Page</a>]
                        [<a href='shop.do?action=computers'>Go To Computer Page</a>]                        
                    </ul>
			
		</div>
	</body>
</html>