<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
crossorigin="anonymous">
<title>Insert Vehicle</title>
</head>
	<div class="mx-auto" style="width:1420px;">
	<h1>Add New Vehicle</h1>
	</div>
	<body>
		<form method ="post" action="./vehicleInsert">
        	<div class="form-group">
	            		<label class="control-label col-sm-1"> Make:</label>
	            		<input type="text" name="make">
	            		<br>           
	            		<label class="control-label col-sm-1"> Model:</label>
	            		<input type="text"  name="model">
	            		<br>
	            		<label class="control-label col-sm-1"> Year:</label>
	            		<input type="text" name="year">
	            		<br>
	            		<label class="control-label col-sm-1"> Price:</label>
	            		<input type="text" name="price">
	            		<br>
	            		<label class="control-label col-sm-1"> Registration:</label>
	            		<input type="text" name="license_number" pattern="(?<NewFormat>^[A-Z]{2}[0-9]{2}[A-Z]{3}$)|(?<OldStyle>^[A-Z][0-9]{1,3}[A-Z]{3}$)">
	            		<br>
	            		<label class="control-label col-sm-1"> Colour:</label>
	            		<input type="text" name="colour">
	            		<br>
	            		<label class="control-label col-sm-1"> Doors:</label>
	            		<input type="text" name="number_doors">
	            		<br>
	            		<label class="control-label col-sm-1"> Transmission:</label>
	            		<input type="text" name="transmission">
	            		<br>
	            		<label class="control-label col-sm-1"> Mileage:</label>
	            		<input type="text" name="mileage">
	            		<br>
	            		<label class="control-label col-sm-1"> Fuel Type:</label>
	            		<input type="text"  name="fuel_type">
	            		<br>
	            		<label class="control-label col-sm-1"> Engine Size:</label>
	            		<input type="text" name="engine_size">
	            		<br>
	            		<label class="control-label col-sm-1"> Body Style:</label>
	            		<input type="text" name="body_style">
	            		<br>
	            		<label class="control-label col-sm-1"> Condition:</label>
	            		<input type="text" name="condition">
	            		<br>
	            		<label class="control-label col-sm-1"> Notes:</label>
	            		<input type="text" name="notes">
	            		<br>
						</div>
            <div class="mx-auto" style="width:83%;">
            	<a href="./homepage" class="btn btn-warning btn-sm" style="width:85px;">Cancel</a>
				<input type="submit" class="btn btn-primary btn-sm" style="width:85px;">
			</div>
			
		</form>
	</body>
</html>