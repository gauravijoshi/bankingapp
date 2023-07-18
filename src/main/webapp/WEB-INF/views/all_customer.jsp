<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All customers</title>
<link rel="stylesheet" href="/bankapp/resource/css/style5.css">
</head>
<body>
<div class="header">
		<jsp:include page="include/header.jsp"></jsp:include>
	</div>
	
	<div class="menu">
		<jsp:include page="include/menu.jsp"></jsp:include>
	</div>
<table >
	<tr>
	    <th>Customer Id</th>
	    <th>Name</th>
	    <th>Gender</th>
	    <th>Date of Birth</th>
	    <th>Phone</th>
	    <th>Email</th>
	    <th>Address</th>
  	</tr>
  	<c:forEach var="user" items="${userList}"> 
  	<tr>
  		<td>${user.userId}</td>
  		<td>${user.name}</td>
  		<td>${user.gender}</td>
  		<td>${user.dateOfBirth}</td>
  		<td>${user.phone}</td>
  		<td>${user.email}</td>
  		<td>${user.address}</td>
  	</tr>
  	</c:forEach> 
	</table>
	
	<br><br><br>
   <br><br><br>
   <br><br><br>
   <br><br><br>
    <div class=footer>
		<jsp:include page="include/footer.jsp"></jsp:include>
	</div>
</body>
</html>