<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<meta <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
crossorigin="anonymous">
</head>
<body>
<div class="mx-auto" style="width:1225px;">
<h1>Log In</h1>
</div>
	<form method="post" action="signIn">
		<div class="form-group">
		<label class="control-label col-sm-1"> Username:</label>
		<input type ="text" name="username">
		<br>
		<label class="control-label col-sm-1"> Password:</label>
		<input type ="password" name="password">
		<input type="submit" class="btn btn-primary btn-sm" value="Sign in">
		</div>
	</form>
	</body>
</html>