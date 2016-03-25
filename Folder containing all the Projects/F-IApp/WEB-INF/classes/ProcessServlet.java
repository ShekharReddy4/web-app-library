// This servlet includes response of DBServlet in between Table heading and closing.

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class  ProcessServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException
	{
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();

			pw.println("<HTML><BODY>");
			pw.println("<CENTER><TABLE BORDER=1>");
			pw.println("<tr><th>EMPNO</th>");
			pw.println("<th>ENAME</th>");
			pw.println("<th>JOB</th>");
			pw.println("<th>MGR</th>");
			pw.println("<th>HIREDATE</th>");
			pw.println("<th>SAL</th>");
			pw.println("<th>COMM</th>");
			pw.println("<th>DEPTNO</th></tr>");

			ServletContext sc=getServletContext();
			RequestDispatcher rd=sc.getRequestDispatcher("/QueryServlet");
			rd.include(req, res);

			pw.println("</TABLE></CENTER>");
			pw.println("</HTML></BODY>");
	}
}