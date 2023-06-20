<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendors/css/grid.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendors/css/normalize.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendors/css/normalize.css"/>">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;1,300&display=swap" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
 	
	<div class="row">
	<img src/>
	<form:form action="../author/searchAudio" method="POST" modelAttribute="author">
	
	<h1>Welcome to AudioBook ${author.username } </h1>
	
	
	   <c:forEach var="table" items="${authorobj}">
	   <c:url var="viewplaylist" value="/author/viewPlaylist" >
		
						<c:param name="authorId" value="${table.id}" />
					</c:url>
			<c:url var="uploads" value="/author/upload" >
		
						<c:param name="authorId" value="${table.id}" />
				</c:url>
				<c:url var="createplaylist" value="/author/createPlaylist" >
		
						<c:param name="authorId" value="${table.id}" />
				</c:url>
				<c:url var="viewplaylists" value="/author/viewPlaylists" >
		
						<c:param name="authorId" value="${table.id}" />
				</c:url>		
	   		</c:forEach>
				
				
				Search Audio: <input type="text" name="audioName" />
				<input type="submit" value="Search"  />
				
			</form:form>
		
			<br><br>
				<ul>
				<li class="nav-item">
  					<a class="nav-link" href="${uploads}">Upload</a>
		  			<a class="nav-link"  href="${viewplaylist}">View PlayList</a>
		  			<a href="${createplaylist }">create a new playlist</a><br>
		  			<a href="${viewplaylists }">view Playlists</a>
		  			</li>
				</ul>
	</div>	
</body>
</html>