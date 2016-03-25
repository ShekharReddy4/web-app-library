import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class  ReqTestSrv extends HttpServlet
{

	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String rp1=req.getParameter("sno");
		String rp2=req.getParameter("sname");

		String sh1=req.getHeader("user-agent");
		String sh2=req.getHeader("accept-language");

		pw.println("Request Params are<b> rp1="+rp1+"  <br> rp2="+rp2+"  <br>");
		pw.println("Request Headers are<I> user-agent:"+sh1+"<br>"+"accept-lang"+sh2+"</br>");
	}//servie
}//servlet


