<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Students</title>
		
		<link rel="stylesheet" type="text/css" href="/css/main.css">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
		
		<script src="/js/main.js"></script>
	</head>
	
	<body>
		<!-- GLOBAL HEADER -->
		<header>
			<a href="/">CO2101 - Group 06</a>
			<div class="drop_container">
				<button class="dropbutton" onclick="header_dropdown()">Logged in as: ${user}</button>
				
				<div id="dropdown" class="dropdown_contents">
					<a href="/logout">Logout</a>
				</div>
			</div>
		</header>
		
		<!-- GLOBAL NAV BAR -->
		<nav>
			<div class="buttons">
				<a class="nav_button" href="/admin/newConvenor">Add Convenor</a>
				<a class="nav_button" href="/admin/convenors">View Convenors</a>
				<a class="nav_button" href="/admin/students">View Students</a>
			</div>
		
			<footer>
				CO2101 Project<br/>
				Project by: Group 06
			</footer>
		</nav>
	
		<section class="content">
			<h1>Students</h1>
			
			<c:forEach items="${students}" var="student">
			<div class="objdiv-inline">
				<h3>Name: ${student.name}&nbsp;&nbsp;&nbsp;Username: ${student.username}</h3>
			  		<div class="buts">

			  			<a class="sec_but" href="/admin/removeStudent?username=${student.username}">Remove</a>
					</div>
			  	</div>
			</c:forEach>
		</section>
	</body>
</html>