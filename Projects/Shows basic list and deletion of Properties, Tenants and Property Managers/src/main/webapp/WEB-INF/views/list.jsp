<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List of Objects</title>
</head>
<body>

	<h2>Properties</h2>
	<c:forEach items="${propertys}" var="property">
	<p>${property}
	</c:forEach>
	
	<h2>Tenants</h2>
	<c:forEach items="${tenants}" var="tenant">
	<p>${tenant}</p>
	</c:forEach>
	
	<h2>Property Managers</h2>
	<c:forEach items="${propertymanagers}" var="pm">
	<p>${pm}</p>
	</c:forEach>
</body>
</html>