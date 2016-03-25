import javax.servlet.*;
import java.io.*;
public class  TestSrv extends GenericServlet
{

	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		// Set MIME type
		res.setContentType("text/html");
		// get output writer object
 PrintWriter pw=res.getWriter();
 pw.println("<h1 align=center> Welcome to the world Servlet Programing </h1>");

 pw.close();
	}//service
}//class