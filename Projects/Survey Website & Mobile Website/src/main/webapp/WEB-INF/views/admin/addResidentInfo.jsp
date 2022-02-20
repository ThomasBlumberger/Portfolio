<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add Resident Information</title>
		
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
			<h1 id="createUser_title">Add Resident Information</h1>
			<form:form modelAttribute="newResidentInfo" class="createAccForm" method="post" action="/admin/addResidentInformation">
				<form:label path="fullName">Full Name:</form:label><br/>
				<form:input path="fullName" required="required" placeholder="Enter residents full name"></form:input>
				<form:errors class="err" path="fullName"></form:errors>
				<br/>
				
				<form:label path="sni">Shangri-La National Insurance:</form:label><br/>
				<form:input path="sni" id="sni_value" required="required" placeholder="Enter residents SNI" maxlength="8" minlength="8"></form:input><a id="btn-scan-qr"><img src="https://dab1nmslvvntp.cloudfront.net/wp-content/uploads/2017/07/1499401426qr_icon.svg"></a>
				<form:errors class="err" path="sni"></form:errors>
				<br/>
				 <div id="container">
      <canvas hidden="" id="qr-canvas"></canvas>

      <div id="qr-result" hidden="">
        <b>Data:</b> <span id="outputData"></span>
      </div>
    </div>
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
		<script src="/js/qsCodeScanner.js"></script>
	</body>
</html>