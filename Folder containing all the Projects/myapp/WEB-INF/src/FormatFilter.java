import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class  FormatFilter implements Filter
{
	public void init(FilterConfig fc)
	{
		System.out.println("inseid init");
	}

	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws ServletException,IOException
	{
		CharArrayWrapper caw=new CharArrayWrapper((HttpServletResponse) res);
		chain.doFilter(req,caw);
		String greetings=caw.toString();
		greetings=greetings+"u r response is modified here";
		PrintWriter out=res.getWriter();
		out.println(greetings);
	}
	
	public void destroy()
	{}
}
