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
<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>
<style>


.formContainer input[type=text],[type=email], .formContainer input[type=password] {
  width: 50%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}
.formContainer .btn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 20%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.formContainer .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.formContainer.btn:hover, .open-button:hover {
  opacity: 1;
}
.card{
width:50%;
}

</style>

</head>
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
<body>

 <center>
<div class="card" >
<div class="card-body">
 <form action=LoginServlets id="myform" class="formContainer"  method="post">
          <h2>Edit Your profile</h2>
 
           <label for="label-name">
            <strong> Your Name</strong>
          </label>
           <input title="Enter your username only alphates" type="text"  name="name" id="name" class="form-control" placeholder="Enter your name" pattern="^[a-zA-Z\\s]+$" required  autofocus>
        <label for="label-name">
            <strong> Your email</strong>
          </label>
        <input type="email"  name="email" id="email" class="form-control" placeholder="Enter your email" required autofocus>
         <label for="label-name">
            <strong> Your password</strong>
          </label>
              <input type="password"  name="password" id="pass" class="form-control" placeholder="Enter your password" required autofocus>
          <button type="submit" class="btn">Save</button>
          <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
        </form>
</center>
</div>
</div>

</body>
</html>