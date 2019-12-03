<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Students</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<div class="container">
	<h1 class="display-2">All Students</h1>
	<table class="table table-striped">
		  <thead class="thead-light">
		    <tr>
		      <th scope="col">Name</th>
		      <th scope="col">Age</th>
		      <th scope="col">Address</th>
		      <th scope="col">City</th>
		      <th scope="col">State</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="student" items="${students}" >
		    <tr>
		      <td><a><c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/></a></td>
		      <td><c:out value="${student.age}"/></td>
		      <td><c:out value="${student.contact.address}"/></td>
		      <td><c:out value="${student.contact.city}"/></td>
		      <td><c:out value="${student.contact.state}"/></td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>


</body>
</html>