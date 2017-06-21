<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/suppliervalidate.js"></script>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<div class="container">
  <form action="newSupplier" method="post" onsubmit="return suppliervalidate()">
  <div class="form-group">
         <label for="name">SupplierName</label>
      <input type="name" class="form-control" name="supplierName" id="suppliername" placeholder="Enter supplierName">
    </div>
    <div class="form-group">
      <label for="address">Address</label>
      <input type="name" class="form-control" name="address" id="address" placeholder="Enter address">
    </div>
    <div class="form-group">
      <label for="mobile number">MobileNumber</label>
      <input type="mobile number" class="form-control" name="mobileNumber" id="mobilenumber" placeholder="Enter mobileNumber">
    </div>
    <button type="submit" class="btn btn-default" name="">Submit</button>
  </form>
</div>>  
</body>
</html>