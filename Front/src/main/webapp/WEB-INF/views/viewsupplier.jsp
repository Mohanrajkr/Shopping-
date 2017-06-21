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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<table class = "table table-bordered">
   <caption>Supplier List</caption>
   
   <thead>
      <tr>
      <th>S.No</th>
       <th>SupplierId</th>
         <th>SupplierName</th>
         <th>Address</th>
         <th>MobileNumber</th>
          <th>Edit</th>
           <th>Delete</th>
      </tr>
   </thead>
   
  <c:forEach items="${supplierList}" var="supplier" varStatus="status">
  <tr>
  <td>${status.count}</td>
  <td>${supplier.supplierId}</td>
   <td>${supplier.supplierName}</td>
   <td>${supplier.address}</td>
   <td>${supplier.mobileNumber}</td>
    <td><a class="btn btn-info" href="editSupplier?supplierId=${supplier.supplierId}">edit</a></td>
    <td><a class="btn btn-info" href="deleteSupplier?supplierId=${supplier.supplierId}">delete</a></td>
  
  </tr>
  
  </c:forEach>
  
	
</table>
</body>
</html>