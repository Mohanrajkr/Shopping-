
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


<c:choose>
<c:when test="${isAdminClickedAddCategory== 'true'}">
<jsp:include page="Category.jsp"></jsp:include>
</c:when>
<c:when test="${ isAdminClickedViewCategory=='true'}">
<jsp:include page="viewcategory.jsp"></jsp:include>
</c:when>
<c:when test="${ isAdminClickedEditCategory=='true'}">
<jsp:include page="editcategory.jsp"></jsp:include>
</c:when>
<c:when test="${isAdminClickedAddProduct=='true'}">
<jsp:include page="Product.jsp"></jsp:include>
</c:when>
<c:when test="${isAdminClickedViewProduct=='true'}">
<jsp:include page="viewproduct.jsp"></jsp:include>
</c:when>
<c:when test="${isAdminClickedEditProduct=='true'}">
<jsp:include page="editproduct.jsp"></jsp:include>
</c:when>
<c:when test="${isAdminClickedAddSupplier=='true'}">
<jsp:include page="Supplier.jsp"></jsp:include>
</c:when>
<c:when test="${isAdminClickedViewSupplier=='true'}">
<jsp:include page="viewsupplier.jsp"></jsp:include>
</c:when>
<c:when test="${isAdminClickedEditSupplier=='true'}">
<jsp:include page="editsupplier.jsp"></jsp:include>
</c:when>
<c:otherwise><h2>Welcome admin</h2></c:otherwise>
</c:choose>


</body>
</html>