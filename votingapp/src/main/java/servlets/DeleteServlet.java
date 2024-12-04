package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;


@WebServlet("/delcand")
public class DeleteServlet extends HttpServlet {
       
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
	   processRequest(req, resp);	
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}


	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String canId=req.getParameter("id");
		int id=Integer.parseInt(canId);
		
		try(CandidateDao cando =new CandidateDaoImpl())
		{
			int count=cando.deleteById(id);
			if(count==1)
			{
				String message ="candidate deleted :"+ count;
				req.setAttribute("msg", message);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd=req.getRequestDispatcher("result");
		rd.forward(req, resp);
		
		
		
		
		
		
	}

}
