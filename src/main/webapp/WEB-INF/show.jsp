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
    <title>Song</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/song.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="flex-container">
		<div class="row justify-content-md-center">
			<div class=col-6 id="song-container">
				<h1><c:out value="${song.getName()}"></c:out></h1>
				<h2>Fist created by:<c:out value="${creator.getFirstName()}"></c:out><c:out value="${creator.getFirstName()}"></c:out></h2>
				<h3>Genre:<c:out value="${song.getGenre()}"></c:out></h3>
				<h3>Lyrics:<c:out value="${song.getLyrics()}"></c:out></h3>
				<a href="edit/${song.getId()}"class="btn btn-dark mt-3" type="submit">Contribute</a>
			</div>
		 	
		</div>
	</div>
</body>
</html>