import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
public class eighth implements Filter
{
	public eighth()
	{
	System.out.println("Inside constructor of Filter class");
	}

	public  void init (FilterConfig  fcon) throws ServletException 
	{
		System.out.println("Inside init() method of Filter class");
	}

	public void doFilter(ServletRequest req,ServletResponse res,FilterChain  fc) throws IOException,ServletException
	{
		System.out.println("inside dofilter() of Filter class");
		int x=Integer.parseInt(req.getParameter("first"));
		int y=Integer.parseInt(req.getParameter("second"));
		
		if ((x<0 ||y<0))
		{
			PrintWriter pw=res.getWriter();
			pw.println("<html> <head>");
			pw.println("<head><title>From Filter !!!</title></head>");
			pw.println("<body> sorry !!! ur input should be only positive numbers ! ! . .  ");
			pw.println("</body></html>");
		}//if
		else
		{
			fc.doFilter(req,res);
		}//else
	}//doFilter
	
	public void destroy()
	{
		System.out.println("inside destroy() of Filter class");
	}
}//class