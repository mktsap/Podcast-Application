<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css" integrity="sha256-46r060N2LrChLLb5zowXQ72/iKKNiw/lAmygmHExk/o=" crossorigin="anonymous" />
  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
	<c:forEach var="tempplay" items="${audiolist}">
		<!--<c:url value="/resources/audio/${tempplay.fileName }" var="myUrl"/>-->
	
<audio  controls>
  <source src="<c:url value="/resources/audio/${tempplay.fileName }"/>"" type="audio/mpeg">
  Your browser does not support the audio element.
</audio>
</c:forEach>
<p>Click the buttons to play or pause the audio.</p>




</body>
</body>
</html>