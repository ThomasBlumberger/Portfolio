<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>View Groupwork</title>
		
		<link rel="stylesheet" type="text/css" href="/css/main.css">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
		
		<script src="/js/main.js"></script>
	</head>
	
	<body onload="function();">
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
			
			<h1>Student Information</h1>
			<div class="objdiv">
				<h3>&nbsp; Name: &nbsp; ${student.name}</h3>
				<h3>&nbsp; Username: &nbsp; ${student.username}</h3>
				<script>
					var atRisk = [[${student.atRisk}]];
					if (atRisk == "true"){
						document.write('<h3>&nbsp; At Risk: &nbsp; True</h3>');	
					}
					else {
						document.write('<h3>&nbsp; At Risk: &nbsp; False</h3>')
					}
				</script>
			</div>
			<div class="objdiv">
				<h1>Preferences (from most to least favourite): </h1><br/>
				<h3>${selection}</h3>
			<br/>
			</div>
			
			<a class="sec_but" href="/convenor/AllProjectsAndGroups?groupwork=${groupworkID}">Back</a>
			
		</section>
	</body>
</html>