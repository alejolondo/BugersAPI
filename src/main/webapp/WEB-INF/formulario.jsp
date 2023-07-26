<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
	
	<div class="container">
	
	 <form:form action="/burgers/create" method="post" modelAttribute="burger">
 		<h1>New Burger Track</h1>
			
			<div class="form-group">
			
			<form:label path="burgerName">Burger Name:</form:label>
			<form:input path="burgerName" class="form-control" />
			<form:errors path="burgerName" class="text-danger" />
			
			</div>
			
			<div class="form-group">
			
			<form:label path="restaurantName">Restaurant Name:</form:label>
			<form:input path="restaurantName" class="form-control" />
			<form:errors path="restaurantName" class="text-danger" />
			
			</div>
			
			<div class="form-group">
			
			<form:label path="rating">Rating:</form:label>
			<form:input type="number" path="rating" class="form-control" />
			<form:errors path="rating" class="text-danger" />
			
			</div>
			<input type="submit" value="Save" class="btn btn-success" />
 	
 	</form:form>
	</div>

</body>
</html>