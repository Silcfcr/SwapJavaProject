<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>Swaps dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="flex-container">
		<div class="row justify-content-center">
			<div class=col-5>
				<h1>Hello <c:out value="${user.getFirstName()}"></c:out> <c:out value="${user.getLastName()}"></c:out></h1>
			</div>
			<div class=col-5>
				<a href="/profile/${user.getFirstName()}" class="btn btn-dark mt-3">Go to profile </a>
				<a href="/addProduct" class="btn btn-dark mt-3">Add a product </a>
				<a class="btn btn-dark mt-3" href="/logout">Logout</a>
				
				    	 
				    
			</div>
		</div>
		<div class="row justify-content-md-center">
			<div class=col-10 >
				<h3>All swaps:</h3>
				<table class="table">
			        <thead>
			            <tr>
			                <th scope="col">Image(s)</th>
			                <th scope="col">Details</th>
			                <th scope="col"></th>
			                
			            </tr>
			        </thead>
			        <tbody>
			        	<c:forEach items="${productList}" var="song">
			            <tr>
			            	<td><c:out value=""></c:out></td>
			                <td><a href="show/${song.getId()}"><c:out value="${song.getName()}"></c:out></a>
			                <br>
			                	Category:<c:out value="${song.getCategory()}"></c:out>
			                <br>
			                	Description:<c:out value="${song.getDescription()}"></c:out>
			                
				            </td>
			               	<td><a class=" btn btn-dark" href="/swap">Swap</a></td>
			            </tr>
			            </c:forEach>
			        </tbody>
			    </table>			       
			</div>
		</div>
	</div>
</body>
</html>