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
   <caption>Category List</caption>
   
   <thead>
      <tr>
      <th>S.No</th>
       <th>categoryId</th>
         <th>categoryName</th>
         <th>Description</th>
      </tr>
   </thead>
   
   
 <c:forEach items="${categoryList}" var="category" varStatus="status">
  <tr>
  <td>${status.count}</td>
  <td>${category.categoryId}</td>
   <td>${category.categoryName}</td>
    <td>${category.description}</td>
    <td><a class="btn btn-info" href="editCategory?categoryId=${category.categoryId}">edit</a></td>
    <td><a class="btn btn-info" href="deleteCategory?categoryId=${category.categoryId}">delete</a></td>
  
  </tr>
  
  </c:forEach>
 
 
 
 
 
  
	
</table>

</body>
</html>