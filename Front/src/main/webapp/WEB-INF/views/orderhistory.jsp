<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<div class="container">
<center>List Of Cart</center>
<table class = "table table-bordered">
<tr>
<th>S.No</th>
<th>Product Name</th>
<th>Prize</th>
<th>Quantity</th>
<th>Ordered Date</th>
<th>Days</th>
<th>Status</th>



</tr>
<c:forEach items="${mycartList}" var="mycart" >

<tr>
<td>${status.count}</td>

<td>${mycart.productName}</td>
<td>${mycart.prize}</td>
<td>${mycart.productId}</td> 
<td>${mycart.date}</td>
<td>${mycart.days}</td>
<td>${mycart.status}</td>

</tr>
</c:forEach>
</table>
</div>
</body>
</html>