<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <form action="newShippingAddress" method="post">
  <div class="form-group">
   <label for="name">shippingId</label>
      <input type="name" class="form-control" name="ShippingId" id="email" placeholder="Enter shippingid">
    </div>
     <label for="name">userId</label>
      <input type="name" class="form-control" name="UserId" id="email" placeholder="Enter userid">
    </div>
        <label for="name">userName</label>
      <input type="name" class="form-control" name="UserName" id="email" placeholder="Enter username">
    </div>
    <div class="form-group">
      <label for="mobile number">mobileNumber</label>
      <input type="mobile number" class="form-control" name="MobileNumber" id="mobile number" placeholder="Enter moblie number">
    </div>
    <div class="form-group">
      <label for="email">email</label>
      <input type="email" class="form-control" name="Email" id="email" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="address"></label>
      <input type="address" class="form-control" name="Address" id="pwd" placeholder="Enter address">
    </div>
    
    <button type="submit" class="btn btn-default" name="">Submit</button>
  </form>
</div>
</body>
</html>