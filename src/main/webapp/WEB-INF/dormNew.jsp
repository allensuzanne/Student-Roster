<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>New Dorm</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<div class="container">
	
		<h1 class="display-2">New Dorm</h1>
		
		<form:form action="/dorms/create" method="POST" modelAttribute="dorm">
		    <p>
		        <form:label class="col-sm-2 col-form-label" path="name">Name:</form:label>
		        <form:errors path="name"/>
		        <form:input class="form-control col-sm-6" path="name"/>
		    </p>
		    		 
		    <input type="submit" class="btn btn-warning" value="Create"/>
		</form:form> 
	</div>


</body>
</html>