<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>View students in ${groupwork.name}</title>
		
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
			
			<h1>Students in ${groupwork.name}</h1>
	
			<c:forEach items="${groupwork.students}" var="student">
				<div class="objdiv-inline">
			  		<p>${student.name}</p>

			  		<div class="buts">
			  			<a class="sec_but" href="/convenor/removeStudent?username=${student.username}&&groupwork=${groupwork.id}">Remove</a>
					</div>
			  	</div>
			</c:forEach>
			<br>
			<h1>Add New Students</h1>
			<br/>
			<a class="sec_but" href="/uploadCSV?groupworkId=${groupwork.id}">Upload file</a>
			<a class="sec_but" href="manuallyAddStudent?groupworkId=${groupwork.id}">Manually</a>
		</section>
	</body>
</html>