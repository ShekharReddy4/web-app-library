// This servlet just forwards the request to ProcessServlet.
// This is used just for demonstrating forward concept.
// Any HTML response, from this servlet will not be received by the client.
// If response is committed, using flush() method, then doing a forward / include 
//											will give InvalidStateException.

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class  DummyServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
					throws ServletException,IOException
	{
		ServletContext sc=getServletContext();
		RequestDispatcher rd=sc.getRequestDispatcher("/HTMLServlet");
		rd.forward(req,res);
	}
}
