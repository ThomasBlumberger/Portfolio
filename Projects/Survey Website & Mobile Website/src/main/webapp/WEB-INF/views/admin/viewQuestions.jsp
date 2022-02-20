<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>View Questions</title>
		
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
	<div class="objdiv">
	<h2>${question.title}</h2>
	<div class="buts">
	<c:choose>
	<c:when test="${questionCheck1.contains(question.ID) && question.hiddenFromResident == false}">
	<a class="sec_but" href="/admin/viewResults?question=${question.ID}">View results</a>
	<a class="sec_but" href="/admin/removeQuestion?question=${question.ID}">Delete question</a>
	<a class="sec_but" onclick="hideQuestionWarning(event)" href="/admin/hideQuestion?question=${question.ID}">Hide from residents</a>
	</c:when>
	<c:when test="${questionCheck1.contains(question.ID) && question.hiddenFromResident == true}">
	<a class="sec_but" href="/admin/viewResults?question=${question.ID}">View results</a>
	<a class="sec_but" href="/admin/removeQuestion?question=${question.ID}">Delete question</a>
	<a class="sec_but" onclick="showQuestionWarning(event)" href="/admin/showQuestion?question=${question.ID}">Show question to residents</a>
	</c:when>
	<c:when test="${not questionCheck1.contains(question.ID)}">
	<a class="sec_but" href="/admin/editQuestion?question=${question.ID}">Edit question title</a>
	<a class="sec_but" href="/admin/viewOptions?question=${question.ID}">View Options</a>
	<a class="sec_but" href="/admin/removeQuestion?question=${question.ID}">Delete question</a>
	</c:when>
	</c:choose>
	</div>
	</div>
	</c:forEach>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			
			</section>
	</body>
</html>