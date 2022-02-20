<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		
		<link rel="stylesheet" type="text/css" href="css/main.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@700&display=swap" rel="stylesheet">
	</head>
	
	<body>
		<section class="login_main">
			<section class="login_box">
				<h2>Password Reset Success</h2>
				
				<section class="login_form_container">
					<a href="/login-form">Go to login page</a>
				</section>
				
				<c:if test="${not empty response}">
					<p class="error">
						${response}
					</p>
				</c:if>
			</section> 
		</section>
	</body>
</html>