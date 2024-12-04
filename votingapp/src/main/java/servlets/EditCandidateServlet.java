package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/editcand")
public class EditCandidateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String candId = req.getParameter("id");
				int id = Integer.parseInt(candId);
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Edit</title>");
				out.println("</head>");
				ServletContext app = this.getServletContext();
				String appTitle = app.getInitParameter("app.title");
				String color=app.getInitParameter("color");
				out.printf("<body bgcolor='%s'>",color);
				out.printf("<h1>%s</h1>", appTitle);
				out.println("<h2>Edit Candidate</h2>");
				try(CandidateDao candDao = new CandidateDaoImpl()) {
					Candidate c = candDao.findById(id);
					if(c != null) {
						out.println("<form method='post' action='editcand'>");
						out.printf("<input type='hidden' name='id' value='%d' ><br/><br/>\n", c.getId());
						out.printf("Name: <input type='text' name='name' value='%s'><br/><br/>\n", c.getName());
						out.printf("Party: <input type='text' name='party' value='%s'><br/><br/>\n", c.getParty());
						out.printf("Votes: <input type='text' name='votes' value='%d' readonly><br/><br/>\n", c.getVotes());
						out.println("<input type='submit' value='Update Candidate'>");
						out.println("</form>");
					}
				}
				catch (Exception e) {
					e.printStackTrace();
					throw new ServletException(e);
				}
				out.println("</body>");
				out.println("</html>");
}
		

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  int id=Integer.parseInt(req.getParameter("id"));
		  String name=req.getParameter("name");
		  String party=req.getParameter("party");
		  int votes=Integer.parseInt(req.getParameter("votes"));
		  
				try(CandidateDao candDao = new CandidateDaoImpl()) {
					Candidate c= new Candidate(id, name, party, votes);
					int count = candDao.update(c);
					String message = "Candidates updated: " + count;
					req.setAttribute("msg", message);
				}
				catch (Exception e) {
					e.printStackTrace();
					throw new ServletException(e);
				}

				RequestDispatcher rd = req.getRequestDispatcher("result");
				rd.forward(req, resp);
			} 
}
