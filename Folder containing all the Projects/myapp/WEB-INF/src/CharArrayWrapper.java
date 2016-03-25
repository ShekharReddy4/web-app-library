import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class  CharArrayWrapper extends HttpServletResponseWrapper
{
	private CharArrayWriter        charwriter=null;

	public CharArrayWrapper(HttpServletResponse hres)
	{
		super(hres);
		charwriter=new CharArrayWriter();
	}

	public PrintWriter getWriter()
	{
		return(new PrintWriter(charwriter));
	}

	public String toString()
	{
		return(charwriter.toString());
	}
}