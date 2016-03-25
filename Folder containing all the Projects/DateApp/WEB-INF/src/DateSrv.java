import javax.servlet.*;
import java.io.*;
import java.util.*;
public class  DateSrv extends GenericServlet
{
	
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException 
	{
         ServletConfig cg=getServletConfig();
		 String s1=cg.getInitParameter("sno");
		String s2=cg.getInitParameter("sname");

		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Date d=new Date();
		String s=d.toString();
		pw.println("<b> Date is"+s +"</b>");
		pw.println("<font color=red ><br> Param1 :"+s1+"<br> param2 is:  "+s2+"</font>");
	   	pw.close();
	}//service

}//class




