<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>New Students</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<div class="container">
		<h1 class="display-2">New Student</h1>
		<form:form action="/students/create" method="POST" modelAttribute="studentObj">
		    <p>
		        <form:label class="col-sm-2 col-form-label" path="firstName">First Name:</form:label>
		        <form:errors path="firstName"/>
		        <form:input class="form-control col-sm-6" path="firstName"/>
		    </p>
		        <p>
		        <form:label class="col-sm-2 col-form-label" path="lastName">Last Name</form:label>
		        <form:errors path="lastName"/>
		        <form:input class="form-control col-sm-6" path="lastName"/>
		    </p>
		    <p>
		        <form:label class="col-sm-2 col-form-label" path="age">Age</form:label>
		        <form:errors path="age"/>
		        <form:input class="form-control col-sm-6" path="age"/>
		    </p>
		 
		    <input type="submit" class="btn btn-warning" value="Create"/>
		</form:form> 
	
	</div>


</body>
</html>