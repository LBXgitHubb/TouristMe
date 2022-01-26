<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>creating new user</title>
<style>
.blue {
	color: blue;
}
</style>
</head>
<body>

	<h1 class="blue">Create New User Here</h1>
	<div>
		<form action="RegisterServlet" method="post">
			Username:<input type="text" name="userName"> Password:<input
				type="password" name="password"> Confirm password:<input
				type="password" name="re-password"> <input type="submit"
				value="Create!"/>
		</form>
	</div>

</body>
</html>