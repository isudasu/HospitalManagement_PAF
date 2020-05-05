package model;

public class HospitalClass {
	
	public String Hid; 
	public String companyName; 
	public String contact; 
	public String email;
	public String address; 
	public String services;
	public String userName;
	public String password;
	

	public String getid() {
		return Hid;
	}

	public void setid(String Hid) {
		this.Hid = Hid;
	}
	public String getcompany() {
		return companyName;
	}

	public void setcompany(String companyName) {
		this.companyName = companyName;
	}

	public String getcontact() {
		return contact;
	}

	public void setcontact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getservices() {
		return services;
	}

	public void setservices(String services) {
		this.services = services;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}
	
	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

}
