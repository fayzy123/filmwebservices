package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Vehicle;
import Models.VehicleDAO;

@SuppressWarnings("serial")
public class ServletSearch extends HttpServlet {

	@SuppressWarnings("unused")
	private static final long serialversionUID = 1L;

	
	// Used the doGet to serve the page with a form on a GET request
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		VehicleDAO dao = new VehicleDAO();
		int vehicle_id = Integer.parseInt(req.getParameter("vehicle_id"));

		try {
			Vehicle searchVehicle = dao.getVehicle(vehicle_id);
			RequestDispatcher view = req.getRequestDispatcher("vehicleSearch.jsp");
			System.out.println(searchVehicle);
			req.setAttribute("searchVehicle", searchVehicle);
			view.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
