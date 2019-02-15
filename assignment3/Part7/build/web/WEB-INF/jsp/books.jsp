<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.me.pojo.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Books</title>
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
				<br/>
				Shop for Books
			</div>
			<div id='bottom'>
                            [<a href="shop.do?action=viewcart">View Carts</a>]<br/><br/>
                            <form method="post" action="shop.do?action=add">
                                <c:if test="${sessionScope.Merchandise !=null}">
                                    <c:forEach items="${sessionScope.Merchandise}" var="mer">
                                        
                                    </c:forEach>
                                </c:if>
                                <%
                                    ArrayList<Merchandise> merList = (ArrayList<Merchandise>) session.getAttribute("Merchandise");
                                    if (merList!=null)
                                    for (Merchandise mer : merList)
                                        if (mer instanceof Book)
                                        out.println("<input type='checkbox' name='mer' value='"+mer.getName()+"'/>"+mer.getName()+"[$"+mer.getPrice()+"]<br/><br/>");
                                %>
                                <button>Add to Cart</button>
                            </form>
			</div>
		</div>
	</body>
</html>