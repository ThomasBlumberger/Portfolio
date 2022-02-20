<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Dashboard</title>
		
		<link rel="stylesheet" type="text/css" href="css/main.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@700&display=swap" rel="stylesheet">
		<script src="js/main.js"></script>
	</head>
		<script type="text/javascript">
		function setCookie(cname, cvalue, exdays) {
			  const d = new Date();
			  d.setTime(d.getTime() + (exdays*24*60*60*1000));
			  let expires = "expires="+ d.toUTCString();
			  document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
			}
	function getCookie(cname) {
		  let name = cname + "=";
		  let ca = document.cookie.split(';');
		  for(let i = 0; i < ca.length; i++) {
		    let c = ca[i];
		    while (c.charAt(0) == ' ') {
		      c = c.substring(1);
		    }
		    if (c.indexOf(name) == 0) {
		      return c.substring(name.length, c.length);
		    }
		  }
		  return "";
		}
	
	function checkCookie() {
		  let user = getCookie("username");
		  if (user != "") {
		  } else {
		    user = ${user}
		    if (user != "" && user != null) {
		      setCookie("username", user, 365);
		    }
		  }
		}
	</script>
	<body class="dashboardPage">

		<header>
			<a href="/">Dashboard</a>
			<div class="drop_container">
				<button class="dropbutton" onclick="header_dropdown()">Logged in as: ${user}</button>
				
				<div id="dropdown" class="dropdown_contents">
					<a href="/accountInformation">Account Information</a>
					<a href="/logout">Logout</a>
				</div>
			</div>
		</header>

	<div class="content_dash">
	<a class="navigate_btn" href="/admin/newQuestion">Add new question</a>
	<a class="navigate_btn" href="/admin/newResidentInformation">Add resident information</a>
	<a class="navigate_btn" href="/admin/viewQuestions">View questions</a>
	</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</body>
	</html>