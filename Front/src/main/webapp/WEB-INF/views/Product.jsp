  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
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
 <script type="text/javascript" src="resources/js/productvalidate.js"></script>

</head>

<body>
<br>
<br>
<br>
<br>
<br>
<div class="container">

  <form action="newProduct" method="post" onsubmit="return productvalidate()" enctype="multipart/form-data">
  <div class="form-group">
      <label for="name">productName</label>
      <input type="name" class="form-control" name="productName" id="productname" placeholder="Enter productName">
    </div>
    <div class="form-group">
      <label for="number">prize</label>
      <input type="name" class="form-control" name="prize" id="prize" placeholder="Enter prize">
    </div>
    <div class="form-group">
      <label for="mobile number">quantity</label>
      <input type="mobile number" class="form-control" name="quantity" id="quantity" placeholder="Enter quantity">
    </div>
   <div class="form-group">
     <label class=" control-label" for="post">Category</label>  
  
  <select name="categoryName">
  <option value="">Select Category</option>
  <c:forEach items="${CategoryList}" var="category" varStatus="status"><br><br>
  <option value="${category.categoryName}">${category.categoryName}</option>
  </c:forEach>
 </select>
 </div>
   <div class="form-group">
     <label class=" control-label" for="post">SupplierName</label>  
  
  <select name="supplierName">
  <option value="">Select Supplier</option>
  <c:forEach items="${SupplierList}" var="supplier" varStatus="status"><br><br>
  <option value="${supplier.supplierName}">${supplier.supplierName}</option>
  </c:forEach>
</select>
     </div>
     <div class="form-group">
      <label for="description">description</label>
      <input type="text" class="form-control" name="description" id="description" placeholder="Enter description">
    </div>
    <div class="form-group">
      <label for="image">Image</label>
      <input type="file" class="form-control" name="image"  placeholder="">
    </div>
    <button type="submit" class="btn btn-default" name="">Add</button>
  </form>
</div>
</body>
</html>