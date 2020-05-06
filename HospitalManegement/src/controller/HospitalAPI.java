package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.hospitalDetails;
import model.HospitalClass;


/**
 * Servlet implementation class HospitalAPI
 */
@WebServlet("/HospitalAPI")
public class HospitalAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	hospitalDetails hospital = new hospitalDetails();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HospitalAPI() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//String Hid = request.getParameter("Hid");
		String companyName = request.getParameter("companyName");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String services = request.getParameter("services");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		HospitalClass tb = new HospitalClass();
		//tb.setcompany(Hid);
		tb.setcompany(companyName);
		tb.setcontact(contact);
		tb.setEmail(email);
		tb.setaddress(address);
		tb.setservices(services);
		tb.setuserName(userName);
		tb.setpassword(password);

		String output = hospital.insertHospital(tb);

		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map paras = getParasMap(request);
		
		String Hid =paras.get("hidItemIDSave").toString();
		String companyName =paras.get("companyName").toString();
		String contact =paras.get("contact").toString();
		String email =paras.get("email").toString();
		String address =paras.get("address").toString();
		String services =paras.get("services").toString();
		String userName =paras.get("userName").toString();
		String password =paras.get("password").toString();
		
		HospitalClass tb = new HospitalClass();
		//tb.setcompany(Hid);
		tb.setcompany(companyName);
		tb.setcontact(contact);
		tb.setEmail(email);
		tb.setaddress(address);
		tb.setservices(services);
		tb.setuserName(userName);
		tb.setpassword(password);

		
		String output = hospital.updateHospital(Hid,tb);
		
		
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map paras = getParasMap(request);
		
		String output = hospital.deleteHospital(paras.get("Hid").toString());
		response.getWriter().write(output);
	}

	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}

}
