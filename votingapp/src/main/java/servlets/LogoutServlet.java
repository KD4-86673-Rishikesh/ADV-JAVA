package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     processsRequest(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processsRequest(req,resp);
	}
	private void processsRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{    Cookie c1 = new Cookie("uname", "");
	     c1.setMaxAge(-1);
	     resp.addCookie(c1);
	     Cookie c2 = new Cookie("role", "");
	     c2.setMaxAge(-1);
	     resp.addCookie(c2);
	     HttpSession session =req.getSession(false);
	     if(session==null)
	     {
	    	 resp.sendError(440);
	    	 return;
	     }
	     session.invalidate();
	
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Logout</title>");
		out.println("</head>");
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		String color=app.getInitParameter("color");
		out.printf("<body bgcolor='%s'>",color);
		out.printf("<h1>%s</h1>", appTitle);
		out.println("<h2>Thank You !! </h2>");
		out.println("<p>God bless you.</p>");
		out.println("<p><a href='index.html'>Login Again</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
		
}

