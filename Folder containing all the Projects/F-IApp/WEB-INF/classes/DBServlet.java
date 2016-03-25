import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.math.*;

public class  DBServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException
	{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		PrintWriter pw=res.getWriter();
		
		String  jobs[]=req.getParameterValues("job");

		StringBuffer sb=new StringBuffer();
		
		sb.append("(");
		
		for(int i=0; i < jobs.length; i++)
		{
			if(i == jobs.length-1)
				sb.append("'" + jobs[i] + "'");
			else
				sb.append("'" + jobs[i] + "'"+ ",");
		}

		sb.append(")");

		String condition=sb.toString();

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
															"scott", "tiger");
			
			stmt=con.createStatement();
			rs=stmt.executeQuery("SELECT * FROM EMP WHERE JOB IN " 
										+ condition 
										+ " ORDER BY JOB ");
			
			while(rs.next())
			{
				 int empno=rs.getInt(1);
				 String ename=rs.getString(2);
				 String job=rs.getString(3);
				 int mgr=rs.getInt(4);
				 Date hiredate=rs.getDate(5);
				 float sal=rs.getFloat(6);
				 float comm=rs.getFloat(7);
				 int deptno=rs.getInt(8);
	
				 BigDecimal bd=new BigDecimal(sal); 
				 pw.println("<tr>");
				 pw.println("<td>"+empno+"</td>");
   				 pw.println("<td>"+ename+"</td>");
      			 pw.println("<td>"+job+"</td>");
				 pw.println("<td>"+mgr+"</td>");
				 pw.println("<td>"+hiredate+"</td>");
				 pw.println("<td>"+bd.setScale(2,BigDecimal.ROUND_HALF_UP)+"</td>");
				 pw.println("<td>"+comm+"</td>");
				 pw.println("<td>"+deptno+"</td>");
				 pw.println("</tr>");
			 } // while
			
			rs.close();
			con.close();
		} // try
		catch(Exception e)
		{
			e.printStackTrace();
		}
	} // doGet()
} // class