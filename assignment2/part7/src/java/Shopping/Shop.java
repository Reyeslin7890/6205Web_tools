package Shopping;

import Beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import javax.servlet.RequestDispatcher;

public class Shop extends HttpServlet {
	
	List<Merchandise> merList;
	public void init() {
		merList = new ArrayList<>();
                
		Merchandise b1 = new Book();
		b1.setName("Java Servlet Programming");
		b1.setPrice(29.95);
		merList.add(b1);
		
		Merchandise b2 = new Book();
		b2.setName("Oracle Database Programming");
		b2.setPrice(48.95);
		merList.add(b2);
		
		Merchandise b3 = new Book();
		b3.setName("System Analysis and Design with UML");
		b3.setPrice(14.95);
		merList.add(b3);
		
		Merchandise b4 = new Book();
		b4.setName("Object Oriented Software Engineering");
		b4.setPrice(35.99);
		merList.add(b4);
		
		Merchandise b5 = new Book();
		b5.setName("Java Web Services");
		b5.setPrice(27.99);
		merList.add(b5);
		
                Merchandise c1 = new CD();
		c1.setName("I'm Going to Tell You a Secret by Mcdonna");
		c1.setPrice(29.95);
		merList.add(c1);
		
		Merchandise c2 = new CD();
		c2.setName("Baby One More Time by Britney Spears");
		c2.setPrice(10.95);
		merList.add(c2);
		
		Merchandise c3 = new CD();
		c3.setName("Justified by Timberlake");
		c3.setPrice(9.97);
		merList.add(c3);
		
		Merchandise c4 = new CD();
		c4.setName("Loose by Nelly Furtado");
		c4.setPrice(13.98);
		merList.add(c4);
		
		Merchandise c5 = new CD();
		c5.setName("Gold Digger by Kanye West");
		c5.setPrice(13.98);
		merList.add(c5);
                
                Merchandise l1 = new Laptop();
		l1.setName("Apple MacBook Pro with 13.3 Display");
		l1.setPrice(949.95);
		merList.add(l1);
		
		Merchandise l2 = new Laptop();
		l2.setName("Asus Laptop with Centrino 2 Black");
		l2.setPrice(949.95);
		merList.add(l2);
		
		Merchandise l3 = new Laptop();
		l3.setName("HP Pavilion Laptop with Centrino 2 DV7");
		l3.setPrice(1199.95);
		merList.add(l3);
		
		Merchandise l4 = new Laptop();
		l4.setName("Toshiba Satellite Laptop with Centrino 2 - Copper");
		l4.setPrice(899.99);
		merList.add(l4);
		
		Merchandise l5 = new Laptop();
		l5.setName("Sony VAIO Laptop with Core 2 Duo Cosmopolitan Pink");
		l5.setPrice(779.99);
		merList.add(l5); 
	}
        
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String page = request.getParameter("page");
        String action = request.getParameter("action");
        Set<Merchandise> myCart,newItem;
        if (session.getAttribute("myCart")!=null){
            myCart = (Set<Merchandise>) session.getAttribute("myCart");
        } else {
            myCart = new HashSet<Merchandise>();
        }
        newItem = new HashSet<>();
        if (page!=null && page.equals("welcome")){
            session.setAttribute("Merchandise", merList);
            RequestDispatcher rd = request.getRequestDispatcher("/books.jsp");
            rd.forward(request, response);
        }
        else if (action.equals("add")){
            String[] values = request.getParameterValues("mer");
            for (String value : values)
                for (Merchandise mer : merList)
                    if (mer.getName().equals(value)){
                        myCart.add(mer);
                        newItem.add(mer);
                }
            session.setAttribute("myCart", myCart);
            session.setAttribute("newItem", newItem);
            RequestDispatcher rd = request.getRequestDispatcher("/addsuccess.jsp");
            rd.forward(request, response);
        }
        else if (action.equals("remove")){
            String str = request.getParameter("mer");
            Merchandise removeMerchandise=null;
            for (Merchandise mer : myCart)
                if (mer.getName().equals(str))
                    removeMerchandise = mer;
            myCart.remove(removeMerchandise);
            session.setAttribute("myCart", myCart);
            RequestDispatcher rd = request.getRequestDispatcher("/viewcart.jsp");
            rd.forward(request, response);
        }
    }
}
