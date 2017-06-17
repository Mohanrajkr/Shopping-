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




<c:choose>
<c:when test="${ isUserClickedSignUp=='true'}">
<jsp:include page="register.jsp"></jsp:include>
</c:when>

<c:when test="${isUserClickedLogin=='true'}">
<br>
<br>
<br>

<jsp:include page="login.jsp"></jsp:include>
</c:when>

<c:otherwise>
<br>
<br>
<br>

<jsp:include page="carousel.jsp"></jsp:include>
<jsp:include page="productlist.jsp"></jsp:include>
</c:otherwise>
 </c:choose>
</body>
</html>
