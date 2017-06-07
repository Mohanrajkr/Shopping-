<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/shippingaddressvalidate.js"></script>
</head>
<body>
<div class="container">
  <form action="addShippingaddress" method="post" onsubmit="return shippingaddressvalidate()">

    <div class="form-group">
        <label for="name">User Name</label>
      <input type="name" class="form-control" name="UserName" id="username" placeholder="Enter username">
    </div>
    <div class="form-group">
      <label for="mobile number">Contact Number</label>
      <input type="mobile number" class="form-control" name="MobileNumber" id="mobile number" placeholder="Enter moblie number">
    </div>
  
    <div class="form-group">
      <label for="address">Shippingaddress</label>
      <input type="address" class="form-control" name="Address" id="password" placeholder="Enter address">
    </div>
     <div class="form-group">
      <label for="mobile number">Zipcode</label>
      <input type="mobile number" class="form-control" name="Zipcode" id="mobile number" placeholder="Enter zipcode">
    </div>
    <button type="submit" class="btn btn-default" name="">Submit</button>
  </form>
</div>
</body>
</html>