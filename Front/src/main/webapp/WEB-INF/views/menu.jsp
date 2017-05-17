<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">HomePlus</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
 
        <ul class="dropdown-menu">
          <li><a href="kitchenPage">Kitchen&Dining</a></li>
          <li><a href="servingPage">Dining&Serving</a></li>
          <li><a href="furniturePage">Furniture</a></li>
          <li><a href="furnisingPage">Furnising</a></li>
          <li><a href="automationPage">Smart Home Automation</a></li>
           <li><a href="#">Tools&Hardwares</a></li>
            <li><a href="#">Home Decor</a></li>
            <li><a href="#">Lighting</a></li>
        </ul>
      </li>
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">NewCategory <span class="caret"></span></a>
           <ul class="dropdown-menu">
             <li><a href="CategoryPage">Add Category</a></li>
             <li><a href="viewcategoryPage">ViewCategory</a></li>
          </ul>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Supplier <span class="caret"></span></a>
          <ul class="dropdown-menu">
             <li><a href="SupplierPage">AddSupplier</a></li>
             <li><a href="viewsupplierPage">ViewSupplier</a></li>
          </ul>
           <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Product <span class="caret"></span></a>
          <ul class="dropdown-menu">
          <li class="active"><a href="ProductPage">AddProduct</a></li>
          <li class="active"><a href="viewproductPage">ViewProduct</a></li>
        </ul>
      </li>
    </ul>
    <form class="navbar-form navbar-left">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
    <ul class="nav navbar-nav navbar-right">
    <li class="active"><a href="ShippingAddressPage">ShippingAddress</a></li>
     <li class="active"><a href="BillingAddressPage">BillingAddress</a></li>
      <li><a href="registerPage"><span class="glyphicon glyphicon-user"></span> SignUp</a></li>
      <li><a href="loginPage"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

</body>
</html>