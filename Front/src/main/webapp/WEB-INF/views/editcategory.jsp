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
  <form action="afterEditCategory" method="post">
  <div class="form-group">
      <label for="id">categoryId</label>
      <input type="text" class="form-control" name="categoryId" id="categoryid" value="${category.categoryId }" readonly="true">
    </div>
  <div class="form-group">
      <label for="name">categoryName</label>
      <input type="text" class="form-control" name="categoryName" id="categoryname" value="${category.categoryName }">
    </div>
    <div class="form-group">
      <label for="description">description</label>
      <input type="text" class="form-control" name="description" id="description" value="${category.description }">
    </div>
    <button type="submit" class="btn btn-default" name="">Submit</button>
  </form>
</div>
</body>
</html>