<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script>
$(".carousel").swipe({

	  swipe: function(event, direction, distance, duration, fingerCount, fingerData) {

	    if (direction == 'left') $(this).carousel('next');
	    if (direction == 'right') $(this).carousel('prev');

	  },
	  allowPageScroll:"vertical"

	});
</script>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>
<div class="container">
  
  
       

  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
      <li data-target="#carousel-example-generic" data-slide-to="2"></li>
      <li data-target="#carousel-example-generic" data-slide-to="3"></li>
      <li data-target="#carousel-example-generic" data-slide-to="4"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="resources/images/1.jpg">
      </div>
      <div class="item">
        <img src="resources/images/2.jpg">
      </div>
      <div class="item">
        <img src="resources/images/3.jpg">
      </div>
      <div class="item">
        <img src="resources/images/4.jpg">
      </div>
      <div class="item">
        <img src="resources/images/5.jpg">
      </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>

</div>

<br>
<c:if test="${ isUserClickedSignUp=='true'}">
<jsp:include page="register.jsp"></jsp:include>
</c:if>
<br>
<c:if test="${isUserClickedLogin=='true'}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>
<br>
<c:if test="${ isUserClickedNewCategory=='true'}">
<jsp:include page="Category.jsp"></jsp:include>
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
<c:if test="${ isUserClickedViewCategory=='true'}">
<jsp:include page="viewcategory.jsp"></jsp:include>
</c:if>
<br>
<c:if test="${ isUserClickedViewSupplier=='true'}">
<jsp:include page="viewsupplier.jsp"></jsp:include>
</c:if>
<br>
<c:if test="${ isUserClickedViewProduct=='true'}">
<jsp:include page="viewproduct.jsp"></jsp:include>
</c:if>
</body>
</html>
