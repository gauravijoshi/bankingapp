<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>    
<html>    
<head>    
    <title>Login Form</title>    
    <link rel="stylesheet" href="/banking-service/resource/css/style2.css">  
    
    <style>
     
.login{  
        width: 382px;  
        overflow: hidden;  
        margin: auto;  
        margin: 20 0 0 450px;  
        padding: 80px;  
        background: #D2B48C;  
        border-radius: 10px ;  
        text-align: center;   
}  

.header{
	width: 100%;
	background: #D2B48C;
	text-align: left; 
	margin-top: 0;
}

.menu{
	width: 100%;
	background:#D2B48C;
	text-align: left; 
	height: 40px;
}

h2{  
    text-align: center;  
    color: black;  
    padding: 20px;  
}  
label{  
    color: black;  
    font-size: 17px;  
}  
button{  
    width: 100px;  
    height: 30px;  
    border: none;  
    border-radius: 17px;  
    padding-left: 7px;  
    color: blue;  
}

.footer{
	width: 100%;
	background:#D2B48C;
	text-align: center;
	height: 70px; 
	bottom: 0px;
}  


.error{
	 text-align: center;
    color: red;
}
.success{
	text-align: center;
    color: green;
}
</style>  
</head>    
<body>      
				
	<div class="header">
		<jsp:include page="include/header.jsp"></jsp:include>
	</div>
	
	<div class="menu">
		<jsp:include page="include/menu.jsp"></jsp:include>
	</div>
	
	<h2>Login</h2><br>
	<c:if test="${err!=null}">
				<p class="error">${err}</p>
				</c:if> 
				<c:if test="${param.act eq 'lo'}">
				<p class="success">Logout Successfully ! Thanks for using banking application</p>
				</c:if> 
				<c:url var="user_url" value="/login"></c:url> 
    <div class="login">    
    <f:form	action='${user_url}' modelAttribute="command">    
        <label><b>User Name:     
        </b>    
        </label>    
        <f:input path="loginName" />    
        <br><br>    
        <label><b>Password:     
        </b>    
        </label>    
        <f:input path="password" />   
        <br><br>    
        <button>Login</button>       
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