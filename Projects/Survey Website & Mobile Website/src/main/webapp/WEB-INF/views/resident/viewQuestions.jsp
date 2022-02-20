<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>View Questions</title>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
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
	<h1>Questions</h1>
	<input type="hidden" id="questionCheck1" value="${questionCheck1}"/>
	
	<c:forEach items="${questions}" var="question">
	<c:if test="${not empty question.options}">
	<div class="objdiv">
	<h2>${question.title}</h2>
	<div class="buts">
	<c:choose>
	<c:when test="${questionCheck1.contains(question.ID)}">
				<label class="answered_label">You have answered this question</label>
				</c:when>
	<c:when test="${not questionCheck1.contains(question.ID)}">
		<a class="sec_but" href="/resident/answerQuestion?question=${question.ID}">Answer question</a>
				</c:when>
				</c:choose>
	</div>
	</div>
	</c:if>
	</c:forEach>
	
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</section>
	</body>
</html>