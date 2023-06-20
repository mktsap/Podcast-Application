<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<title>Insert title here</title>
</head>
<body>
	<table>
				<tr>
					<th>PlayList</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our c -->
				<c:forEach var="tempPlaylist" items="${playlistdetails}">
				
				<!-- create Update Link -->
				<!--<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>
					
				<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>-->
					<c:url var="playlink" value="/author/play2">
						<c:param name="playnames" value="${tempPlaylist.filename}" />
					</c:url>
					<tr>
						<td> ${tempPlaylist.filename} </td>
						<td><a href="${ playlink}"> Play Audio</a></td>
						<!-- <td><button onClick=window.location.href="${ playlink}">Play this Audio</button></td>-->
						<td>
						
						<!-- add code to prompt the user -->
						<a href="${deleteLink}" onClick="if(!(confirm('Are you sure you want to delete this'))) return false"> delete</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
</body>
</html>