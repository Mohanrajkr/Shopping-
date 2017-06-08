<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<button type="button"><span style="float: center;"><a href="shippingaddressPage">New Shipping Address</a></span></button><br><br>


<!-- <a href="shippingaddressPage"><input style="color:green;" type="button" name="button" value="New Shipping Address"/></a></td></tr>
 -->					
<c:forEach items="${shippingaddressList}" var="shipping" >
<div class="col-sm-3 col-sm-offset-1" style="width:300px;heigth:500px;border:5px solid grey; float: left; margin-left: 1.5em;" >

<a href="deleteshippingAddress?shippingId=${shipping.shippingId}">
<span style="float: right;margin-right:1em;" class="glyphicon glyphicon-trash"></span> 
</a>
<a href="editshippingAddress?shippingId=${shipping.shippingId }">
<span style="float: right; margin-right:1em;"class="glyphicon glyphicon-pencil"></span>
</a>

<br><font color="#ff0066">Shipping address</font><br><br>

Name:${shipping.userName}<br>

Contact Number:${shipping.mobileNumber}<br>
Address:${shipping.address}<br>
Zipcode:${shipping.zipcode}


 
<a href="shippingAddress?shippingId=${shipping.shippingId}"><input style="color:green;" type="button" name="button" value="DeliverHere"/></a>
	</div>					
 
</c:forEach>
<br><br>
</body>
</html>