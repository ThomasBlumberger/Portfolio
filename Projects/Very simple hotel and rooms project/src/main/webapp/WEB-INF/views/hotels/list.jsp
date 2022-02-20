<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List of Hotels</title>
</head>
<body>
<c:forEach items="${hotels}" var="hotel">
	<p>The Hotel's name is: ${hotel.name}. The description is: ${hotel.description}<a href="/rooms?hotel=${hotel.id}"> Rooms </a></p>
</c:forEach>
</body>
</html>