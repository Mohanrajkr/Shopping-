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
<center>List Of Cart</center>
<table class = "table table-bordered">
<tr>
<th>S.No</th>

<th>productName</th>
<th>prize</th>
<th>quantity</th>
<th>date</th>
<th>days</th>
<th>status</th>
<th>total</th>

<th> DELETE</th>
</tr>
<c:forEach items="${mycartList}" var="mycart" varStatus="status">

<tr>
<td>${status.count}</td>

<td>${mycart.productName}</td>
<td>${mycart.prize}</td>
<td>${mycart.quantity}</td> 
<td>${mycart.date}</td>
<td>${mycart.days}</td>
<td>${mycart.status}</td>
<td>${mycart.total}</td>

<td><a  class="btn btn-danger" href="removecart?cartId=${mycart.cartId}">DELETE</a></td>
</tr>
</c:forEach>
<tr>
<td>  </td>
<td> <td><td><td><td><td>Grand Total:</td><td><c:out value="${GrandTotal}"></c:out></td>
</tr>
<tr>
<c:if test="${ismycartEmpty==true}">
<td>No items in cart
</td>
</c:if>
<c:if test="${ismycartEmpty==false}">
<td><a href="proceed"><button>proceed delivery</button></a>
</td>
</c:if>
</tr>
</table>
</body>
</html>