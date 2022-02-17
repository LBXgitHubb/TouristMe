<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login in page</title>
<style type="text/css">
</style>
</head>
<body>
<h1>Login with your credential</h1>
<form action="LoginServlet" method="post">
Username:<input type="text" name="userName" placeholder="Enter Here"><br><br>
Password:<input type="password" name="password" placeholder="Enter Here"><br>
<input type ="submit" value="Login!" id="submit">
</form>
</body>
</html>