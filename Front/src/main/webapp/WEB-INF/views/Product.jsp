<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <script type="text/javascript" src="resources/js/productvalidate.js"></script>
</head>
<body>
<div class="container">
  <form action="newProduct" method="post" onsubmit="return productvalidate()">
  <div class="form-group">
   
      <label for="name">productName</label>
      <input type="name" class="form-control" name="ProductName" id="productname" placeholder="Enter productName">
    </div>
    <div class="form-group">
      <label for="number">prize</label>
      <input type="name" class="form-control" name="Prize" id="prize" placeholder="Enter prize">
    </div>
    <div class="form-group">
      <label for="mobile number">quantity</label>
      <input type="mobile number" class="form-control" name="Quantity" id="quantity" placeholder="Enter quantity">
    </div>
     <div class="form-group">
      <label for="description">description</label>
      <input type="name" class="form-control" name="Description" id="description" placeholder="Enter description">
    </div>
    <button type="submit" class="btn btn-default" name="">Submit</button>
  </form>
</div>
</body>
</html>