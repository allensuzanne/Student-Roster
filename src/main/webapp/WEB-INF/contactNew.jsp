<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>New Contact Info</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<div class="container">
		<h1 class="display-2">Contact Info</h1>
		
		<form action="/contact/create" method="GET" modelAttribute="contactObj">
		
			  <div class="form-group">
			    <label>Student</label>
			    <select name="student" class="form-control">
			      <c:forEach var="student" items="${students}" >
			      <option value="<c:out value="${student.id}"/>"><c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/></option>
			      </c:forEach>
			    </select>
			  </div>
			  
			  <div class="form-group">
			    <label class="col-sm-2 col-form-label">Address</label>
			    <errors name="address"/>
			    <input type="text" class="form-control col-sm-6" name="address">
			  </div>
			  
			  <div class="form-group">
			    <label class="col-sm-2 col-form-label">City</label>
			    <input type="text" class="form-control col-sm-6" name="city">
			  </div>
			  
			   <div class="form-group">
			    <label class="col-sm-2 col-form-label">State</label>
			    <input type="text" class="form-control col-sm-6" name="state">
			  </div>		
			   
		    <input type="submit" class="btn btn-warning" value="Create"/>
		    
		</form>
	</div>


</body>
</html>