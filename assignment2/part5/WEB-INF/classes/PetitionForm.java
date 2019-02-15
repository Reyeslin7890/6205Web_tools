
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class PetitionForm extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Enumeration<String> formEnum = request.getParameterNames();
        //page

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Petition Form Values</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<H1> Petition Form </H1>");
        out.println("<table border=1>\n" + " <tr bgcolor='#FFAD00'>\n");
        out.println("<th>Variable Name<th>Value");

        while (formEnum.hasMoreElements()) {
            String str = formEnum.nextElement();
            String[] values = request.getParameterValues(str);
            out.println("<tr><td>" + str + "<td>");
            for (int i = 0; i < values.length - 1; i++) {
                out.print(values[i] + ", ");
            }
            out.print(values[values.length - 1]);
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
