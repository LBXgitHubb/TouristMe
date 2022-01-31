<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Attraction Booking</title>
</head>

<body>
<h1>Attraction Booking</h1>

<form action="SubmitBooking" method="post">
 Enter Name: <input type="text" name="name" size="20"><br>
 Enter Email: <input type="text" name="email" size="20"> <br>
 Enter Card Number: <input type="text" name="cardnumber" size="20"> <br>
 Enter CVV: <input type="text" name="cvv" size="20"> <br>
 Enter Card Expiry Date: <input type="text" name="expirydate" size="20"> <br>
 Enter Quantity Of Ticket: <input type="text" name="quantity" size="20"> <br>
 Enter Date of Admission  : <input type="text" name="date" size="20">
 <!-- Implement submit button with type = submit to perform the request when clicked -->
 <input type="submit" value="Submit Booking" />
</form>

</body>
</html>