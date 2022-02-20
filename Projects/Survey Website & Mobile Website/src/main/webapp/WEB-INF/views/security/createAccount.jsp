<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Create Account</title>
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
		<script src="https://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
		<script src="https://rawgit.com/sitepoint-editors/jsqrcode/master/src/qr_packed.js"></script>
		<link rel="stylesheet" type="text/css" href="css/main.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Open+Sans+Condensed:wght@700&display=swap" rel="stylesheet">
		<script src="/js/main.js"></script>
		 <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBzqAq7PAYMX6Frog_lHIdsz3MmpXaZVq0&callback=initAutocomplete&libraries=places&v=weekly"
      async
	  ></script>
	  <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
	</head>
	<body id="createAccBody">
	 <script>
$(function() {
  $("#datepicker").datepicker(
    {
      minDate: new Date(1900,1-1,1), maxDate: '-18Y',
      dateFormat: 'dd/mm/yy',
      changeMonth: true,
      changeYear: true,
      yearRange: '-100:-18'
    }
  );                    
});
  </script>
	<section class="createAcc_main">
	<section class="createAcc_box">
			<h1 id="createAcc_title">Create Account</h1>
			<form:form modelAttribute="resident" class="createAccForm" method="post" action="/addResident">
				<form:label path="fullName">Full Name:</form:label><br/>
				<form:input path="fullName" required="required" placeholder="Enter your full name"></form:input>
				<form:errors class="err" path="fullName"></form:errors>
				<br/>
				
				<form:label path="userid">Email:</form:label><br/>
				<form:input path="userid" required="required" type="email" placeholder="Enter your resident email"></form:input>
				<form:errors class="err" path="userid"></form:errors>
				<br/>
				
				<form:label path="password">Password:</form:label><br/>
				<form:input path="password" required="true" type="password" placeholder="Enter a password"></form:input>
				<form:errors class="err" path="password"></form:errors>
				<br/>

				<form:label path="DOB">Enter your DOB:</form:label><br/>
				<form:input path="DOB" id="datepicker" name="datepicker" type="text" required="true" placeholder="Enter your Date of Birth"></form:input>
				<form:errors class="err" path="DOB"></form:errors>
				<br/>
				
				<form:label path="address.postcode">Start entering your postcode or location</form:label><br/>
				<form:input path="address.postcode" required="true" id="postcode" name="postcode" placeholder="Enter your postcode"></form:input>
				<form:errors class="err" path="address.postcode"></form:errors>
				<br/>
				
				<form:label path="address.houseNumber">Enter your residence number:</form:label><br/>
				<form:input path="address.houseNumber" required="true" id="address2" name="address2" placeholder="e.g. 121A"></form:input>
				<form:errors class="err" path="address.houseNumber"></form:errors>
				<br/>
				
				<form:label path="address.street">Enter the street name:</form:label><br/>
				<form:input path="address.street" required="true" id="ship-address" name="ship-address" placeholder="Your street will autofill" disabled="true"></form:input>
				<form:errors class="err" path="address.street"></form:errors>
				<br/>
				
				<form:label path="address.city">Enter the city you live in:</form:label><br/>
				<form:input path="address.city" required="true" id="postal_town" name="postal_town" placeholder="Your city will autofill" disabled="true"></form:input>
				<form:errors class="err" path="address.city"></form:errors>
				<br/>
				
				<form:label path="address.country">Enter your country:</form:label><br/>
				<form:input path="address.country" id="country" name="country" required="true" placeholder="Your country will autofill" disabled="true"></form:input>
				<form:errors class="err" path="address.country"></form:errors>
				<br/>	
				
				<form:label path="sni">Enter your Shangri-La National Insurance Number (SNI):</form:label>
				<form:input path="sni" id="sni_value" required="true" placeholder="Enter your sni" minValue="8" maxValue="8"></form:input><a id="btn-scan-qr"><img src="https://dab1nmslvvntp.cloudfront.net/wp-content/uploads/2017/07/1499401426qr_icon.svg"></a>
				<form:errors class="err" path="sni"></form:errors>
				<br/>
				
				<form:hidden path="address.latitude" name="latitude" id="latitude" required="true"></form:hidden>
				<form:hidden path="address.longitude" name="longitude" id="longitude" required="true"></form:hidden>
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
   
	 <script src="js/qsCodeScanner.js"></script>
	</body>
</html>