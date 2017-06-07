<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<h2>Welcome user</h2>


<jsp:include page="productlist.jsp"></jsp:include>

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
</c:choose>
</body>
</html>