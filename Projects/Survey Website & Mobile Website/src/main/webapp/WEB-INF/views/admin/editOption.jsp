<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edit Question</title>
		
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
	<section class="createUser_main">
	<section class="createUser_box">
			<h1 id="createUser_title">Edit Option</h1>
			<form:form modelAttribute="option" class="createAccForm" method="post" action="/admin/editedOption?question=${option.question.ID}&option=${option.id}">
				<form:label path="questionOption">Option:</form:label><br/>
				<form:input path="questionOption" required="required" placeholder="Enter the option"></form:input>
				<form:errors class="err" path="questionOption"></form:errors>
				<br/>
				
				<c:if test="${not empty userError}">
				<p class="error">
					${userError}
				</p>
			</c:if>
				
				<button type="submit">Submit</button>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form:form>
			
			</section>
		</section>
	</body>
</html>