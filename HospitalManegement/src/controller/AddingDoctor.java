package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import util.DBConnection;

public class AddingDoctor {

	

	public String readDoctorForAdding() {
		String output = "";
		
		
		try {
			Connection con = util.DBConnection.getconnection();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Dname</th>" + "<th>Dmail</th>"
					+ "<th>Specialization</th><th>Dcontact</th>" + "<th>Add</th></tr>";
			
			String query = "select * from doctor";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			
			// iterate through the rows in the result set
			while (rs.next()) {
				String Did = Integer.toString(rs.getInt("Did"));
				String Dname = rs.getString("Dname");
				String Dmail = rs.getString("Dmail");
				String Specialization = rs.getString("Specialization");
				String Dcontact = rs.getString("Dcontact");
				String Username = rs.getString("Username");
				String password = rs.getString("password");
				// Add into the html table

				output += "<tr><td>" + Dname + "</td>";
				output += "<td>" + Dmail + "</td>";
				output += "<td>" + Specialization + "</td>";
				output += "<td>" + Dcontact + "</td>";
				// buttons
				output += "<td><input name=\"btnAdd\" " + " type=\"button\" value=\"Add\"></td></tr>";
			}
			con.close();
			
			output += "</table>";
			
		} catch (Exception e) {
			
			output = "Error while reading the details.";
			System.err.println(e.getMessage());
		}
	
		return output;
	}

	public String insertDoctorHospital(String Hid, String Mid) {
		String output = "";
		
		try {
			Connection con = util.DBConnection.getconnection();
			if (con == null) {
				return "Error while connecting to the database";
			}
			
			// create a prepared statement
			String query = " insert into addeddoctors(`Hid`,`Mid`)"
					+ " values (?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(Hid));
			preparedStmt.setInt(2, Integer.parseInt(Mid));

			// execute the statement
			preparedStmt.execute();
			con.close();
			
			output = "Inserted successfully";
			
		} catch (Exception e) {
			
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readAddedDoctor() {
		String output = "";
		
		try {
			Connection con = util.DBConnection.getconnection();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Hid</th>" + "<th>Mid</th>"
					+ "<th>Remove</th></tr>";
			
			String query = "select * from addeddoctors";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next()) {
				String Hid = Integer.toString(rs.getInt("Hid"));
				String Mid = Integer.toString(rs.getInt("Mid"));
				// Add into the html table

				output += "<tr><td>" + Hid + "</td>";
				output += "<td>" + Mid + "</td>";
				// buttons
				output += "<td><form method=\"post\" action=\"HotelAccount.jsp\">" + "<input name=\"btnRemove\" "
						+ " type=\"submit\" value=\"Remove\">" + "<input name=\"itemID\" type=\"hidden\" " + " value=\""
						+ Hid+Mid + "\">" + "</form></td></tr>";
			}
			con.close();
			
			output += "</table>";
			
		} catch (Exception e) {
		
			output = "Error while reading the details.";
			System.err.println(e.getMessage());
		}
		return output;
	
	}

	public String deleteAddedDoctor(String Hid , String Mid) {
		String output = "";
		
		try {
			Connection con = util.DBConnection.getconnection();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			
			// create a prepared statement
			String query = "delete from addeddoctors where Hid=? and Mid=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			preparedStmt.setInt(1, Integer.parseInt(Hid));
			preparedStmt.setInt(2, Integer.parseInt(Mid));
			// execute the statement
			preparedStmt.execute();
			con.close();
			
			output = "Deleted successfully";
			
		} catch (Exception e) {
			
			output = "Error while deleting the details.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
	
}
