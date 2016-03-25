import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SetCookies extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		
		// default maxage is -1, indicating cookie
		// applies only to current browsing session
		
		Cookie cookie1,cookie2,cookie3,cookie4;
		
		cookie1=new Cookie("ap","Hyderabad");
		cookie2=new Cookie("tn","Chennai");
		response.addCookie(cookie1);
		response.addCookie(cookie2);

		// Cookie is valid for an hour, regardless of whether
		//user quits browser, reboots computer or whatever

		cookie3=new Cookie("kr","Bangalore");
		cookie4=new Cookie("mh","mumbai");
		cookie3.setMaxAge(3600);
		cookie4.setMaxAge(3600);

		response.addCookie(cookie3);
		response.addCookie(cookie4);

		System.out.println("Successful in setting cookies....");
	}//doGet()
}//class