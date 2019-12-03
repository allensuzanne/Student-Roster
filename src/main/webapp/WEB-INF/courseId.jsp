<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Course ID</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<div class="container">
			<h1 class="display-2"><c:out value="${course.name}"/></h1>
			<h5>Students taking this class:</h5>
			<table class="table table-striped">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">Name</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var="student" items="${course.students}" >
			    <tr>
			      <td><c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/></td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>
	
	</div>


</body>
</html>