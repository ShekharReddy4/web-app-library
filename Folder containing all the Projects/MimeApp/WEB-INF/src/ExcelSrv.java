import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class   ExcelSrv extends HttpServlet
{

public void service (HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	PrintWriter pw=res.getWriter();
	res.setContentType("application/vnd.ms-excel");
	pw.println("<TABLE><TH>Id</TH><TH>Name</TH><TH>Salary</TH></TR>	<TR><TD>115</TD><TD>Sachin</TD><TD>50000</TD></TR><TR><TD>175</TD><TD>Rahul</TD><TD>48000</TD></TR><TR><TD>135</TD><TD>Saurv</TD><TD>10000</TD></TR><TR><TD>225</TD><TD>Anil</TD><TD>45000</TD></TR> </TABLE>");
	pw.close();
	}
}
