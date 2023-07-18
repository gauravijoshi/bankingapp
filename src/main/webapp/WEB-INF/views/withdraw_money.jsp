<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>    
<html>    
<head>    
    <title>Withdraw</title>    
    <link rel="stylesheet" href="/bankapp/resource/css/style11.css">    
</head>    
<body>      
				
	<div class="header">
		<jsp:include page="include/header.jsp"></jsp:include>
	</div>
	
	<div class="menu">
		<jsp:include page="include/menu.jsp"></jsp:include>
	</div>
	
	<c:if test="${error!=null}">
				<p class="error">${error}</p>
				</c:if> 
				<c:if test="${param.act eq 'wi'}">
				<p class="success">Withdrawn Successfully</p>
				</c:if> 
				<c:url var="withdraw_url" value="/withdraw"></c:url> 
    <div class="withdraw">    
    <f:form	action='${withdraw_url}' modelAttribute="withdraw">  
    	<label><b> Enter the account number:     
        </b>    
        </label>    
        <f:input path="accountNumber" />    
        <br><br> 
    	<label><b>Enter Amount:     
        </b>    
        </label>    
        <f:input path="accountBalance" />    
        <br><br> 
        <button>Withdraw</button>       
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