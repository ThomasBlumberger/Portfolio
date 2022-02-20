<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>View Questions</title>
		
		<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
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
	<c:forEach items="${questions}" var="question">
	<div class="objdiv">
	<h2>${question.title}</h2>
		<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
    	  
    	  var frequency = ${countNum}
    	  var chartData = [];
    	  Object.keys(frequency).forEach(function (name){
    		  chartData.push([name, frequency[name]]);
    	  });
    	  console.log(chartData);
        var data = google.visualization.arrayToDataTable(chartData, true);
        
        var options = {
          title: '${question.title} \n Responses: ${countRes}',
          sliceVisibilityThreshold:0,
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
     <script type="text/javascript">			 
 // This example requires the Visualization library. Include the libraries=visualization
 // parameter when you first load the API. For example:
 // <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB41DRUbKWJHPxaFjMAwdrzWzbVKartNGg&libraries=visualization">
 let map, heatmap;

 function initMap() {
	 
	  chartData1 = ${longlat}
	  latLngArray = [];
	  heatMapData=[];
	  
	  Object.keys(chartData1).forEach(function (dta){
		  latLngArray.push([dta, chartData1[dta]]);
	  });
	  console.log(latLngArray);
	  for (i=0; i<latLngArray.length; i++){
		  const tempLat = latLngArray[i][0];
		  const tempLong = latLngArray[i][1];
		  const tempVar = new google.maps.LatLng(tempLat, tempLong);
		  console.log(tempLat, tempLong);
		  heatMapData.push(new google.maps.LatLng(tempLat, tempLong));
	  }
	

   map = new google.maps.Map(document.getElementById("map"), {
     zoom: 13,
     center: { lat: 52.622, lng: -1.124 },
     mapTypeId: "satellite",
   });
   heatmap = new google.maps.visualization.HeatmapLayer({
     data: heatMapData,
     map:map
   });
   document
     .getElementById("toggle-heatmap")
     .addEventListener("click", toggleHeatmap);
   document
     .getElementById("change-gradient")
     .addEventListener("click", changeGradient);
   document
     .getElementById("change-opacity")
     .addEventListener("click", changeOpacity);
   document
     .getElementById("change-radius")
     .addEventListener("click", changeRadius);
 }

 function toggleHeatmap() {
   heatmap.setMap(heatmap.getMap() ? null : map);
 }

 function changeGradient() {
   const gradient = [
     "rgba(0, 255, 255, 0)",
     "rgba(0, 255, 255, 1)",
     "rgba(0, 191, 255, 1)",
     "rgba(0, 127, 255, 1)",
     "rgba(0, 63, 255, 1)",
     "rgba(0, 0, 255, 1)",
     "rgba(0, 0, 223, 1)",
     "rgba(0, 0, 191, 1)",
     "rgba(0, 0, 159, 1)",
     "rgba(0, 0, 127, 1)",
     "rgba(63, 0, 91, 1)",
     "rgba(127, 0, 63, 1)",
     "rgba(191, 0, 31, 1)",
     "rgba(255, 0, 0, 1)",
   ];

   heatmap.set("gradient", heatmap.get("gradient") ? null : gradient);
 }

 function changeRadius() {
   heatmap.set("radius", heatmap.get("radius") ? null : 20);
 }

 function changeOpacity() {
   heatmap.set("opacity", heatmap.get("opacity") ? null : 0.2);
 }
    </script>
	</div>
	</c:forEach>
	<div id="piechart" style="width: 100%; height: 500px;"></div><br><br>
	
	 <div id="floating-panel">
      <button id="toggle-heatmap">Toggle Heatmap</button>
      <button id="change-gradient">Change gradient</button>
      <button id="change-radius">Change radius</button>
      <button id="change-opacity">Change opacity</button>
    </div>
    <div id="map"></div>
    		 		<script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBzqAq7PAYMX6Frog_lHIdsz3MmpXaZVq0&callback=initMap&libraries=visualization&v=weekly"
      async
    ></script>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</section>
	</body>
</html>