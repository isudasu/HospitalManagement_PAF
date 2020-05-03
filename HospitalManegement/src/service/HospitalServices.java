package service;
import controller.*;


//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import model.*;

//For JSON
import com.google.gson.*;
import com.mysql.cj.xdevapi.Table;


//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

;

@Path("/hospitalDetails")
public class HospitalServices {

	hospitalDetails hospital = new hospitalDetails();
	AddingDoctor doctor = new AddingDoctor();
	
	
	// readdata hospital
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readHospital() {

		return hospital.readHospital();
	}
	
	
	// Inserting data hospital
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertHospital(@FormParam("companyName") String companyName,
	 @FormParam("contact") String contact,
	 @FormParam("email") String email,
	 @FormParam("address") String address,
	 @FormParam("services") String services,
	 @FormParam("userName") String userName,
	 @FormParam("password") String password)
	{
		
		HospitalClass tb = new HospitalClass();
		tb.setcompany(companyName);
		tb.setcontact(contact);
		tb.setEmail(email);
		tb.setaddress(address);
		tb.setservices(services);
		tb.setuserName(userName);
		tb.setpassword(password);
		
		
		
	 String output = hospital.insertHospital(tb);
	return output;
	}

	
	
	//updating data hospital
	
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateHospital(String hospitalData)
		{
			
		//Convert the input string to a JSON object
		 JsonObject itemObject = new JsonParser().parse(hospitalData).getAsJsonObject();
		 
		//Read the values from the JSON object
		 String Hid = itemObject.get("Hid").getAsString();
		 String companyName = itemObject.get("companyName").getAsString();
		 String contact = itemObject.get("contact").getAsString();
		 String email = itemObject.get("email").getAsString();
		 String address = itemObject.get("address").getAsString();
		 String services = itemObject.get("services").getAsString();
		 String userName = itemObject.get("userName").getAsString();
		 String password = itemObject.get("password").getAsString();
		 
		 
		 HospitalClass tbl = new HospitalClass();
			tbl.setcompany(companyName);
			tbl.setcontact(contact);
			tbl.setEmail(email);
			tbl.setaddress(address);
			tbl.setservices(services);
			tbl.setuserName(userName);
			tbl.setpassword(password);
		 
		 String output = hospital.updateHospital(Hid, tbl);
		
		 return output;
		}
		
		
		//delete(remove) hospital
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteHospital(String hospitalData)
		{
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(hospitalData, "", Parser.xmlParser());

	
		 String Hid = doc.select("Hid").text();
		 String output = hospital.deleteHospital(Hid);
		return output;
		}
	
		
		
		//read doctor details to add 
		@GET
		@Path("/addDoctor")
		@Produces(MediaType.TEXT_HTML)
		public String readDoctorForAdding() {

			return doctor.readDoctorForAdding();
		}
		
		// read doctor details which added
			@GET
			@Path("/readDoctor")
			@Produces(MediaType.TEXT_HTML)
			public String readAddedDoctor() {

				return doctor.readAddedDoctor();
			}
		
			
		// Inserting data doctor for hospital
			@POST
			@Path("/readDoctor")
			@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
			@Produces(MediaType.TEXT_PLAIN)
		public String insertDoctorHospital(@FormParam("Hid") String Hid,
			 @FormParam("Mid") String Mid)
			{
			 String output = doctor.insertDoctorHospital(Hid,Mid);
			return output;
			}

		//delete(remove) doctor
			@DELETE
			@Path("/readDoctor")
			@Consumes(MediaType.APPLICATION_XML)
			@Produces(MediaType.TEXT_PLAIN)
		public String deleteAddedDoctor(String DoctorData)
			{
			//Convert the input string to an XML document
			 Document doc = Jsoup.parse(DoctorData, "", Parser.xmlParser());

			
			 String Hid = doc.select("Hid").text();
			 String Mid = doc.select("Mid").text();
			 String output = doctor.deleteAddedDoctor(Hid,Mid);
			return output;
			}
	
}
