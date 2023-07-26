<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger Tracker</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	
	<div class="container">
		<header class="d-flex justify-content-between align-items-center">
		<h1> Burger Tracker </h1>
		<a href="/burgers/new" class="btn btn-success">Add New</a>
		</header>
		
		
		<table class="table table-hover">
			<thead>
				<tr>
				 	<th>Burger Name</th>
				 	<th>Restaurant Name</th>
				 	<th>Rating(out of 5)</th>
				 	<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="burger" items="${burgers}">
					<tr>
					 	<td><c:out value="${burger.burgerName}"/> </td>
					 	<td><c:out value="${burger.restaurantName}"/> </td>
					 	<td><c:out value="${burger.rating}"/> </td>
					 	<td> 
					 		<a href="/burgers/edit/${burger.id}" class="btn btn-warning">Edit</a>
					 		<form action="/burgers/delete/${burger.id }" method="post">
					 			<input type="hidden" name="_method" value="DELETE">
					 			<input type="submit" value="Borar" class="btn btn-danger">
					 		</form>
					 	</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>