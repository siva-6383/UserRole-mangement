<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.rawgit.com/tonystar/bootstrap-float-label/v4.0.1/dist/bootstrap-float-label.min.css" >
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
<style>
.border-lable-flt {
  display: block;
  position: relative;
}
.border-lable-flt label, .border-lable-flt > span {
  position: absolute;
  left: 0;
  top: 0;
  cursor: text;
  font-size: 75%;
  opacity: 1;
  -webkit-transition: all .2s;
          transition: all .2s;
  top: -.5em;
  left: 0.75rem;
  z-index: 3;
  line-height: 1;
  padding: 0 1px;
}
.border-lable-flt label::after, .border-lable-flt > span::after {
  content: " ";
  display: block;
  position: absolute;
  background: white;
  height: 2px;
  top: 50%;
  left: -.2em;
  right: -.2em;
  z-index: -1;
}
.border-lable-flt .form-control::-webkit-input-placeholder {
  opacity: 1;
  -webkit-transition: all .2s;
          transition: all .2s;
}
.border-lable-flt .form-control:placeholder-shown:not(:focus)::-webkit-input-placeholder {
  opacity: 0;
}
.border-lable-flt .form-control:placeholder-shown:not(:focus) + * {
  font-size: 150%;
  opacity: .5;
  top: .3em;
}

.input-group .border-lable-flt {
  display: table-cell;
}
.input-group .border-lable-flt .form-control {
  border-radius: 0.25rem;
}
.input-group .border-lable-flt:not(:last-child), .input-group .border-lable-flt:not(:last-child) .form-control {
  border-bottom-right-radius: 0;
  border-top-right-radius: 0;
  border-right: 0;
}
.input-group .border-lable-flt:not(:first-child), .input-group .border-lable-flt:not(:first-child) .form-control {
  border-bottom-left-radius: 0;
  border-top-left-radius: 0;
}

.form-control:focus {
  color: #804000;
  background-color: #fff;
  border-color: #006633;
  box-shadow: 0 0 0 0.2rem rgba(0, 102, 51, 0.25);
}
.card{
 height:300px;
 width:400px;
 background-image:  url("img_tree.png");
 background-repeat: no-repeat;    
 }




</style>




</head>

<body>
<div
  class="bg-image d-flex justify-content-center align-items-center"
  style="
    background-image: url('https://www.w3schools.com/css/img_mountains.jpg');
    background-repeat: no-repeat;
     background-size: cover;
      background-size: 100% 100%;
    height: 100vh;
  "
>
<div class="container">
 <center> 
<div class="card" >
<div class="card-body">
 <form action="LoginServlets" method="post"  onsubmit="return validateform()" class="was-validated">
<legend class="m-b-1 text-xs-center"><h1>Login Form</h1></legend>
  <div class="form-group input-group">
    <span class="border-lable-flt">
     <input title="Enter your username only alphates" type="text"  name="name" class="form-control" placeholder="Enter your name" pattern="^[a-zA-Z\\s]+$" required  autofocus>
      <label for="label-name">Your Name</label>
     <div class="valid-feedback">Valid.</div>
    <div class="invalid-feedback">Please fill out this field.</div>
    </span>  
  </div>
 <div class="form-group input-group">
    <span class="border-lable-flt">
      <input type="password"  name="password" class="form-control" placeholder="Enter your password" required autofocus>
      <label for="label-name">password</label>
       <div class="valid-feedback">Valid.</div>
     <div class="invalid-feedback">Please fill out this field.</div>
    </span>
  </div>
  <input type="submit" class="btn btn-primary" value="login"/>
<a href="Signup.jsp">Don't have an account? Register Here</a>
</form>
</div>
</div>
</center>
</div>
</div>
</body>
</html>