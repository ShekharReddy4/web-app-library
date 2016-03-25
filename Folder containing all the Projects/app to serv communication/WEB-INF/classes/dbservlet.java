//APPLET SERVLET COMMUNICATION

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class dbservlet extends HttpServlet
{
	Connection con;
	ResultSet rs;
	Statement st;
	ServletOutputStream out;
	//	PrintWriter out;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		try
		{
			out = res.getOutputStream();
			out.println("<html>");
			out.println("<body>");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			st = con.createStatement();
			String qry = req.getParameter("name");
			rs = st.executeQuery(qry);
			ResultSetMetaData rsm = rs.getMetaData();
			int cols = rsm.getColumnCount();
			out.println("<table border = 4>");
			while(rs.next())
			{
				out.println("<tr>");
				for(int j=1;j<=cols;j++)
				{
					out.println("<td>");
					out.println(rs.getString(j));
					out.println("</td>");
				}//for
				out.println("<tr>");
			}//while
			out.println("</table>");
		}//try
		catch(Exception e)
		{
			out.println(e.getMessage());
		}//catch
		out.println("</body>");
		out.println("</html>");
	}//doGet()
}//class