<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Attraction Listings</title>
</head>
<body>
<div class="row">
<div class="container">
<h3 class="text-center">List of Attractions</h3>
<hr>
<div class="container text-left">
<!-- Add new user button redirects to the register.jsp page -->
</div>
<br>
<!-- Create a table to list out all current users information -->
<table class="table">
<thead>
<tr>
<th>Name</th>
<th>Region</th>
<th>Price</th>
<th>Address</th>
<th>Type</th>
<th>Details</th>
<th>Image</th>


</tr>
</thead>
<!-- Pass in the list of users receive via the Servlet's response to a loop -->
<tbody>
<c:forEach var="listing" items="${listListings}">
<!-- For each user in the database, display their
information accordingly -->
<tr>
<td>
<c:out value="${listing.name}" />
</td>
<td>
<c:out value="${listing.region}" />
</td>
<td>
<c:out value="${listing.price}" />
</td>
<td>
<c:out value="${listing.address}" />
</td>
<td>
<c:out value="${listing.type}" />
</td>
<td>
<c:out value="${listing.details}" />
</td>
<td>
<img src="data:image/png;base64,'.base64_encode(${listing.image}).'"/>
<td>

</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</body>
</html>