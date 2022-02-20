<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Create Circumstance</title>
		
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
		<h1>Add Circumstances</h1>
		
		<form id="form-shower">
		<select id="myselect">
		<option value="" selected="selected"></option>
		<option value="LiveWith">Live with</option>
		<option value="Other">Other</option>
		</select>
		<br/>
		<br/>
		<p style="color: red">${status}</p>
		<br/>
		<a class="sec_but" href="/student/circumstances?groupwork=${groupwork.id}">Back</a>
		</form>
		
		
	<form:form action="/student/addLivesWithCircumstance?groupwork=${groupwork.id}" modelAttribute = "lwCircumstance" class="cwform" name="LiveWith" id="LiveWith" style="display:none" method="post">
	<form:label path="otherStudent">Live with:</form:label><br/>
	<input name="otherStudent" type="text" required="required"></input>
	<button type="submit">Submit</button>
	<br/>
	<br/>
	<a class="sec_but" href="/student/circumstances?groupwork=${groupwork.id}">Back</a>
	</form:form>
	
	<form:form action="/student/addOtherCircumstance?groupwork=${groupwork.id}" modelAttribute = "oCircumstance" class="cwform" name="Other" id="Other" style="display:none" method="post">
	<form:label path="description">Other:</form:label>
	<form:input path="description" required="required"></form:input>
	<button type="submit">Submit</button>
	<br/>
	<br/>
	<a class="sec_but" href="/student/circumstances?groupwork=${groupwork.id}">Back</a>
	</form:form>
	<br/>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
$("#myselect").on("change", function() {
    $("#" + $(this).val()).show().siblings().hide();
})
</script>
	
		</section>
	</body>
</html>
		