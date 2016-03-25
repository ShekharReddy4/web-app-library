import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class seventh extends HttpServlet 
{
	public  void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		System.out.println("inside doGet() of Servlet class");
		int x=Integer.parseInt(req.getParameter("first"));
		int y=Integer.parseInt(req.getParameter("second"));
		int z=x+y;
		PrintWriter pw=res.getWriter();
		pw.println("<html>");
		pw.println("<head><title>From servlet !!!</title></head>");
		pw.println("<body> result is"+ z+"</body></html>");
		pw.close();
	}//doGet
}//class 