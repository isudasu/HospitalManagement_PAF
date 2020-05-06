<%@page import="controller.hospitalDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="view/bootstrap.min.css">
<script src="components/jquery-3.2.1.min.js"></script>
<script src="components/hospital.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Hospital Registration</h1>
				<form id="formHospital" name="formHospital"  action="HotelRegisteration.jsp">
					
					Company name : <input id="companyName" name="companyName" type="text" class="form-control form-control-sm"> <br> 
					Contact : <input id="contact" name="contact" type="text" class="form-control form-control-sm"> <br> 
					Email : <input id="email" name="email" type="text" class="form-control form-control-sm"> <br>
					Address : <input id="address" name="address" type="text" class="form-control form-control-sm"> <br> 
					Services  : <input id="services" name="services" type="text" class="form-control form-control-sm"> <br> 
					User Name : <input id="userName" name="userName" type="text" class="form-control form-control-sm"> <br> 
				    Password : <input id="password" name="password" type="text" class="form-control form-control-sm"> <br>  
				    
					<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary"> 
					<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
				</form>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divItemsGrid">
					<%
					hospitalDetails hospital = new hospitalDetails();
						out.print(hospital.readHospital());
					%>
				</div>
			</div>
		</div>
	</div>

</body>
</html>