<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
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
				<h1>Add to <c:out value="${song.name}"></c:out></h1>
				<form method="post" action="/edit/${song.id}">
					<p><c:out value="${songError}" /></p>
					<div class=form-group>
						<label for="name">Title: </label>
						<input class="form-control" type="text" id="name" name="name" placeholder="${song.getName()}"/>
					</div>
					<div class=form-group>
						<label for="genre">Genre:</label>
						<input class="form-control" type="text" id="genre" name="genre" placeholder="${song.getGenre()}"/>
					</div>
					<div class=form-group>
						<label for="lyrics">Add your lyrics: </label>
						<textarea placeholder="${song.getLyrics()}"class="form-control" name="lyrics" id="lyrics" cols="30" rows="10"></textarea>
				    	<button class="btn btn-dark mt-3" type="submit">Submit</button>
				    </div>
				    	<input type="hidden" name="contributor_id" value="${user.getId()}">        
				</form>
				<a class="btn btn-dark mt-3" href="/songs">Cancel</a>
					<a class="btn btn-dark mt-3" href="/delete/${song.id}">Delete</a>
			</div>
			</div>
			
		
	    
	    
	</div>
</body>
</html>