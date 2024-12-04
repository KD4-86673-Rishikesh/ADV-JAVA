package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.Candidate;
import com.sunbeam.entities.User;

@WebServlet("/addcandidate")
public class AddcandidateServlet extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	
		   String name=req.getParameter("name");
		   String party=req.getParameter("party");
	   
		
			
			
			
			
			try(CandidateDao candao =new CandidateDaoImpl())
			{
		        Candidate c= new Candidate(0, name, party, 0);
		        int count=candao.save(c);
				if(count==1)
				{
					resp.sendRedirect("result");
					
				}
				else
				{
					resp.setContentType("text/html");
					PrintWriter out = resp.getWriter();
					out.println("<html>");
					out.println("<head>");
					out.println("<title>Registration of candidate</title>");
					out.println("</head>");
					ServletContext app = this.getServletContext();
					String color=app.getInitParameter("color");
					out.printf("<body bgcolor='%s'>",color);
					out.println("<body>");
					out.println("<h3>Something Went Wrong</h3>");
					out.println("<p><a href='newcandidate.html'>Please add again</a></p>");
					out.println("</body>");
					out.println("</html>");
				}
				
			} catch (Exception e) 
			{
			
				e.printStackTrace();
				throw new ServletException(e);
			}
			
	}

	
	

}
