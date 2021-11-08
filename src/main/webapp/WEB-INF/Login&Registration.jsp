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
    <title>Login and Registration</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="flex-container">
		<div class="row justify-content-md-center">
			<div class=col-10>
				<h1>Swap</h1>
			</div>
			
		</div>
		<div class="row justify-content-md-center">
			<div class="col-5">
				<form:form modelAttribute="user" action="/register" method="POST">
					<h1>Register</h1>
					<div>
						<c:out value="${errorMessage}"></c:out>
					</div>
					<div class="form-group">
				        <form:label path="firstName" for="first_name">First name:</form:label>
				        <form:input class="form-control" path="firstName" type="text" name="first_name" id="first_name"/>
				        <form:errors path="firstName"/>
				    </div>
				    <div class="form-group">
				        <form:label path="lastName" for="last_name">Last name:</form:label>
				        <form:input class="form-control" path="lastName" type="text" name="last_name" id="last_name"/>
				        <form:errors path="lastName"/>
				    </div>
				    <div class="form-group">
				        <form:label path="email" for="email">Email:</form:label>
				        <form:input class="form-control" path="email" type="email" name="email" id="email"/>
				        <form:errors path="email"/>
				    </div>
				    <div class="form-group">
				        <form:label path="password">Password:</form:label>
            			<form:password class="form-control" path="password"/>
            			<form:errors path="password"/>
				    </div>
				    <div class="form-group">
				        <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            			<form:password class="form-control" path="passwordConfirmation"/>
            			<form:errors path="passwordConfirmation"/>
				    </div>
				    <div>
				    	<button class="btn btn-dark mt-3" type="submit">Register</button>
				    </div>
				</form:form>
			</div>
			<div class="col-5">
				    <h1>Login</h1>
				    <form action="/login" method="post">
				    <div>
						<c:out value="${loginError}"></c:out>
					</div>
				        <div class=form-group>
				            <label for="email">Email: </label>
				            <input class="form-control" type="email" id="email" name="email"/>
				        </div>
				        <div class=form-group>
				            <label for="password">Password: </label>
				            <input class="form-control" type="password" id="password" name="password"/>
				        </div>
				        <div>
				        	<button class="btn btn-dark mt-3" type="submit">Login</button>
				        </div>
				    </form> 
			</div>
		</div>
	
	</div>
</body>
</html>