<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
<form:form action="logins" modelAttribute="admin">
		
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
				
					<tr>
						<td><label>Password: </label></td>
						<td><form:input path="password" type="password" /></td>
					</tr>

					

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="login" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	

</body>
</html>