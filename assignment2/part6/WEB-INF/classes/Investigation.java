
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

public class Investigation extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Investigation</title>");
        
        out.println("<script>");
        out.println("function invest(){");
        out.println("var x = Number(document.getElementById(\"num\").value);");
        out.println("document.write(\"<form method='post' action='investigation'>\");");
        out.println("for (var i=1; i<=x; i++){");
        out.println("document.write(\"Please enter the name of child number \"+i+\"<br/>\");");
        out.println("document.write(\"<input type='text' name='num\"+i+\"' value=''/><br/><br/>\");");
        out.println("}");
        out.println("document.write(\"<button>Submit Query</button>\");");
        out.println("document.write(\"</form>\");");
        out.println("}");
        out.println("</script>");
        
        out.println("</head>");
        out.println("<body>");
        out.println("<b>How many children do you have?</b>");
        out.println("<input type='text' id='num' value=''/><br/><br/>");
        out.println("<input type='hidden' id='names' value='abc'/>");
        out.println("<button onclick ='invest()'>Submit Query</button>");

        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        Enumeration<String> names = request.getParameterNames();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Investigation</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Your children's names are");
        while (names.hasMoreElements()) {
            String str = request.getParameter(names.nextElement());
            out.println("<br/><br/>" + str);
        }
        out.println("</body>");
        out.println("</html>");
    }

}
