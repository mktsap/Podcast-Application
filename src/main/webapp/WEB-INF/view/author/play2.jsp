<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="tempplay" items="${audiolist}">
		<!--<c:url value="/resources/audio/${tempplay.fileName }" var="myUrl"/>-->
	
<audio  controls>
  <source src="<c:url value="/resources/audios/${tempplay.fileName }"/>"" type="audio/mpeg">
  Your browser does not support the audio element.
</audio>
</c:forEach>
<p>Click the buttons to play or pause the audio.</p>

</body>
</html>