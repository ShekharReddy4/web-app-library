// program to work with cookies
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ShowCookies extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String title="Active cookies";

		out.println("<html> <head> <title>"+ title);
		out.println("</title> </head> <body>");
		out.println("<table border=1 align=\"center\">");
		out.println("<tr> <td> Cookie Name</td>");
		out.println("<td> Cookie Value</td></tr>");

		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			Cookie cookie;
			for (int i=0;i<cookies.length;i++) {
				cookie =cookies[i];
				out.println("<tr><td>"+cookie.getName()+"</td>"+"<td>"+cookie.getValue()+"</tr>");
			}//for
		}//if
		else {
			System.out.println("No cookies  present....");
		}//else
		out.println("</table></body></html>");
	}//doGet()
}//class				
			
