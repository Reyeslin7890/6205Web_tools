import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class PetitionForm extends HttpServlet{


	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		Map<String,String[]> formMap = request.getParameterMap();
                Set<String> keySet = formMap.keySet();
                //page
                        
		out.println("<html>");
		out.println("<head>");
                out.println("<title>Petition Form Values</title>");
		out.println("</head>");
		out.println("<body>");		
		out.println("<H1> Petition Form </H1>");
		out.println("<table border=1>\n" + " <tr bgcolor='#FFAD00'>\n");
		out.println("<th>Variable Name<th>Value");
                
                for (String key : keySet){                    
                    String[] values = formMap.get(key);
                    out.println("<tr><td>"+key+"<td>");
                    for (int i=0; i<values.length-1;i++)
                        out.print(values[i] + ",");
					out.print(values[values.length-1]);
                }
		

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}