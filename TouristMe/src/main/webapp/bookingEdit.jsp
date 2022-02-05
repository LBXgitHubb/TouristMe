
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Booking Management Application</title>
 <link rel="stylesheet" 
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
crossorigin="anonymous">
</head>

<body>
<nav class="navbar navbar-expand-md navbar-light">
<div>
<a class="navbar-brand"> Booking Management Application </a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/bookingservlet/dashboard"
class="nav-link">Back to Dashboard</a></li>
</ul>
</nav>
<div class="container col-md-6">
<div class="card">
<div class="card-body">
<c:if test="${booking != null}">
<form action="update" method="post">
</c:if>
<c:if test="${booking == null}">
<form action="insert" method="post">
</c:if>
<caption>
<h2>
<c:if test="${booking != null}">
Edit Booking
</c:if>
<c:if test="${booking == null}">
Add New Booking
</c:if>
</h2>
</caption>
<c:if test="${booking != null}">
<input type="hidden" name="oriName" value="<c:out 
value='${booking.name}' />" />
</c:if>
<fieldset class="form-group">
<label>Booking Name</label> <input type="text" value="<c:out 
value='${booking.name}' />" class="form-control" name="name" required="required">
</fieldset>
<fieldset class="form-group">
<label>booking Email</label> <input type="text" value="<c:out 
value='${booking.email}' />" class="form-control" name="email">
</fieldset>
<fieldset class="form-group">
<label> CardNumber</label> <input type="text" value="<c:out 
value='${booking.cardnumber}' />" class="form-control" name="cardnumber">
</fieldset>
<fieldset class="form-group">
<label> CVV</label> <input type="text" value="<c:out 
value='${booking.cvv}' />" class="form-control" name="cvv">
</fieldset>
<fieldset class="form-group">
<label> ExpiryDate</label> <input type="text" value="<c:out 
value='${booking.expirydate}' />" class="form-control" name="expirydate">
</fieldset>
<fieldset class="form-group">
<label> Quantity</label> <input type="text" value="<c:out 
value='${booking.quantity}' />" class="form-control" name="quantity">
</fieldset>
<fieldset class="form-group">
<label> Date</label> <input type="text" value="<c:out 
value='${booking.date}' />" class="form-control" name="date">
</fieldset>
<button type="submit" class="btn btn-success">Save</button>
</form>
</div>
</div>
</div>

</body>
</html>