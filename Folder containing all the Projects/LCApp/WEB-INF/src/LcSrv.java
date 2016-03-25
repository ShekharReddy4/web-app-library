package pack1;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class  LcSrv extends HttpServlet
{
	public void init()
	{
		System.out.println("init method");
	}


public void service(HttpServletRequest hreq,HttpServletResponse hres)throws ServletException,IOException
	{
	PrintWriter pw=hres.getWriter();
	hres.setContentType("text/html");
	pw.println("<font color=red  size=6> welcome to servlet LcTest  </font>");
	System.out.println("service method");
	pw.close();
	}
	public void destroy()
	{
		System.out.println("Destroy method");
	}
}//class


