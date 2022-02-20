<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add a student</title>
		
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
			<h1>Add a Student <h1>
	
			<form:form action="/convenor/addStudent?groupwork=${groupwork.id}" modelAttribute="student" class="cwform">
				<form:label path="name">Name:</form:label><br/>
				<form:input path="name"></form:input>
				<p>Note: If the user already exists the name won't be updated</p>
				<form:errors class="err" path="name"></form:errors>
				<br/>
				
				<form:label path="username">Username:</form:label><br/>
				<form:input path="username"></form:input>
				<form:errors class="err" path="username"></form:errors>
				<br/>
				
				<form:label path="atRisk">At Risk:</form:label><br/>
				<form:select type="text" path="atRisk" required="required">
					<option value="false">False</option>
					<option value="true">True</option>
    			</form:select>
				<form:errors class="err" path="atRisk"></form:errors>
				<br/>
				<button type="submit">Submit</button>
			</form:form>
		</section>
	</body>
</html>