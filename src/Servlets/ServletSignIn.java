package Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class ServletSignIn extends HttpServlet {

	@SuppressWarnings("unused")
	private static final long serialversionUID = 1L;
	

	// Used the doGet to serve the page with a form on a GET request
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher view = req.getRequestDispatcher("signIn.jsp");
		view.forward(req, resp);
	}
	
	
	// Used the doPost to handle what happens when the form is POST'ed
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if (username.equals("admin") && password.equals("kings123")) {
			HttpSession session = req.getSession();
			session.setAttribute("signedIn", true);
			resp.sendRedirect("homepage");
			
			System.out.println("You have successfully logged in!");
		}
		else
		{
			System.out.println("Incorrect credentials, Please try again!");
			req.getRequestDispatcher("signIn.jsp").include(req, resp);
		}
	}
}
