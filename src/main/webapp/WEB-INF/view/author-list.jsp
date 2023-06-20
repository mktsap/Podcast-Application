<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
<!--  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"> -->
</head>

<body>
<%@ include file="homes.jsp" %>  
	<div id="wrapper">
		<div id="header">
		
		<!-- Add button to save customer -->
		<input type="button" value="Add Author"
			onClick="window.location.href='showFormForAdd';return false;" class="addButton"/>
			
			<!--  add a search box -->
			<form:form action="search" method="GET">
				Search customer: <input type="text" name="theSearchName" />
				
				<input type="submit" value="Search" class="add-button" />
			</form:form>
			
			<h2>Author List</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempAuthor" items="${author}">
				
				<!-- create Update Link -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="authorId" value="${tempAuthor.id}" />
					</c:url>
				<c:url var="deleteLink" value="/customer/delete">
						<c:param name="authorId" value="${tempAuthor.id}" />
					</c:url>
					<tr>
						<td> ${tempAuthor.first_name} </td>
						<td> ${tempAuthor.last_name} </td>
						<td> ${tempAuthor.email} </td>
						<td>
						<!-- display update href -->
						<a href="${updateLink}">Update</a>
						</td>
						
						<td>
						
						<!-- add code to prompt the user -->
						<a href="${deleteLink}" onClick="if(!(confirm('Are you sure you want to delete this'))) return false"> delete</a>
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
			
			
		</div>
	
	</div>
	

</body>

</html>