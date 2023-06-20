<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					<th>File Name</th>
					<th>Author Id</th>
					
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempPending" items="${pending}">
				
				<!-- create Update Link -->
				<c:url var="approveLink" value="/customer/approve">
						<c:param name="audioId" value="${tempPending.id}" />
					</c:url>
				<c:url var="declineLink" value="/customer/decline">
						<c:param name="audioId" value="${tempPending.id}" />
					</c:url>
					<tr>
						<td> ${tempPending.id} </td>
						<td> ${tempPending.fileName} </td>
						
						<td>
						<!-- display update href -->
						<a href="${approveLink}">Approve</a>
						</td>
						
						<td>
						
						<!-- add code to prompt the user -->
						<a href="${declineLink}" onClick="if(!(confirm('Are you sure you want to delete this'))) return false"> Decline</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
			
			
		</div>
	
	</div>
	

</body>
</html>