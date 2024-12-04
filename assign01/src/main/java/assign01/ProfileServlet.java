package assign01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet 
{
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
    	 
  	    resp.setContentType("text/html");
  	    PrintWriter out = resp.getWriter();
  		out.println("<html>");
  		out.println("<head>");
  		out.println("<title>Profile</title>");
  		out.println("</head>");
  		out.println("<body bgcolor='pink'>");
  		out.println("<h1>Profile Information</h1>");
  		out.println("<h3>First Name:Chandrashekhar</h3>");
  		out.println("<h3>Last Name:Kshirsagar </h3>");
  		out.println("<h3>Qualification:B.tech</h3>");
  		out.println("<h3>college: Walchand Institude Of technology Solapur </h3>");
  		out.println("<h3>birth date:18/10/2001 </h3>");
  		out.println("</body>");
  		out.println("</html>");
    }
}
