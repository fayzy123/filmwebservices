package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class ServletSignOut extends HttpServlet {

	@SuppressWarnings("unused")
	private static final long serialversionUID = 1L;

	// Used the doGet to serve the page with a form on a GET request
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Used session variables for the login system
		HttpSession session = req.getSession();
		session.setAttribute("signedIn", false);
		session.invalidate();
		req.getRequestDispatcher("homepage").include(req, resp);
	
		System.out.println("You have successfully logged out!");
	}
}