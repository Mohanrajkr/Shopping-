<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

<br>
<br>
<br>




<br>




<br>
<c:if test="${ isUserClickedSignUp=='true'}">
<jsp:include page="register.jsp"></jsp:include>
</c:if>
<br>
<c:if test="${isUserClickedLogin=='true'}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>
<br>

<c:if test="${ isUserClickedSupplier=='true'}">
<jsp:include page="Supplier.jsp"></jsp:include>
</c:if>
<br>
<c:if test="${ isUserClickedProduct=='true'}">
<jsp:include page="Product.jsp"></jsp:include>
</c:if>
<br>
<c:if test="${ isUserClickedProduct=='true'}">
<jsp:include page="Product.jsp"></jsp:include>
</c:if>
<br>
<c:if test="${ isUserClickedhomePage=='true'}">
<jsp:include page="home.jsp"></jsp:include>
<jsp:include page="carousel.jsp"></jsp:include>
</c:if>
<br>

 
</body>
</html>
