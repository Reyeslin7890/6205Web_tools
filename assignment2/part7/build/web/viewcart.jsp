<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Beans.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
		<title>View Carts</title>		
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
                    
                    <%
                       HashSet<Merchandise> myCart = (HashSet<Merchandise>) session.getAttribute("myCart");
                       double total = 0;
                    %>
                    <table border ='1'>
                        <thead><tr><th>Merchandise</th><th>Price</th></tr></thead>
                        <tbody>
                            <%
                                if (myCart!=null)
                                for (Merchandise mer : myCart){
                                    out.println("<tr><td>"+mer.getName()+"<td>"+mer.getPrice()+
                                                "<td><a href='shop.do?action=remove&mer="+mer.getName()+"'>Remove</a>"+
                                            "</tr>");
                                    total+=mer.getPrice();
                                }
                            %>
                        <tfoot><tr><td>Total</td><td><%=total%></td></tr></tfoot>
                    </table>
                    <ul>
                        [<a href='books.jsp'>Go To Book Page</a>]
                        [<a href='music.jsp'>Go To Music Page</a>]
                        [<a href='computers.jsp'>Go To Computer Page</a>]                        
                    </ul>
		</div>
	</body>
</html>