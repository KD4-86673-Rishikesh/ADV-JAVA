package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String fname=req.getParameter("fname");
	    String lname=req.getParameter("lname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String DOBStr=req.getParameter("DOB");
		Date DOB=Date.valueOf(DOBStr);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Registration</title>");
		out.println("</head>");
		ServletContext app = this.getServletContext();
		String color=app.getInitParameter("color");
		out.printf("<body bgcolor='%s'>",color);
		
		
		
		
		try(UserDao udao=new UserDaoImpl())
		{
			User u=new User(0, fname, lname, email, password, DOB, 0, "voter");
			int count=udao.save(u);
			if(count==1)
			{
				out.println("<h2>User Registration Succesfully!!");
				out.println("<p>You can vote next time...............</p>");
			}
			else
			{
				out.println("<h3>Something Went Wrong</h3>");
				out.println("<p><a href='newuser.html'>Please register again</a></p>");
			}
			
		} catch (Exception e) 
		{
		
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
