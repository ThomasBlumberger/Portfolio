<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Create a convenor</title>
		
		<link rel="stylesheet" type="text/css" href="/css/main.css">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
		
		<script src="/js/main.js"></script>
	</head>
	
	<body onload='document.createConvenorForm.emailinput.focus()'>
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
			<h1>Add Convenor</h1>
			<div class="mail">
			<form:form action="/admin/addConvenor" modelAttribute="convenor" class="cwform" method="post">
				<form:label path="name">Full Name:</form:label><br/>
				<form:input path="name" required="required"></form:input>
				<form:errors class="err" path="name"></form:errors>
				<br/>
				
				<form:label path="username">Username:</form:label><br/>
				<form:input path="username" required="required"></form:input>
				<form:errors class="err" path="username"></form:errors>
				<br/>
				
				<form:label path="password">Password:</form:label><br/>
				<form:input path="password" required="true" type="password"></form:input>
				<form:errors class="err" path="password"></form:errors>
				<br/>
				
				<form:label path="email">Email:</form:label><br/>
				<form:input path="email" required="true" type="email"></form:input>
				<form:errors class="err" path="email"></form:errors>
				<br/>
				
				<button type="submit">Submit</button>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form:form>
			</div>
		</section>
	</body>
</html>