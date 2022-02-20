<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List of Hotels</title>
</head>
<body>
<c:forEach items="${rooms}" var="room">
	<p>The room name is: ${room.name}. The description is: ${room.description}. The category is: ${room.category}<a href="/newRoom?hotel=${hotel}"> Rooms </a></p>
</c:forEach>
</body>
</html>