<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TouristMe</title> 

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>

  <!-- add in picture with forloop -->
<c:forEach var="listing" items="${listAttractions}">
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
<c:out value="${listing.detail}" />
</td>
<td>
<img src="${listing.image}"/>
<td>
ffgfg
<a href="edit?name=<c:out value='${listing.name}'
/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="delete?name=<c:out
value='${listing.name}' />">Delete</a>
</td>
</tr>
</c:forEach>
  
  <!-- things to add route to pages, sql workbench  -->
</body>
</html>