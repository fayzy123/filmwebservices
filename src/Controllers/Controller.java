package Controllers;

import java.util.ArrayList;
import java.util.Scanner;

import Models.Vehicle;
import Models.VehicleDAO;

import java.sql.SQLException;

public class Controller {
	public static void main(String[] args) throws SQLException {
		MenuDisplay();
	}

	public static void MenuDisplay() throws SQLException {
		// Declaring the variables for the vehicles details
		int vehicle_id;
		String make;
		String model;
		int year;
		int price;
		String license_number;
		String colour;
		int number_doors;
		String transmission;
		int mileage;
		String fuel_type;
		int engine_size;
		String body_style;
		String condition;
		String notes;
		
		/**
		 * Menu System for running the backend program
		 */
		// While loop to keep the program running
		while (true) {
			System.out.println("---------------------------------");
			System.out.println("Vehicle Inventory System");
			System.out.println("Choose from the following options: ");
			System.out.println("---------------------------------");
			System.out.println("1 - Retrieve all vehicles");
			System.out.println("2 - Search for a vehicle");
			System.out.println("3 - Insert a new vehicle");
			System.out.println("4 - Update an existing vehicles details");
			System.out.println("5 - Delete a vehicle from the database ");
			System.out.println("6 - Exit");
			System.out.print("Enter choice: ");

			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			int showMenu = input.nextInt();
			VehicleDAO dao = new VehicleDAO();

			// Display the menu based on user selection
			switch (showMenu) {
			case 1:
				// Retrieves all the vehicles
				ArrayList<Vehicle> allVehicles = null;
				allVehicles = dao.getAllVehicles();
				for (Vehicle v : allVehicles) {
					System.out.println("--------------------");
					System.out.println(v);
				}
				break;

			case 2:
				// Searches for a vehicle
				Scanner input2 = new Scanner(System.in);
				System.out.print("Please enter the vehicle id you want to search for: ");
				int searchID = input2.nextInt();
				Vehicle searchVehicle = dao.getVehicle(searchID);
				System.out.println(searchVehicle);
				System.out.println("Your vehicle has been searched!");
				dao.getVehicle(searchID);
				break;

			case 3:
				// Inserts a new vehicle
				Scanner input3 = new Scanner(System.in);
				System.out.print("Please enter a make: ");
				make = input3.next();
				System.out.print("Please enter a model: ");
				model = input3.next();
				System.out.print("Please enter a year: ");
				year = input3.nextInt();
				System.out.print("Please enter a price: ");
				price = input3.nextInt();
				System.out.print("Please enter a licence number: ");
				license_number = input3.next();
				while (!license_number.matches("(?<NewFormat>^[A-Z]{2}[0-9]{2}[A-Z]{3}$)|(?<OldStyle>^[A-Z][0-9]{1,3}[A-Z]{3}$)")) {
					System.out.println("Invalid licence number!");
					System.out.println("Please enter a valid UK licence number: ");
					license_number = input3.next();
				}
				System.out.print("Please enter a colour: ");
				colour = input3.next();
				System.out.print("Please enter number of doors: ");
				number_doors = input3.nextInt();
				System.out.print("Please enter a transmission: ");
				transmission = input3.next();
				System.out.print("Please enter a mileage: ");
				mileage = input3.nextInt();
				System.out.print("Please enter a fuel type: ");
				fuel_type = input3.next();
				System.out.print("Please enter an engine size: ");
				engine_size = input3.nextInt();
				System.out.print("Please enter a body style: ");
				body_style = input3.next();
				System.out.print("Please enter a condition: ");
				condition = input3.next();
				System.out.print("Please enter any notes: ");
				notes = input3.next();

				Vehicle veh = new Vehicle(0, make, model, year, price, license_number, colour, number_doors,
						transmission, mileage, fuel_type, engine_size, body_style, condition, notes);
				dao.insertVehicle(veh);
				break;

			case 4:
				// Updates an existing vehicle
				Scanner input4 = new Scanner(System.in);
				System.out.print("Please enter the vehicle id of the vehicle you want to update: ");
				vehicle_id = input4.nextInt();
				System.out.print("Please enter a new make: ");
				make = input4.next();
				System.out.print("Please enter a new model: ");
				model = input4.next();
				System.out.print("Please enter a new year: ");
				year = input4.nextInt();
				System.out.print("Please enter a new price: ");
				price = input4.nextInt();
				System.out.print("Please enter a new licence number: ");
				license_number = input4.next();
				System.out.print("Please enter a new colour: ");
				colour = input4.next();
				System.out.print("Please enter the new number of doors: ");
				number_doors = input4.nextInt();
				System.out.print("Please enter a new transmission: ");
				transmission = input4.next();
				System.out.print("Please enter a new mileage: ");
				mileage = input4.nextInt();
				System.out.print("Please enter a new fuel type: ");
				fuel_type = input4.next();
				System.out.print("Please enter a new engine size: ");
				engine_size = input4.nextInt();
				System.out.print("Please enter a new body style: ");
				body_style = input4.next();
				System.out.print("Please enter a new condition: ");
				condition = input4.next();
				System.out.print("Please enter any new notes: ");
				notes = input4.next();

				Vehicle updateVehicle = new Vehicle(vehicle_id, make, model, year, price, license_number, colour,
						number_doors, transmission, mileage, fuel_type, engine_size, body_style, condition, notes);
				dao.updateVehicle(updateVehicle, vehicle_id);
				break;

			case 5:
				// Deletes an existing vehicle
				Scanner input5 = new Scanner(System.in);
				System.out.print("Please enter the vehicle id you want to delete: ");
				int toDelete = input5.nextInt();
				dao.deleteVehicle(toDelete);
				break;

			case 6:
				// Exits the program
				System.out.println("The program has finished running!");
				System.exit(0);
				return;
				
			default:
				// Prompts the user with an error if an invalid option is chosen
				System.out.println("ERROR! Please choose a valid option from (1-6)");
			}
		}
	}
}
