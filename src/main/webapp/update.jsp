
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: SkyBlue">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Role
					Permission </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/home.jsp"
					class="nav-link"></a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">


				<form action="Rolepermissionservlet?action=update" method="post">
                   <h2>RolePermission</h2>    
					<fieldset class="form-group">
						<label>username</label> <input type="text"
							value="<c:out value='${user}'/>" class="form-control" name="name"
							required="required" readonly>
					</fieldset>
					
	<fieldset class="form-group">
							<label>Role</label> <select name="Role" style="width: 465px;">
							<c:set var="roles" value="${param.role}"/>
								<c:forEach var="list" items="${role}">														
							<c:choose>
				 			<c:when test="${list.role eq roles}">
   								 <OPTION  value="${list.role}"  selected="selected"><c:out value="${list.role}"  /></OPTION>
    						</c:when>
  							<c:otherwise>
       								 <OPTION  value="${list.role}"><c:out value="${list.role}"/></OPTION>
   					 		</c:otherwise>
   					 		</c:choose>
								</c:forEach>
							</select> 
						</fieldset>
						
						<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>