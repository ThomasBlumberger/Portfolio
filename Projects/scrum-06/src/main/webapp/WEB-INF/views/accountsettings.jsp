<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Account Settings</title>
		
		<link rel="stylesheet" type="text/css" href="css/main.css">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
		
		<script src="js/main.js"></script>
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
				<a class="nav_button" href="groupworks">View Groupwork</a>
			</div>
		
			<footer>
				CO2101 Project<br/>
				Project by: Group 06
			</footer>
		</nav>
	
		<section class="content">
			<h1>Account Settings</h1>

			<form action="" class="cwform">
				<label for="username">Username</label>
				<input type="text" name="username" placeholder="${user}" readonly></input>
				<br/><br/>
				<label for="email">Email</label>
				<input type="text" name="email" placeholder="${email}" readonly/>
			</form>
			
			<form action="/changeEmail" class="cwform" method="post">
				<label for="email1">Change email address</label>
				<input type="email" name="email1" placeholder="Enter new email" required/>
				<input type="email" name="email2" placeholder="Reenter new email" required/>
				<button type="submit">Submit</button>
				
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			<c:if test="${not empty emailerrors}">
				<p class="error">
					${emailerrors}
				</p>
			</c:if>
			
			<form action="/changePassword" class="cwform" method="post">
				<label for="pass1">Change password</label>
				<input type="password" name="pass1" placeholder="Enter new password" required/>
				<input type="password" name="pass2" placeholder="Reenter new password" required/>
				<button>Submit</button>
				
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
			<c:if test="${not empty passerrors}">
				<p class="error">
					${passerrors}
				</p>
			</c:if>
		</section>
	</body>
</html>