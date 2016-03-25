import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class SearchEngines extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String searchString = request.getParameter("searchString");
		if ((searchString == null) || (searchString.length() == 0)) 
		{
			reportProblem(response, "Missing search string.");
			return;
		}
		
		searchString = URLEncoder.encode(searchString);

		String numResults = request.getParameter("numResults");
		if ((numResults == null) || (numResults.equals("0")) || (numResults.length() == 0)) 
		{
			numResults = "10";
		}
		
		String searchEngine = request.getParameter("searchEngine");
		if (searchEngine == null) 
		{
			reportProblem(response, "Missing search engine name.");
			return;
		}

		SearchSpec[] commonSpecs = SearchSpec.getCommonSpecs();
		for(int i=0; i<commonSpecs.length; i++) 
		{
			SearchSpec searchSpec = commonSpecs[i];
			if (searchSpec.getName().equals(searchEngine)) 
			{
				String url = searchSpec.makeURL(searchString, numResults);
				response.sendRedirect(url);
				return;
			}
		}
		reportProblem(response, "Unrecognized search engine.");
	} // doGet()

	private void reportProblem(HttpServletResponse response, String message)
				throws IOException 
	{
		response.sendError(response.SC_NOT_FOUND, "<H2>" + message + "</H2>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException 
	{
		doGet(request, response);
	}//doPost
} // class
