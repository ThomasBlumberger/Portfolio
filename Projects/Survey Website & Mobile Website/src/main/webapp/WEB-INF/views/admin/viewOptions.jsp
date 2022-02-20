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
	
	<c:forEach items="${options}" var="option">
	<div class="objdiv">
	<h2>${option.questionOption}</h2>
	<div class="buts">
	<a class="sec_but" href="/admin/editOption?question=${option.question.ID}&option=${option.id}">Edit option</a>
	<a class="sec_but" href="/admin/removeOption?question=${option.question.ID}&option=${option.id}">Delete option</a>
	</div>
	</div>
	</c:forEach>
	
	<a class="sec_but" href="/admin/newOption?question=${questionID}">Add Option</a>
	<a class="sec_but" href="/admin/viewQuestions">Back to questions</a>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</section>
	</body>
</html>