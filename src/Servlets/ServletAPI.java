package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import Models.Vehicle;
import Models.VehicleDAO;

public class ServletAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	VehicleDAO dao = new VehicleDAO();
	Gson gson = new Gson();
	PrintWriter writer;
	
	/*
	 * RESTful route to GET the data in JSON format
	 * Therefore it will deal with retrieving data
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Vehicle> allvehicles = null;
		try {
			allvehicles = dao.getAllVehicles();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.setContentType("application/json");
		writer = resp.getWriter();
		String vehJSON = gson.toJson(allvehicles);
		writer.write(vehJSON);
		writer.close();
	}
	
	/*
	 * RESTful route to POST the data in JSON format
	 * Therefore it deals with inserting any new data
	 */
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		writer = resp.getWriter();
		resp.setContentType("text/html;charset=UTF-8");

		Gson gson = new Gson();
		Vehicle veh = gson.fromJson(req.getParameter("JSONInsert"), Vehicle.class);	
		
		boolean Inserted = false;
		try {
			Inserted = dao.insertVehicle(veh);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (Inserted) {
			writer.write("New Vehicle Added!");
		} else {
			writer.write("ERROR!");
		}
		writer.close();
	}
	
	/*
	 * RESTful route to PUT the data in JSON format
	 * Therefore it deals with updating any data
	 */
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		writer = resp.getWriter();
		resp.setContentType("text/html;charset=UTF-8");
		
		Gson gson = new Gson();
		Vehicle updateVehicle = gson.fromJson(req.getParameter("JSONUpdate"), Vehicle.class);
		
		boolean Updated = false;
		try {
			int vehicle_id = updateVehicle.getVehicle_id();
			Updated = dao.updateVehicle(updateVehicle, vehicle_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (Updated) {
			writer.write("Vehicle has been Updated!");
		} else {
			writer.write("ERROR!");
		}
		writer.close();
	}
	
	/*
	 * RESTful route to DELETE data
	 * Therefore it deals with any requests that involve
	 * deleting any data
	 */
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		writer = resp.getWriter();
		
		int vehicleDel = Integer.parseInt(req.getParameter("vehicle_id"));
		boolean delete = false;
		
		try {
			delete = dao.deleteVehicle(vehicleDel);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (delete) {
			writer.write("Vehicle sucessfully deleted!");
		} else {
			writer.write("ERROR!");
		}
		writer.close();

	}
}
