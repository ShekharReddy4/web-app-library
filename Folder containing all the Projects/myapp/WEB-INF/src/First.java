
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class First extends HttpServlet 
{
	public void init()
	{
		System.out.println("servlet object is created");
		System.out.println("init");
	}

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();
		String greetings="Welcome to Sathya Technologies";
		out.println(greetings);
	}
}