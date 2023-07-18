<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>    
<html>    
<head>    
    <title>Register Form</title>    
    <link rel="stylesheet" href="/bankapp/resource/css/style3.css">
      
</head>    
<body>      
				
	<div class="header">
		<jsp:include page="include/header.jsp"></jsp:include>
	</div>
	
	<div class="menu">
		<jsp:include page="include/menu.jsp"></jsp:include>
	</div>
	
	<h2>Register</h2><br>
	<c:if test="${error!=null}">
				<p class="error">${error}</p>
				</c:if> 
				<c:if test="${param.act eq 're'}">
				<p class="success">Registered Successfully ! Login to use banking application</p>
				</c:if> 
				<c:url var="register_url" value="/register"></c:url> 
    <div class="register">    
    <f:form	name = "register" action='${register_url}' modelAttribute="command">  
    	<label><b>Full Name:     
        </b>    
        </label>    
        <f:input name="name" type="name" path="name" />    
        <br><br> 
        <label><b>Gender:     
        </b>   
        </label>   
        <f:radiobutton path="gender" value="Male"/>  Male
        <f:radiobutton path="gender" value="Female"/>  Female
        <br><br> 
        <label><b>Date of Birth:     
        </b>    
        </label>    
        <f:input name="date" type="date" path="dateOfBirth" />    
        <br><br> 
        <label><b>Phone:     
        </b>    
        </label>    
        <f:input name="phone" path="phone" />    
        <br><br> 
        <label><b>Email:     
        </b>    
        </label>    
        <f:input name="email" type="email" path="email" />    
        <br><br> 
        <label><b>Address:     
        </b>    
        </label>    
        <f:input name="address" path="address" />    
        <br><br> 
        <label><b>User Name:     
        </b>    
        </label>    
        <f:input name="loginName" path="loginName" />    
        <br><br>      
        <label><b>Password:     
        </b>    
        </label>    
        <f:input name="password" type="password" path="password" />   
        <br><br>    
        <button >Register</button>       
   </f:form>  
	</div> 

   <br><br><br>
   <br><br><br>
   <br><br><br>
   <br><br><br>
    <div class=footer>
		<jsp:include page="include/footer.jsp"></jsp:include>
	</div>
</body>    
</html>     