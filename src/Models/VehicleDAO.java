package Models;

/**
 * @author Fayzhan KHAN
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VehicleDAO {
	
	//Creates a connection to the database
	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {
			String dbURL = "jdbc:sqlite:vehicles.sqlite";
			dbConnection = DriverManager.getConnection(dbURL);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	/**
	 * Retrieves all data from the Vehicle Database
	 * @return Vehicle ArrayList called vehicleList
	 * @throws SQLException
	 */
	public ArrayList<Vehicle> getAllVehicles() throws SQLException {
		System.out.println("Retrieving all vehicles...");
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		String query = "SELECT * FROM vehicles;";

		ArrayList<Vehicle> vehicleList = new ArrayList<>();

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			result = statement.executeQuery(query);
			while (result.next()) {
				int vehicle_id = result.getInt("vehicle_id");
				String make = result.getString("make");
				String model = result.getString("model");
				int year = result.getInt("year");
				int price = result.getInt("price");
				String license_number = result.getString("license_number");
				String colour = result.getString("colour");
				int number_doors = result.getInt("number_doors");
				String transmission = result.getString("transmission");
				int mileage = result.getInt("mileage");
				String fuel_type = result.getString("fuel_type");
				int engine_size = result.getInt("engine_size");
				String body_style = result.getString("body_style");
				String condition = result.getString("condition");
				String notes = result.getString("notes");

				vehicleList.add(new Vehicle(vehicle_id, make, model, year, price, license_number, colour, number_doors,
						transmission, mileage, fuel_type, engine_size, body_style, condition, notes));
			}
		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return vehicleList;
	}

	/**
	 * Allows user to search the vehicle by the ID
	 * @param searchID
	 * @returns the vehicle details user has searched for 
	 * @throws SQLException
	 */
	public Vehicle getVehicle(int searchID) throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		Vehicle tempv = null;

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			result = statement.executeQuery("SELECT* FROM vehicles WHERE vehicle_id = " + searchID + ";");
			while (result.next()) {

				int vehicle_id = result.getInt("vehicle_id");
				String make = result.getString("make");
				String model = result.getString("model");
				int year = result.getInt("year");
				int price = result.getInt("price");
				String license_number = result.getString("license_number");
				String colour = result.getString("colour");
				int number_doors = result.getInt("number_doors");
				String transmission = result.getString("transmission");
				int mileage = result.getInt("mileage");
				String fuel_type = result.getString("fuel_type");
				int engine_size = result.getInt("engine_size");
				String body_style = result.getString("body_style");
				String condition = result.getString("condition");
				String notes = result.getString("notes");
				tempv = new Vehicle(vehicle_id, make, model, year, price, license_number, colour, number_doors,
						transmission, mileage, fuel_type, engine_size, body_style, condition, notes);
			}
		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return tempv;
	}
	
		// Searches for a vehicle by the the make, model and price
		public Vehicle getsearchVehicle(String searchMake, String searchModel, int searchPrice) throws SQLException {
			Connection dbConnection = null;
			Statement statement = null;
			ResultSet result = null;
			Vehicle tempv2 = null;

			try {
				dbConnection = getDBConnection();
				statement = dbConnection.createStatement();
				result = statement.executeQuery("SELECT* FROM vehicles WHERE make LIKE '%searchMake%' AND model LIKE '%searchModel%' AND price LIKE '%searchPrice%';");
				while (result.next()) {

					int vehicle_id = result.getInt("vehicle_id");
					String make = result.getString("make");
					String model = result.getString("model");
					int year = result.getInt("year");
					int price = result.getInt("price");
					String license_number = result.getString("license_number");
					String colour = result.getString("colour");
					int number_doors = result.getInt("number_doors");
					String transmission = result.getString("transmission");
					int mileage = result.getInt("mileage");
					String fuel_type = result.getString("fuel_type");
					int engine_size = result.getInt("engine_size");
					String body_style = result.getString("body_style");
					String condition = result.getString("condition");
					String notes = result.getString("notes");
					tempv2 = new Vehicle(vehicle_id, make, model, year, price, license_number, colour, number_doors,
							transmission, mileage, fuel_type, engine_size, body_style, condition, notes);
				}
			} finally {
				if (result != null) {
					result.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (dbConnection != null) {
					dbConnection.close();
				}
			}
			return tempv2;
		}
	
	/**
	 * Allows the user to insert a new vehicle to the database
	 * @param veh
	 * @throws SQLException
	 */
	public Boolean insertVehicle(Vehicle veh) throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			PreparedStatement ps = dbConnection.prepareStatement(
					"INSERT INTO vehicles (make, model, year, price, license_number, colour, number_doors, transmission, mileage, fuel_type, engine_size, body_style, condition, notes)"
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			//Prepared statements to insert a new vehicle
			ps.setString(1, veh.getMake());
			ps.setString(2, veh.getModel());
			ps.setInt(3, veh.getYear());
			ps.setInt(4, veh.getPrice());
			ps.setString(5, veh.getLicense_number());
			ps.setString(6, veh.getColour());
			ps.setInt(7, veh.getNumber_doors());
			ps.setString(8, veh.getTransmission());
			ps.setInt(9, veh.getMileage());
			ps.setString(10, veh.getFuel_type());
			ps.setInt(11, veh.getEngine_size());
			ps.setString(12, veh.getBody_style());
			ps.setString(13, veh.getCondition());
			ps.setString(14, veh.getNotes());
			System.out.println("New vehicle has been inserted!");
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return false;
	}

	/**
	 * Allows the user to update an existing vehicle in the database
	 * @param updateVehicle
	 * @param vehicle_id allows to the vehicle to be retrieved so user can edit details
	 * @return
	 * @throws SQLException
	 */
	public Boolean updateVehicle(Vehicle updateVehicle, int vehicle_id) throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			PreparedStatement psmt = dbConnection.prepareStatement(
					"UPDATE vehicles SET make = ?, model = ?, year = ?, price = ?,license_number = ?, colour = ?, number_doors = ?, transmission = ?, "
							+ "mileage= ?, fuel_type = ?,engine_size = ?, body_style = ?, condition = ?, notes = ? WHERE vehicle_id = ?");
			//Prepared statements to update the vehicle
			psmt.setString(1, updateVehicle.getMake());
			psmt.setString(2, updateVehicle.getModel());
			psmt.setInt(3, updateVehicle.getYear());
			psmt.setInt(4, updateVehicle.getPrice());
			psmt.setString(5, updateVehicle.getLicense_number());
			psmt.setString(6, updateVehicle.getColour());
			psmt.setInt(7, updateVehicle.getNumber_doors());
			psmt.setString(8, updateVehicle.getTransmission());
			psmt.setInt(9, updateVehicle.getMileage());
			psmt.setString(10, updateVehicle.getFuel_type());
			psmt.setInt(11, updateVehicle.getEngine_size());
			psmt.setString(12, updateVehicle.getBody_style());
			psmt.setString(13, updateVehicle.getCondition());
			psmt.setString(14, updateVehicle.getNotes());
			psmt.setInt(15, updateVehicle.getVehicle_id());
			psmt.executeUpdate();
			System.out.println("Vehicle has been updated!");
			return true;

		} catch (SQLException e) {
			System.out.println(e);

		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return false;
	}

	/**
	 * Allows the user to delete an existing vehicle stored in the password
	 * @param toDelete asks user which vehicle they want to delete by the ID
	 * @return
	 * @throws SQLException
	 */
	public Boolean deleteVehicle(int toDelete) throws SQLException {
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		String query = "DELETE FROM vehicles WHERE vehicle_id = " + toDelete + ";";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println(query);
			statement.executeUpdate(query);
			System.out.println("Vehicle has been deleted!");
			return true;

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return false;
	}
}
