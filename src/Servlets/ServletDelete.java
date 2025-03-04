package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.VehicleDAO;

@SuppressWarnings("serial")
public class ServletDelete extends HttpServlet {

	@SuppressWarnings("unused")
	private static final long serialversionUID = 1L;

	// Used the doGet to serve the page with a form on a GET request
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		VehicleDAO dao = new VehicleDAO();
		int toDelete = Integer.parseInt(req.getParameter("vehicle_id"));

		try {
			boolean done = dao.deleteVehicle(toDelete);
			System.out.println(done);
			if (done) {
				resp.sendRedirect("index");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}