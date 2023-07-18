<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>    
<html>    
<head>    
    <title>Fund Transfer</title>    
    <link rel="stylesheet" href="/bankapp/resource/css/style12.css">    
</head>    
<body>      
				
	<div class="header">
		<jsp:include page="include/header.jsp"></jsp:include>
	</div>
	
	<div class="menu">
		<jsp:include page="include/menu.jsp"></jsp:include>
	</div>
	
	<h2>Fund Transfer</h2><br>
	<c:if test="${error!=null}">
				<p class="error">${error}</p>
				</c:if> 
				<c:if test="${param.act eq 'fu'}">
				<p class="success">Fund Transferred Successfully !</p>
				</c:if> 
				<c:url var="transfer_fund_url" value="/transfer_fund"></c:url> 
    <div class="fund">    
    <f:form	action='${transfer_fund_url}' modelAttribute="transfer_fund">  
    	<label><b>Account Id:     
        </b>    
        </label>    
        <f:input path="accountId" />    
        <br><br> 
        <label><b>From Account:     
        </b>   
        </label>   
        <f:input path="fromAccount" /> 
        <br><br> 
        <label><b>To Account:     
        </b>    
        </label>    
        <f:input path="toAccount" />    
        <br><br> 
        <label><b>Amount:     
        </b>    
        </label>    
        <f:input path="amount" />    
        <br><br> 
        <button>Transfer</button>       
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