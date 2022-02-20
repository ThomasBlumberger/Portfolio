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
				<h2>Reset Password</h2>
				
				<section class="login_form_container">
					<form action="/performPasswordReset" method="post"> 
						<label for="pass1">New password</label>
				   		<input type="password" name="pass1" placeholder="Enter your new password" required/>
				   		
				   		<label for="pass2">Reenter new password</label>
				   		<input type="password" name="pass2" placeholder="Reenter your new password" required/>
				   		
						<button type="submit">Reset</button>
						
				   		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				   		<input type="hidden" name="key" value="${reqkey}"/>
					</form>
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