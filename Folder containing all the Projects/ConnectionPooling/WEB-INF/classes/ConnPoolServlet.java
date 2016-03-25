import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnPoolServlet extends HttpServlet
{
	PrintWriter out;
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		out=res.getWriter();
		String tableName=req.getParameter("table");
		try
		{
			Connection con=getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from "+tableName);
			ResultSetMetaData rsmd=rs.getMetaData();
			int columnCount=rsmd.getColumnCount();
			out.println("<html><body bgcolor=#ffffa9>");
			out.println("<center><h3>The Details of the table "+tableName);
			out.println("<br><br><table cellspacing=1  bgcolor=#00ff00>");
			out.println("<tr bgcolor=#ffffa9>");
			for(int col=1;col<=columnCount;col++)
				out.println("<th>"+rsmd.getColumnLabel(col)+"&nbsp;&nbsp;</th>");
			out.println("</tr>");
			while(rs.next())
			{
				out.println("<tr bgcolor=#ffffa9>");
				for(int i=1;i<=columnCount;i++)
					out.println("<td>"+rs.getString(i)+"&nbsp;&nbsp;</td>");
				out.println("</tr>");
			}//while
			out.println("</table><br>");
			out.println("To view another table<b><a href=index.htm>Click here</a></b>");
			out.println("</body></html>");
		}//try
		catch(Exception e)
		{
			out.println("<html><body bgcolor=#ffffa9><center><br><br>");
			out.println("<h3>Table Doesn't Exist in Database</h3>");
			out.println("<br>To view another table <a href=index.htm>Click here</a>");
			out.println("</body></html>");
			System.out.println(e);
		}//catch
	}//service
	
	public Connection getConnection()
	{
		Connection con=null;
		try
		{
			InitialContext  ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("MyDsJndi");
			con= ds.getConnection();
		}//try
		catch(Exception e)
		{
			System.out.println(e);
		}//catch
		return con;	
	}//getConnection()
}//class