<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
	<head>
		<meta name="format-detection" content="telephone=no">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>View Groupworks</title>
		
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
			<h1>Your Groupwork</h1>
	
			<c:forEach items="${groupworks}" var="groupwork">
				<div class="objdiv">
			 		<h2>${groupwork.name}</h2>
			  		<p>Group Size: ${groupwork.groupSize}</p>
			  		<p>Module weight: ${groupwork.modulePercent}%</p>
			  		<p>Deadline: ${groupwork.deadline.date}/${groupwork.deadline.getMonth()+1}/${groupwork.deadline.getYear()-100}</p>
			  		<br>
			  		<p id="status${groupwork.id}" style="color:#ff3333"></p>
			  		
			  		<script>
		  	       		var released = [[${groupwork.groupsReleased}]];
						if (released == "true"){
							document.getElementById("status"+${groupwork.id}).innerHTML = "Groups Released";
							document.getElementById("status"+${groupwork.id}).style.color = "green";
						}
						else {
							document.getElementById("status"+${groupwork.id}).innerHTML = "Groups Pending";
						}
			  		</script>
			  		
			  		
			  		
			  		<div class="buts">
			  			<script>
			  				var generated = [[${groupwork.groupsGenerated}]];
			  	       		var released = [[${groupwork.groupsReleased}]];
	
				  	       	if (generated == "true" && released != "true"){
								document.write('<a class="sec_but" onclick="releaseGroupsWarning(event)" href="/convenor/releaseGroups?groupwork=${groupwork.id}">Release Groups</a>');
								document.write('<a class="sec_but" href="/convenor/AllProjectsAndGroups?groupwork=${groupwork.id}">Review Groups</a>');															
							}
				  	      	if (generated == "true" && released == "true"){
								document.write('<a class="sec_but" href="/convenor/AllProjectsAndGroups?groupwork=${groupwork.id}">Review Groups</a>');															
							}
							if (generated != "true"){
								document.write('<a class="sec_but" onclick="formulateGroupsWarning(event)" href="/convenor/formulateGroups?groupwork=${groupwork.id}">Generate Groups</a>');
							}
			  			</script>
			  			
			  			
					  	<a class="sec_but" href="/convenor/projects?groupwork=${groupwork.id}">View Projects</a>
					  	
					  	<c:if test="${groupwork.projects.size() != 0}">
							<a class="sec_but" href="/convenor/students?groupwork=${groupwork.id}">View Students</a>
						</c:if>

					  	<c:if test="${groupwork.groupsReleased == false}">
							<a class="sec_but" href="/convenor/sendReminder?groupwork=${groupwork.id}">Send Reminder</a>
						</c:if>
					  	
					  	<a class="sec_but" onclick="removeGroupworkWarning(event)" href="/convenor/removeGroupwork?groupwork=${groupwork.id}">Remove</a>
					</div>
			  	</div>
			  		
			</c:forEach>
			
			
			<a class="sec_but" href="/convenor/newGroupwork">Add Groupwork</a>
		</section>
	</body>
</html>