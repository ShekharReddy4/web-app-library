 /* If the user is not logged in send login form otherwise send appropriate form.
Author : Team -n
Version: 1.0
*/

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthFilter implements Filter
{
	private FilterConfig f = null;
	private ServletContext sc = null;

	public void init(FilterConfig filterConfig)
	{
		f = filterConfig;
		sc = f.getServletContext();
	}//init()
	
	public void doFilter(ServletRequest request, 
                         ServletResponse response, 
                         FilterChain chain)
        throws IOException, ServletException
	{
		HttpServletRequest hreq = (HttpServletRequest) request;
		String login_page="/one.html";
		String un = hreq.getParameter("uname");
		String pwd = hreq.getParameter("pwd");

		sc.log("in filter :"+hreq.getRequestURI());
		sc.log("in filter :"+hreq.getServletPath());
		sc.log("uname = " + un + "password = " + pwd);
		
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			PreparedStatement ps=con.prepareStatement("SELECT * FROM USERLIST WHERE USERNAME=? AND PASSWORD=?");
			ps.setString(1,un);
			ps.setString(2,pwd);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				/* here is the code to check for uname/pwd */
				sc.log("user name  and passwords are given and they are correct");
				chain.doFilter(request,response);
				return;
			}//if
			else
			{
				sc.log("Trying to dispaly the same login page");
				RequestDispatcher rd=sc.getRequestDispatcher(login_page);
				rd.forward(request,response);
				sc.log("after forwarding request to login page");
				return;
			}//else
		}//try
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}//doFilter()
	
	public void destroy()
	{
		f=null;
	}//destroy()
}//class