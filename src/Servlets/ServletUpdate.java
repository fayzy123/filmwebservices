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
public class ServletUpdate extends HttpServlet {

	@SuppressWarnings("unused")
	private static final long serialversionUID = 1L;

	// Used the doGet to serve the page with a form on a GET request
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Get parameter out of request
		VehicleDAO dao = new VehicleDAO();
		int vehicle_id = Integer.parseInt(req.getParameter("vehicle_id"));
		try {
			// Get the vehicle from database
			Vehicle updateVehicle = dao.getVehicle(vehicle_id);
			RequestDispatcher view = req.getRequestDispatcher("vehicleUpdate.jsp");
			System.out.println(updateVehicle);
			// Set attribute in jsp
			req.setAttribute("updateVehicle", updateVehicle);
			view.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Used the doPost to handle what happens when the form is POST'ed
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		VehicleDAO dao = new VehicleDAO();

		int vehicle_id = Integer.parseInt(req.getParameter("vehicle_id"));
		String make = (String) req.getParameter("make");
		String model = (String) req.getParameter("model");
		int year = Integer.parseInt(req.getParameter("year"));
		int price = Integer.parseInt(req.getParameter("price"));
		String license_number = (String) req.getParameter("license_number");
		String colour = (String) req.getParameter("colour");
		int number_doors = Integer.parseInt(req.getParameter("number_doors"));
		String transmission = (String) req.getParameter("transmission");
		int mileage = Integer.parseInt(req.getParameter("mileage"));
		String fuel_type = (String) req.getParameter("fuel_type");
		int engine_size = Integer.parseInt(req.getParameter("engine_size"));
		String body_style = (String) req.getParameter("body_style");
		String condition = (String) req.getParameter("condition");
		String notes = (String) req.getParameter("notes");

		Vehicle updateVehicle = new Vehicle(vehicle_id, make, model, year, price, license_number, colour, number_doors,
				transmission, mileage, fuel_type, engine_size, body_style, condition, notes);
		try {
			boolean done = dao.updateVehicle(updateVehicle, vehicle_id);
			System.out.println(done);
			if (done) {
				resp.sendRedirect("homepage");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}