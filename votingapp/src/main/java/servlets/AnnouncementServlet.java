package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/announce")
public class AnnouncementServlet extends HttpServlet {
	
   
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String announcement =request.getParameter("ann");
       ServletContext cxt =this.getServletContext();
       cxt.setAttribute("announcement", announcement);
       response.sendRedirect("result");
  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
