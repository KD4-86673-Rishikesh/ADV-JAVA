package assign01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	
	private  ArrayList<Marks> result;
	
	@Override
	 public void init(ServletConfig config) throws ServletException 
	{
	 super.init(config);
	 result = new ArrayList<>();
	 result.add(new Marks("Java programming", 90.0));
	 result.add(new Marks("Web programming", 85.0));
	 result.add(new Marks("Database technologies", 87.0));
	 result.add(new Marks("Operrating Systems", 80.0));
	 result.add(new Marks("Software Development", 88.0));
	 
	 
	}
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		     float percent=calculatePercentage();
		    resp.setContentType("text/html");
	  	    PrintWriter out = resp.getWriter();
	  		out.println("<html>");
	  		out.println("<head>");
	  		out.println("<title>Result</title>");
	  		out.println("</head>");
	  		out.println("<body>");
	  		out.println("<h1>Result</h1>");
	  		out.println("<table border='2px solid black'>");
	  		out.println("<thead>");
	  		out.println("<tr>");
	  		out.println("<th> Subject </th>");
	  		out.println("<th> Marks </th>");
	  		out.println("</tr>");
	  		out.println("</thead>");
	  		out.println("<tbody>");
		     for(Marks m:result) 
		     {
			    out.println("<tr>");
			    out.printf("<td>%s</td>", m.getName());
			    out.printf("<td>%.2f</td>", m.getMarks());
			    out.println("</tr>");
			}
		    out.println("</tbody>");
	  		out.println("</table>");
	  		out.println("<h3> Result:"+calculatePercentage()+"%</h3>");
	  		out.println("</body>");
	  		out.println("</html>");
	  	
	}
	private float calculatePercentage() 
	{ int sum=0;
	 for(Marks m:result) 
	 {
		 sum+=m.getMarks();
		 
	 }
		return sum/result.size();
	}


}
