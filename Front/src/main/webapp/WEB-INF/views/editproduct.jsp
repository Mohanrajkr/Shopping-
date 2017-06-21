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
  <form action="afterEditProduct" method="post" >
  <div class="form-group">
      <label for="id">ProductId</label>
      <input type="text" class="form-control" name="productId" id="productid" value="${product.productId }" readonly="true">
    </div>
  <div class="form-group">
      <label for="name">ProductName</label>
      <input type="text" class="form-control" name="productName" id="productname" value="${product.productName }" >
    </div>
    <div class="form-group">
      <label for="number">Prize</label>
      <input type="text" class="form-control" name="prize" id="prize" value="${product.prize }" >
    </div>
    <div class="form-group">
      <label for="mobile number">Quantity</label>
      <input type="text" class="form-control" name="quantity" id="quantity" value="${product.quantity }">
    </div>
     <div class="form-group">
      <label for="description">Description</label>
      <input type="text" class="form-control" name="description" id="description" value="${product.description }" >
    </div>
    
    <button type="submit" class="btn btn-default" name="">Submit</button>
  </form>
</div>
</body>
</html>