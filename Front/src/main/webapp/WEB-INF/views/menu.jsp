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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <style> 
input[type=text] {
    width: 130px;
    height: 40px;
    
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    background-image: url('searchicon.png');
    background-position: 10px 10px; 
    background-repeat: no-repeat;
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
}

input[type=text]:focus {
    width: 100%;
}
</style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top w3-card-4">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar" href="#"><img alt="" src="resources/images/logo.png" style="height: 100%;"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
       
       <ul class="nav navbar-nav">
        <li class="active"><a href=""><br>Home</a></li></ul>
       
         <c:if test="${isUser == 'true' }">
        <ul class="nav navbar-nav">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><br>Category<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Headphone with mic</a></li>
            <li><a href="#">Boom Headphone</a></li>
            <li><a href="#">Bluetooth Headphone</a></li>
          </ul> 
        </li>
        </ul>
      </c:if>
      
      
      <ul class="navbar-form navbar-left">
      <br><input type="text" name="search" placeholder="Search..">
    </ul>
    
   <c:if test="${isAdmin == 'true' }">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><br>NewCategory<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="viewcategoryPage">ViewCategory</a></li>
            <li><a href="CategoryPage">AddCategory</a></li>
        </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><br>Product<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="viewproductPage">ViewProduct</a></li>
            <li><a href="ProductPage">AddProduct</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><br>Supplier<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="viewsupplierPage">ViewSupplier</a></li>
            <li><a href="SupplierPage">AddSupplier</a></li>
          </ul>
        </li>
      </ul>     
     </c:if>
    
   <c:if test="${pageContext.request.userPrincipal.name != null }">
      <ul class="nav navbar-nav navbar-right"> 
    		<li><a href="homePage"><br><span class="glyphicon glyphicon-logout"></span> Logout</a></li></ul>
  </c:if>
    
      <c:if test="${isUser =='true'}">
      <ul class="nav navbar-nav navbar-right"> 
	     	 <li><a href="mycartlistpage"><br><span class="glyphicon glyphicon-shopping-cart"></span> Mycart</a></li></ul>
	</c:if>
	  
	  <c:if test="${pageContext.request.userPrincipal.name!='isUser' && name !=null}">
      <ul class="navbar-form navbar-right">
	  <li><a href="#"><br><span class="glyphicon glyphicon-about"></span>ABOUT</a></li>
	  </ul>
	</c:if>
	  
	  
	  
	 <ul class="nav navbar-nav navbar-right"> 
    	   <li><a href="registerPage"><br><span class="glyphicon glyphicon-pencil"></span>SignUp</a></li>
      	   <li><a href="loginPage"><br><span class="glyphicon glyphicon-user"></span>Login</a></li>
 	 </ul>
 	

    
      
    </div>
    </div>
</nav>
	
	
	
	</body>
</html>