<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

	<title>Save Customer</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	<%@ include file="homes.jsp" %>  
	<div id="wrapper">
		<div id="header">
			<h2>Customer Form</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>
	
	<form:form action="saveAuthor" modelAttribute="author" method="POST">
	<form:hidden path="id"/>
  <div class="form-group">
    <label for="exampleInputfirst">FirstName</label>
    <form:input type="text" class="form-control col-md-4" path="first_name" id="exampleInputfirst"  placeholder="Enter FirstName"/>
    
  </div>
  <div class="form-group">
    <label for="exampleInputlast">LastName</label>
    <form:input type="text" path="last_name" class="form-control col-md-4" id="exampleInputlast" placeholder="Enter LastName"/>
  </div>
  <div class="form-group">
    <label for="exampleInputuser">Username</label>
    <form:input type="text" path="username" class="form-control col-md-4" id="exampleInputuser" placeholder="Enter username"/>
  </div>
  <label for="exampleInputEmail1">Email address</label>
    <form:input type="email" path="email" class="form-control col-md-4" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/>
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    <div class="form-group">
    <label for="exampleInputpass">Password</label>
    <form:input type="text" path="password" class="form-control col-md-4" id="exampleInputpass" placeholder="Enter Password"/>
  </div>
    country:
		<br><br>
		<form:select path="country">
		<c:forEach var="prof" items="${thecountryOptions}">
     		<form:option value="${prof.key}" label="${prof.value}" />
   		</c:forEach>
			<!--<form:options items="${thecountryOptions}" />-->
			
		</form:select>
  <br><br>
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










