<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AdminListingsServlet" method="post">
Name:<input type="text" name="Name">
Region:<input type="text" name="Region">
Price:<input type="text" name="Price">
Address:<input type="text" name="Address">
Type:<input type="text" name="Attraction Type">
Details:<input type="text" name="Details">
Image:<input type="file" name="Image">
<input type="submit" value="Call Servlet">
</form>

</body>
</html>