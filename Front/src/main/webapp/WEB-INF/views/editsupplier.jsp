<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<div class="container">
  <form action="afterEditSupplier" method="post" >
  <div class="form-group">
         <label for="id">SupplierId</label>
      <input type="id" class="form-control" name="supplierId" id="supplierid" value="${supplier.supplierId }" readonly="true">
    </div>
  <div class="form-group">
         <label for="name">SupplierName</label>
      <input type="name" class="form-control" name="supplierName" id="suppliername" value="${supplier.supplierName }" >
    </div>
    <div class="form-group">
      <label for="address">Address</label>
      <input type="name" class="form-control" name="address" id="address" value="${supplier.address }" >
    </div>
    <div class="form-group">
      <label for="mobile number">MobileNumber</label>
      <input type="mobile number" class="form-control" name="mobileNumber" id="mobilenumber" value="${supplier.mobileNumber }" >
    </div>
    <button type="submit" class="btn btn-default" name="">Submit</button>
  </form>
</div>>  
</body>
</html>