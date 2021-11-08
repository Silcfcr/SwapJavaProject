<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New products</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<!-- <link rel="stylesheet" href="/css/main.css"/> -->
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="flex-container">
		<div class="row justify-content-md-center">
			<div class=col-10>
				<h1>Add a product to your profile</h1>
				<form method="post" action="/addProduct">
				<div>
						<c:out value="${errorMessage}"></c:out>
					</div>
					<p><c:out value="${songError}" /></p>
					<div class=form-group>
						<label for="name">Name: </label>
						<input class="form-control" type="text" id="name" name="name"/>
					</div>
					<div class=form-group>
						<label for="category">Category:</label>
						<input class="form-control" type="text" id="category" name="category"/>
					</div>
					<div class=form-group>
						<label for="description">Description: </label>
						<textarea class="form-control" name="description" id="description" cols="30" rows="10"></textarea>
				    </div>	
				    <div>
				    	<button class="btn btn-dark mt-3" type="submit">Add</button>
				    </div>
				    <input type="hidden" name="creatorId" value="${user.getId()}">        
				</form>
				<a class="btn btn-dark mt-3" href="/products">Cancel</a>
			</div>
		</div>
	</div>
</body>
</html>