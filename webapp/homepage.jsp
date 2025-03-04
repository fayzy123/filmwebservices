<%@page import="Models.Vehicle"%>
<%@page import="java.util.ArrayList"%>

<html>
<head>
<meta charset="UTF-8">
<title>Vehicle Database Home</title>
<meta <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="v"%>>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
crossorigin="anonymous">					
</head>
<body>
	<div class="text-right" style="width: 1408px;">
	<v:choose>
		<v:when test="${signedIn==true}">
		<a href="./signOut" class="btn btn-primary btn-sm" >Log Out</a>
		</v:when>
	
		<v:otherwise>
		<a href="./signIn" class="btn btn-primary btn-sm" >Log In</a>
		</v:otherwise>
	</v:choose>
	</div>
	
	<h1 class="text-center">My Vehicle Database</h1>
	<div class="form-group mb-2">
		<form method ="get" action="./vehicleSearch" class="form-inline">
			<div class="mx-auto" style="width: 420px;">
				Search For A Vehicle ID: <input type="number"  name="vehicle_id">
				<input type="submit" class="btn btn-primary btn-sm" value="search">	
			</div>
		</form>
	</div>

	<table class="table table-sm">
  	<thead class="thead-dark">
		<tr>
			<th scope="col" class="text-center">ID</th>
			<th scope="col" class="text-center">Make</th>
			<th scope="col" class="text-center">Model</th>
			<th scope="col" class="text-center">Year</th>
			<th scope="col" class="text-center">Price</th>
			<th scope="col" class="text-center">Registration</th>
			<th scope="col" class="text-center">Colour</th>
			<th scope="col" class="text-center">Doors</th>
			<th scope="col" class="text-center">Transmission</th>
			<th scope="col" class="text-center">Mileage</th>
			<th scope="col" class="text-center">Fuel</th>
			<th scope="col" class="text-center">Engine Size</th>
			<th scope="col" class="text-center">Body</th>
			<th scope="col" class="text-center">Condition</th>
			<th scope="col" class="text-center">Notes</th>
			<v:if test="${signedIn==true}">
			<th scope="col" class="text-center">Admin Tools</th>
			</v:if>
		</tr>
		<v:forEach items="${allVehicles}" var="v">
		<tr>
			<td class="text-center">${v.getVehicle_id()}</td>
			<td class="text-center">${v.getMake()}</td>
			<td class="text-center">${v.getModel()}</td>
			<td class="text-center">${v.getYear()}</td>
			<td class="text-center">${v.getPrice()}</td>
			<td class="text-center">${v.getLicense_number()}</td>
			<td class="text-center">${v.getColour()}</td>
			<td class="text-center">${v.getNumber_doors()}</td>
			<td class="text-center">${v.getTransmission()}</td>
			<td class="text-center">${v.getMileage()}</td>
			<td class="text-center">${v.getFuel_type()}</td>
			<td class="text-center">${v.getEngine_size()}</td>
			<td class="text-center">${v.getBody_style()}</td>
			<td class="text-center">${v.getCondition()}</td>
			<td class="text-center">${v.getNotes()}</td>
			
			<td>
				<v:if test="${signedIn==true}">
				<a href="./vehicleDelete?vehicle_id=${v.getVehicle_id()}"class="btn btn-danger btn-sm">Delete Vehicle</a>
				<a href="./vehicleUpdate?vehicle_id=${v.getVehicle_id()}"class="btn btn-info btn-sm">Update Vehicle</a>
				</v:if> 
			</td>
			</tr>
			</v:forEach>
		</table>
		
		<div class="text-right" style="width: 1408px;">
			<v:if test="${signedIn==true}">
			<a href="./vehicleInsert" class="btn btn-success btn-sm" style="width:230px;"> + Add New Vehicle</a>
			</v:if>
		</div>
	</body>
</html>