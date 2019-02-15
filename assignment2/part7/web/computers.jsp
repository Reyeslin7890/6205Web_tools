<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Beans.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Computers</title>		
		<style type="text/css">
		#top,
		#bottom {
			position: fixed;
			left: 20%;
			right: 0;
			height: 80%;
		}
		#top {top: 0;}
		#bottom {bottom: 0;}
		</style>
	</head>
	<body>
		<div style="float:left; width:20%;">
			<jsp:include page='menu.jsp' />			
		</div>
		<div style="float:right; width:80%; ">
			<div id='top' >
				<br/>Shop for Laptops
			</div>
			<div id='bottom'>
				[<a href="viewcart.jsp">View Carts</a>]<br/><br/>
                            <form method="post" action="shop.do?action=add">
                                <%
                                    ArrayList<Merchandise> merList = (ArrayList<Merchandise>) session.getAttribute("Merchandise");
                                    if (merList!=null)
                                    for (Merchandise mer : merList)
                                        if (mer instanceof Laptop)
                                        out.println("<input type='checkbox' name='mer' value='"+mer.getName()+"'/>"+mer.getName()+"[$"+mer.getPrice()+"]<br/><br/>");
                                %>
                                <button>Add to Cart</button>
                            </form>
			</div>
		</div>
	</body>
</html>