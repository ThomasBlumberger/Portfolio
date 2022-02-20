<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>View Projects</title>
		
		<link rel="stylesheet" type="text/css" href="/css/main.css">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
		
		<script src="/js/main.js"></script>
		
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  		
  		<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
		<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
		<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jqueryui-touch-punch/0.2.3/jquery.ui.touch-punch.min.js"></script>
  		<script>
		  $( function() {
		    $( "#sortable" ).sortable();
		    $( "#sortable" ).disableSelection();
		  } );
		</script>
		
		
		<style>
			#sortable { list-style-type: none; margin: 0; padding: 0; width: 100%; }
			#sortable li { font-size: 1.4em; height: auto; width: 100%; }
			#sortable li span { position: absolute; margin-left: -1.3em; }
	  	</style>
	  
	  
	  	<script>
			function custom_submit() {
				var sortedOrder = $("#sortable").sortable("toArray");
				var frm = document.forms['selectprojs']
				
				for (i = 0; i < frm.elements.length; i++) {
					if (frm.elements[i].name != "groupwork" && frm.elements[i].name != "_csrf") {
						frm.elements[i].value = sortedOrder.indexOf(frm.elements[i].id) + 1;
					}
				}

				frm.submit();
			}
	  	</script>
	  	
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
			<h1>${groupworkName} Project choices</h1>
			<h2>Please drag the modules in the order of your preference from best to worse</h2>
			<br/>
	
			<ul id="sortable">
				<c:forEach items="${projects}" var="project" varStatus="loop">
					<li id="${project.id}" onmouseover="" style="cursor: pointer;"> 
						<div class="objdiv">
					 		<h2>${project.name}</h2>
					 		<p>Description: ${project.description}</p>
					  		<p>Max number of projects: ${project.maxNumOfProjects}</p>
					  		<br>
					  	</div> 
				  	</li>  	
				</c:forEach>
			</ul>
			
			<form action="/student/selectProjects?groupwork=${groupwork.id}" id='selectprojs' class="cwform" method="post">
				<c:forEach items="${projects}" var="project"> 
					<input type="hidden" id="${project.id}" name="${project.id}"/>
				</c:forEach>
				<button type="button" onclick="submitPreferenceWarning(); custom_submit()">Submit</button>	
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
		</section>
		
		
	</body>
</html>