//Filter to check the time taken to process a request. We can use such a filter
//while optimizing the code to improve the speed.

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public final class PerfTestFilter implements Filter 
{
	FilterConfig f=null;
	
	public void doFilter(ServletRequest request, 
                         ServletResponse response,
                         FilterChain chain)
        throws IOException, ServletException 
	{
		long beforeProcess = System.currentTimeMillis();
		chain.doFilter(request, response);
		long afterProcess = System.currentTimeMillis();
		long diff = afterProcess - beforeProcess;
		HttpServletRequest hreq = (HttpServletRequest) request;
		f.getServletContext().log("Total Time for processing "+ hreq.getRequestURI()+" : "+  diff);
	}//doFilter()

	public void destroy() 
	{
		f=null;
	}//destroy()

	public void init(FilterConfig filterConfig) throws ServletException 
	{
		f = filterConfig;
	}//init()
}//class

