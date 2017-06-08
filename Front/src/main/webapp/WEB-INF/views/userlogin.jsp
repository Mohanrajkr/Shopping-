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
<jsp:include page="menu.jsp"></jsp:include>
<h2>Welcome user</h2>



<c:choose>
<c:when test="${productDescription == 'true'}">
<jsp:include page="productDescription.jsp"></jsp:include>
</c:when>
<c:when test="${isUserClickedAddtocart== 'true'}">
<jsp:include page="mycartlist.jsp"></jsp:include>
</c:when>
<c:when test="${isUserClickedShippingaddress=='true'}">
<jsp:include page="viewshippingaddress.jsp"></jsp:include>
</c:when>
<c:when test="${newShippingaddressClicked=='true' }">
 <jsp:include page="Shippingaddress.jsp"></jsp:include>
</c:when>
 <c:when test="${editShippingAddressClicked=='true'}">    
  <jsp:include page="editshippingaddress.jsp"></jsp:include>
     </c:when>
     <c:when test="${ not empty DeliverHereClicked}">    
     <%@include file= "/WEB-INF/views/payment.jsp"%>
     </c:when>
     <c:when test="${ not empty CheckoutClicked}">    
     <%@include file= "/WEB-INF/views/thankyou.jsp"%>
     </c:when>
     <c:when test="${ not empty isUser}">    
     <%@include file= "/WEB-INF/views/productlist.jsp"%>
     </c:when>
     <%--  <c:when test="${ not empty redirect:mycartlistPage}">    
     <%@include file= "/WEB-INF/views/mycartlist.jsp"%>
     </c:when> --%>
<c:otherwise> <%@include file="/WEB-INF/views/productlist.jsp" %></c:otherwise>
     
</c:choose>
</body>
</html>