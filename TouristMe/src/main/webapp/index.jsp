<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Testing</h1>

<form action="HelloIndexServlet" method="post">
 Enter your name: <input type="text" name="yourName" size="20">
 <!-- Implement submit button with type = submit to perform the request when clicked -->
 <input type="submit" value="Call Servlet" />
</form>

</body>
</html>