<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<link rel="stylesheet" type="text/css" href="css/main.css">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@700&display=swap" rel="stylesheet">
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
		  var user = getCookie("username");
		  if (user != "") {
			  document.getElementById("username").value = getCookie("username");
		  }
	}
	
	function putCookie(form)
    //this should set the UserName cookie to the proper value;
{
setCookie("username", form[0].username.value);

return true;
}
	</script>
	<body id="loginBody" onload="checkCookie()">
		<section class="login_main">
			<section class="login_box">
				<h1>Shangri-La Council</h1>
				<h2>e-Survey Shangria-La</h2>
				<section class="login_form_container">
					<form action="/myLogin" method="POST"> 
						<label for="username">User ID:</label>
				   		<input type="text" id="username" name="username" placeholder="Enter User ID" required  />
				   		<label for="password">Password:</label>
				   		<input type="password" name="password" placeholder="Enter password" required/>
				   		<h4 id="noAccount">No account?</h4>
				   		<h4 id="createAcc"><a href="/newResident">Create Account</a></h4>
				   		<p></p><h4 id="LoginIssue">Can't Login?</h4>
				   		<h4 id="forgotPass"><a href="/resident">Forgot Password?</a></h4>
						<button type="submit" onclick="putCookie(document.getElementsByTagName('form'));">Login</button>
				   		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
				</section>
				<c:if test="${not empty error}">
					<p class="error">
						${error}
					</p>
				</c:if>
			</section> 
		</section>
	</body>
</html>