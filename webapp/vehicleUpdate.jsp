<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
crossorigin="anonymous">
<title>Update Vehicle</title>
</head>
<div class="mx-auto" style="width:1390px;">
<h1>Update Vehicle</h1>
</div>
<body>
	<form method ="POST" action="./vehicleUpdate">
			<div class="form-group">
						<input type="hidden" name="vehicle_id" value="${updateVehicle.getVehicle_id()}">
						<label class="control-label col-sm-1"> Make:</label>
						<input type="text" name="make" value="${updateVehicle.getMake()}">
						<br>
						<label class="control-label col-sm-1"> Model:</label>
						<input type="text" name="model" value="${updateVehicle.getModel()}">
						<br>			
						<label class="control-label col-sm-1"> Year:</label>
						<input type="number" name="year" value="${updateVehicle.getYear()}">
						<br>
						<label class="control-label col-sm-1"> Price:</label>
						<input type="number" name="price" value="${updateVehicle.getPrice()}">
						<br>
						<label class="control-label col-sm-1"> Registration:</label>
						<input type="text" name="license_number" value="${updateVehicle.getLicense_number()}" pattern="(?<NewFormat>^[A-Z]{2}[0-9]{2}[A-Z]{3}$)|(?<OldStyle>^[A-Z][0-9]{1,3}[A-Z]{3}$)">
						<br>
						<label class="control-label col-sm-1"> Colour:</label>
						<input type="text" name="colour" value="${updateVehicle.getColour()}">
						<br>
						<label class="control-label col-sm-1"> Doors:</label>
						<input type="number" name="number_doors" value="${updateVehicle.getNumber_doors()}">
						<br>
						<label class="control-label col-sm-1"> Transmission:</label>
						<input type="text" name="transmission" value="${updateVehicle.getTransmission()}">
						<br>
						<label class="control-label col-sm-1"> Mileage:</label>
						<input type="number" name="mileage" value="${updateVehicle.getMileage()}">
						<br>
						<label class="control-label col-sm-1"> Fuel Type:</label>
						<input type="text" name="fuel_type" value="${updateVehicle.getFuel_type()}">
						<br>
						<label class="control-label col-sm-1"> Engine Size:</label>
						<input type="number" name="engine_size" value="${updateVehicle.getEngine_size()}">
						<br>
						<label class="control-label col-sm-1"> Body Style:</label>
						<input type="text" name="body_style" value="${updateVehicle.getBody_style()}">
						<br>
						<label class="control-label col-sm-1"> Condition:</label>
						<input type="text" name="condition" value="${updateVehicle.getCondition()}">
						<br>
						<label class="control-label col-sm-1"> Notes:</label>
						<input type="text" name="notes" value="${updateVehicle.getNotes()}">
						<br>	
					</div>
		
				<div class="mx-auto" style="width:83%;">
				<a href="./homepage" class="btn btn-warning btn-sm" style="width:85px;">Cancel</a>
				<input type="submit" class="btn btn-primary btn-sm" style="width:85px;">
				</div>
		</form>
	</body>
</html>