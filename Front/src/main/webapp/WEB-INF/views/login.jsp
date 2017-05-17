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
</head>
<body>
<div class="container">
  <form action="signIn" method="post">
<div class="form-group">
      <label for="name">email</label>
      <input type="email" class="form-control" name="Email"id="email" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="pwd">password</label>
      <input type="password" class="form-control" name="Password"id="pwd" placeholder="Enter password">
    </div>
   
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</body>
</html>