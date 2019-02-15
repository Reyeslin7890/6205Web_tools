import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class Headers extends HttpServlet{


	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		Enumeration<String> headers = request.getHeaderNames();
		//page
		out.println("<html>");
		out.println("<head>");
                out.println("<title>Headers</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<H1> Headers </H1>\n" +
					"<TABLE BORDER=1>\n" + " <TR BGCOLOR=\"#FFAD00\">\n" +
					"<TH>CGI Variable Name<TH>Value");
		while (headers.hasMoreElements()){
			String header = headers.nextElement();
			Enumeration<String> values = request.getHeaders(header);
			out.println(" <TR><TD>" + header + "<TD>");
			while (values.hasMoreElements()){
			out.print(values.nextElement());			
			}
		}

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}