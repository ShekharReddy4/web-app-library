/* to Display Success Messgae 
Version : 1.0
Author : Team - J
*/

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginSrv extends HttpServlet
{    
	public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, java.io.IOException
	{
		PrintWriter		out;
		response.setContentType("text/html");
		out = response.getWriter();
		
		out.println("<HTML><HEAD><TITLE>");
  		out.println("</TITLE></HEAD><BODY>");

		out.println(" <h1><center> Successfull Entered uname & password <h1>");
		out.println("</BODY>");
	
		out.close();
    }//doGet()
}//class