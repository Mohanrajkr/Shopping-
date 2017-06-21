<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script type="text/javascript" src="resources/js/validate.js"></script>
 </head>
<body>
<div class="container">
  <form action="newUser" method="post" onsubmit="return validate()">
  <div class="form-group">
  <label for="name" >UserName</label>
      <input type="name" class="form-control" name="userName" id="username"  placeholder="Enter username">
    </div>
    <div class="form-group">
     
    <div class="form-group">
      <label for="email">Email</label>
      <input type="email" class="form-control" name="email" id="email" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" class="form-control" name="password" id="password" placeholder="Enter password">
    </div>
    <label for="mobile number">MobileNumber</label>
    <input type="mobile number" class="form-control" name="mobileNumber" id="mobilenumber" placeholder="Enter moblie number">
  </div>
  <div class="form-group">
  <label for="address"> Address</label>
  <input type="address" class="form-control" name="address" id="address" placeholder="Enter address">
</div>
<div class="form-group">
<label for="zipcode">Zipcode</label>
<input type="zipcode" class="form-control" name="zipcode" id="zipcode" placeholder="Enter zipcode">
</div>
    
   <button type="submit" class="btn btn-default" name="">Submit</button>
  </form>
</div>
</body>
</html>