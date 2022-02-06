<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Attraction Listings</title>
</head>

<div class="container">
	<header
		class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
		<a href="/"
			class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
			<svg class="bi me-2" width="40" height="32" role="img"
				aria-label="Bootstrap">
				<use xlink:href="#bootstrap"></use></svg>
		</a>
		<h1>Tourist Me</h1>
		<br>
		<ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
		
			<c:if test="${status == '1'}">	
        	<li><a href="<%=request.getContextPath()%>/UserServlet/logout"> logout </a></li>
        	<li><a href="ListingServlet/dashboard" class="nav-link px-2 link-dark">Admin View</a></li>
        	<br/>
			</c:if>
			<c:if test="${status != '1'}">	
        	<li><a href="login.jsp" class="nav-link px-2 link-dark">Login</a></li>
        	<br/>   
        	</c:if>	
			<li><a href="register.jsp" class="nav-link px-2 link-dark">Register</a></li>
			<li><a href="AttractionBooking.jsp" class="nav-link px-2 link-dark">Booking</a></li>
		</ul>

	</header>
</div>

<body>
	<div class="row">
		<div class="container">
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
							<td><c:out value="${listing.name}" /></td>
							<td><c:out value="${listing.region}" /></td>
							<td><c:out value="${listing.price}" /></td>
							<td><c:out value="${listing.address}" /></td>
							<td><c:out value="${listing.type}" /></td>
							<td><c:out value="${listing.details}" /></td>
							<td><img src="${listing.image}" /> <!-- <img src="data:image/png;base64,'.base64_encode(${listing.image}).'"/> -->
							
							
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>