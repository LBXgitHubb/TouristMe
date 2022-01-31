<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" 
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
crossorigin="anonymous">
</head>

<body>
<div class="row"> 
<div class="container">
<h3 class="text-center">List of Bookings</h3>
<hr>
<div class="container text-left">
<!-- Add new booking button redirects to the AttractionBooking.jsp page -->
<a href="<%=request.getContextPath()%>/AttractionBooking.jsp" class="btn btn-success">Add New Booking</a>
</div>
<br>
<!-- Create a table to list out all current bookings information -->
<table class="table">
<thead>
<tr>
<th>Name</th>
<th>Email</th>
<th>Card Number</th>
<th>CVV</th>
<th>Expiry Date</th>
<th>Quantity</th>
<th>Date</th>
<th>Actions</th>
</tr>
</thead>
<!-- Pass in the list of bookings receive via the Servlet’s response to a loop 
-->
<tbody>
<c:forEach var="booking" items="${listBookings}">
<!-- For each booking in the database, display their 
information accordingly -->
<tr>
<td>
<c:out value="${booking.name}" />
</td>
<td>
<c:out value="${booking.email}" />
</td>
<td>
<c:out value="${booking.cardnumber}" />
</td>
<td>
<c:out value="${booking.cvv}" />
</td>
<td>
<c:out value="${booking.expirydate}" />
</td>
<td>
<c:out value="${booking.quantity}" />
</td>
<td>
<c:out value="${booking.date}" />
</td>
<!-- For each booking in the database, Edit/Delete 
buttons which invokes the edit/delete functions -->
<td>
<a href="edit?name=<c:out value='${booking.name}' 
/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; 
<a href="delete?name=<c:out 
value='${booking.name}' />">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>

</body>
</html>