$(document).ready(function() {
	$("#alertSuccess").hide();
	$("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	// Form validation-------------------
	var status = validateItemForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "HospitalAPI",
		type : type,
		data : $("#formHospital").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onItemSaveComplete(response.responseText, status);
		}
	});
});
function onItemSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidItemIDSave").val("");
	$("#formHospital")[0].reset();
}

//update=================
$(document).on("click", ".btnUpdate", function(event) {  
    $("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());  
    $("#companyName").val($(this).closest("tr").find('td:eq(0)').text());    
    $("#contact").val($(this).closest("tr").find('td:eq(1)').text());   
    $("#email").val($(this).closest("tr").find('td:eq(2)').text());    
    $("#address").val($(this).closest("tr").find('td:eq(3)').text()); 
    $("#services").val($(this).closest("tr").find('td:eq(4)').text()); 
    $("#userName").val($(this).closest("tr").find('td:eq(5)').text()); 
    $("#password").val($(this).closest("tr").find('td:eq(6)').text()); 
}); 

$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "HospitalAPI",
		type : "DELETE",
		data : "Hid=" + $(this).data("Hid"),
		dataType : "text",
		complete : function(response, status) {
			onItemDeleteComplete(response.responseText, status);
		}
	});
});
function onItemDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

function validateItemForm() {  
	 
	if ($("#companyName").val().trim() == "") 
	{  
		return "Insert company name!"; 
		} 

if ($("#contact").val().trim() == "")  
{  
	return "Insert your contact number!"; 
} 

var tmpPrice = $("#contact").val().trim(); 
if (!$.isNumeric(tmpPrice)) 
{  
	return "Insert a numerical value for contact !";  
	} 
 
if ($("#email").val().trim() == "") 
{  
	return "Insert your valied email!";  
	} 
 
if ($("#address").val().trim() == "") 
{  
	return "Insert your company address !";  
	} 
 
if ($("#services").val().trim() == "") 
{  
	return "Insert your company services !";  
	} 
if ($("#userName").val().trim() == "") 
{  
	return "Insert User name !";  
	} 

if ($("#password").val().trim() == "")  
{   
	return "Insert password !."; 
	} 
 
 return true;
 }