import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;
import java.io.*;
public class Third extends HttpServlet {
	
	public void init(ServletConfig config) {
		System.out.println("Inside init");
		System.out.println(config.getClass());
		System.out.println(config.getServletName());
		Enumeration e=config.getInitParameterNames();
		while(e.hasMoreElements()) {
			String ne=(String)e.nextElement();
			System.out.println(ne);
			System.out.println("\t"+config.getInitParameter(ne));
		}//while
		ServletContext sc=config.getServletContext();
		System.out.println(sc.getServerInfo());
		Enumeration sne=sc.getServletNames();
		while(sne.hasMoreElements())
		 {
		System.out.println((String)sne.nextElement());
		} //while
		System.out.println(sc.getMajorVersion());
		System.out.println(sc.getMinorVersion());
	}//int()
	
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		PrintWriter p=res.getWriter();
		System.out.println("inside service");
		Enumeration e1=req.getHeaderNames();
		while(e1.hasMoreElements()) {
			String s=(String)e1.nextElement();
			System.out.println(s+"\t"+req.getHeader(s));
		}//while
		Enumeration e2=req.getParameterNames();
		while(e2.hasMoreElements()) {
			String s=(String)e2.nextElement();
			System.out.println(s+"\t"+req.getParameter(s));
		}//while
		System.out.println(req.getAuthType());
		System.out.println(req.getPathInfo());
		System.out.println(req.getPathTranslated());
		System.out.println(req.getQueryString());
		System.out.println(req.getRemoteUser());
		System.out.println(req.getRequestURI());
		System.out.println(req.getServletPath());
		System.out.println(req.getMethod());
		
		//methods implemented in generic servlet
		System.out.println(req.getContentType());
		System.out.println(req.getContentLength());
		System.out.println(req.getProtocol());
		System.out.println(req.getRemoteAddr());
		System.out.println(req.getRemoteHost());
		System.out.println(req.getScheme());
		System.out.println(req.getServerName());
		System.out.println(req.getServerPort());
	}//service()
	
  }//class