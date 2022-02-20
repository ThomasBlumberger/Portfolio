<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>View Options</title>
		
		<script src="https://rawgit.com/sitepoint-editors/jsqrcode/master/src/qr_packed.js"></script>
		<link rel="stylesheet" type="text/css" href="/css/main.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@700&display=swap" rel="stylesheet">
		<script src="/js/main.js"></script>
	</head>
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
	<section class="content">
	<h1>Options</h1>
	<section class="createUser_main">
	<section class="createUser_box">
	<h1 id="createUser_title">Answer Question</h1>
	<form:form modelAttribute="response" class="createAccForm" method="post" action="/resident/answeredQuestion?question=${questionID}">
	
	<c:forEach items="${options}" var="response">
	<div class="objdiv">
	<label id="radioLabel">${response.questionOption}<form:radiobutton path="questionResponse" required="true" name="radioBut" value="${response.id}"></form:radiobutton></label>
	<br/>
	</div>
	</c:forEach>
	<form:hidden path="user" value="${userID}"/>
	<button type="submit">Submit</button>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form:form>	
			</section>
			</section>
			</section>
	</body>
</html>