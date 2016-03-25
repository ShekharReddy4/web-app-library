import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class  SumServlet extends HttpServlet {
	
	public SumServlet() {
		System.out.println("Inside constructor");
	}
	
	public void init(ServletConfig sc)	{
		System.out.println("Inside init() method");
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Inside doGet() ");
		try {
			int x, y, sum;
			x = Integer.parseInt(req.getParameter("fno"));
			y = Integer.parseInt(req.getParameter("sno"));
			sum = x+ y;
			
			PrintWriter pw;
			pw = res.getWriter();

			pw.println("<html>");
			pw.println("<body>");
			pw.println("<center> <h2> <br> <br>");
			pw.println("Result is " + sum);
			pw.println("</h2> </center>");
			pw.println("</body> </html>");
		} // try
		catch(Exception e) {
			e.printStackTrace();
		}
	} // doGet()  
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Inside doPost()");
		try {
			doGet(req, res);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	} // doPost()
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("Inside service() ");
		try {
			super.service(req, res);
		}
		catch(Exception e) {
			e.printStackTrace();
		}//catch
	} // service()
}//class