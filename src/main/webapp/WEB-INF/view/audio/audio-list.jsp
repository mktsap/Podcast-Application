<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="container">
	
		<div id="content">
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Serial no</th>
					<th>Audio Name</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempAudio" items="${audio}">
					<c:url var="playList" value="/author/playlist">
						<c:param name="audioId" value="${tempAudio.id}" />
					</c:url>
				
					<tr>
						<td> ${tempAudio.id} </td>
						<td> ${tempAudio.fileName} </td>
						<c:forEach var="tempPlaylist" items="${playlists}"></c:forEach>
						<td> <a href=${playList}>Add to PlayList</a> </td>
					</tr>
				
				</c:forEach>
					<c:forEach var="tempPlaylists" items="${playlists}">
					<c:url var="playListdetail" value="/author/playlistdetails">
						<c:param name="detailid" value="${tempPlaylists.playlistname}" />
					</c:url>
					
					<td> <a href=${playListdetail}>Add to ${tempPlaylists.playlistname }</a> </td>
					</c:forEach>	
			</table>
			
			
		</div>
	
	</div>

</body>
</html>