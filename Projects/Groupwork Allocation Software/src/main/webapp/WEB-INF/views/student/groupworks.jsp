<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>View groupworks</title>
		
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
				<a class="nav_button" href="/student/groupworks">View Groupwork</a>
			</div>
		
			<footer>
				CO2101 Project<br/>
				Project by: Group 06
			</footer>
		</nav>
	
		<section class="content">
			<h1>Your Groupwork</h1>
	
			<c:forEach items="${groupworks}" var="groupwork">
				<div class="objdiv">
			 		<h2>${groupwork.get(0).name}</h2>
			 		<p>Convenor: ${groupwork.get(0).author.name}</p>
			 		<p>Module weight: ${groupwork.get(0).modulePercent}%</p>
			  		<p>Group Size: ${groupwork.get(0).groupSize}</p>
			  		<p>Deadline: ${groupwork.get(0).deadline.date}/${groupwork.get(0).deadline.getMonth()+1}/${groupwork.get(0).deadline.getYear()-100}</p>
			  		<br>
			  		<p id="status${groupwork.get(0).id}" style="color:#ff3333"></p>
			  		<script>
		  	       		var released = [[${groupwork.get(0).groupsReleased}]];
						if (released == "true"){
							document.getElementById("status"+${groupwork.get(0).id}).innerHTML = "Groups Released";
							document.getElementById("status"+${groupwork.get(0).id}).style.color = "green";
						}
						else {
							document.getElementById("status"+${groupwork.get(0).id}).innerHTML = "Groups Pending";
						}
			  		</script>
			  		<div class="buts">
						<a class="sec_but" href="/student/circumstances?groupwork=${groupwork.get(0).id}">My Circumstances</a>
			  		
			  			<script>
			  	       		var released = [[${groupwork.get(0).groupsReleased}]];
							if (released == "true"){
								document.write('<a class="sec_but" href="/student/studentGroup?groupwork=${groupwork.get(0).id}">View My Group</a>');
							}
							var submitted = [[${groupwork.get(1)}]]
							if(released != "true" && submitted == "false"){
								document.write('<a class="sec_but" href="/student/projects?groupwork=${groupwork.get(0).id}">View Projects</a>');
							}
			  			</script>
					</div>
			  	</div>
			</c:forEach>
			
		</section>
	</body>
</html>