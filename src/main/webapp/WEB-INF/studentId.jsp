<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Student Id</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<div class="container">
		<h1 class="display-2"><c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/></h1>
		
		<form:form action="/student/add/${student.id }" method="POST" modelAttribute="student" >
		    <p>
	        	<form:label class="col-sm-2 col-form-label" path="">Add Courses:</form:label>
		        <select class="form-control col-sm-6" name="course_id">
		          <c:forEach var="course" items="${courses}" >
			      <option value="${course.id}"> <c:out value="${course.name}"/> </option>
			      </c:forEach>
			    </select>
		    </p>
		    <input type="submit" class="btn btn-warning" value="Add"/>
		</form:form>  
		
		<table class="table table-striped">
		  <thead class="thead-light">
		    <tr>
		      <th scope="col">Course Name</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="course" items="${student.courses}" >
		    <tr>
		      <td><c:out value="${course.name}"/></td>
		      <td><a href="/courses/<c:out value="${student.id}"/>/remove/<c:out value="${course.id}"/>">Remove</a></td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	
	</div>


</body>
</html>