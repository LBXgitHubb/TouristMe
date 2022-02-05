<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
 <link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-md navbar-light">
<div>
<a class="navbar-brand"> User Management Application </a>
</div>
<ul class="navbar-nav">
<li><a href="<%=request.getContextPath()%>/ListingServlet/dashboard"
class="nav-link">Back to Dashboard</a></li>
</ul>
</nav>
<div class="container col-md-6">
<div class="card">
<div class="card-body">
<c:if test="${listing != null}">
<form action="update" method="post">
</c:if>
<c:if test="${listing == null}">
<form action="insert" method="post">
</c:if>
<caption>
<h2>
<c:if test="${listing != null}">
Edit User
</c:if>
<c:if test="${listing == null}">
Add New User
</c:if>
</h2>
</caption>
<c:if test="${listing != null}">
<input type="hidden" name="oriName" value="<c:out
value='${listing.name}' />" />
</c:if>
<fieldset class="form-group">
<label>User Name</label> <input type="text" value="<c:out
value='${listing.name}' />" class="form-control" name="name" required="required">
</fieldset>
<fieldset class="form-group">
<label>Region</label> <input type="text" value="<c:out
value='${listing.region}' />" class="form-control" name="region">
</fieldset>
<fieldset class="form-group">
<label>Price</label> <input type="text" value="<c:out
value='${listing.price}' />" class="form-control" name="price">
</fieldset>
<fieldset class="form-group">
<label>Address</label> <input type="text" value="<c:out
value='${listing.address}' />" class="form-control" name="address">
</fieldset>
<fieldset class="form-group">
<label>Attraction Type</label> <input type="text" value="<c:out
value='${listing.type}' />" class="form-control" name="type">
</fieldset>
<fieldset class="form-group">
<label>Details</label> <input type="text" value="<c:out
value='${listing.details}' />" class="form-control" name="details">
</fieldset>
<fieldset class="form-group">
<label>Image</label> <input type="text" value="<c:out
value='${listing.image}' />" class="form-control" name="image">
</fieldset>
<button type="submit" class="btn btn-success">Save</button>
</form>
</div>
</div>
</div>
</body>
</html>