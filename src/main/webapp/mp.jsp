
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
			style="background-color:grey">
			<div>
				<a href=" " class="navbar-brand"> Modal Permission </a>
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


				<form action="modalpermissionservlet?action=mpupdate" method="post">
                 <h2>ModalPermission</h2>    
					<fieldset class="form-group">
						<label>modal</label>
							
						<select name="modal" style="width: 465px;">
						<c:set var="models" value="${param.modal}"/>  
						<c:forEach items="${modalper}" var="mp"> 
						<c:choose>
				 			<c:when test="${mp.modal eq models}">
   								 <OPTION  value="${mp.modal}"  selected="selected"><c:out value="${mp.modal}"  /></OPTION>
    						</c:when>
  							<c:otherwise>
       								 <OPTION  value="${mp.modal}"><c:out value="${mp.modal}"  /></OPTION>
   					 		</c:otherwise>
   					 		</c:choose>
								</c:forEach>
						 </select>
					
					</fieldset>
					
	<fieldset class="form-group">
							<label>Role</label> <select name="roles" style="width: 465px;">
						<c:set var="values" value="${param.roles}"/>
								<c:forEach var="list" items="${role}">														
							<c:choose>
				 			<c:when test="${list.role eq values}">
   								 <OPTION  value="${list.role}"  selected="selected"><c:out value="${list.role}"  /></OPTION>
    						</c:when>
  							<c:otherwise>
       								 <OPTION  value="${list.role}"><c:out value="${list.role}"  /></OPTION>
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