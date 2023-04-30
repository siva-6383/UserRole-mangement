<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <%@ page import="java.io.*,java.util.*"%>   
 <%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" /><!-- eye icon -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">

 .formContainer input[type=text],[type=email],input[type=password]{
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
.form-group input-group input[type=password] {
  width:10%;
   padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
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
  margin: auto;
  width: 50%;
 
  padding: 10px;
}
 
    .fa fa-fw fa-eye field_icon toggle-password{
      float: right;

    }  
    
</style>




<meta charset="UTF-8">
<title>Insert title here</title>

</head>


<script>

  
    	$(document).ready(function () {
    		
    		  $('#user_table').DataTable({
    	        pagingType: 'full_numbers',
    	        paging: true,
    	        searching: true,
    	        info: false,
    	        "scrollCollapse": true,
    		    pageLength: 5,
    	        lengthMenu: [[3,5, 10, 20, -1], [3,5, 10, 20, "all"]] 
    	    });
    	});
    	function myFunction() {
    		  var x = document.getElementById("pass");
    		  if (x.type === "password") {
    		    x.type = "text";
    		  } else {
    		    x.type = "password";
    		  }
    		}
</script>

<body>
<div class="m-4">

    <ul class="nav nav-tabs" id="myTab">
        <li class="nav-item">
            <a href="#home" class="nav-link active" data-bs-toggle="tab">Home</a>
        </li>
 <c:set var = "modules" value = "${checkmodal}"/>
   
<c:if test = "${fn:containsIgnoreCase(modules, 'userlist')}">
        <li class="nav-item">
            <a href="#profile" class="nav-link" data-bs-toggle="tab">UserList</a>
        </li>
    
 </c:if> 
     <c:if test = "${fn:containsIgnoreCase(modules, 'userrole')}">
        <li class="nav-item">
            <a href="#messages" class="nav-link" data-bs-toggle="tab">UserRole</a>
        </li>
        
         </c:if> 
     <c:if test = "${fn:containsIgnoreCase(modules, 'rolepermission')}">
        <li class="nav-item">
            <a href="#Permission" class="nav-link" data-bs-toggle="tab">RolePermission</a>
        </li>
        </c:if> 
        
         <li class="nav-item">
            <a href="#modalpermission" class="nav-link" data-bs-toggle="tab">modal Permission</a>
        </li> 
         <li class="nav-item">
            <a href="#pro" class="nav-link" data-bs-toggle="tab">profile</a>
        </li>  
        

       
       <li class="nav-item">
        <div class="topnav-right">
          <!--<a class="btn navbar-btn btn-primary navbar-right  pull-right" role="button"  href="logout.jsp">Logout</a>-->
          <a class="auth-modal-toggle btn btn-danger"  href="logout.jsp" style="">Logout</a>
          </div>
        </li> 
      
       </ul>
  
		<div class="tab-content">
			<div class="tab-pane fade show active" id="home">
				<h3 class="wel">Welcome To Home Page!!!</h3>
			</div>

			<div class="tab-pane fade" id="profile">
				<table id="user_table"
					class="table table-striped table-bordered table-sm" 
					border="1">
					<thead class="table-white">
						<tr>
							<th>userName</th>
							<th>email</th>
							<th>password</th>
						</tr>
					</thead>
					<tbody id="category_showData" class="scroll">
						<c:forEach items="${result}" var="student">
							<tr>
								<td><c:out value="${student.username}"></c:out></td>
								<td><c:out value="${student.email}"></c:out></td>
								<td><c:out value="${student.password}"></c:out></td>
								</tr>
						</c:forEach>
						
					</tbody>
				</table>
			</div>

			<div class="tab-pane fade" id="messages">


				
					<header>
						<nav class="navbar navbar-expand-md navbar-dark"
							style="background-color: tomato">
							<div>
								<a href="" class="navbar-brand"> UserRole</a>
							</div>

							<!--  <ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>-->
						</nav>
					</header>
					<br>

					<div class="row">
						<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

						<div class="container">
							<h3 class="text-center">List of Users</h3>
							<hr>
							<div class="container text-left">
                            <center>
								<a href="<%=request.getContextPath()%>/Role.jsp"
									class="btn btn-success">Add New User</a>
							</center>
							</div>
							<br>
							<table id="userroletable" class="table table-bordered">
								<thead>
									<tr>
										<th>Id</th>
										<th>Role</th>


									</tr>
								</thead>
								<tbody>
									<!--   for (Todo todo: todos) {  -->
									<c:forEach items="${listUser}" var="user">
										<tr>
											<td><c:out value="${user.id}" /></td>
											<td><c:out value="${user.role}" /></td>

											<td><a
												href="UserServlet?action=edit&id=<c:out value='${user.id}' />">Edit</a>
												&nbsp;&nbsp;&nbsp;&nbsp; <a
												href="UserServlet?action=delete&id=<c:out value='${user.id}' />">Delete</a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
			
			</div>
			<div class="tab-pane fade show" id="Permission">
				<table id="Permission_Table"
					class="table table-striped table-bordered table-sm" 
					border="1">
					<thead class="table-white">
						<tr>
							<th>userName</th>
							<th>email</th>
							<th>password</th>
							<th>Role</th>
						</tr>
					</thead>
					<tbody id="showData" class="scroll">
						<c:forEach items="${permission}" var="RP">
							<tr>
								<td><c:out value="${RP.username}"></c:out></td>
								<td><c:out value="${RP.email}"></c:out></td>
								<td><c:out value="${RP.password}"></c:out></td>
								<td><c:out value="${RP.role}"></c:out></td>

								<!--  <select class="input-select" style="width: 100px;" id="zone">
   <c:forEach items="${list}" var="dl"> 
  <option value='<c:out value="${dl.role}"></c:out>'>
  </option>
  </c:forEach>
  </select>
  </td> -->


								<td><a
									href="Rolepermissionservlet?action=edit&username=<c:out value='${RP.username}'/>&role=<c:out value='${RP.role}'/>">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp;</td>
							</tr>

						</c:forEach>
					</tbody>

				</table>
			</div>
			<div class="tab-pane fade" id="modalpermission">
				
					<header>
						<nav class="navbar navbar-expand-md navbar-dark"
							style="background-color: olive">
							<div>
								<a href="" class="navbar-brand"> Modal permission</a>
							</div>

							<!--  <ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>-->
						</nav>
					</header>
					<br>
					<table id="modal_Table"
						class="table table-striped table-bordered table-sm"
						 border="1">
						<thead class="table-white">
							<tr>

								<th>Modal</th>
								<th>Role</th>
								<th>Action</th>
								<%
System.out.println("rolepermission...."+request.getAttribute("modalper"));
%>
							</tr>
						</thead>
						<tbody id="per" class="scroll">
							<c:forEach items="${modalper}" var="mp">
								<tr>
									<td><c:out value="${mp.modal}"></c:out></td>
									<td><c:out value="${mp.role}"></c:out></td>

									<td><a id="myLink"
										href="modalpermissionservlet?action=edit&modal=<c:out value='${mp.modal}'/>&roles=<c:out value='${mp.role}'/>">save</a>&nbsp;&nbsp;&nbsp;&nbsp;
									</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
		<div class="tab-pane fade" id="pro">
				
					<div class="card">
						<div class="card-body">
							<form action="Signupservlet?action=update2" id="myform"
								class="formContainer" method="post">
								<h2>Edit Your profile</h2>
<%
System.out.println("profiles...."+request.getAttribute("proedit"));
%>
								<c:forEach items="${proedit}" var="pe">

									<label for="label-name"> <strong> Your Id</strong>
									</label>
									<input title="Enter your id" type="text" value="${pe.id}"
										name="ids" id="id" class="form-control"
										placeholder="Enter your id" pattern="^[a-zA-Z\\s]+$" required
										autofocus readonly>

									<label for="label-name"> <strong> Your Name</strong>
									</label>
									<input title="Enter your username only alphates" type="text"
										value="${pe.username}" name="name" id="name"
										class="form-control" placeholder="Enter your name"
										pattern="^[a-zA-Z\\s]+$" required autofocus>
									<label for="label-name"> <strong> Your email</strong>
									</label>
									<input type="email" name="email" id="email" value="${pe.email}"
										class="form-control" placeholder="Enter your email" required
										autofocus>
									<label for="label-name"> <strong> Your
											password</strong>
									</label>
									 <div>
									 <input type="password" name="password" value="${pe.password}"
										id="pass" class="form-control"
										placeholder="Enter your password" required autofocus>
										<input type="checkbox" onclick="myFunction()">Show Password
									</div>

								  
									<button type="submit" class="btn">Save</button>
									<button type="button" class="btn cancel">Close</button>
								</c:forEach>
							</form>
						</div>
					</div>
				
			</div>
		</div>
	</div>
</body>
</html>