<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Dorm</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	<div class="container">
	
		<h1 class="display-2"><c:out value="${dorm.name}"/> Dorm</h1>
		
		<form:form action="/dorms/add" method="POST" modelAttribute="dorm" >
		    <p>
	        	<input type="hidden" value="${dorm.id }" name="dorm_id"/>
	        	<form:label class="col-sm-2 col-form-label" path="">Add Students:</form:label>
		        <form:errors path=""/>
		        <select class="form-control col-sm-6" name="student_id">
		          <c:forEach var="person" items="${students}" >
			      <option value="${person.id}"><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></option>
			      </c:forEach>
			    </select>
		    </p>
		    <input type="submit" class="btn btn-warning" value="Add"/>
		</form:form>  
		<table class="table table-striped">
		  <thead class="thead-light">
		    <tr>
		      <th scope="col">Name</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="student" items="${dorm.students}" >
		    <tr>
		      <td><c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/></td>
		      <td><a href="/dorms/<c:out value="${student.id}"/>/remove/<c:out value="${dorm.id}"/>">Remove</a></td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>
	</div>


</body>
</html>