<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Create a Groupwork</title>
		
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
					<a href="/account-settings">Settings</a>
					<a href="/logout">Logout</a>
				</div>
			</div>
		</header>
		
		<!-- GLOBAL NAV BAR -->
		<nav>
			<div class="buttons">
				<a class="nav_button" href="/convenor/groupworks">View Groupwork</a>
			</div>
		
			<footer>
				CO2101 Project<br/>
				Project by: Group 06
			</footer>
		</nav>
	
		<section class="content">
			<h1>Add Groupwork</h1>
	
			<form:form action="/convenor/addGroupwork" modelAttribute="groupwork" class="cwform">
				<form:label path="name">Name</form:label><br/>
				<form:input path="name"></form:input>
				<form:errors class="err" path="name"></form:errors>
				<br/>
				
				<form:label path="groupSize">Max Group Size</form:label><br/>
				<form:input type="number" path="groupSize" required="required"></form:input>
				<form:errors class="err" path="groupSize"></form:errors>
				<br/>
				
				<form:label path="modulePercent">Weight</form:label><br/>
				<form:input type="number" path="modulePercent" required="required"></form:input>
				<form:errors class="err" path="modulePercent"></form:errors>
				
				<form:label path="deadline">Deadline</form:label><br/>
				<form:input type="date" path="deadline" required="required"></form:input>
				<form:errors class="err" path="deadline"></form:errors>
				<br/>
				<br/>
				
				<button type="submit">Submit</button>
			</form:form>
		</section>
	</body>
</html>