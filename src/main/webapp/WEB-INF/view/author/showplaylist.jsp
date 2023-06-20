<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="tempplay" items="${playlists}">
					
				<c:url var="showdetails"  value="/author/showdetail">
					<c:param name="showid" value="${tempplay.id}" />
				</c:url>
					<tr>
						<td> ${tempplay.id} </td>
						<td><a href=" ${showdetails }">${tempplay.playlistname}</a> </td>
						
					</tr>
				
				</c:forEach>
</body>
</html>