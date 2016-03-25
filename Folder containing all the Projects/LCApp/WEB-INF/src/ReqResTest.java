import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class  ReqResTest extends HttpServlet
{
	public void service(HttpServletRequest hreq,HttpServletResponse hres)throws ServletException,IOException
	{
	  PrintWriter pw=hres.getWriter();
	  hres.setContentType("text/html");
	  pw.println("<center>req params are</center> ");
       Enumeration e=hreq.getParameterNames();

	   while(e.hasMoreElements())
		{
		   String name=(String)e.nextElement();
		   String val=hreq.getParameter(name);
		   pw.println("<br>name="+name+"&nbsp;&nbsp;"+"value="+val);
		}

	pw.println("<center>req Headers are</center> ");
        e=hreq.getHeaderNames();

	   while(e.hasMoreElements())
		{
		   String name=(String)e.nextElement();
		   String val=hreq.getHeader(name);
		   pw.println("<br>name="+name+"&nbsp;&nbsp;"+"value="+val);
		}
	

		pw.println("<br><font color=red size=7> date is"+new Date().toString()+"</font>");
		hres.setHeader("refresh","5");

		pw.close();   
	}//service

}//class
