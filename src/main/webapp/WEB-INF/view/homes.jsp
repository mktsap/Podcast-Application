<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/styles.css"/> ">
 <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendors/css/normalize.css"/>">
 <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendors/css/normalize.css"/>">
 <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;1,300&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        
        <link href="https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,100;0,300;0,400;1,300&display=swap" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<style>
header{
/*    to make th image color black so that our text will be displayed properly, use linear-gradient()*/
    background-image:linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)), url(<c:url value="/resources/img/image2.jpg"/>);
    background-size: cover;
    background-position: center;
    background-attachment: fixed;
    height:100vh;
}
</style>
</head>
<body>
 

<header>
<nav>
	<div class="row">
	
	<img src="<c:url value="/resources/img/image1.jpg" />" alt="AudioBook logo" class="logo">
		<ul class="main-nav">
		  <li><a href="login">Admin Login</a>
		  </li>
		  <li >
		    <a href="customerform">Customer Registration</a>
		  </li>
		  <li >
		  	<a  href="../author/authorForm">Author registration</a>
		  </li>
		   
		   <li >
		  	<a  href="../author/loginforauthor">AuthorLogin</a>
		  </li>
		</ul>
	
	 </div>
</nav>
</header>
</body>
</html>