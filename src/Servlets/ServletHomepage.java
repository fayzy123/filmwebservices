package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.Vehicle;
import Models.VehicleDAO;

@SuppressWarnings("serial")
public class ServletHomepage extends HttpServlet {

	@SuppressWarnings("unused")
	private static final long SerialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		VehicleDAO dao = new VehicleDAO();

		try {
			ArrayList<Vehicle> allVehicles = dao.getAllVehicles();
			System.out.println(allVehicles.size());
			RequestDispatcher view = req.getRequestDispatcher("homepage.jsp");
			req.setAttribute("allVehicles", allVehicles);
			view.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}