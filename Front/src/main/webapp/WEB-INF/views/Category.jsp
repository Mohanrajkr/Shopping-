<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <script type="text/javascript" src="resources/js/categoryvalidate.js"></script>
</head>
<body>
<div class="container">
  <form action="newCategory" method="post" onsubmit="return categoryvalidate()">
  <div class="form-group">
   
      <label for="name">categoryName</label>
      <input type="name" class="form-control" name="CategoryName" id="categoryname" placeholder="Enter categoryName">
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