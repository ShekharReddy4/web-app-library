import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class  HtmlSrv extends HttpServlet
{
	public void doPost(HttpServletRequest hreq,HttpServletResponse hres)throws ServletException,IOException
	{
		PrintWriter pw=hres.getWriter();
		hres.setContentType("text/html");
		String s1=hreq.getParameter("pname");
		String s2=hreq.getParameter("fname");
		String s3=hreq.getParameter("age");
		try
		{
			int age=Integer.parseInt(s3.trim());
			String msg=null;
			if(age<=5)
				msg="welcome Masster."+s1+" u r baby child";
			else if(age<=13)
				msg="welcome Mr/Miss."+s1+"u r child";
			else if(age<=18)
			  msg="welcome Mr/Miss/Mrs."+s1+"u r teenager" ;
			else if(age<=60)
				msg="welcome Mr/Miss/Mrs."+s1+"u r young man/woman";
			else
				msg="weclome Mr/Miss/Mrs"+s1+"u r old man/woman";

			pw.println("<font color=blue size=6>"+msg+"</font>"); 

		}//try
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("In do Post method");
	}//doPost

	public void doGet(HttpServletRequest hreq,HttpServletResponse hres)throws ServletException,IOException
	{
		try
		{
			doPost(hreq,hres);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("do Get method");

	}//doGet

}//class









