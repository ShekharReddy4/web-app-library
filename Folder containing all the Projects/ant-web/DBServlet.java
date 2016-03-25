import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

public class  DBServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		try {
			// Getting query
			String qry;
			qry = req.getParameter("query");
			System.out.println(qry);

			ServletConfig cg=getServletConfig();
			String s1=cg.getInitParameter("dname");
			String s2=cg.getInitParameter("dburl");


			// DB accessing
			Class.forName(s1);
			System.out.println("driver Loaded");
			Connection con;
			con = DriverManager.getConnection(s2,"scott","tiger");
			System.out.println("connection  established");
			Statement st;
			st = con.createStatement();
			ResultSet rs;
			rs = st.executeQuery(qry);

			// Sending table
			PrintWriter pw;
			pw = res.getWriter();

			pw.println("<html>");
			pw.println("<body>");
			pw.println("<table border=5 bgcolor=red width=100%>");
			pw.println("<tr>");
			pw.println("<th> Number </th>");
			pw.println("<th> Name </th>");
			pw.println("<th> Designation </th>");
			pw.println("</tr>");
		
			while(rs.next())	{
				pw.println("<tr>");	
				pw.println("<td>" + rs.getInt(1) + "</td>");
				pw.println("<td>" + rs.getString(2) + "</td>");
				pw.println("<td>" + rs.getString(3) + "</td>");
				pw.println("</tr>");	
			} //while
			rs.close();
			st.close();
			con.close();
			pw.println("</table> </body> </html>");	
			ServletContext sc=getServletContext();

			pw.println("<br> <b> servlet api version is "+sc.getMajorVersion()+"."+sc.getMinorVersion()+"</b>");
			pw.println("<br> <b> server name  is "+sc.getServerInfo());

		} //try
		catch(Exception e) {
			e.printStackTrace();
		}
	} // doGet()
} // class