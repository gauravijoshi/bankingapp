<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>    
<html>    
<head>    
    <title>Delete Account</title>    
    <link rel="stylesheet" href="/bankapp/resource/css/style10.css">    
</head>    
<body>      
				
	<div class="header">
		<jsp:include page="include/header.jsp"></jsp:include>
	</div>
	
	<div class="menu">
		<jsp:include page="include/menu.jsp"></jsp:include>
	</div>
	
	<c:if test="${err!=null}">
				<p class="error">${err}</p>
				</c:if> 
				<c:if test="${param.act eq 'up'}">
				<p class="success">Account is inactivated!</p>
				</c:if> 
				<c:url var="delete_url" value="/delete"></c:url> 
    <div class="delete">    
    <f:form	action='${delete_url}' modelAttribute="delete_account">  
    	<label><b> Enter the account number of account to be inactivate:     
        </b>    
        </label>    
        <f:input type="id" path="accountNumber" />    
        <br><br>
        <label><b>Date of Closure:     
        </b>    
        </label>    
        <f:input type="date" path="dateOfClosure" />    
        <br><br>   
        <button>Inactivate</button>       
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