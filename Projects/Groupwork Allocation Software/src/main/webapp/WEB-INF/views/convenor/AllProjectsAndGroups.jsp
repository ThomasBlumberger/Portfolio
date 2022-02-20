

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">
<head>
<meta name="csrf-token" content="${_csrf.token}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View student groups</title>
<link rel="stylesheet" type="text/css" href="/css/main.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">

<script src="/js/main.js"></script>
</head>

<body>
	<!-- GLOBAL HEADER -->
	<header>
		<a href="/">CO2101 - Group 06</a>
		<div class="drop_container">
			<button class="dropbutton" onclick="header_dropdown()">Logged
				in as: ${user}</button>

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
			CO2101 Project<br /> Project by: Group 06
		</footer>
	</nav>

	<section class="content">
		<h1>Review Student Groups</h1>
		<h1 style="color: red">${error}</h1>
		<c:forEach items="${projects}" var="project">
			<div class="objdiv">
				
				<div class="dropdown">
					<button class="dropbutton">
						<h1>${project.name}</h1>
					</button>
					<div class="dropdown-content">
						<div class="buttons">
							<a class="nav_button"
								href="/convenor/addGroup?project=${project.id}"><h2>Add Group</h2></a>
						</div>
					</div>
				</div>
			

				<c:forEach items="${project.studentGroups}" var="group">
					<br />
					<div class="dropdown">
						<button class="dropbutton">
							<h3>Group: ${group.id}</h3>
						</button>
						<div class="dropdown-content">
							<div class="buttons">
								<a class="nav_button"
									href="/convenor/deleteGroup?group=${group.id}&groupwork=${groupwork}"><h2>Delete
										Group</h2></a>
							</div>
						</div>
					</div>
					<c:forEach items="${group.studentList}" var="student">

						<div class="dropdown">
							<div class="shiftRight">
							
								<script>
									var atRisk = [[${student.atRisk}]]
									if (atRisk == "true"){
										document.write('<button class="dropbutton"><a class="studentButtonTextRed" href="studentInformation?student=${student.username}&groupwork=${groupwork}">${student.name}</a></button>');
									}
									else{
										document.write('<button class="dropbutton"><a class="studentButtonText" href="studentInformation?student=${student.username}&groupwork=${groupwork}">${student.name}</a></button>');
									}
									 
								</script>
								
								<div class="dropdown-content">

									<form action="/convenor/moveStudent" method="POST"
										autocomplete="off">
										<label><h2>&nbsp;Enter id of group to move to</h2></label> <input
											type="int" name="group"> <input type="hidden"
											name="student" value="${student.username}"> <input
											type="hidden" name="groupwork" value="${groupwork}">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
										<button type="submit">Submit</button>
									</form>
								</div>
							</div>
						</div>
					</c:forEach>
					<br />
				</c:forEach>
			</div>
		</c:forEach>

		</br>
		<div class="objdiv">
		<h2>Unassigned Students</h2>	
		<c:forEach items="${unassigned}" var="unassignedStudent">
			<div class="dropdown">
				<div class="shiftRight">
				
					<script>
						var atRisk = [[${unassignedStudent.atRisk}]]
						if (atRisk == "true"){
							document.write('<button class="dropbutton"><a class="studentButtonTextRed" href="studentInformation?student=${unassignedStudent.username}&groupwork=${groupwork}">${unassignedStudent.name}</a></button>');
						}
						else{
							document.write('<button class="dropbutton"><a class="studentButtonText" href="studentInformation?student=${unassignedStudent.username}&groupwork=${groupwork}">${unassignedStudent.name}</a></button>');
						}
						 
					</script>
				
				
					<div class="dropdown-content">

						<form action="/convenor/moveStudent" method="POST"
							autocomplete="off">
							<label><h2>&nbsp;Enter id of group to move to</h2></label> <input
								type="int" name="group"> <input type="hidden"
								name="student" value="${unassignedStudent.username}"> <input
								type="hidden" name="groupwork" value="${groupwork}">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<button type="submit">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
		<br />
		

		<div class="buts">
			<a class="sec_but"
				href="/convenor/circumstances?groupwork=${groupwork}">View
				Circumstances</a>
		</div>

	</section>

</body>
</html>