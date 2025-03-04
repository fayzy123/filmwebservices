<html>
<head>
<meta charset="UTF-8">
<title>Vehicle Search</title>
<meta <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center">Search Vehicle</h1>
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
		</tr>
		<tr>
			<td class="text-center">${searchVehicle.getVehicle_id()}</td>
			<td class="text-center">${searchVehicle.getMake()}</td>
			<td class="text-center">${searchVehicle.getModel()}</td>
			<td class="text-center">${searchVehicle.getYear()}</td>
			<td class="text-center">${searchVehicle.getPrice()}</td>
			<td class="text-center">${searchVehicle.getLicense_number()}</td>
			<td class="text-center">${searchVehicle.getColour()}</td>
			<td class="text-center">${searchVehicle.getNumber_doors()}</td>
			<td class="text-center">${searchVehicle.getTransmission()}</td>
			<td class="text-center">${searchVehicle.getMileage()}</td>
			<td class="text-center">${searchVehicle.getFuel_type()}</td>
			<td class="text-center">${searchVehicle.getEngine_size()}</td>
			<td class="text-center">${searchVehicle.getBody_style()}</td>
			<td class="text-center">${searchVehicle.getCondition()}</td>
			<td class="text-center">${searchVehicle.getNotes()}</td>
		</tr>
	</table>
	<br>
	<a href="./homepage" class="btn btn-primary btn-sm" >Home</a>
</body>
</html>